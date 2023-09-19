package br.edu.ifsp.restaurante.Restaurante.controller;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.model.Prato;
import br.edu.ifsp.restaurante.Restaurante.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
