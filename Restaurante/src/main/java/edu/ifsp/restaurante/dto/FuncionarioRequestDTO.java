package edu.ifsp.restaurante.dto;

import edu.ifsp.restaurante.model.Endereco;

public record FuncionarioRequestDTO(String nome, String cpf, String funcao, Endereco endereco){
}
