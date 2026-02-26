package Gioco.Classi;
import java.util.*;

 class Giocatore {
    ArrayList<Personaggio> personaggi = new ArrayList<>();
    String nome;
    boolean elimina = false;

     Giocatore(String nome) {
        this.nome = nome;
    }

    String getNome() {
        return nome;
    }

    ArrayList<Personaggio> getPersonaggi() {
        return personaggi;
    }

    void assegnaPersonaggio(String[] p, ArrayList<Personaggio> allPersonaggi){    //Metodo assegnaPersonaggio si trova in Gestore
        for(String nome: p){
            for(Personaggio pers : allPersonaggi){
                if(pers.getNome().equals(nome)){
                    personaggi.add(pers);
                }
            }
        }
    }

    void stampaPersonaggi(){
        for(Personaggio p : personaggi){
            System.out.println(p.getNome() + " " + p.getVita());
        }
    }
}
