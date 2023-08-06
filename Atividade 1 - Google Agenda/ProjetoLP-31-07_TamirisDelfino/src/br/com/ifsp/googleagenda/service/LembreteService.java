package br.com.ifsp.googleagenda.service;

import br.com.ifsp.googleagenda.entity.Lembrete;
import br.com.ifsp.googleagenda.repository.LembreteRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LembreteService {

    private LembreteRepository lembreteRepository = new LembreteRepository();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void criarLembrete(Integer id, String titulo, LocalDateTime dataHora) {
        Lembrete lembrete = new Lembrete(id, titulo, dataHora);
        lembreteRepository.criar(lembrete);
    }

    public Lembrete buscarLembrete(Integer id) {
        return lembreteRepository.ler(id);
    }

    public void editarLembrete(Integer id, String novoTitulo, LocalDateTime novaDataHora) {
        Lembrete lembrete = lembreteRepository.ler(id);
        if (lembrete != null) {
            lembrete.setTitulo(novoTitulo);
            lembrete.setDataHorarioInicio(novaDataHora);
            lembreteRepository.atualizar(lembrete);
        } else {
            System.out.println("Lembrete não encontrado com o ID informado.");
        }
    }


    public void excluirLembrete(Integer id) {
        lembreteRepository.excluir(id);
    }

    public void listarTodosLembretes() {
        List<Lembrete> lembretes = lembreteRepository.listarTodos();
        if (lembretes.isEmpty()) {
            System.out.println("Nenhum lembrete cadastrado.");
        } else {
            System.out.println("Lista de Lembretes:");
            for (Lembrete lembrete : lembretes) {
                System.out.println(formatarLembrete(lembrete));
            }
        }
    }

    public String formatarLembrete(Lembrete lembrete) {
        String dataHoraFormatada = lembrete.getDataHorarioInicio().format(formatter);
        return String.format("ID: %d | Título: %s | Data/Hora: %s", lembrete.getId(), lembrete.getTitulo(), dataHoraFormatada);
    }
}
