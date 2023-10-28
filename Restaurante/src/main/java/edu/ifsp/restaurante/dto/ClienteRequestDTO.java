package edu.ifsp.restaurante.dto;

import edu.ifsp.restaurante.model.Endereco;

public record ClienteRequestDTO(String nome, Endereco endereco) {
}
