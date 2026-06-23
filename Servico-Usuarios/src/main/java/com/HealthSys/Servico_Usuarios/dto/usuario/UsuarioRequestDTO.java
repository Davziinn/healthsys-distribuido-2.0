package com.HealthSys.Servico_Usuarios.dto.usuario;

import com.HealthSys.Servico_Usuarios.enums.RoleUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioRequestDTO (

        @NotBlank(message = "O campo NOME é obrigatório")
        String nome,

        @Email(message = "O campo deve conter um EMAIL válido")
        String email,

        @Size(min = 8, message = "O campo SENHA deve conter no MÍNIMO 8 caracteres")
        String senha,

        RoleUsuario role
) {}
