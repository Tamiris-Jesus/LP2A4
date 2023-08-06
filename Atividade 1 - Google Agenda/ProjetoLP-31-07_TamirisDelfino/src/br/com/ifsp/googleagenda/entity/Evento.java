package br.com.ifsp.googleagenda.entity;

import br.com.ifsp.googleagenda.entity.Compromisso;

import java.time.LocalDateTime;

public class Evento extends Compromisso {

    private Boolean repete;
    private LocalDateTime dataHoraFim;
    private String local;
    private String descricao;
    private Boolean diaInteiro;

    public Evento(){
        super();

    }
    // Evento com local
    public Evento(Integer id, String titulo, LocalDateTime dataHoraInicio, String descricao, String local, LocalDateTime dataHoraFim) {
        super(id, titulo, dataHoraInicio);
        this.repete = false;
        this.diaInteiro = false;
        this.descricao = descricao;
        this.local = local;
        this.dataHoraFim = dataHoraFim;
    }

    // Evento sem local
    public Evento(Integer id, String titulo, LocalDateTime dataHoraInicio, String descricao, LocalDateTime dataHoraFim) {
        super(id, titulo, dataHoraInicio);
        this.repete = false;
        this.diaInteiro =  false;
        this.descricao = descricao;
        this.dataHoraFim = dataHoraFim;
    }

    public Boolean getRepete() {
        return repete;
    }

    public void setRepete(Boolean repete) {
        this.repete = repete;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDiaInteiro() {
        return diaInteiro;
    }

    public void setDiaInteiro(Boolean diaInteiro) {
        this.diaInteiro = diaInteiro;
    }
}
