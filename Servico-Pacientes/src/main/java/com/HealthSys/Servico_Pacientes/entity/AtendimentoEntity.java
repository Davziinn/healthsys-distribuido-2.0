package com.HealthSys.Servico_Pacientes.entity;

import com.HealthSys.Servico_Pacientes.enums.StatusAtendimento;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_ATND")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AtendimentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ATND")
    private Long id;

    @Column(name = "TP_ATND", nullable = false)
    private String tipoAtendimento;

    @Column(name = "DT_ATND", nullable = false, updatable = false)
    private LocalDateTime dataAtendimento;

    @Column(name = "OBS_ATND")
    private String observacoes;

    @Enumerated(EnumType.STRING)
    @Column(name = "ST_ATND", nullable = false)
    private StatusAtendimento statusAtendimento;

    @CreationTimestamp
    @Column(name = "DT_CRI", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DT_ATZ")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "ID_PAC")
    private PacienteEntity paciente;
}
