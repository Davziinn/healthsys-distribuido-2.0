package com.HealthSys.Servico_Usuarios.controller;

import com.HealthSys.Servico_Usuarios.dto.login.LoginRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.login.LoginResponseDTO;
import com.HealthSys.Servico_Usuarios.mapper.LoginMapper;
import com.HealthSys.Servico_Usuarios.models.Login;
import com.HealthSys.Servico_Usuarios.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final LoginMapper loginMapper;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> realizarLogin (@Valid @RequestBody LoginRequestDTO login) {
        Login usuarioLogado = authService.login(login.email(), login.senha());
        return ResponseEntity.ok(loginMapper.toDTO(usuarioLogado));
    }
}
