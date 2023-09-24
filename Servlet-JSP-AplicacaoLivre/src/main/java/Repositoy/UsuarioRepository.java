package Repositoy;

import Model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public void adicionarUsuario(Usuario usuario){}

    public void buscarUsuario(Long id){}

    public void listarUsuarios(){}

    public List<Usuario> listarOrganizadores(){
        List<Usuario> organizadores = new ArrayList<>();
        Usuario org = new Usuario("Igor Moraes", "igor@email.com", "senha123", true);
        usuarios.add(org);
        Usuario teste = new Usuario("Tamiris", "tamiris@email.com", "senha123", false);
        usuarios.add(teste);

        for (Usuario organizador : usuarios){
            if(organizador.isOrganizador()){
                organizadores.add(organizador);
            }
        }
        return organizadores;
    }

}
