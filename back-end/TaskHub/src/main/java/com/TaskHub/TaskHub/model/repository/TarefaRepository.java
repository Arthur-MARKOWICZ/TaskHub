package com.TaskHub.TaskHub.model.repository;

import com.TaskHub.TaskHub.model.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
}
