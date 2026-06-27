package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.ProntuarioDocument;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Prontuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProntuarioMapperImpl implements ProntuarioMapper {

    private final ConsultaMapper consultaMapper;

    @Override
    public Prontuario toModel(ProntuarioDocument document) {
        return Prontuario.builder()
                .id(document.getId())
                .idPaciente(document.getIdPaciente())
                .dataCriacao(document.getDataCriacao())
                .dataAtualizacao(document.getDataAtualizacao())
                .consultas(document.getConsultas() != null ? document.getConsultas().stream().map(consultaMapper::toModel).toList() : List.of())
                .build();
    }

    @Override
    public ProntuarioDocument toDocument(Prontuario model) {
        return ProntuarioDocument.builder()
                .id(model.getId())
                .idPaciente(model.getIdPaciente())
                .dataCriacao(model.getDataCriacao())
                .dataAtualizacao(model.getDataAtualizacao())
                .consultas(model.getConsultas() != null ? model.getConsultas().stream().map(consultaMapper::toSubDocument).toList() : List.of())
                .build();
    }

    @Override
    public Prontuario toModel(ProntuarioRequestDTO dto) {
        return Prontuario.builder()
                .idPaciente(dto.idPaciente())
                .build();
    }

    @Override
    public ProntuarioResponseDTO toDTO(Prontuario model) {
        return new ProntuarioResponseDTO(
                model.getId(),
                model.getIdPaciente(),
                model.getDataCriacao(),
                1
        );
    }
}
