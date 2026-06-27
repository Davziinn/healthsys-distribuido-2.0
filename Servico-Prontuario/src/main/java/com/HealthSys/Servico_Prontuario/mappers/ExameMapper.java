package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.ExamesSubDocument;
import com.HealthSys.Servico_Prontuario.dto.exame.ExameRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.exame.ExameResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Exames;

public interface ExameMapper {

    Exames toModel (ExamesSubDocument subDocument);

    ExamesSubDocument toSubDocument (Exames model);

    Exames toModel (ExameRequestDTO dto);

    ExameResponseDTO toDTO (Exames model);
}
