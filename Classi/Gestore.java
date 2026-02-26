package Gioco.Classi;
import java.util.*;

public class Gestore {
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    Random rand = new Random();
    int danni = 0;
    int round = 0;

    void addGiocatore(){
        Giocatore g1 = new Giocatore("Luca");
        Giocatore g2 = new Giocatore("Mario");
        giocatori.add(g1);
        giocatori.add(g2);
    }

    //Assegna i personaggi solo a 1 giocatore
    void assegnaPersonaggi(String[] personaggi, int c){
        for(int i = 0; i < giocatori.size(); i++){
            if(i == c){
                giocatori.get(i).assegnaPersonaggio(personaggi);
            }
        }
    }

    void stampaPers(){
        for(Giocatore g : giocatori){
            System.out.println("Giocatore: " + g.getNome());
            g.stampaPersonaggi();
        }
    }


    /* 
    void iniziaGioco(){
        while(giocatori.size() > 1){
            for(int i = 0; i < giocatori.size(); i++){
                Giocatore g = giocatori.get(i); 
                round++;
                danni = rand.nextInt(20);
                g.setVita(danni);

                checkVincitore(i);
            }
        }
    }

    void checkVincitore(int i){
        if(giocatori.get(i).getVita() <= 0){
            System.out.println("Il giocatore " + giocatori.get(i).getNome() + " è morto!");
            giocatori.remove(i);
        }
    }
    */
}
