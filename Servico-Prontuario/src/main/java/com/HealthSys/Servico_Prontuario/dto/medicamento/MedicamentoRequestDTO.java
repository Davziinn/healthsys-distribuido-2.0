package com.HealthSys.Servico_Prontuario.dto.medicamento;

public record MedicamentoRequestDTO (

        String nomeMedicamento,
        String dosagem,
        String frequencia
) {
}
