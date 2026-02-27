package Gioco.Classi;
import java.util.*;

 class Gestore {
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    ArrayList<Personaggio> allPersonaggi = new ArrayList<>();
    String[] personaggi = {};
    InputManager im = new InputManager();
    FileManager fm = new FileManager();
    int round = 1;

    /** Metodo che richiama altri metodi per impostare il gioco */
    void impostaGioco(){
        addGiocatore();
        caricaPersonaggi();
        sistemazionePersonaggi();
    }

    /** Aggiunge 2 giocatori e gli assegna il nome scelto */
    void addGiocatore() {
        String nome;
        for(int i = 0; i < 2; i++){
            nome = im.scegliNome();
            Giocatore g = new Giocatore(nome);
            giocatori.add(g);
        }
    }

    /** Legge tutti i personaggi disponibili dal file */
    void caricaPersonaggi(){
        allPersonaggi = fm.leggiPersonaggi(allPersonaggi);
    }

    /** Il giocatore sceglie i personaggi e poi li aggiunge */
    void sistemazionePersonaggi(){
        for(Giocatore g : giocatori){
            personaggi = im.scegliPersonaggio(g, allPersonaggi);
            g.assegnaPersonaggio(personaggi, allPersonaggi);   
        }
    }

    /** Stampa lo status del giocatore e dei suoi personaggi */
    void stampaStatus(){
        for(Giocatore g : giocatori){
            System.out.println("Giocatore: " + g.getNome());
            g.stampaPersonaggi();
        }
    }

    /** Fa iniziare il gioco tra i vari giocatori */
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

    /** Controlla se un giocatore ha vinto il gioco */
    void checkVincitore(int i){
        
    }
}
