package com.HealthSys.Servico_Prontuario.messaging.publisher;

import com.HealthSys.Servico_Prontuario.config.RabbitMQConfig;
import com.HealthSys.Servico_Prontuario.messaging.event.ConsultaCriadaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificacaoPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void publicarConsultaCriada (ConsultaCriadaEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NOTIFICACOES,
                RabbitMQConfig.ROUNTING_KEY_CONSULTA_CRIADA,
                event
        );

        log.info("Evento publicado: consulta {} criada para paciente {}", event.idConsulta(), event.idPaciente());
    }
}
