package com.TaskHub.TaskHub.model.dto.tarefa.request;

import com.TaskHub.TaskHub.model.enums.Prioridade;

import java.time.LocalDate;

public record TarefaCadastroRequest(String titulo, String descricao, LocalDate dataVencimento,
                                    Prioridade prioridade,String nomeProjeto, String token) {
}
