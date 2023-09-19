package br.edu.ifsp.restaurante.Restaurante.model;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pratos")
@Entity(name = "pratos")

public class Prato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String titulo;
    @Column
    private String descricao;
    @Column
    private Double preco;

    @ManyToMany(mappedBy = "pratos")
    private List<Pedido> pedidos;

    public Prato(CardapioRequestDTO data) {
        this.titulo = data.titulo();
        this.descricao = data.descricao();
        this.preco = data.preco();
        }
}
