package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
}
