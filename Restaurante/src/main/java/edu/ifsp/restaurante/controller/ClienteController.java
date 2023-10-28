package edu.ifsp.restaurante.controller;

import edu.ifsp.restaurante.dto.ClienteRequestDTO;
import edu.ifsp.restaurante.model.Cliente;
import edu.ifsp.restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import edu.ifsp.restaurante.dto.ClienteResponseDTO;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ClienteResponseDTO> listarTodosClientes(){
        return repository.findAll()
                .stream()
                .map(ClienteResponseDTO::new)
                .toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public ClienteResponseDTO listarCliente(@PathVariable Long id) {
        Optional<Cliente> clienteOptional = repository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO(cliente);
            return clienteResponseDTO;
        } else {
            return null;
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void addCliente(@RequestBody ClienteRequestDTO data){
        repository.save(new Cliente(data));
    }

    @PutMapping("/{id}")
    public void editarCliente(@PathVariable Long id, @RequestBody ClienteRequestDTO data){
        Cliente cliente = new Cliente(data);
        cliente.setId(id);
        repository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id){
        repository.deleteById(id);
    }


}
