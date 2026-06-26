package com.HealthSys.Servico_Pacientes.service;

import com.HealthSys.Servico_Pacientes.mappers.VacinaMapper;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import com.HealthSys.Servico_Pacientes.repository.VacinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VacinaService {

    private final VacinaRepository vacinaRepository;
    private final VacinaMapper vacinaMapper;
    private final PacienteService pacienteService;

    @Transactional
    public Vacina vincularVacinaPaciente(Long id, Vacina vacina) {
        Paciente pacienteBuscado = pacienteService.buscarPacienteById(id);

        vacina.setPaciente(pacienteBuscado);

        return vacinaMapper.toModel(vacinaRepository.save(vacinaMapper.toEntity(vacina)));
    }

}
