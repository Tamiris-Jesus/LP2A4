package br.edu.ifsp.restaurante.Restaurante.model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
//@Data // Gera Getters e Settters de todos os atributos
//@NoArgsConstructor
public class Prato {

    private static Integer idBase = 0;

    private Integer id;
    private String nome;
    private String descricao;
    private double preco;

    public Prato(CardapioRequestDTO cardapioRequestDTO){
        this.nome = cardapioRequestDTO.titulo();
        this.descricao = cardapioRequestDTO.descricao();
        this.preco = cardapioRequestDTO.preco();
        this.id = idBase++;
    }

    public Prato(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Prato(Integer id, String nome, String descricao, double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
