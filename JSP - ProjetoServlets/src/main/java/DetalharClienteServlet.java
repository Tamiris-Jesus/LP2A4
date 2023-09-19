import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cliente;
import repository.ClienteRepository;

import java.io.IOException;

public class DetalharClienteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteRepository.buscarClientePorCpf(cpf);
        request.setAttribute("cliente", cliente);
       request.getRequestDispatcher("/detalhes.jsp").forward(request, response);
    }
}
