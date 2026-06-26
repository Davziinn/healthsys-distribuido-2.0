package com.HealthSys.Servico_Pacientes.dtos.paciente;

import java.time.LocalDate;

public record PacienteResponseDTO (
        Long id,
        Long idUsuario,
        String nomePaciente,
        String cpfPaciente,
        LocalDate dataNascimento,
        String sexo,
        String telefone
) {
}
