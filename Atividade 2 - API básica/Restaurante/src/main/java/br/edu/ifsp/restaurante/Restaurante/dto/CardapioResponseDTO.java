package br.edu.ifsp.restaurante.Restaurante.dto;

import br.edu.ifsp.restaurante.Restaurante.model.Prato;

public record CardapioResponseDTO(Integer id, String titulo, String descricao, double preco) {

   public CardapioResponseDTO(Prato prato){
       this(prato.getId(), prato.getNome(), prato.getDescricao(), prato.getPreco());
   }
}
