package Gioco.Classi;
import java.util.*;

public class Giocatore {
    ArrayList<Personaggio> personaggi = new ArrayList<>();
    String nome;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }

    void assegnaPersonaggio(String[] p){
        FileManager fm = new FileManager();
        fm.leggiFile(personaggi, Arrays.asList(p));
    }

    void stampaPersonaggi(){
        for(Personaggio p : personaggi){
            System.out.println(p.getNome() + " " + p.getVita());
        }
    }
}
