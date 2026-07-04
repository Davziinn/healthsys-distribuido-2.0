package com.HealthSys.Servico_Usuarios.dto.login;

public record LoginResponseDTO(
        String token,
        String role,
        String username
) {
}
