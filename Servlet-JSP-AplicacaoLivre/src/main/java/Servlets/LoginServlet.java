package Servlets;

import Model.Usuario;
import Repositoy.UsuarioRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        List<Usuario> organizadores = usuarioRepository.listarOrganizadores();

        // Verifique o email e a senha do organizador (você precisa implementar essa lógica)
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");


        for (Usuario organizador : organizadores) {
            if (organizador.getEmail().equals(email) && organizador.getSenha().equals(senha) && organizador.isOrganizador()) {
                // Organizador autenticado, armazene-o na sessão
                HttpSession session = request.getSession();
                session.setAttribute("organizador", organizador);
                // Redirecione para a página de cadastro de atividades
                response.sendRedirect("cadastroAtividade.jsp");
                return;
            }
        }

        // Caso o login falhe, redirecione de volta para a página de login
        response.sendRedirect("login.jsp?error=1");
    }
}
