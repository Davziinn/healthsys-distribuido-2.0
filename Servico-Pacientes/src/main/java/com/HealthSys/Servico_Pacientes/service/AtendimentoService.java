package com.HealthSys.Servico_Pacientes.service;

import com.HealthSys.Servico_Pacientes.exceptions.ListaAtendimentosPacienteVaziaException;
import com.HealthSys.Servico_Pacientes.mappers.AtendimentoMapper;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.repository.AtendimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;

    private final PacienteService pacienteService;

    public Page<Atendimento> listarAtendimentosPaciente(Long id, Pageable pageable) {
        return atendimentoRepository.findAllByPacienteId(id, pageable).map(atendimentoMapper::toModel);
    }

    @Transactional
    public Atendimento salvarAtendimento(Long idPaciente, Atendimento dadosAtendimento) {
        Paciente pacienteEncontrado = pacienteService.buscarPacienteById(idPaciente);

        dadosAtendimento = dadosAtendimento.toBuilder()
                .dataAtendimento(LocalDateTime.now())
                .paciente(pacienteEncontrado)
                .build();

        return atendimentoMapper.toModel(atendimentoRepository.save(atendimentoMapper.toEntity(dadosAtendimento)));
    }
}
