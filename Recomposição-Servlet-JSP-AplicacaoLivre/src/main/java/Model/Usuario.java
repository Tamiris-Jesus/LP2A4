package Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario {

    private static Long idClasse = 0L;
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private boolean organizador;

    public Usuario(String nome, String email, String senha, boolean organizador) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.organizador = organizador;
        this.id = idClasse++;
    }

    public boolean isOrganizador(){
        return organizador;
    }


}
