package com.HealthSys.Servico_Usuarios.mapper;


import com.HealthSys.Servico_Usuarios.dto.usuario.UpdateUsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioResponseDTO;
import com.HealthSys.Servico_Usuarios.entity.UsuarioEntity;
import com.HealthSys.Servico_Usuarios.models.Usuario;

public interface UsuarioMapper {

    Usuario toModel (UsuarioEntity entity);

    UsuarioEntity toEntity (Usuario model);

    Usuario toModel (UsuarioRequestDTO dto);

    Usuario toUpdateModel (UpdateUsuarioRequestDTO dto);

    UsuarioResponseDTO toDTO (Usuario model);

    //UpdateUsuarioRequestDTO toUpdateDTO (Usuario model);
}
