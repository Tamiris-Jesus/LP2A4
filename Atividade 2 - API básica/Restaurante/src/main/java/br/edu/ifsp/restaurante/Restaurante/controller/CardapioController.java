package br.edu.ifsp.restaurante.Restaurante.controller;

import br.edu.ifsp.restaurante.Restaurante.dto.CardapioRequestDTO;
import br.edu.ifsp.restaurante.Restaurante.dto.CardapioResponseDTO;
import br.edu.ifsp.restaurante.Restaurante.model.Prato;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("cardapio")

public class CardapioController {

    List<Prato> pratos = new ArrayList<>();

    @GetMapping("/{id}")
    private Prato findPratoById(@PathVariable Integer id) {
        for (Prato prato : pratos) {
            if (prato.getId() == id) {
                return prato;
            }
        }
        return null; // Retorna null se o prato com o ID não for encontrado
    }

    @GetMapping
    public List<CardapioResponseDTO> getAll() {
        pratos.add(new Prato(200, "Macarrao", "macarrao", 200));
        return pratos.stream().map(CardapioResponseDTO::new).toList();
    }

    @PostMapping
    public void addPrato(@RequestBody CardapioRequestDTO data){
        pratos.add(new Prato(data));
    }

    @DeleteMapping("/{id}")
    public void removePrato(@PathVariable Integer id){
        for(Prato prato : pratos){
            if(prato.getId() == id){
                pratos.remove(prato);
            }
        }
    }

    @PutMapping
    public void alteraPrato(@RequestBody CardapioResponseDTO cardapioResponseDTO){
        Prato prato = findPratoById(cardapioResponseDTO.id());
        if (prato == null) {
            System.out.println("Prato não encontrado");
        } else {
            prato.setDescricao(cardapioResponseDTO.descricao());
            prato.setNome(cardapioResponseDTO.titulo());
            prato.setPreco(cardapioResponseDTO.preco());
        }
    }
}
