package br.com.ifsp.googleagenda.entity;

import java.time.LocalDateTime;

public class Tarefa extends Compromisso {

    private Boolean repete;
    private String descricao;


    public Tarefa(Integer id, String titulo, LocalDateTime dataHora, String descricao, boolean repete) {
        super(id, titulo, dataHora);
        this.repete = repete;
        this.descricao = descricao;
    }

    public Boolean getRepete() {
        return repete;
    }

    public void setRepete(Boolean repete) {
        this.repete = repete;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
