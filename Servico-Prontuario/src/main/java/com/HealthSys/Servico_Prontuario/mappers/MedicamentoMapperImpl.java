package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.MedicamentosSubDocument;
import com.HealthSys.Servico_Prontuario.dto.medicamento.MedicamentoRequestDTO;
import com.HealthSys.Servico_Prontuario.models.Medicamentos;
import org.springframework.stereotype.Component;

@Component
public class MedicamentoMapperImpl implements MedicamentoMapper {

    @Override
    public Medicamentos toModel(MedicamentosSubDocument subDocument) {
        return Medicamentos.builder()
                .nomeMedicamento(subDocument.getNomeMedicamento())
                .dosagem(subDocument.getDosagem())
                .frequencia(subDocument.getFrequencia())
                .build();
    }

    @Override
    public MedicamentosSubDocument toSubDocument(Medicamentos model) {
        return MedicamentosSubDocument.builder()
                .nomeMedicamento(model.getNomeMedicamento())
                .dosagem(model.getDosagem())
                .frequencia(model.getFrequencia())
                .build();
    }

    @Override
    public Medicamentos toModel(MedicamentoRequestDTO dto) {
        return Medicamentos.builder()
                .nomeMedicamento(dto.nomeMedicamento())
                .dosagem(dto.dosagem())
                .frequencia(dto.frequencia())
                .build();
    }
}
