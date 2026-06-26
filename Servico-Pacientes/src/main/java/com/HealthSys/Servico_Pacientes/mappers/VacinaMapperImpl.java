package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.VacinaEntity;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import org.springframework.stereotype.Component;

@Component
public class VacinaMapperImpl implements VacinaMapper {

    private final PacienteMapper pacienteMapper;

    public VacinaMapperImpl(PacienteMapper pacienteMapper) {
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public Vacina toModel(VacinaEntity entity) {
        return Vacina.builder()
                .id(entity.getId())
                .nomeVacina(entity.getNomeVacina())
                .dataAplicacao(entity.getDataAplicacao())
                .loteVacina(entity.getLoteVacina())
                .dataCadastro(entity.getDataCadastro())
                .dataAtualizacao(entity.getDataAtualizacao())
                .paciente(
                        entity.getPaciente() != null ? pacienteMapper.toModel(entity.getPaciente()) : null
                )
                .build();
    }

    @Override
    public VacinaEntity toEntity(Vacina model) {
        return VacinaEntity.builder()
                .id(model.getId())
                .nomeVacina(model.getNomeVacina())
                .dataAplicacao(model.getDataAplicacao())
                .loteVacina(model.getLoteVacina())
                .dataCadastro(model.getDataCadastro())
                .dataAtualizacao(model.getDataAtualizacao())
                .paciente(
                        model.getPaciente() != null ? pacienteMapper.toEntity(model.getPaciente()) : null
                )
                .build();
    }
}
