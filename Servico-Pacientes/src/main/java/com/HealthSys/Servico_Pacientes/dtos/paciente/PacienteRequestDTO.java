package com.HealthSys.Servico_Pacientes.dtos.paciente;

import java.time.LocalDate;

public record PacienteRequestDTO(
        Long idUsuario,
        String nomePaciente,
        String cpfPaciente,
        LocalDate dataNascimento,
        String sexo,
        String telefone
) {
}
