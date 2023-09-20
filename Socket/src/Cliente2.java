import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente2{
    public static void main(String[] args) throws IOException {
        // Abrir conexão
        Socket socket = new Socket("localhost", 54321);
        Scanner teclado = new Scanner(System.in);

        // Definir stream de saída de dados do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        System.out.println("Mensagem do cliente: ");
        String mensagem = teclado.nextLine();
        saida.writeUTF(mensagem); // enviando mensagem para servidor

        // Definir stream de entrada de dados no cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF(); // recebe a mensagem enviada pelo servidor
        System.out.println("Resposta do servidor: " + novaMensagem);  // mostra a mensagem enviada pelo servidor para o cliente

        // Fechar streams de trada e saida de dados
        entrada.close();
        saida.close();

        // fechar o socket
        socket.close();
    }
}
