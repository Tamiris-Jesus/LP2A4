package br.edu.ifsp.restaurante.Restaurante.controller;

import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.FuncionarioResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.model.Funcionario;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("funcionario")

public class FuncionarioController {

    List<Funcionario> funcionarios = new ArrayList<>();

    @PostMapping
    public void addFuncionario(@RequestBody FuncionarioRequestDTO data){
        funcionarios.add(new Funcionario(data));

    }

    @GetMapping
    public List<FuncionarioResponseDTO> getAll(){
        return funcionarios.stream().map(FuncionarioResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public Funcionario findFuncById(@PathVariable Integer id){
        for(Funcionario f : funcionarios){
            if(f.getId() == id){
                return f;
            }
        } return null;
    }

    @DeleteMapping("/{id}")
    public void removeFuncionario(@PathVariable Integer id){
        for(Funcionario f : funcionarios){
            if(f.getId() == id){
                funcionarios.remove(f);
            }
        }
    }

    @PutMapping
    public void alteraFuncionario(@RequestBody FuncionarioResponseDTO funcionarioResponseDTO){
        Funcionario funcionario = findFuncById(funcionarioResponseDTO.id());
        if(funcionario == null){
            System.out.println("Funcionario nao encontrado");
        } else {
            funcionario.setCpf(funcionarioResponseDTO.cpf());
            funcionario.setNome(funcionarioResponseDTO.nome());
            funcionario.setFuncao(funcionarioResponseDTO.funcao());
        }
    }
}
