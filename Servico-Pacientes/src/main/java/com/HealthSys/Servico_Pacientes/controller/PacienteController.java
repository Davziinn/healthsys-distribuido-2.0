package com.HealthSys.Servico_Pacientes.controller;

import com.HealthSys.Servico_Pacientes.dtos.atendimento.AtendimentoResponseDTO;
import com.HealthSys.Servico_Pacientes.dtos.paciente.PacienteRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.paciente.PacienteResponseDTO;
import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.vacina.VacinaResponseDTO;
import com.HealthSys.Servico_Pacientes.mappers.AtendimentoMapper;
import com.HealthSys.Servico_Pacientes.mappers.PacienteMapper;
import com.HealthSys.Servico_Pacientes.mappers.VacinaMapper;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import com.HealthSys.Servico_Pacientes.model.Paciente;
import com.HealthSys.Servico_Pacientes.model.Vacina;
import com.HealthSys.Servico_Pacientes.service.AtendimentoService;
import com.HealthSys.Servico_Pacientes.service.PacienteService;
import com.HealthSys.Servico_Pacientes.service.VacinaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;
    private final PacienteMapper pacienteMapper;

    private final VacinaService vacinaService;
    private final VacinaMapper vacinaMapper;

    private final AtendimentoService atendimentoService;
    private final AtendimentoMapper atendimentoMapper;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> cadastrarPaciente (@Valid @RequestBody PacienteRequestDTO dto) {
        Paciente pacienteCriado = pacienteService.salvarPaciente(pacienteMapper.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteMapper.toDTO(pacienteCriado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> consultarDadosPacienteById (@PathVariable Long id) {
        Paciente pacienteConsultado = pacienteService.buscarPacienteById(id);

        return ResponseEntity.ok(pacienteMapper.toDTO(pacienteConsultado));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteResponseDTO>> listarPacientes (@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "10") int quantidadeElementos) {
        Page<Paciente> pacientesBuscados = pacienteService.buscarTodosPacientesCadastrados(PageRequest.of(page, quantidadeElementos));

        return ResponseEntity.ok(pacientesBuscados.map(pacienteMapper::toDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> atualizarPacientes (@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO dto) {
        Paciente pacienteEditado = pacienteService.editarPaciente(id, pacienteMapper.toModel(dto));

        return ResponseEntity.ok(pacienteMapper.toDTO(pacienteEditado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagarPaciente (@PathVariable Long id) {
        pacienteService.deletarPacienteById(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/vacinas")
    public ResponseEntity<VacinaResponseDTO> salvarVacinaPaciente (@PathVariable Long id, @Valid @RequestBody VacinaRequestDTO dto) {
        Vacina vacinaFoiVinculada = vacinaService.vincularVacinaPaciente(id, vacinaMapper.toModel(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(vacinaMapper.toDTO(vacinaFoiVinculada));
    }

    @GetMapping("/{id}/atendimentos")
    public ResponseEntity<Page<AtendimentoResponseDTO>> listarAtendimentosPaciente (@PathVariable Long id,
                                                                                    @RequestParam(defaultValue = "0") int page,
                                                                                    @RequestParam(defaultValue = "10") int quantidadeElementos) {
        Page<Atendimento> atendimentosDoPaciente = atendimentoService.listarAtendimentosPaciente(id, PageRequest.of(page, quantidadeElementos));
        return ResponseEntity.ok(atendimentosDoPaciente.map(atendimentoMapper::toDTO));
    }
}
