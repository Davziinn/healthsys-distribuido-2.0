package com.HealthSys.Servico_Triagem.messaging.publisher;

import com.HealthSys.Servico_Triagem.messaging.event.TriagemConcluidaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TriagemPublisher {

    private static final String TOPIC = "triagem.eventos";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publicarTriagemConcluida (TriagemConcluidaEvent event) {
        String key = event.idPaciente().toString();

        kafkaTemplate.send(TOPIC, key, event);

        log.info("Evento publicado no Kafka: triagem {} do paciente {}, key={}",
                event.idTriagem(), event.idPaciente(), key);
    }
}
