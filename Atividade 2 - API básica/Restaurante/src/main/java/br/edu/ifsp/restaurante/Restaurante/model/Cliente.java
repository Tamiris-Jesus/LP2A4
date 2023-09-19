package br.edu.ifsp.restaurante.Restaurante.model;

import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
@Entity(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    public Cliente(ClienteRequestDTO clienteRequestDTO) {
        this.nome = clienteRequestDTO.nome();
        this.endereco = clienteRequestDTO.endereco();
    }
}

