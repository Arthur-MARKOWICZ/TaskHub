package com.TaskHub.TaskHub.model.repository;

import com.TaskHub.TaskHub.model.entity.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacaoRepository extends JpaRepository<Notificacao,Long> {
}
