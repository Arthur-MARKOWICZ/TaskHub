package com.TaskHub.TaskHub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_notificacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;
    private LocalDateTime dataEnvio;
    private boolean lida;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
