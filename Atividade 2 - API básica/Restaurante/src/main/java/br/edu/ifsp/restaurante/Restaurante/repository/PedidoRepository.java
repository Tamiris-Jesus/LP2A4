package br.edu.ifsp.restaurante.Restaurante.repository;


import br.edu.ifsp.restaurante.Restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
