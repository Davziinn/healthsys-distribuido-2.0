package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapperImpl implements PacienteMapper {

    @Override
    public Paciente toModel(PacienteEntity entity) {
        return Paciente.builder()
                .id(entity.getId())
                .nomePaciente(entity.getNomePaciente())
                .cpfPaciente(entity.getCpfPaciente())
                .sexo(entity.getSexo())
                .dataNascimento(entity.getDataNascimento())
                .dataCadastro(entity.getDataCadastro())
                .dataAtualizacao(entity.getDataAtualizacao())
                .idUsuario(entity.getIdUsuario())
                .telefone(entity.getTelefone())
                .build();
    }

    @Override
    public PacienteEntity toEntity(Paciente model) {
        return PacienteEntity.builder()
                .id(model.getId())
                .nomePaciente(model.getNomePaciente())
                .cpfPaciente(model.getCpfPaciente())
                .sexo(model.getSexo())
                .dataNascimento(model.getDataNascimento())
                .dataCadastro(model.getDataCadastro())
                .dataAtualizacao(model.getDataAtualizacao())
                .idUsuario(model.getIdUsuario())
                .telefone(model.getTelefone())
                .build();
    }
}
