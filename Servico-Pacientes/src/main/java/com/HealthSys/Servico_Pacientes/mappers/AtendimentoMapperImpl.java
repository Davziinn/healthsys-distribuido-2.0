package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.AtendimentoEntity;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoMapperImpl implements AtendimentoMapper {

    private final PacienteMapper pacienteMapper;

    public AtendimentoMapperImpl(PacienteMapper pacienteMapper) {
        this.pacienteMapper = pacienteMapper;
    }

    @Override
    public Atendimento toModel(AtendimentoEntity entity) {
        return Atendimento.builder()
                .id(entity.getId())
                .tipoAtendimento(entity.getTipoAtendimento())
                .dataAtendimento(entity.getDataAtendimento())
                .observacoes(entity.getObservacoes())
                .statusAtendimento(entity.getStatusAtendimento())
                .dataCadastro(entity.getDataCadastro())
                .dataAtualizacao(entity.getDataAtualizacao())
                .paciente(entity.getPaciente() != null ? pacienteMapper.toModel(entity.getPaciente()) : null)
                .build();
    }

    @Override
    public AtendimentoEntity toEntity(Atendimento model) {
        return AtendimentoEntity.builder()
                .id(model.getId())
                .tipoAtendimento(model.getTipoAtendimento())
                .dataAtendimento(model.getDataAtendimento())
                .observacoes(model.getObservacoes())
                .statusAtendimento(model.getStatusAtendimento())
                .dataCadastro(model.getDataCadastro())
                .dataAtualizacao(model.getDataAtualizacao())
                .paciente(model.getPaciente() != null ? pacienteMapper.toEntity(model.getPaciente()) : null)
                .build();
    }
}
