package com.HealthSys.Servico_Pacientes.service;

import com.HealthSys.Servico_Pacientes.exceptions.ListaAtendimentosPacienteVaziaException;
import com.HealthSys.Servico_Pacientes.exceptions.PacienteNotFoundException;
import com.HealthSys.Servico_Pacientes.mappers.AtendimentoMapper;
import com.HealthSys.Servico_Pacientes.mappers.PacienteMapper;
import com.HealthSys.Servico_Pacientes.mappers.VacinaMapper;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import com.HealthSys.Servico_Pacientes.repository.AtendimentoRepository;
import com.HealthSys.Servico_Pacientes.repository.PacienteRepository;
import com.HealthSys.Servico_Pacientes.repository.VacinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final PacienteMapper pacienteMapper;

    private final VacinaRepository vacinaRepository;
    private final VacinaMapper vacinaMapper;

    private final AtendimentoRepository atendimentoRepository;
    private final AtendimentoMapper atendimentoMapper;

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

    public List<Paciente> buscarTodosPacientesCadastrados() {
        return pacienteRepository.findAll().stream().map(pacienteMapper::toModel).toList();
    }

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

    public Vacina vincularVacinaPaciente(Long id, Vacina vacina) {
        Paciente pacienteBuscado = buscarPacienteById(id);

        vacina.setPaciente(pacienteBuscado);

        return vacinaMapper.toModel(vacinaRepository.save(vacinaMapper.toEntity(vacina)));
    }

    public List<Atendimento> listarAtendimentosPaciente(Long id) {
        List<Atendimento> atendimentosBuscados = atendimentoRepository.findAllByPacienteId(id).stream().map(atendimentoMapper::toModel).toList();

        if (atendimentosBuscados.isEmpty()) {
            throw new ListaAtendimentosPacienteVaziaException("Nenhum atendimento foi encontrado para esse paciente");
        }

        return atendimentosBuscados;
    }
}
