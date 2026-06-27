package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.MedicamentosSubDocument;
import com.HealthSys.Servico_Prontuario.dto.medicamento.MedicamentoRequestDTO;
import com.HealthSys.Servico_Prontuario.models.Medicamentos;

public interface MedicamentoMapper {

    Medicamentos toModel(MedicamentosSubDocument subDocument);

    MedicamentosSubDocument toSubDocument(Medicamentos model);

    Medicamentos toModel (MedicamentoRequestDTO dto);
}
