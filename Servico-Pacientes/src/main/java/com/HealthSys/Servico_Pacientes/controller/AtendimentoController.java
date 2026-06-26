package com.HealthSys.Servico_Pacientes.controller;

import com.HealthSys.Servico_Pacientes.dtos.atendimento.AtendimentoRequestDTO;
import com.HealthSys.Servico_Pacientes.dtos.atendimento.AtendimentoResponseDTO;
import com.HealthSys.Servico_Pacientes.mappers.AtendimentoMapper;
import com.HealthSys.Servico_Pacientes.model.Atendimento;
import com.HealthSys.Servico_Pacientes.service.AtendimentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/atendimento")
@RequiredArgsConstructor
public class AtendimentoController {

    private final AtendimentoService atendimentoService;
    private final AtendimentoMapper atendimentoMapper;

    @PostMapping("/{idPaciente}")
    public ResponseEntity<AtendimentoResponseDTO> cadastrarAtendimento (@PathVariable Long idPaciente, @Valid @RequestBody AtendimentoRequestDTO dto) {
        Atendimento atendimentoCadastrado = atendimentoService.salvarAtendimento(idPaciente, atendimentoMapper.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoMapper.toDTO(atendimentoCadastrado));
    }
}
