package edu.ifsp.restaurante.dto;

import edu.ifsp.restaurante.model.Endereco;
import edu.ifsp.restaurante.model.Funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String cpf, String funcao, Endereco endereco) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getFuncao(), funcionario.getEndereco());
    }
}
