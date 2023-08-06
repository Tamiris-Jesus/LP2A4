package br.com.ifsp.googleagenda.service;

import br.com.ifsp.googleagenda.entity.Tarefa;
import br.com.ifsp.googleagenda.repository.TarefaRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TarefaService {

    private TarefaRepository tarefaRepository = new TarefaRepository();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void cadastrarTarefa(Integer id, String titulo, LocalDateTime dataHora, String descricao, Boolean repete) {
        Tarefa tarefa = new Tarefa(id, titulo, dataHora, descricao, repete);
        tarefaRepository.criar(tarefa);
    }

    public Tarefa buscarTarefa(Integer id) {
        return tarefaRepository.ler(id);
    }

    public void editarTarefa(Integer id, String novoTitulo, LocalDateTime novaDataHora, String novaDescricao, boolean novoRepete) {
        Tarefa tarefa = tarefaRepository.ler(id);
        if (tarefa != null) {
            tarefa.setTitulo(novoTitulo);
            tarefa.setDataHorarioInicio(novaDataHora);
            tarefa.setDescricao(novaDescricao);
            tarefa.setRepete(novoRepete);
            tarefaRepository.atualizar(tarefa);
        } else {
            System.out.println("Tarefa não encontrada com o ID informado.");
        }
    }


    public void excluirTarefa(Integer id) {
        tarefaRepository.excluir(id);
    }

    public void listarTodosTarefas() {
        List<Tarefa> tarefas = tarefaRepository.listarTodos();
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            System.out.println("Lista de Tarefas:");
            for (Tarefa tarefa : tarefas) {
                System.out.println(formatarTarefa(tarefa));
            }
        }
    }

    public String formatarTarefa(Tarefa tarefa) {
        String dataHoraFormatada = tarefa.getDataHorarioInicio().format(formatter);
        return String.format("ID: %d | Título: %s | Data/Hora: %s | Descrição: %s | Repete: %s",
                tarefa.getId(), tarefa.getTitulo(), dataHoraFormatada, tarefa.getDescricao(), tarefa.getRepete());
    }
}
