package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.dtos.atendimento.AtendimentoRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.atendimento.AtendimentoResponseDTO;
import com.HealthSys.Servico_Pacientes.entity.AtendimentoEntity;
import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoMapperImpl implements AtendimentoMapper {

    @Override
    public Atendimento toModel(AtendimentoEntity entity) {

        Paciente pacienteModel = Paciente.builder()
                .id(entity.getPaciente().getId())
                .idUsuario(entity.getPaciente().getIdUsuario())
                .nomePaciente(entity.getPaciente().getNomePaciente())
                .cpfPaciente(entity.getPaciente().getCpfPaciente())
                .dataNascimento(entity.getPaciente().getDataNascimento())
                .sexo(entity.getPaciente().getSexo())
                .telefone(entity.getPaciente().getTelefone())
                .dataCadastro(entity.getPaciente().getDataCadastro())
                .dataAtualizacao(entity.getPaciente().getDataAtualizacao())
                .build();

        return Atendimento.builder()
                .id(entity.getId())
                .tipoAtendimento(entity.getTipoAtendimento())
                .dataAtendimento(entity.getDataAtendimento())
                .observacoes(entity.getObservacoes())
                .statusAtendimento(entity.getStatusAtendimento())
                .dataCadastro(entity.getDataCadastro())
                .dataAtualizacao(entity.getDataAtualizacao())
                .paciente(pacienteModel)
                .build();
    }

    @Override
    public AtendimentoEntity toEntity(Atendimento model) {

        PacienteEntity pacienteEntity = PacienteEntity.builder()
                .id(model.getPaciente().getId())
                .idUsuario(model.getPaciente().getIdUsuario())
                .nomePaciente(model.getPaciente().getNomePaciente())
                .cpfPaciente(model.getPaciente().getCpfPaciente())
                .dataNascimento(model.getPaciente().getDataNascimento())
                .sexo(model.getPaciente().getSexo())
                .telefone(model.getPaciente().getTelefone())
                .dataCadastro(model.getPaciente().getDataCadastro())
                .dataAtualizacao(model.getPaciente().getDataAtualizacao())
                .build();

        return AtendimentoEntity.builder()
                .id(model.getId())
                .tipoAtendimento(model.getTipoAtendimento())
                .dataAtendimento(model.getDataAtendimento())
                .observacoes(model.getObservacoes())
                .statusAtendimento(model.getStatusAtendimento())
                .dataCadastro(model.getDataCadastro())
                .dataAtualizacao(model.getDataAtualizacao())
                .paciente(pacienteEntity)
                .build();
    }

    @Override
    public AtendimentoResponseDTO toDTO(Atendimento model) {
        return new AtendimentoResponseDTO(
                model.getId(),
                model.getTipoAtendimento(),
                model.getDataAtendimento(),
                model.getObservacoes(),
                model.getStatusAtendimento()
        );
    }

    @Override
    public Atendimento toModel(AtendimentoRequestDTO dto) {
        return Atendimento.builder()
                .tipoAtendimento(dto.tipoAtendimento())
                .statusAtendimento(dto.statusAtendimento())
                .observacoes(dto.observacoes())
                .build();
    }
}
