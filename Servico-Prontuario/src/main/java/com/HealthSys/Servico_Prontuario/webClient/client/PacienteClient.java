package com.HealthSys.Servico_Prontuario.webClient.client;

import com.HealthSys.Servico_Prontuario.exceptions.PacienteServiceIndisponivelException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Component
@Slf4j
@RequiredArgsConstructor
public class PacienteClient {

    private final WebClient pacienteWebClient;

    @Retry(name = "pacientes-service")
    @CircuitBreaker(name = "pacientes-service", fallbackMethod = "pacienteExisteFallback")
    public boolean pacienteExiste (Long idPaciente) {
        try {
            pacienteWebClient.get()
                    .uri("/v1/pacientes/{id}", idPaciente)
                    .retrieve()
                    .toBodilessEntity()
                    .block();

            return true;

        } catch (WebClientResponseException.NotFound ex) {
            return false;
        }
    }

    private boolean pacienteExisteFallback (Long idPaciente, Throwable throwable) {
        log.error("Servico-Pacientes indisponivel ao validar idPaciente={}: {}", idPaciente, throwable.getMessage());

        throw new PacienteServiceIndisponivelException(
                "Não foi possível validar o paciente no momento. Tente novamente em instantes."
        );
    }
}
