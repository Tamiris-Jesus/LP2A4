package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Pedido;
import java.util.List;

public record PedidoResponseDTO(Long id, String title, ClienteResponseDTO cliente, List<CardapioResponseDTO> pratos) {
    public PedidoResponseDTO(Pedido pedido){
        this(pedido.getId(), pedido.getTitle(), new ClienteResponseDTO(pedido.getCliente()), pedido.getPratos().stream().map(CardapioResponseDTO::new).toList());
    }
}
