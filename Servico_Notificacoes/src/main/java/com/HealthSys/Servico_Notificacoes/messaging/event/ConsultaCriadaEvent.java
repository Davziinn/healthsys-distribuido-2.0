package com.HealthSys.Servico_Notificacoes.messaging.event;

import java.io.Serializable;
import java.time.LocalDate;

public record ConsultaCriadaEvent (
        String idProntuario,
        Long idPaciente,
        String idConsulta,
        String nomeMedico,
        LocalDate dataConsulta
) implements Serializable {
}