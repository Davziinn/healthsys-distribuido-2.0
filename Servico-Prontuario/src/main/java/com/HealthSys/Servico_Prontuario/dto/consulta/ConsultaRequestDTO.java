package com.HealthSys.Servico_Prontuario.dto.consulta;

import com.HealthSys.Servico_Prontuario.dto.exame.ExameRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.medicamento.MedicamentoRequestDTO;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record ConsultaRequestDTO(
        @NotNull LocalDate dataConsulta,
        @NotBlank String nomeMedico,
        @NotBlank String diagnostico,
        String observacoes,
        List<ExameRequestDTO> exames,
        List<MedicamentoRequestDTO> medicamentos
) {
}
