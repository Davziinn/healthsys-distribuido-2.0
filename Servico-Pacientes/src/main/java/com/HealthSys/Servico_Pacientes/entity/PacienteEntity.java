package com.HealthSys.Servico_Pacientes.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_PAC")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAC")
    private Long id;

    @Column(name = "ID_USU", nullable = false, unique = true)
    private Long idUsuario;

    @Column(name = "NM_PAC", nullable = false)
    private String nomePaciente;

    @Column(name = "CPF_PAC", nullable = false, unique = true, length = 14)
    private String cpfPaciente;

    @Column(name = "DT_NASC", nullable = false, length = 10)
    private LocalDate dataNascimento;

    @Column(name = "SX_PAC", nullable = false)
    private String sexo;

    @Column(name = "TEL_PAC")
    private String telefone;

    @CreationTimestamp
    @Column(name = "DT_CRI", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "DT_ATZ")
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<AtendimentoEntity> atendimentos;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<VacinaEntity> vacinas;
}
