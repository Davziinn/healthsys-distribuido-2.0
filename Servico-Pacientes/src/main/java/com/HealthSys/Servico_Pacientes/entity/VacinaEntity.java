package com.HealthSys.Servico_Pacientes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VAC")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class VacinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VAC")
    private Long id;

    @Column(name = "NM_VAC", nullable = false)
    private String nomeVacina;

    @Column(name = "DT_APL_VAC", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "LT_VAC", nullable = false)
    private String loteVacina;

    @CreationTimestamp
    @Column(name = "DT_CRI", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DT_ATZ")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PAC")
    private PacienteEntity paciente;

}
