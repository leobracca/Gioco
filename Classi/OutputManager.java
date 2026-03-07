package Gioco.Classi;
import java.util.*;

public class OutputManager {
    ArrayList<Personaggio> personaggi = new ArrayList<>();  

    void stampaStatus(ArrayList<Giocatore> giocatori, int round){
        System.out.println();
        System.out.println("Round: " + round);
        for(Giocatore g : giocatori){
            personaggi = null;
            System.out.println("Giocatore: " + g.getNome());
            System.out.println("Punti giocatore: " + g.getPunteggio());
            personaggi = g.getPersonaggi();
            stampaPersonaggi();
            System.out.println();
        }
    }

    void stampaPersonaggi(){
        for(Personaggio p: personaggi){
            System.out.println("{Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni() + "}");
        }
    }

    void stampaVincitore(int difensore, int attaccante, ArrayList<Giocatore> giocatori){
        System.out.println();
        System.out.println("Risultato finale:");
        System.out.println("Perdente: " + giocatori.get(difensore).getNome() + " punti: " + giocatori.get(difensore).getPunteggio());
        System.out.println("Vincitore: " + giocatori.get(attaccante).getNome() + " punti: " + giocatori.get(attaccante).getPunteggio());
    }
}
