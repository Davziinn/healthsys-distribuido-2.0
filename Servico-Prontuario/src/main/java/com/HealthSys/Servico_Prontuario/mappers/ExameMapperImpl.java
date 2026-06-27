package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.ExamesSubDocument;
import com.HealthSys.Servico_Prontuario.dto.exame.ExameRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.exame.ExameResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Exames;
import org.springframework.stereotype.Component;

@Component
public class ExameMapperImpl implements ExameMapper {

    @Override
    public Exames toModel(ExamesSubDocument subDocument) {
        return Exames.builder()
                .tipoExame(subDocument.getTipoExame())
                .resultadoExame(subDocument.getResultadoExame())
                .arquivo(subDocument.getArquivo())
                .build();
    }

    @Override
    public ExamesSubDocument toSubDocument(Exames model) {
        return ExamesSubDocument.builder()
                .tipoExame(model.getTipoExame())
                .resultadoExame(model.getResultadoExame())
                .arquivo(model.getArquivo())
                .build();
    }

    @Override
    public Exames toModel(ExameRequestDTO dto) {
        return Exames.builder()
                .tipoExame(dto.tipoExame())
                .resultadoExame(dto.resultadoExame())
                .arquivo(dto.caminhoArquivo())
                .build();
    }

    @Override
    public ExameResponseDTO toDTO(Exames model) {
        return new ExameResponseDTO(
                model.getTipoExame(),
                model.getResultadoExame(),
                model.getArquivo()
        );
    }
}
