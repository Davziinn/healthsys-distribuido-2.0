package com.HealthSys.Servico_Prontuario.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Exames {

    private String tipoExame;
    private String resultadoExame;
    private String arquivo;
}
