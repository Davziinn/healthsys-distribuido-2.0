package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.AtendimentoEntity;
import com.HealthSys.Servico_Pacientes.model.Atendimento;

public interface AtendimentoMapper {

    Atendimento toModel (AtendimentoEntity entity);

    AtendimentoEntity toEntity (Atendimento model);

}
