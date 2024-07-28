package com.impa.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.impa.entity.Tarefa;
import com.impa.exception.TarefaNotFoundException;
import com.impa.service.TarefaService;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Value("${welcome.message:test}")
    private String message = "Hello World";
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        model.put("tarefas", tarefas);
        return "welcome";
    }

    @GetMapping("/tarefas/{id}")
    public String exibirTarefa(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaService.exibirTarefa(id);
        model.addAttribute("tarefa", tarefa);
        return "visualizar";
    }

    @GetMapping("/tarefas/{id}/editar")
    public String editarTarefa(@PathVariable("id") Long id, Model model) {
        Tarefa tarefa = tarefaService.exibirTarefa(id);
        model.addAttribute("tarefa", tarefa);
        return "editar";
    }

    @PostMapping("/tarefas/{id}/atualizar")
    public String atualizarTarefa(@PathVariable("id") Long id, @ModelAttribute Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefaService.exibirTarefa(id);
        tarefaAtualizada.setId(id);
        tarefaAtualizada.setDataCriacao(tarefaExistente.getDataCriacao());

        if (tarefaAtualizada.isConcluida()) {
            if (tarefaExistente.getDataConclusao() == null) {
                tarefaAtualizada.setDataConclusao(new Date());
            } else {
                tarefaAtualizada.setDataConclusao(tarefaExistente.getDataConclusao());
            }
        } else {
            tarefaAtualizada.setDataConclusao(null);
        }

        tarefaService.atualizarTarefa(id, tarefaAtualizada);
        return "redirect:/";
    }


    @PostMapping("/tarefas/{id}/deletar")
    public String deletarTarefa(@PathVariable("id") Long id) {
        tarefaService.deletarTarefa(id);
        return "redirect:/";
    }

    @PostMapping("/tarefas/{id}/concluir")
    public String concluirTarefa(@PathVariable("id") Long id) {
        tarefaService.concluirTarefa(id);
        return "redirect:/";
    }
    
    @GetMapping("/novo")
    public String novaTarefaForm(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "novaTarefa";
    }

    @PostMapping("/novo")
    public String criarTarefa(@ModelAttribute Tarefa tarefa) {
        tarefaService.cadastrarTarefa(tarefa);
        return "redirect:/";
    }

    @ControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler(TarefaNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String handleTarefaNotFoundException(TarefaNotFoundException ex, Model model) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "error";
        }
    }
}
