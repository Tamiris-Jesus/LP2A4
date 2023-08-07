package br.edu.ifsp.restaurante.Restaurante.model;

import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;

public class Funcionario {

    private static Integer idBase = 0;

    private Integer id;
    private String nome;
    private String cpf;
    private String funcao;


    public Funcionario(Integer id, String nome, String cpf, String funcao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.funcao = funcao;
    }

    public Funcionario(FuncionarioRequestDTO f){
        this.nome = f.nome();
        this.cpf = f.cpf();
        this.funcao = f.funcao();
        this.id = idBase++;
    }

    public Funcionario(){}


    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
