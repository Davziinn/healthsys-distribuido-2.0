package com.HealthSys.Servico_Prontuario.config;

import io.netty.channel.ChannelOption;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClienteConfig {

    @Bean
    public WebClient pacientesWebCliente (@Value("${services.pacientes.url}") String baseUrlServicoPacientes) {

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000)
                .responseTimeout(Duration.ofSeconds(3));

        return WebClient.builder()
                .baseUrl(baseUrlServicoPacientes)
                .build();
    }
}
