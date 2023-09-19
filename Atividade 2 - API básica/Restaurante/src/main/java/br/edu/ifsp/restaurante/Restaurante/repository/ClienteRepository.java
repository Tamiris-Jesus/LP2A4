package br.edu.ifsp.restaurante.Restaurante.repository;


import br.edu.ifsp.restaurante.Restaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
