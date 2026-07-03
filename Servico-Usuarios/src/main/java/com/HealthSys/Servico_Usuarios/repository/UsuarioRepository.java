package com.HealthSys.Servico_Usuarios.repository;

import com.HealthSys.Servico_Usuarios.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByEmailUsuario (String email);
}
