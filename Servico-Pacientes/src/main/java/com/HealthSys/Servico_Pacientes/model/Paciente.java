package com.HealthSys.Servico_Pacientes.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Paciente {

    private Long id;
    private Long idUsuario;
    private String nomePaciente;
    private String cpfPaciente;
    private LocalDate dataNascimento;
    private String sexo;
    private String telefone;
    private List<Atendimento> atendimentos;
    private List<Vacina> vacinas;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
}
