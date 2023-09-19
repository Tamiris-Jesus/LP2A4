package br.edu.ifsp.restaurante.Restaurante.model;

import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedidos")
@Entity(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pedido-prato", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "prato_id"))
    private List<Prato> pratos;

    public Pedido(String title, Cliente cliente, List<Prato> pratos) {
        this.title = title;
        this.cliente = cliente;
        this.pratos = pratos;
    }

//    public Pedido(PedidoRequestDTO data) {
//        this.title = data.title();
//        this.cliente.setId(data.cliente());
//        for (Long id : data.pratos()){
//            this.pratos.set(id, data.pratos());
//        }
//    }
}
