import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class ServidorComThread {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta!");
        System.out.println("Servidor esperando receber mensagem dos clientes");

        while(true){
            //Aguardar solicitação de conexão de clientes
            Socket socket = serverSocket.accept();
            //Mostrar endereço IP do cliente conectado
            System.out.println("Cliente " + socket.getInetAddress().getHostAddress() + " conectado");

            //Definir uma thread para cada cliente conectado
            ThreadSockets thread = new ThreadSockets(socket);
            thread.start();

        }
    }
}
