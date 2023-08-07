package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Funcionario;

public record FuncionarioResponseDTO(Integer id, String nome, String cpf, String funcao) {
   public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getFuncao());
    }
}
