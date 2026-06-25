package com.HealthSys.Servico_Pacientes.repository;

import com.HealthSys.Servico_Pacientes.entity.VacinaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<VacinaEntity, Long> {
}
