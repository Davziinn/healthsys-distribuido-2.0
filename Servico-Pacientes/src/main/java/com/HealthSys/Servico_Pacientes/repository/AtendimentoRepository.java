package com.HealthSys.Servico_Pacientes.repository;

import com.HealthSys.Servico_Pacientes.entity.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long> {
    List<AtendimentoEntity> findAllByPacienteId (Long pacienteId);
}
