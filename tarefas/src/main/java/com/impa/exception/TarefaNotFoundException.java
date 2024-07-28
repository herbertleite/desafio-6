package com.impa.exception;

public class TarefaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TarefaNotFoundException(Long id) {
        super("Não foi possível encontrar a tarefa com ID " + id);
    }
}
