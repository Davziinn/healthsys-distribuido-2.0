package com.HealthSys.Servico_Pacientes.dtos.atendimento;

import com.HealthSys.Servico_Pacientes.enums.StatusAtendimento;
import jakarta.validation.constraints.NotBlank;


public record AtendimentoRequestDTO(

        @NotBlank(message = "O tipo de atendimento deve ser informado")
        String tipoAtendimento,
        String observacoes,
        StatusAtendimento statusAtendimento
) {
}
