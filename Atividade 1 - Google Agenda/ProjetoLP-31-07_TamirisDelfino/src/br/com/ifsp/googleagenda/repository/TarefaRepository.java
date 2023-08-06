package br.com.ifsp.googleagenda.repository;

import br.com.ifsp.googleagenda.entity.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaRepository implements CompromissoRepository<Tarefa>{

    private List<Tarefa> tarefasCadastradas= new ArrayList<>();

    @Override
    public void criar(Tarefa objeto) {
        tarefasCadastradas.add(objeto);
    }

    @Override
    public Tarefa ler(Integer id) {
        for (Tarefa tarefa : tarefasCadastradas) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Tarefa objeto) {
        for (int i = 0; i < tarefasCadastradas.size(); i++) {
            Tarefa tarefa = tarefasCadastradas.get(i);
            if (tarefa.getId().equals(objeto.getId())) {
                tarefasCadastradas.set(i, objeto);
                break;
            }
        }
    }

    @Override
    public void excluir(Integer id) {
        tarefasCadastradas.removeIf(tarefa -> tarefa.getId().equals(id));
    }

    @Override
    public List<Tarefa> listarTodos() {
        return tarefasCadastradas;
    }
}
