package br.com.ifsp.googleagenda.service;

import br.com.ifsp.googleagenda.entity.Evento;
import br.com.ifsp.googleagenda.repository.EventoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventoService {

    private EventoRepository eventoRepository = new EventoRepository();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void cadastrarEvento(Integer id, String titulo, LocalDateTime dataHoraInicio, String descricao, String local, LocalDateTime dataHoraFim) {
        Evento evento = new Evento(id, titulo, dataHoraInicio, descricao, local, dataHoraFim);
        eventoRepository.criar(evento);
    }

    public Evento buscarEvento(Integer id) {
        return eventoRepository.ler(id);
    }

    public void editarEvento(Integer id, String novoTitulo, LocalDateTime novaDataHoraInicio, String novaDescricao, String novoLocal, LocalDateTime novaDataHoraFim) {
        Evento evento = eventoRepository.ler(id);
        if (evento != null) {
            evento.setTitulo(novoTitulo);
            evento.setDataHorarioInicio(novaDataHoraInicio);
            evento.setDescricao(novaDescricao);
            evento.setLocal(novoLocal);
            evento.setDataHoraFim(novaDataHoraFim);
            eventoRepository.atualizar(evento);
        } else {
            System.out.println("Evento não encontrado com o ID informado.");
        }
    }


    public void excluirEvento(Integer id) {
        eventoRepository.excluir(id);
    }

    public void listarTodosEventos() {
        List<Evento> eventos = eventoRepository.listarTodos();
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado.");
        } else {
            System.out.println("Lista de Eventos:");
            for (Evento evento : eventos) {
                System.out.println(formatarEvento(evento));
            }
        }
    }

    public String formatarEvento(Evento evento) {
        String dataHoraInicioFormatada = evento.getDataHorarioInicio().format(formatter);
        String dataHoraFimFormatada = evento.getDataHoraFim().format(formatter);
        return String.format("ID: %d | Título: %s | Data/Hora Início: %s | Data/Hora Fim: %s | Local: %s | Descrição: %s",
                evento.getId(), evento.getTitulo(), dataHoraInicioFormatada, dataHoraFimFormatada, evento.getLocal(), evento.getDescricao());
    }
}
