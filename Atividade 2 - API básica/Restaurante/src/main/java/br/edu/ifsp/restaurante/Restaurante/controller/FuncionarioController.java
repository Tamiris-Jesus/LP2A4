package br.edu.ifsp.restaurante.Restaurante.controller;

import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.model.Funcionario;
import br.edu.ifsp.restaurante.Restaurante.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FuncionarioResponseDTO> listarTodosFuncionarios(){
        return repository.findAll()
                .stream()
                .map(FuncionarioResponseDTO::new)
                .toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public FuncionarioResponseDTO listarFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);
        if (funcionarioOptional.isPresent()) {
            Funcionario funcionario = funcionarioOptional.get();
            FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO(funcionario);
            return funcionarioResponseDTO;
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void addFuncionario(@RequestBody FuncionarioRequestDTO data){
        repository.save(new Funcionario(data));
    }

    @PutMapping("/{id}")
    public void editarFuncionario(@PathVariable Long id, @RequestBody FuncionarioRequestDTO data){
        Funcionario funcionario = new Funcionario(data);
        funcionario.setId(id);
        repository.save(funcionario);
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id){
        repository.deleteById(id);
    }


}
