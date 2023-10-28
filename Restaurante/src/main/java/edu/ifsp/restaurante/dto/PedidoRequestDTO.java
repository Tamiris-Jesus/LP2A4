package edu.ifsp.restaurante.dto;

import java.util.List;

public record PedidoRequestDTO(String title, Long cliente, List<Long> pratos) {
}
