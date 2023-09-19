import Model.Pessoa;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteEnviaObjeto {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54323);
        // Definir stream de saida de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        Pessoa p = new Pessoa("Tamiris Jesus", 19);
        saida.writeObject(p);

        saida.close();
        socket.close();

    }

}
