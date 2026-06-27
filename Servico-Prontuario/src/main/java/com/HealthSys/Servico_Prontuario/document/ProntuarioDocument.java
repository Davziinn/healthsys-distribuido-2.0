package com.HealthSys.Servico_Prontuario.document;

import com.HealthSys.Servico_Prontuario.document.subdocuments.ConsultasSubDocument;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "TB_PRNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProntuarioDocument {

    @Id
    private String id;

    @Indexed
    @Field("ID_PAC")
    private Long idPaciente;

    @Field("DT_CRI")
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Field("DT_ATZ")
    @LastModifiedDate
    private LocalDateTime dataAtualizacao;

    @Field("PRNT_CNSLT")
    @Builder.Default
    private List<ConsultasSubDocument> consultas = new ArrayList<>();
}