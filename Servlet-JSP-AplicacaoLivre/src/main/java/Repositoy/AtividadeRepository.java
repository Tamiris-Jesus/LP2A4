package Repositoy;

import Model.Atividade;
import Model.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AtividadeRepository {

    private List<Atividade> atividades = new ArrayList<>();

    public void adicionarAtividade(Atividade atividade){
        atividades.add(atividade);
    }

    public List<Atividade> listarAtividades(){
        Atividade atividade = new Atividade("Palestra sobre Java Servlets", LocalDate.now(), LocalTime.now());
        atividades.add(atividade);
        return atividades;
    }

    public Atividade buscarAtividade(Long id){
        for(Atividade atividade : atividades){
            if(atividade.getId() == id){
                return atividade;
            }
        }
        return null;
    }

    public void inscreverParticipante(Long id, Usuario usuario){
        Atividade atividade = buscarAtividade(id);
        atividade.adicionaParticipante(usuario);
    }

}
