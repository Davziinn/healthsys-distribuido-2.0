package com.HealthSys.Servico_Pacientes.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Vacina {

    private Long id;
    private String nomeVacina;
    private LocalDate dataAplicacao;
    private String loteVacina;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private Paciente paciente;
}
