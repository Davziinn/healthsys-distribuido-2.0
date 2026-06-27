package com.HealthSys.Servico_Prontuario.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Medicamentos {

    private String nomeMedicamento;
    private String dosagem;
    private String frequencia;
}
