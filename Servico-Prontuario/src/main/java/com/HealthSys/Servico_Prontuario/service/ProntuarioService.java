package com.HealthSys.Servico_Prontuario.service;

import com.HealthSys.Servico_Prontuario.exceptions.PacienteJaExisteException;
import com.HealthSys.Servico_Prontuario.exceptions.ProntuarioNotFoundException;
import com.HealthSys.Servico_Prontuario.mappers.ProntuarioMapper;
import com.HealthSys.Servico_Prontuario.models.Consulta;
import com.HealthSys.Servico_Prontuario.models.Prontuario;
import com.HealthSys.Servico_Prontuario.repository.ProntuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProntuarioService {

    private final ProntuarioMapper prontuarioMapper;
    private final ProntuarioRepository prontuarioRepository;

    @Transactional
    public Prontuario salvarProntuario(Prontuario novoProntuario) {
        boolean isPacienteExistente = prontuarioRepository.existsByIdPaciente(novoProntuario.getIdPaciente());

        if (isPacienteExistente) {
            throw new PacienteJaExisteException("Paciente já possui prontuário");
        }

        return prontuarioMapper.toModel(prontuarioRepository.save(prontuarioMapper.toDocument(novoProntuario)));
    }

    public Prontuario buscarById(String id) {
        return prontuarioMapper.toModel(
                prontuarioRepository.findById(id)
                        .orElseThrow(() -> new ProntuarioNotFoundException("Prontuário não encontrado"))
        );
    }

    public List<Prontuario> buscarByIdPaciente(Long idPaciente) {
        return prontuarioRepository.findByIdPaciente(idPaciente).stream().map(prontuarioMapper::toModel).toList();
    }

    public void deletarProntuario(String id) {
        if (!prontuarioRepository.existsById(id)) {
            throw new ProntuarioNotFoundException("Prontuário não encontrado");
        }
        prontuarioRepository.deleteById(id);
    }

    public Prontuario adicionarConsulta(String id, Consulta consulta) {
        Prontuario prontuarioEncontrado = buscarById(id);

        consulta = consulta.toBuilder()
                .idConsulta(UUID.randomUUID().toString())
                .build();

        List<Consulta> consultas = new ArrayList<>(prontuarioEncontrado.getConsultas());
        consultas.add(consulta);

        prontuarioEncontrado = prontuarioEncontrado.toBuilder()
                .consultas(consultas)
                .build();

        return prontuarioMapper.toModel(prontuarioRepository.save(prontuarioMapper.toDocument(prontuarioEncontrado)));
    }
}
