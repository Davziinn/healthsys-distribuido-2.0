package com.HealthSys.Servico_Usuarios.mapper;

import com.HealthSys.Servico_Usuarios.dto.usuario.UpdateUsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioRequestDTO;
import com.HealthSys.Servico_Usuarios.dto.usuario.UsuarioResponseDTO;
import com.HealthSys.Servico_Usuarios.entity.UsuarioEntity;
import com.HealthSys.Servico_Usuarios.models.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public Usuario toModel(UsuarioEntity entity) {
        return Usuario.builder()
                .id(entity.getId())
                .nomeUsuario(entity.getNomeUsuario())
                .emailUsuario(entity.getEmailUsuario())
                .senha(entity.getSenha())
                .roleUsuario(entity.getRoleUsuario())
                .ativo(entity.isAtivo())
                .dataCriacao(entity.getDataCriacao())
                .dataAtualizacao(entity.getDataAtualizacao())
                .build();
    }

    @Override
    public UsuarioEntity toEntity(Usuario model) {
        return UsuarioEntity.builder()
                .id(model.getId())
                .nomeUsuario(model.getNomeUsuario())
                .emailUsuario(model.getEmailUsuario())
                .senha(model.getSenha())
                .roleUsuario(model.getRoleUsuario())
                .ativo(model.isAtivo())
                .dataCriacao(model.getDataCriacao())
                .dataAtualizacao(model.getDataAtualizacao())
                .build();
    }

    @Override
    public Usuario toModel(UsuarioRequestDTO dto) {
        return Usuario.builder()
                .nomeUsuario(dto.nome())
                .emailUsuario(dto.email())
                .senha(dto.senha())
                .roleUsuario(dto.role())
                .build();
    }

    @Override
    public Usuario toUpdateModel(UpdateUsuarioRequestDTO dto) {
        return Usuario.builder()
                .nomeUsuario(dto.nome())
                .emailUsuario(dto.email())
                .roleUsuario(dto.role())
                .ativo(dto.ativo())
                .build();
    }

    @Override
    public UsuarioResponseDTO toDTO(Usuario model) {
        return new UsuarioResponseDTO(
                model.getId(),
                model.getNomeUsuario(),
                model.getEmailUsuario(),
                model.getRoleUsuario().name(),
                model.isAtivo()
        );
    }

//    @Override
//    public UpdateUsuarioRequestDTO toUpdateDTO(Usuario model) {
//        return new UpdateUsuarioRequestDTO(
//                model.getNomeUsuario(),
//                model.getEmailUsuario(),
//                model.getRoleUsuario(),
//                model.isAtivo()
//        );
//    }
}
