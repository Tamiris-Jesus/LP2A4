package edu.ifsp.restaurante.controller;

import edu.ifsp.restaurante.dto.PedidoRequestDTO;
import edu.ifsp.restaurante.dto.PedidoResponseDTO;
import edu.ifsp.restaurante.model.Pedido;
import edu.ifsp.restaurante.model.Prato;
import edu.ifsp.restaurante.repository.CardapioRepository;
import edu.ifsp.restaurante.repository.ClienteRepository;
import edu.ifsp.restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository repositoryCliente;

    @Autowired
    private CardapioRepository repositoryPratos;

    @GetMapping
    public List<PedidoResponseDTO> listarTodosPedidos(){
        return repository.findAll().stream().map(PedidoResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public PedidoResponseDTO listarPedido(@PathVariable Long id){
        Optional<Pedido> pedidoencontrado = repository.findById(id);
        if(pedidoencontrado.isPresent()){
            Pedido pedido = pedidoencontrado.get();
            PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(pedido);
            return pedidoResponseDTO;
        } else{
            return null;
        }
    }

    @PostMapping
    public void addPedido(@RequestBody PedidoRequestDTO data){
        List<Prato> p = new ArrayList<>();
        for (Long id: data.pratos()) {
            p.add(repositoryPratos.findById(id).get());
        }
        repository.save(new Pedido(data.title(), repositoryCliente.findById(data.cliente()).get(), p));
    }

//    @PutMapping("/{id}")
//    public void editarPedido(@PathVariable Long id, @RequestBody PedidoRequestDTO data){
//        Pedido pedidoAtualizado = new Pedido(data);
//        pedidoAtualizado.setId(id);
//        repository.save(pedidoAtualizado);
//    }
//
//
    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id){
        repository.deleteById(id);
    }

}
