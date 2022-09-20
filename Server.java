import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    private static int PORT = 9090;

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(Server.PORT);

            System.out.println("Aguardando clientes...");

            ClientServer clientServer = new ClientServer(serverSocket.accept());
            clientServer.start();

            ClientServer clientServer2 = new ClientServer(serverSocket.accept());
            clientServer2.start();

            ClientServer clientServer3 = new ClientServer(serverSocket.accept());
            clientServer3.start();

        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}