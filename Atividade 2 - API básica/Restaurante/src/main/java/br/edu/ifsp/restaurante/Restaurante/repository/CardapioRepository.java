package br.edu.ifsp.restaurante.Restaurante.repository;


import br.edu.ifsp.restaurante.Restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Prato, Long> {
}
