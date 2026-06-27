package com.HealthSys.Servico_Prontuario.dto.medicamento;

public record MedicamentoResponseDTO(
        String nome,
        String dosagem,
        String frequencia
) {}