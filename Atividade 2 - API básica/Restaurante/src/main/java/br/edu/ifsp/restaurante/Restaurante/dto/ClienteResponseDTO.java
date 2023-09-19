package br.edu.ifsp.restaurante.Restaurante.dto;


import br.edu.ifsp.restaurante.Restaurante.model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.model.Endereco;

public record ClienteResponseDTO(Long id, String nome, Endereco endereco/*, List<PedidoResponseDTO> pedidos*/) {
    public ClienteResponseDTO(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEndereco()/*, cliente.getPedidos().stream().map(PedidoResponseDTO::new).toList()*/);
    }
}
