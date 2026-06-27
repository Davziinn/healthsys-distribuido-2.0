package com.HealthSys.Servico_Prontuario.mappers;

import com.HealthSys.Servico_Prontuario.document.subdocuments.ConsultasSubDocument;
import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaResponseDTO;
import com.HealthSys.Servico_Prontuario.models.Consulta;

public interface ConsultaMapper {

    Consulta toModel (ConsultasSubDocument subDocument);

    ConsultasSubDocument toSubDocument (Consulta model);

    Consulta toConsultaModel(ConsultaRequestDTO dto);

    ConsultaResponseDTO toDTO (Consulta model);
}
