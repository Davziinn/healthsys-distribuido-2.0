package com.HealthSys.Servico_Pacientes.mappers;

import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaResponseDTO;
import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import com.HealthSys.Servico_Pacientes.entity.VacinaEntity;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import org.springframework.stereotype.Component;

@Component
public class VacinaMapperImpl implements VacinaMapper {

    @Override
    public Vacina toModel(VacinaEntity entity) {

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

        return Vacina.builder()
                .id(entity.getId())
                .nomeVacina(entity.getNomeVacina())
                .dataAplicacao(entity.getDataAplicacao())
                .loteVacina(entity.getLoteVacina())
                .dataCadastro(entity.getDataCadastro())
                .dataAtualizacao(entity.getDataAtualizacao())
                .paciente(pacienteModel)
                .build();
    }

    @Override
    public VacinaEntity toEntity(Vacina model) {

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

        return VacinaEntity.builder()
                .id(model.getId())
                .nomeVacina(model.getNomeVacina())
                .dataAplicacao(model.getDataAplicacao())
                .loteVacina(model.getLoteVacina())
                .dataCadastro(model.getDataCadastro())
                .dataAtualizacao(model.getDataAtualizacao())
                .paciente(pacienteEntity)
                .build();
    }

    @Override
    public Vacina toModel(VacinaRequestDTO dto) {
        return Vacina.builder()
                .nomeVacina(dto.nomeVacina())
                .dataAplicacao(dto.dataAplicacao())
                .loteVacina(dto.loteVacina())
                .build();
    }

    @Override
    public VacinaResponseDTO toDTO(Vacina model) {
        return new VacinaResponseDTO(
                model.getId(),
                model.getNomeVacina(),
                model.getDataAplicacao(),
                model.getLoteVacina(),
                model.getPaciente().getId()
        );
    }
}
