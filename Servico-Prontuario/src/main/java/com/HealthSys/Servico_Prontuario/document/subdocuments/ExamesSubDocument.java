package com.HealthSys.Servico_Prontuario.document.subdocuments;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ExamesSubDocument {

    private String tipoExame;
    private String resultadoExame;
    private String arquivo;
}
