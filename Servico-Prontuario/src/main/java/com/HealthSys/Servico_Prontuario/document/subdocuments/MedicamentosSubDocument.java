package com.HealthSys.Servico_Prontuario.document.subdocuments;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MedicamentosSubDocument {

    private String nomeMedicamento;
    private String dosagem;
    private String frequencia;
}
