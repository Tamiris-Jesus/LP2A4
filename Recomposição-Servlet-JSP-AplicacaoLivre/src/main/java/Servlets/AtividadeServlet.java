package Servlets;

import Model.Atividade;
import Repositoy.AtividadeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupere os parâmetros do formulário
        String descricao = request.getParameter("descricao");
        LocalDate dia = LocalDate.parse(request.getParameter("dia"));
        LocalTime hora = LocalTime.parse(request.getParameter("hora"));

        // Crie uma nova atividade
        Atividade novaAtividade = new Atividade(descricao, dia, hora);
        // Salva atividade no evento
        AtividadeRepository atividadeRepository = new AtividadeRepository();
        atividadeRepository.adicionarAtividade(novaAtividade);


        // Redirecione de volta para a página do evento
        response.sendRedirect("index.jsp");
    }
}
