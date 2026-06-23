package com.HealthSys.Servico_Usuarios.dto.usuario;

public record UsuarioResponseDTO(
        Long id,
        String nomeUsuario,
        String emailUsuario,
        String roleUsuario,
        boolean ativo
) {
}
