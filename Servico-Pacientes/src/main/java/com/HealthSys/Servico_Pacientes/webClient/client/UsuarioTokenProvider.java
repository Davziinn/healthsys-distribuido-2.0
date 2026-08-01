package com.HealthSys.Servico_Pacientes.webClient.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@Slf4j
public class UsuarioTokenProvider {

    private final WebClient usuarioWebClient;
    private final String email;
    private final String senha;

    private volatile String tokenCache;

    public UsuarioTokenProvider(@Qualifier("usuarioWebClient") WebClient usuarioWebClient,
                                 @Value("${services.usuarios.auth.email}") String email,
                                 @Value("${services.usuarios.auth.senha}") String senha) {
        this.usuarioWebClient = usuarioWebClient;
        this.email = email;
        this.senha = senha;
    }


    public synchronized String obterToken () {
        if (tokenCache == null) {
            tokenCache = login();
        }
        return tokenCache;
    }

    public synchronized void invalidarToken (){
        tokenCache = null;
    }

    private String login () {
        LoginResponse loginResponse = usuarioWebClient.post()
                .uri("/v1/auth/login")
                .bodyValue(new LoginResquest(email, senha))
                .retrieve()
                .bodyToMono(LoginResponse.class)
                .block();

        log.info("Novo token obtido do Servico-Usuario para chamadas internas");
        return loginResponse.token();
    }

    private record LoginResquest (String email, String senha) {}
    private record LoginResponse (String token, String role, String username) {}
}
