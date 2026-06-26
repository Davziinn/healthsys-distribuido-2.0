package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.VacinaEntity;
import com.HealthSys.Servico_Pacientes.model.Vacina;

public interface VacinaMapper {

    Vacina toModel (VacinaEntity entity);

    VacinaEntity toEntity (Vacina model);
}
