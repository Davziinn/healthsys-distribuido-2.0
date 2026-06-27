package com.HealthSys.Servico_Prontuario.dto.consulta;

import com.HealthSys.Servico_Prontuario.dto.exame.ExameResponseDTO;
import com.HealthSys.Servico_Prontuario.dto.medicamento.MedicamentoResponseDTO;

import java.time.LocalDate;
import java.util.List;

public record ConsultaResponseDTO(
        String idConsulta,
        LocalDate dataConsulta,
        String nomeMedico,
        String diagnostico,
        String observacoes,
        List<ExameResponseDTO> exames,
        List<MedicamentoResponseDTO> medicamentos
) {}