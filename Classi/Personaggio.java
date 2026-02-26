package Gioco.Classi;

 class Personaggio {
    String nome;
    int vita;

     Personaggio(String nome, int vita) {
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
