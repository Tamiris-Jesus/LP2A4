package repository;

import model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private static List<Cliente> clientes = new ArrayList<>();

    // Bloco estático para inicializar a aplicação com clientes cadastrados
    static {
        Cliente pedro = new Cliente("Pedro Felipe", LocalDate.now(), "1234", "11953962563");
        Cliente tamiris = new Cliente("Tamiris Jesus", LocalDate.now(), "2030", "11977576924");

        clientes.add(pedro);
        clientes.add(tamiris);
    }

    public static void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> listarClientes() {
        return clientes;
    }

    public static Cliente buscarClientePorCpf(String cpf) {
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                return c;
            }
        }
        return null;
    }

}
