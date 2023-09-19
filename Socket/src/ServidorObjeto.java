import Model.Pessoa;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorObjeto {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Definir o server Socket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(54323);
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber mensagem do cliente");

        //Aguardar solicitação de conexão de cliente
        Socket socket = serverSocket.accept();

        //Mostrar endereço IP do cliente conectado
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        // Definir stream de entrada de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
        Pessoa p = (Pessoa) entrada.readObject();
        System.out.println("Nome: " + p.getNome() + "Idade: " + p.getIdade());

        // Fechar streams de entrada e saida
        entrada.close();

        // fechar o socket
        socket.close();
        serverSocket.close();
    }
}
