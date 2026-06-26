package com.HealthSys.Servico_Pacientes.dtos.vacina;

import java.time.LocalDate;

public record VacinaResponseDTO(
        Long id,
        String nomeVacina,
        LocalDate dataAplicacao,
        String loteVacina,
        Long idPaciente
) {
}
