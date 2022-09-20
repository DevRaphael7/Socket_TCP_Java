package models;

import services.Arquivo;
import services.Palavras;

public class Usuario {
    
    private String nome;
    private String message;

    private Palavras palavras;
    private Arquivo arquivo;

    public Usuario(String nome, String message) {
        this.nome = nome;
        this.message = message;
        this.palavras = new Palavras();
        this.arquivo = new Arquivo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.arquivo.saveMessage(String.format("[ %s ]: %s%n", this.nome, message));
        this.message = this.palavras.verificarPalavra(message);

    }
}
