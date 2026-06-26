package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.dtos.paciente.PacienteRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.paciente.PacienteResponseDTO;
import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PacienteMapperImpl implements PacienteMapper {

    private final AtendimentoMapper atendimentoMapper;
    private final VacinaMapper vacinaMapper;

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
                .atendimentos(entity.getAtendimentos() != null ? entity.getAtendimentos().stream().map(atendimentoMapper::toModel).toList() : List.of())
                .vacinas(entity.getVacinas() != null ? entity.getVacinas().stream().map(vacinaMapper::toModel).toList() : List.of())
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
                .atendimentos(model.getAtendimentos() != null ? model.getAtendimentos().stream().map(atendimentoMapper::toEntity).toList() : List.of())
                .vacinas(model.getVacinas() != null ? model.getVacinas().stream().map(vacinaMapper::toEntity).toList() : List.of())
                .build();
    }

    @Override
    public Paciente toModel(PacienteRequestDTO dto) {
        return Paciente.builder()
                .idUsuario(dto.idUsuario())
                .nomePaciente(dto.nomePaciente())
                .cpfPaciente(dto.cpfPaciente())
                .dataNascimento(dto.dataNascimento())
                .sexo(dto.sexo())
                .telefone(dto.telefone())
                .build();
    }

    @Override
    public PacienteResponseDTO toDTO(Paciente model) {
        return new PacienteResponseDTO(
                model.getId(),
                model.getIdUsuario(),
                model.getNomePaciente(),
                model.getCpfPaciente(),
                model.getDataNascimento(),
                model.getSexo(),
                model.getTelefone()
        );
    }
}
