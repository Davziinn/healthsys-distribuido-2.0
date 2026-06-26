package com.HealthSys.Servico_Pacientes.dtos.vacina;

import java.time.LocalDateTime;

public record VacinaRequestDTO(
        String nomeVacina,
        LocalDateTime dataAplicacao,
        String loteVacina
) {
}
