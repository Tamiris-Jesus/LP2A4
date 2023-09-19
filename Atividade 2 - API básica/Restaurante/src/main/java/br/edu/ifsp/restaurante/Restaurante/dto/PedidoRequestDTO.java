package br.edu.ifsp.restaurante.Restaurante.dto;

import java.util.List;

public record PedidoRequestDTO(String title, Long cliente, List<Long> pratos) {
}
