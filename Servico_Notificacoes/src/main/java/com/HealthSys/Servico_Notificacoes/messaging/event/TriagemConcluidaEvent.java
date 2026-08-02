package com.HealthSys.Servico_Notificacoes.messaging.event;

import java.time.LocalDateTime;

public record TriagemConcluidaEvent(
        String idTriagem,
        Long idPaciente,
        String nivelRisco,
        String status,
        LocalDateTime dataTriagem
) {
}
