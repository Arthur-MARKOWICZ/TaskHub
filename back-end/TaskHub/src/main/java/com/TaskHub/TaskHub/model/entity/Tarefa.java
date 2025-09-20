package com.TaskHub.TaskHub.model.entity;

import com.TaskHub.TaskHub.model.enums.Prioridade;
import com.TaskHub.TaskHub.model.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Stack;

@Entity
@Table(name =  "tb_tarefas")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descricao;
    private LocalDate dataVencimento;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
