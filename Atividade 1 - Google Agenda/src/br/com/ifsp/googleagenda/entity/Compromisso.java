package br.com.ifsp.googleagenda.entity;

import java.time.LocalDateTime;

public abstract class Compromisso {

    private Integer id;
    private String titulo;
    private LocalDateTime dataHorarioInicio;

    public Compromisso(Integer id, String titulo, LocalDateTime dataHora) {
        this.id = id;
        this.titulo = titulo;
        this.dataHorarioInicio = dataHora;
    }

    public Compromisso(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHorarioInicio() {
        return dataHorarioInicio;
    }

    public void setDataHorarioInicio(LocalDateTime dataHorarioInicio) {
        this.dataHorarioInicio = dataHorarioInicio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getData() {
        return dataHorarioInicio;
    }

    public void setData(LocalDateTime data) {
        this.dataHorarioInicio = data;
    }


}
