package com.HealthSys.Servico_Prontuario.dto.prontuario;

import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record ProntuarioDetalhadoResponseDTO(
        String id,
        Long idPaciente,
        LocalDateTime dataCriacao,
        LocalDateTime dataAtualizacao,
        List<ConsultaResponseDTO> consultas
) {}