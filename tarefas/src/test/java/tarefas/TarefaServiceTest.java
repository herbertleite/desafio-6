package tarefas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.impa.entity.Tarefa;
import com.impa.exception.TarefaNotFoundException;
import com.impa.repository.TarefaRepository;
import com.impa.service.TarefaService;

public class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListarTarefas() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.findAll()).thenReturn(Collections.singletonList(tarefa));
        assertEquals(1, tarefaService.listarTarefas().size());
    }

    @Test
    public void testExibirTarefaFound() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.of(tarefa));
        assertEquals(tarefa, tarefaService.exibirTarefa(1L));
    }

    @Test
    public void testExibirTarefaNotFound() {
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(TarefaNotFoundException.class, () -> tarefaService.exibirTarefa(1L));
    }

    @Test
    public void testCadastrarTarefa() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);
        assertEquals(tarefa, tarefaService.cadastrarTarefa(tarefa));
    }

    @Test
    public void testAtualizarTarefaFound() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.existsById(anyLong())).thenReturn(true);
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);
        tarefa.setId(1L);
        assertEquals(tarefa, tarefaService.atualizarTarefa(1L, tarefa));
    }

    @Test
    public void testAtualizarTarefaNotFound() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(TarefaNotFoundException.class, () -> tarefaService.atualizarTarefa(1L, tarefa));
    }

    @Test
    public void testDeletarTarefaFound() {
        when(tarefaRepository.existsById(anyLong())).thenReturn(true);
        tarefaService.deletarTarefa(1L);
        verify(tarefaRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeletarTarefaNotFound() {
        when(tarefaRepository.existsById(anyLong())).thenReturn(false);
        assertThrows(TarefaNotFoundException.class, () -> tarefaService.deletarTarefa(1L));
    }

    @Test
    public void testConcluirTarefaFound() {
        Tarefa tarefa = new Tarefa();
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.of(tarefa));
        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);
        tarefa.setConcluida(true);
        assertEquals(tarefa, tarefaService.concluirTarefa(1L));
        assertTrue(tarefa.isConcluida());
    }

    @Test
    public void testConcluirTarefaNotFound() {
        when(tarefaRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(TarefaNotFoundException.class, () -> tarefaService.concluirTarefa(1L));
    }
}
