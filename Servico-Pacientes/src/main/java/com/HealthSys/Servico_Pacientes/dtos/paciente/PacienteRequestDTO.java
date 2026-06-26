package com.HealthSys.Servico_Pacientes.dtos.paciente;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record PacienteRequestDTO(
        Long idUsuario,

        @NotBlank(message = "O nome do paciente deve ser informado")
        String nomePaciente,

        @NotBlank(message = "O CPF do paciente deve ser informado")
        @Length(max = 14, min = 14, message = "O campo CPF deve conter exatamente 14 caracteres")
        String cpfPaciente,
        LocalDate dataNascimento,
        String sexo,
        String telefone
) {
}
