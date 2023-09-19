package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String telefone;

    public Cliente() {

    }

    public Cliente(String nome, LocalDate dataNasc, String cpf, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNasc;
        this.cpf = cpf;
        this.telefone = telefone;
    }


    public String getDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato desejado
        return dataNascimento.format(formatter);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
