package Gioco.Classi;

public class Personaggio {
    String nome;
    int danno;

    public Personaggio(String nome, int danno) {
        this.nome = nome;
        this.danno = danno;
    }

     String getNome() {
        return nome;
    }

     int getDanno() {
        return danno;
    }
}
