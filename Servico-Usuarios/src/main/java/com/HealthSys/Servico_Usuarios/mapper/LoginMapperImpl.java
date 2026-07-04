package com.HealthSys.Servico_Usuarios.mapper;

import com.HealthSys.Servico_Usuarios.dto.login.LoginResponseDTO;
import com.HealthSys.Servico_Usuarios.models.Login;
import org.springframework.stereotype.Component;

@Component
public class LoginMapperImpl implements LoginMapper{
    @Override
    public LoginResponseDTO toDTO(Login login) {
        return new LoginResponseDTO(
                login.getToken(),
                login.getUsername(),
                login.getRole()
        );
    }

    @Override
    public Login toModel(LoginResponseDTO dto) {
        return Login.builder()
                .token(dto.token())
                .username(dto.username())
                .role(dto.role())
                .build();
    }
}
