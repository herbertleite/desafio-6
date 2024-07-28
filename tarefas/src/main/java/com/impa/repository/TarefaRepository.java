package com.impa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.impa.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
