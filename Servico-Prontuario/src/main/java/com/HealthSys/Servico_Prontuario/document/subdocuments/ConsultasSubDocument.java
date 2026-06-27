package com.HealthSys.Servico_Prontuario.document.subdocuments;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ConsultasSubDocument {

    private String idConsulta;
    private LocalDate dataConsulta;
    private String nomeMedico;
    private String diagnostico;
    private String observacoes;

    @Builder.Default
    private List<ExamesSubDocument> exames = new ArrayList<>();

    @Builder.Default
    private List<MedicamentosSubDocument> medicamentos = new ArrayList<>();
}
