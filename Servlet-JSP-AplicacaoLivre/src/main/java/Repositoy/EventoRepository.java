//package Repositoy;
//
//import Model.Atividade;
//import Model.Usuario;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class EventoRepository {
//
//    private Evento evento = new Evento();
//
//    static {
//        Usuario organizadorDoEvento = new Usuario("Igor Sampaio", "igor@email.com", "12345", true);
//        Evento evento = new Evento(organizadorDoEvento);
//        Atividade atividade = new Atividade("Palestra sobre Java Servlets", LocalDate.now(), LocalTime.now());
//        evento.adicionarAtividade(atividade);
//    }
//
//    public void adicionarAtividade(Atividade atividade){
//        evento.adicionarAtividade(atividade);
//    }
//
//    public List<Atividade> listarAtividades(){
//        List<Atividade> atividades = new ArrayList<>();
//        for(Atividade atividade : evento.getAtividades()){
//            atividades.add(atividade);
//        }
//        return atividades;
//    }
//
//
//
//}
