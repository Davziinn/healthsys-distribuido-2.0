package com.HealthSys.Servico_Usuarios.models;

import com.HealthSys.Servico_Usuarios.enums.RoleUsuario;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Usuario {

    private Long id;
    private String nomeUsuario;
    private String emailUsuario;
    private String senha;
    private RoleUsuario roleUsuario;
    private boolean ativo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
