package Gioco.Classi;

public class Personaggio {
    String nome;
    int vita;

    public Personaggio(String nome, int vita) {
        this.nome = nome;
        this.vita = vita;
    }

     String getNome() {
        return nome;
    }

     int getVita() {
        return vita;
    }
}
