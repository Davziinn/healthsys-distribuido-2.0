package com.HealthSys.Servico_Usuarios.repository;

import com.HealthSys.Servico_Usuarios.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
