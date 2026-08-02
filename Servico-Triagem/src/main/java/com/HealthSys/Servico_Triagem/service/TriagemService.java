package com.HealthSys.Servico_Triagem.service;

import com.HealthSys.Servico_Triagem.messaging.event.TriagemConcluidaEvent;
import com.HealthSys.Servico_Triagem.messaging.publisher.TriagemPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TriagemService {

    private final TriagemPublisher triagemPublisher;

    public void concluirTriagem (Long idPaciente, String nivelRisco) {
        TriagemConcluidaEvent event = new TriagemConcluidaEvent(
                UUID.randomUUID().toString(),
                idPaciente,
                nivelRisco,
                "CONCLUIDA",
                LocalDateTime.now()
        );

        triagemPublisher.publicarTriagemConcluida(event);
    }
}
