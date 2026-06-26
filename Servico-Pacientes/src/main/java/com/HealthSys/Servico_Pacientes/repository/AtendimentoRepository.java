package com.HealthSys.Servico_Pacientes.repository;

import com.HealthSys.Servico_Pacientes.entity.AtendimentoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long> {
    Page<AtendimentoEntity> findAllByPacienteId (Long pacienteId, Pageable pageable);
}
