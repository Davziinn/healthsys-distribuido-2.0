package com.HealthSys.Servico_Notificacoes.messaging.listener;

import com.HealthSys.Servico_Notificacoes.messaging.event.TriagemConcluidaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TriagemEventListener {

    @KafkaListener(topics = "triagem.eventos", groupId = "notificacoes-service")
    public void receberTriagemConcluida(TriagemConcluidaEvent event) {
        log.info("Notificação: triagem {} concluída - paciente {} com risco {}", event.idTriagem(), event.idPaciente(), event.nivelRisco());
    }
}
