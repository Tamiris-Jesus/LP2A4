import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends Thread {
    private Socket socket;
    public ThreadSockets(Socket s){
        this.socket = s;
    }


    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()); // imprimir nome da Thread
        try {
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
        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
