package com.HealthSys.Servico_Pacientes.dtos.vacina;

import java.time.LocalDate;

public record VacinaRequestDTO(
        String nomeVacina,
        LocalDate dataAplicacao,
        String loteVacina
) {
}
