package com.HealthSys.Servico_Prontuario.dto.prontuario;

import jakarta.validation.constraints.NotNull;

public record ProntuarioRequestDTO(

        @NotNull(message = "O campo ID_PACIENTE é obrigatório")
        Long idPaciente
) {
}
