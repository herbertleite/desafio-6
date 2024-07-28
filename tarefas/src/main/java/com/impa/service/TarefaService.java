package com.impa.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impa.entity.Tarefa;
import com.impa.exception.TarefaNotFoundException;
import com.impa.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public List<Tarefa> listarTarefas() {
		return tarefaRepository.findAll();
	}

	public Tarefa exibirTarefa(Long id) {
		return tarefaRepository.findById(id).orElseThrow(() -> new TarefaNotFoundException(id));
	}

	public Tarefa cadastrarTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public Tarefa atualizarTarefa(Long id, Tarefa tarefaAtualizada) {
		if (tarefaRepository.existsById(id)) {
			tarefaAtualizada.setId(id);
			return tarefaRepository.save(tarefaAtualizada);
		} else {
			throw new TarefaNotFoundException(id);
		}
	}

	public void deletarTarefa(Long id) {
		if (tarefaRepository.existsById(id)) {
			tarefaRepository.deleteById(id);
		} else {
			throw new TarefaNotFoundException(id);
		}
	}

	public Tarefa concluirTarefa(Long id) {
		Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new TarefaNotFoundException(id));
		tarefa.setConcluida(true);
		Date dataConclusao = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		tarefa.setDataConclusao(dataConclusao); // Define a data de conclusão como a data atual
		return tarefaRepository.save(tarefa);
	}
}
