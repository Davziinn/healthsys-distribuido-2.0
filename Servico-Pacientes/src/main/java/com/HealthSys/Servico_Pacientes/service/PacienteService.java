package com.HealthSys.Servico_Pacientes.service;

import com.HealthSys.Servico_Pacientes.exceptions.PacienteNotFoundException;
import com.HealthSys.Servico_Pacientes.mappers.PacienteMapper;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import com.HealthSys.Servico_Pacientes.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    @Transactional
    public Paciente salvarPaciente(Paciente paciente) {
        /*pacienteRepository.findByIdUsuario(paciente.getIdUsuario());
        * Comentado para lembrar de quando for fazer a comunicação entre os serviços,
        *   deve buscar o idUsuario pelo endpoint exposto pelo serviço de usuários
        *   depois vincular ao paciente na coluna idUsuario
        *   depois salvar o paciente
        */

        /*validarCPF(paciente.getCpfPaciente());
        * Comentado para lembrar de validar se é um CPF válido
        *   se sim, salva
        *   se não, lança exception
        */

        return pacienteMapper.toModel(pacienteRepository.save(pacienteMapper.toEntity(paciente)));
    }

    public Paciente buscarPacienteById(Long id) {
        return pacienteMapper.toModel(pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteNotFoundException("Paciente não encontrado")
        ));
    }

    public Page<Paciente> buscarTodosPacientesCadastrados(Pageable pageable) {
        return pacienteRepository.findAll(pageable).map(pacienteMapper::toModel);
    }

    @Transactional
    public Paciente editarPaciente(Long id, Paciente novoPaciente) {
        Paciente pacienteEncontrado = buscarPacienteById(id);

        pacienteEncontrado = pacienteEncontrado.toBuilder()
                .nomePaciente(novoPaciente.getNomePaciente() != null ? novoPaciente.getNomePaciente() : pacienteEncontrado.getNomePaciente())
                .cpfPaciente(novoPaciente.getCpfPaciente() != null ? novoPaciente.getCpfPaciente() : pacienteEncontrado.getCpfPaciente())
                .dataNascimento(novoPaciente.getDataNascimento() != null ? novoPaciente.getDataNascimento() : pacienteEncontrado.getDataNascimento())
                .sexo(novoPaciente.getSexo() != null ? novoPaciente.getSexo() : pacienteEncontrado.getSexo())
                .telefone(novoPaciente.getTelefone() != null ? novoPaciente.getTelefone() : pacienteEncontrado.getTelefone())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        return pacienteMapper.toModel(pacienteRepository.save(pacienteMapper.toEntity(pacienteEncontrado)));
    }

    public void deletarPacienteById(Long id) {
        buscarPacienteById(id);
        pacienteRepository.deleteById(id);
    }
}
