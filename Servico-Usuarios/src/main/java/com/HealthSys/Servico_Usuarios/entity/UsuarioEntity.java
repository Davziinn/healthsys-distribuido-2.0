package com.HealthSys.Servico_Usuarios.entity;

import com.HealthSys.Servico_Usuarios.enums.RoleUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TB_USU")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USU")
    private Long id;

    @Column(name = "NM_USU", length = 150, nullable = false)
    private String nomeUsuario;

    @Column(name = "EML_USU", length = 150, nullable = false, unique = true)
    private String emailUsuario;

    @Column(name = "SNH_USU", length = 50, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "RL_USU", nullable = false)
    private RoleUsuario roleUsuario;

    @Column(name = "ATV_USU", nullable = false)
    private boolean ativo;

    @CreationTimestamp
    @Column(name = "DT_CRI_USU", nullable = false)
    private LocalDateTime dataCriacao;

    @UpdateTimestamp
    @Column(name = "DT_ATZ_USU")
    private LocalDateTime dataAtualizacao;
}
