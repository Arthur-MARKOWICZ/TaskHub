package com.TaskHub.TaskHub.model.repository;

import com.TaskHub.TaskHub.model.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjetoRepository extends JpaRepository<Projeto,Long> {
    Optional<Projeto> findByNome(String nome);
}
