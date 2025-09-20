package com.TaskHub.TaskHub.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comentario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

}
