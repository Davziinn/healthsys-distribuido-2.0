package com.HealthSys.Servico_Triagem.controller;

import com.HealthSys.Servico_Triagem.dto.TriagemRequestDTO;
import com.HealthSys.Servico_Triagem.service.TriagemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/triagem")
@RequiredArgsConstructor
public class TriagemController {

    private final TriagemService triagemService;

    @PostMapping
    public ResponseEntity<Void> concluirTriagem (@RequestBody TriagemRequestDTO dto) {
        triagemService.concluirTriagem(dto.idPaciente(), dto.nivelRisco());
        return ResponseEntity.accepted().build();
    }
}
