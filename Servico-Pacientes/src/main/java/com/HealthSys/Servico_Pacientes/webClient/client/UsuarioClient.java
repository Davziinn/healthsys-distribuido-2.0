package com.HealthSys.Servico_Pacientes.webClient.client;

import com.HealthSys.Servico_Pacientes.exceptions.UsuarioServiceIndisponivelException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
@Slf4j
public class UsuarioClient {

    private final WebClient usuarioWebClient;
    private UsuarioTokenProvider tokenProvider;

    public UsuarioClient(@Qualifier("usuarioWebClient") WebClient usuarioWebClient,
                         UsuarioTokenProvider tokenProvider) {
        this.usuarioWebClient = usuarioWebClient;
        this.tokenProvider = tokenProvider;
    }

    @Retry(name = "usuarios-service")
    @CircuitBreaker(name = "usuarios-service", fallbackMethod = "usuarioExisteFallback")
    public boolean existeUsario (Long idUsuario) {
        try {
            usuarioWebClient
                    .get()
                    .uri("/v1/usuario/{id}", idUsuario)
                    .headers(header -> header.setBearerAuth(tokenProvider.obterToken()))
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            return true;

        } catch (WebClientResponseException.NotFound e) {
            return false;
        } catch (WebClientResponseException.Unauthorized | WebClientResponseException.Forbidden  e) {
            tokenProvider.invalidarToken();
            throw e;
        }
    }

    private boolean usuarioExisteFallback (Long idUsuario, Throwable throwable) {
        log.error("Servico-Usuarios indisponivel ao validar idUsuario={}: {}", idUsuario, throwable.getMessage());
        throw new UsuarioServiceIndisponivelException(
                "Não foi possível validar o usuário no momento. Tente novamente em instantes."
        );
    }
}
