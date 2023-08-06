package br.com.ifsp.googleagenda.repository;

import br.com.ifsp.googleagenda.entity.Lembrete;

import java.util.ArrayList;
import java.util.List;

public class LembreteRepository implements CompromissoRepository<Lembrete>{

    private List<Lembrete> lembretesCadastrados = new ArrayList<>();


    @Override
    public void criar(Lembrete objeto) {
        lembretesCadastrados.add(objeto);
    }

    @Override
    public Lembrete ler(Integer id) {
        // Itera sobre os lembretes para encontrar o lembrete com o ID especificado
        for (Lembrete lembrete : lembretesCadastrados) {
            if (lembrete.getId().equals(id)) {
                return lembrete;
            }
        }
        return null; // Retorna null se não encontrar o lembrete com o ID especificado
    }

    @Override
    public void atualizar(Lembrete objeto) {
        // Atualiza o lembrete com o mesmo ID
        for (int i = 0; i < lembretesCadastrados.size(); i++) {
            Lembrete lembrete = lembretesCadastrados.get(i);
            if (lembrete.getId().equals(objeto.getId())) {
                lembretesCadastrados.set(i, objeto);
                break;
            }
        }
    }

    @Override
    public void excluir(Integer id) {
        // Remove o lembrete com o ID especificado
        lembretesCadastrados.removeIf(lembrete -> lembrete.getId().equals(id));
    }

    @Override
    public List<Lembrete> listarTodos() {
        return lembretesCadastrados;
    }


}
