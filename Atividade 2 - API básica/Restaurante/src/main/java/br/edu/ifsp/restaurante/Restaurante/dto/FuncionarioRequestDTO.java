package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Endereco;

public record FuncionarioRequestDTO(String nome, String cpf, String funcao, Endereco endereco){
}
