package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import com.HealthSys.Servico_Pacientes.model.Paciente;

public interface PacienteMapper {

    Paciente toModel (PacienteEntity entity);

    PacienteEntity toEntity (Paciente model);
}
