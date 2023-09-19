package br.edu.ifsp.restaurante.Restaurante.controller;

import br.edu.ifsp.restaurante.Restaurante.dto.ClienteResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.PedidoResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.model.Cliente;
import br.edu.ifsp.restaurante.Restaurante.model.Pedido;
import br.edu.ifsp.restaurante.Restaurante.model.Prato;
import br.edu.ifsp.restaurante.Restaurante.repository.CardapioRepository;
import br.edu.ifsp.restaurante.Restaurante.repository.ClienteRepository;
import br.edu.ifsp.restaurante.Restaurante.repository.PedidoRepository;
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



    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id){
        repository.deleteById(id);
    }


}
