package com.HealthSys.Servico_Usuarios.mapper;

import com.HealthSys.Servico_Usuarios.dto.login.LoginResponseDTO;
import com.HealthSys.Servico_Usuarios.models.Login;

public interface LoginMapper {
    LoginResponseDTO toDTO (Login login);
    Login toModel (LoginResponseDTO dto);
}
