package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//@Getter
@Setter

@Entity(name = "atividade")
@Table(name = "atividade")
public class Atividade {

    private static Long idClasse = 0L;
    private Long id;
    private String descricao;
    private LocalDate dia;
    private LocalTime hora;
    private List<Usuario> participantes = new ArrayList<>();

    public Atividade(String descricao, LocalDate dia, LocalTime hora) {
        this.descricao = descricao;
        this.dia = dia;
        this.hora = hora;
        this.id = idClasse++;
    }

    public void adicionaParticipante(Usuario usuario){
        participantes.add(usuario);
    }

    public Long getId() {
        return this.id;
    }

    public String getDescricao() {
        return descricao;
    }

//    public LocalDate getDia() {
//        return dia;
//    }
//
//    public LocalTime getHora() {
//        return hora;
//    }


    public String getDia() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dia.format(formatter);
    }

    public String getHora() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hora.format(formatter);
    }
    public List<Usuario> getParticipantes() {
        return participantes;
    }
}
