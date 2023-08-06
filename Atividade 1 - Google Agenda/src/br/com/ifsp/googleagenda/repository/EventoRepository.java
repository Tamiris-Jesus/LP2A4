package br.com.ifsp.googleagenda.repository;

import br.com.ifsp.googleagenda.entity.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoRepository implements CompromissoRepository<Evento>{

    private List<Evento> eventosCadastrados = new ArrayList<>();
    @Override
    public void criar(Evento evento) {
        eventosCadastrados.add(evento);
    }

    @Override
    public Evento ler(Integer id) {
        for (Evento evento : eventosCadastrados) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Evento evento) {
        for (int i = 0; i < eventosCadastrados.size(); i++) {
            Evento eventoAtual = eventosCadastrados.get(i);
            if (eventoAtual.getId().equals(evento.getId())) {
                eventosCadastrados.set(i, evento);
                break;
            }
        }
    }

    @Override
    public void excluir(Integer id) {
        eventosCadastrados.removeIf(evento -> evento.getId().equals(id));
    }

    @Override
    public List<Evento> listarTodos() {
        return eventosCadastrados;
    }
}
