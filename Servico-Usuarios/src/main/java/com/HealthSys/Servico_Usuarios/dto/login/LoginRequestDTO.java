package com.HealthSys.Servico_Usuarios.dto.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO (

        @NotBlank(message = "O campo [EMAIL] é obrigatório")
        @Email (message = "Email inválido")
        String email,

        @NotBlank(message = "O campo [SENHA] é obrigatório")
        String senha
){
}
