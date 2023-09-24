package Servlets;

import Model.Atividade;
import Repositoy.AtividadeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarAtividades")
public class ListarAtividadesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AtividadeRepository atividadeRepository = new AtividadeRepository();
        List<Atividade> atividades = atividadeRepository.listarAtividades();

        // Defina a lista de atividades como um atributo de solicitação
        request.setAttribute("atividades", atividades);

        // Encaminhe para a página JSP de listagem de atividades
        request.getRequestDispatcher("listarAtividades.jsp").forward(request, response);
    }
}
