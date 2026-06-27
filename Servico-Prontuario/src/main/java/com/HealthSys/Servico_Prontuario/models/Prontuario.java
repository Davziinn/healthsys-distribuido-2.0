package com.HealthSys.Servico_Prontuario.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Prontuario {

    private String id;
    private Long idPaciente;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
    private Long totalConsultas;
    private List<Consulta> consultas = new ArrayList<>();
}
