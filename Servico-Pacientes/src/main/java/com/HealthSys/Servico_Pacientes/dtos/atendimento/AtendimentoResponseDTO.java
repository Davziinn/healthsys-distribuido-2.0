package com.HealthSys.Servico_Pacientes.dtos.atendimento;

import com.HealthSys.Servico_Pacientes.enums.StatusAtendimento;

import java.time.LocalDateTime;

public record AtendimentoResponseDTO(
        Long id,
        String tipoAtendimento,
        LocalDateTime dataAtendimento,
        String observacoes,
        StatusAtendimento statusAtendimento
) {
}
