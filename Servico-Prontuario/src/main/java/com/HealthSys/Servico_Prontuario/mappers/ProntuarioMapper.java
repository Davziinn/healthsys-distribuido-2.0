package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.ProntuarioDocument;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Prontuario;

public interface ProntuarioMapper {

    Prontuario toModel (ProntuarioDocument document);

    ProntuarioDocument toDocument (Prontuario model);

    Prontuario toModel (ProntuarioRequestDTO dto);

    ProntuarioResponseDTO toDTO (Prontuario model);
}
