package com.HealthSys.Servico_Prontuario.models;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Consulta {

    private String idConsulta;
    private LocalDate dataConsulta;
    private String nomeMedico;
    private String diagnostico;
    private String observacoes;

    @Builder.Default
    private List<Exames> exames = new ArrayList<>();

    @Builder.Default
    private List<Medicamentos> medicamentos = new ArrayList<>();
}
