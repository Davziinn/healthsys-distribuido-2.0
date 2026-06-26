package com.HealthSys.Servico_Pacientes.dtos.vacina;

import java.time.LocalDateTime;

public record VacinaResponseDTO(
        Long id,
        String nomeVacina,
        LocalDateTime dataAplicacao,
        String loteVacina,
        Long idPaciente
) {
}
