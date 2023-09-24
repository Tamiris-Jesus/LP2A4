package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/inscrever")
public class InscricaoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // Obtenha o ID da atividade da solicitação
        String atividadeId = request.getParameter("atividadeId");

        if (atividadeId != null) {
            try {
                // Converta o ID da atividade para um formato apropriado (por exemplo, Long)
                Long id = Long.parseLong(atividadeId);

                // Realize a inscrição do usuário na atividade (implemente sua lógica de inscrição aqui)

                // Redirecione o usuário de volta para a página de listagem de atividades
                response.sendRedirect(request.getContextPath() + "/listarAtividades");
                return;
            } catch (NumberFormatException e) {
                // Trate possíveis erros de conversão de ID aqui, se necessário
            }
        }

        // Em caso de erro ou ID inválido, redirecione o usuário para uma página de erro
        response.sendRedirect(request.getContextPath() + "/erro.jsp");
    }
}

