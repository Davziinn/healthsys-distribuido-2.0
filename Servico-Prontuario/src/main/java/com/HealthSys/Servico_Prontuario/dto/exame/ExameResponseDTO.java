package com.HealthSys.Servico_Prontuario.dto.exame;

public record ExameResponseDTO(
        String tipo,
        String resultado,
        String arquivo
) {}