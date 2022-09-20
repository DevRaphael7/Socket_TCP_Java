import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import models.Usuario;

public class ClientServer extends Thread {

    private final Socket socket;
    private PrintWriter out;
    private BufferedReader input;
    private Usuario user;
    
    public ClientServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            askNameOfNewClient();
            initializaChat();

            this.closeSocket();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void askNameOfNewClient() throws IOException {
        String nome = "";

        while(nome.length() < 1){
            this.out.println("Your name: ");
            nome = this.input.readLine();
        }

        this.user = new Usuario(nome, "");

        System.out.println(String.format("Novo cliente conectado [ %s ]\n", this.user.getNome()));

        String boasVindas = "-- Bem-vindo [ %s ] --\n";
        this.out.println(String.format(boasVindas, this.user.getNome()));
    }

    private void initializaChat() throws IOException {
        while(!this.user.getMessage().equals("exit()")) {
            this.user.setMessage(this.input.readLine());

            System.out.println(String.format(
                "[ %s ]: %s", 
                this.user.getNome(), 
                this.user.getMessage()
                )
            );
        }
    }

    private void closeSocket() throws IOException {
        this.out.close();
        this.input.close();
        this.socket.close();
    }
}
