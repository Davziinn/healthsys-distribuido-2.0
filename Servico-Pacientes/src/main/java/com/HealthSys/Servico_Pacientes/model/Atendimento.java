package com.HealthSys.Servico_Pacientes.model;

import com.HealthSys.Servico_Pacientes.enums.StatusAtendimento;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Atendimento {

    private Long id;
    private String tipoAtendimento;
    private LocalDateTime dataAtendimento;
    private String observacoes;
    private StatusAtendimento statusAtendimento;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private Paciente paciente;
}
