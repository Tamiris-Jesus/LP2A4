package br.com.ifsp.googleagenda.repository;

import br.com.ifsp.googleagenda.entity.Compromisso;
import br.com.ifsp.googleagenda.entity.Lembrete;

import java.util.List;

public interface CompromissoRepository<T extends Compromisso> {
    void criar(T objeto);

    // Método para ler um registro pelo seu ID
    T ler(Integer id);

    void atualizar(T objeto);

    void excluir(Integer id);

    List<T> listarTodos();
}
