import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorRecebeTexto {
    public static void main(String[] args) throws IOException {
        // Definir o server Socket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber mensagem do cliente");

        //Aguardar solicitação de conexão de cliente
        Socket socket = serverSocket.accept();

        //Mostrar endereço IP do cliente conectado
        System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

        // Definir stream de entrada de dados no servidor
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensagem = entrada.readUTF(); // recebe mensagem do cliente
        String novaMensagem = mensagem.toUpperCase(); // converte mensagem para maiusculo

        // Definir stream de saida de dados do servidor
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF(novaMensagem); // envia nova mensagem para o cliente

        // Fechar streams de entrada e saida
        entrada.close();
        saida.close();

        // fechar o socket
        socket.close();
        serverSocket.close();
    }

}
