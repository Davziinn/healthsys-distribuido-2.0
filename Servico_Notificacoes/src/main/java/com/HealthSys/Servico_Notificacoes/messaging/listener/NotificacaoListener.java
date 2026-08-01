package com.HealthSys.Servico_Notificacoes.messaging.listener;

import com.HealthSys.Servico_Notificacoes.messaging.event.ConsultaCriadaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificacaoListener {

    @RabbitListener(queues = "notificacoes.consulta.criada")
    public void receberConsultaCriada (ConsultaCriadaEvent event) {
        log.info("Notificação: nova consulta registrada - paciente {} com {} em {}", event.idPaciente(), event.nomeMedico(), event.dataConsulta());
        // aqui, no futuro, entraria o envio de verdade (email, SMS, push...)
        // por agora, o log já prova que o consumidor está funcionando
    }
}
