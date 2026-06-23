package com.HealthSys.Servico_Usuarios.controller;

import com.HealthSys.Servico_Usuarios.dto.usuario.UpdateUsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioResponseDTO;
import com.HealthSys.Servico_Usuarios.mapper.UsuarioMapper;
import com.HealthSys.Servico_Usuarios.models.Usuario;
import com.HealthSys.Servico_Usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario (@Valid @RequestBody UsuarioRequestDTO dto) {
        Usuario usuarioCadastrado = usuarioService.salvarUsuario(usuarioMapper.toModel(dto));

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDTO(usuarioCadastrado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> consultarUsuarioById (@PathVariable Long id) {
        Usuario usuarioBuscado = usuarioService.buscarUsuarioById(id);

        return ResponseEntity.ok(usuarioMapper.toDTO(usuarioBuscado));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> consultarTodosUsuarios () {
        return ResponseEntity.ok(usuarioService.buscarTodosUsuarios().stream().map(usuarioMapper::toDTO).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario (@PathVariable Long id, @Valid @RequestBody UpdateUsuarioRequestDTO dto) {
        Usuario usuarioAtualizado = usuarioService.editarUsuario(id, usuarioMapper.toUpdateModel(dto));

        return ResponseEntity.ok(usuarioMapper.toDTO(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario (@PathVariable Long id) {
        usuarioService.deletarUsuarioById(id);
        return ResponseEntity.noContent().build();
    }
}
