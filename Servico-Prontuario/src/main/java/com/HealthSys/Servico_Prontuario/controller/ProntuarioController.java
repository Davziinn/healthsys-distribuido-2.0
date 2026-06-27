package com.HealthSys.Servico_Prontuario.controller;

import com.HealthSys.Servico_Prontuario.dto.consulta.ConsultaRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioDetalhadoResponseDTO;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioRequestDTO;
import com.HealthSys.Servico_Prontuario.dto.prontuario.ProntuarioResponseDTO;
import com.HealthSys.Servico_Prontuario.mappers.ConsultaMapper;
import com.HealthSys.Servico_Prontuario.mappers.ProntuarioMapper;
import com.HealthSys.Servico_Prontuario.models.Prontuario;
import com.HealthSys.Servico_Prontuario.service.ProntuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prontuario")
@RequiredArgsConstructor
public class ProntuarioController {

    private final ProntuarioService prontuarioService;
    private final ProntuarioMapper prontuarioMapper;
    private final ConsultaMapper consultaMapper;

    @PostMapping
    public ResponseEntity<ProntuarioResponseDTO> cadastrarProntuario (@Valid @RequestBody ProntuarioRequestDTO dto) {
        Prontuario prontuarioSalvo = prontuarioService.salvarProntuario(prontuarioMapper.toModel(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(prontuarioMapper.toDTO(prontuarioSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDetalhadoResponseDTO> buscarId(@PathVariable String id) {
        return ResponseEntity.ok(prontuarioMapper.toDetalhadoDTO(prontuarioService.buscarById(id)));
    }

    @GetMapping("/{idPaciente}/paciente")
    public ResponseEntity<List<ProntuarioResponseDTO>> buscarByPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(prontuarioService.buscarByIdPaciente(idPaciente).stream().map(prontuarioMapper::toDTO).toList());
    }

    @PostMapping("/{id}/consultas")
    public ResponseEntity<ProntuarioResponseDTO> cadastrarConsultaProntuario (@Valid @PathVariable String id, @RequestBody ConsultaRequestDTO dto){
        Prontuario atualizado = prontuarioService.adicionarConsulta(
                id, consultaMapper.toConsultaModel(dto)
        );
        return ResponseEntity.ok(prontuarioMapper.toDTO(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProntuario(@PathVariable String id) {
        prontuarioService.deletarProntuario(id);
        return ResponseEntity.noContent().build();
    }
}
