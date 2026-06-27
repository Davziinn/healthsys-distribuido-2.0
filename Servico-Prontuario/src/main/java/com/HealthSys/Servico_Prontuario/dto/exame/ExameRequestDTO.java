package com.HealthSys.Servico_Prontuario.dto.exame;

public record ExameRequestDTO(

        String tipoExame,
        String resultadoExame,
        String caminhoArquivo
) {
}
