package Gioco.Classi;
import java.util.*;

 class Gestore {
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    ArrayList<Personaggio> allPersonaggi = new ArrayList<>();
    String[] personaggi = {};
    InputManager im = new InputManager();
    FileManager fm = new FileManager();
    int round = 1;

    void impostaGioco(){
        addGiocatore();
        caricaPersonaggi();
        sistemazionePersonaggi();
    }

    void addGiocatore() {
        String nome;
        for(int i = 0; i < 2; i++){
            nome = im.scegliNome();
            Giocatore g = new Giocatore(nome);
            giocatori.add(g);
        }
    }

    void caricaPersonaggi(){
        allPersonaggi = fm.leggiPersonaggi(allPersonaggi);
    }

    void sistemazionePersonaggi(){
        for(Giocatore g : giocatori){
            personaggi = im.scegliPersonaggio(g, allPersonaggi);
            g.assegnaPersonaggio(personaggi, allPersonaggi);   
        }
    }

    void stampaStatus(){
        for(Giocatore g : giocatori){
            System.out.println("Giocatore: " + g.getNome());
            g.stampaPersonaggi();
        }
    }

    void iniziaGioco(){
        while(giocatori.size() > 1){
            if(giocatori.size() > 1){
                for(int i = 0; i < giocatori.size(); i++) {
                    int attaccante = i;
                    int difensore = (i + 1) % giocatori.size();

                    int danni = giocatori.get(attaccante).combatti();
                    giocatori.get(difensore).setVitaPersonaggio(danni);
                    checkVincitore(difensore);
                }

                round++;
            }    
        }
    }

    void checkVincitore(int i){
        
    }
}
