import Model.Pessoa;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEnviaObjeto {

    public static void main(String[] args) throws IOException {
        //Abrir conexão
        Socket socket = new Socket("localhost", 54323);

        // Criar instância de Scanner para conseguir ler as informações digitadas pelo cliente
        Scanner teclado = new Scanner(System.in);

        //Definir stream de saída de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Digite o nome: ");
        String nome = teclado.nextLine();
        System.out.println("Digite uma idade: ");
        int idade = teclado.nextInt();
        Pessoa p = new Pessoa(nome, idade);
        saida.writeObject(p);

        //Fechar streams de saída de dados
        saida.close();

        //Fechar o socket
        socket.close();

    }

}
