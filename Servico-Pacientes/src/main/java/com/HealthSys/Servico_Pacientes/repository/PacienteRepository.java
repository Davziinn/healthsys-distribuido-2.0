package com.HealthSys.Servico_Pacientes.repository;

import com.HealthSys.Servico_Pacientes.entity.PacienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {
}
