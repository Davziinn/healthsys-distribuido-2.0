package com.HealthSys.Servico_Usuarios.dto.usuario;

import com.HealthSys.Servico_Usuarios.enums.RoleUsuario;

public record UpdateUsuarioRequestDTO (
        String nome,
        String email,
        RoleUsuario role,
        boolean ativo
) {}
