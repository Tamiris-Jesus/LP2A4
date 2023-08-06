package br.com.ifsp.googleagenda.entity;

import br.com.ifsp.googleagenda.entity.Compromisso;

import java.time.LocalDateTime;

public class Lembrete extends Compromisso {

    public Lembrete(Integer id, String titulo, LocalDateTime dataHora) {
        super(id, titulo, dataHora);
    }
}
