package Servlets;

import Model.Usuario;
import Repositoy.AtividadeRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inscrever")
public class InscricaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String atividadeId = request.getParameter("atividadeId");
        AtividadeRepository atividadeRepository = new AtividadeRepository();

        if (atividadeId != null) {
                Long id = Long.parseLong(atividadeId);

                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                boolean organizador = false;

                Usuario participante = new Usuario(nome, email, senha, organizador);

                atividadeRepository.inscreverParticipante(id, participante);

                response.sendRedirect(request.getContextPath() + "/listarAtividades");

        } else {
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
        }
    }
}
