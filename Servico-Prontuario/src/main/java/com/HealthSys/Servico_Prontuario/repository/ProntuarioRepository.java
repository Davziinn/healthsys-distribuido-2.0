package com.HealthSys.Servico_Prontuario.repository;

import com.HealthSys.Servico_Prontuario.document.ProntuarioDocument;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProntuarioRepository extends MongoRepository<ProntuarioDocument, String> {

    boolean existsByIdPaciente (Long idPaciente);

    List<ProntuarioDocument> findByIdPaciente (Long id);

    @Aggregation(pipeline = {
            "{ '$match': { 'pacienteId': ?0 } }",
            "{ '$group': { '_id': null, 'total': { '$sum': { '$size': { '$ifNull': [ '$consultas', [] ] } } } } }",
            "{ '$project': { '_id': 0, 'value': '$total' } }"
    })
    Long countConsultasByPacienteId(Long pacienteId);


}
