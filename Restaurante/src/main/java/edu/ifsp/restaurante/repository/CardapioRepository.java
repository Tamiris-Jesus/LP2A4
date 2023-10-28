package edu.ifsp.restaurante.repository;


import edu.ifsp.restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Prato, Long> {
}
