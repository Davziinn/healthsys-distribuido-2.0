package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaResponseDTO;
import com.HealthSys.Servico_Pacientes.entity.VacinaEntity;
import com.HealthSys.Servico_Pacientes.model.Vacina;

public interface VacinaMapper {

    Vacina toModel (VacinaEntity entity);

    VacinaEntity toEntity (Vacina model);

    Vacina toModel (VacinaRequestDTO dto);

    VacinaResponseDTO toDTO (Vacina model);
}
