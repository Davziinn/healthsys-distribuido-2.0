package com.HealthSys.Servico_Prontuario.dto.prontuario;

import java.time.LocalDateTime;

public record ProntuarioResponseDTO(
        String id,
        Long idPaciente,
        LocalDateTime dataCriacao,
        int totalConsultas
) {
}
