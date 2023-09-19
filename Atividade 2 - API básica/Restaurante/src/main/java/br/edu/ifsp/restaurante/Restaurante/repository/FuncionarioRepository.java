package br.edu.ifsp.restaurante.Restaurante.repository;

import br.edu.ifsp.restaurante.Restaurante.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
