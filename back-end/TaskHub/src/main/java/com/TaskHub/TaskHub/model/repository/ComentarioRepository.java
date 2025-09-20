package com.TaskHub.TaskHub.model.repository;

import com.TaskHub.TaskHub.model.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
