package edu.ifsp.restaurante.model;

import edu.ifsp.restaurante.dto.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "funcionarios")
@Entity(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String cpf;
    @Column
    private String funcao;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Funcionario(String nome, String cpf, String funcao, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.funcao = funcao;
        this.endereco = endereco;
    }

    public Funcionario(FuncionarioRequestDTO f){
        this.nome = f.nome();
        this.cpf = f.cpf();
        this.funcao = f.funcao();
        this.endereco = f.endereco();
    }


}
