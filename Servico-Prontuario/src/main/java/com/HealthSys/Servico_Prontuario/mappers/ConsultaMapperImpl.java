package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.ConsultasSubDocument;
import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Consulta;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ConsultaMapperImpl implements ConsultaMapper {

    private final ExameMapper exameMapper;
    private final MedicamentoMapper medicamentoMapper;

    @Override
    public Consulta toModel(ConsultasSubDocument subDocument) {
        return Consulta.builder()
                .idConsulta(subDocument.getIdConsulta())
                .dataConsulta(subDocument.getDataConsulta())
                .nomeMedico(subDocument.getNomeMedico())
                .diagnostico(subDocument.getDiagnostico())
                .observacoes(subDocument.getObservacoes())
                .exames(subDocument.getExames() != null ? subDocument.getExames().stream().map(exameMapper::toModel).toList() : List.of())
                .medicamentos(subDocument.getMedicamentos() != null ? subDocument.getMedicamentos().stream().map(medicamentoMapper::toModel).toList() : List.of())
                .build();
    }

    @Override
    public ConsultasSubDocument toSubDocument(Consulta model) {
        return ConsultasSubDocument.builder()
                .idConsulta(model.getIdConsulta())
                .dataConsulta(model.getDataConsulta())
                .nomeMedico(model.getNomeMedico())
                .diagnostico(model.getDiagnostico())
                .observacoes(model.getObservacoes())
                .exames(model.getExames() != null ? model.getExames().stream().map(exameMapper::toSubDocument).toList() : List.of())
                .medicamentos(model.getMedicamentos() != null ? model.getMedicamentos().stream().map(medicamentoMapper::toSubDocument).toList() : List.of())
                .build();
    }

    @Override
    public Consulta toConsultaModel(ConsultaRequestDTO dto) {
        return Consulta.builder()
                .dataConsulta(dto.dataConsulta())
                .nomeMedico(dto.nomeMedico())
                .diagnostico(dto.diagnostico())
                .observacoes(dto.observacoes())
                .exames(dto.exames() != null ? dto.exames().stream().map(exameMapper::toModel).toList() : List.of())
                .medicamentos(dto.medicamentos() != null ? dto.medicamentos().stream().map(medicamentoMapper::toModel).toList() : List.of())
                .build();
    }

    @Override
    public ConsultaResponseDTO toDTO(Consulta model) {
        return new ConsultaResponseDTO(
                model.getIdConsulta(),
                model.getDataConsulta(),
                model.getNomeMedico(),
                model.getDiagnostico(),
                model.getObservacoes(),
                model.getExames() != null ? model.getExames().stream().map(exameMapper::toDTO).toList() : null,
                model.getMedicamentos() != null ? model.getMedicamentos().stream().map(medicamentoMapper::toDTO).toList() : null
        );
    }
}
