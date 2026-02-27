package Gioco.Classi;

 class Personaggio {
    String nome;
    int vita;
    int danni;

     Personaggio(String nome, int vita, int danni) {
        this.nome = nome;
        this.vita = vita;
        this.danni = danni;
    }

     String getNome() {
        return nome;
    }

     int getVita() {
        return vita;
    }

    int getDanni(){
        return danni;
    }
}
