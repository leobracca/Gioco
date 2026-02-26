package Gioco.Classi;
import java.util.*;

public class Gestore {
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    Random rand = new Random();
    int danni = 0;
    int round = 0;

    void impostaGioco(){
        addGiocatore();
        addInput();
    }

    void addGiocatore(){
        Giocatore g1 = new Giocatore("Luca");
        Giocatore g2 = new Giocatore("Mario");
        giocatori.add(g1);
        giocatori.add(g2);
    }

    void addInput(){
        InputManager im = new InputManager();       
        for(Giocatore g : giocatori){
            im.addPersonaggio(g);
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
