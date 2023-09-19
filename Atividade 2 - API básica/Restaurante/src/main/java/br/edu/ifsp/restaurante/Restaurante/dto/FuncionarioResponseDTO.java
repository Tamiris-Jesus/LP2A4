package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Endereco;
import br.edu.ifsp.restaurante.Restaurante.model.Funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String cpf, String funcao, Endereco endereco) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getFuncao(), funcionario.getEndereco());
    }
}
