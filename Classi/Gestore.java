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
        iniziaGioco();
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
        System.out.println("Round: " + round);
        for(Giocatore g : giocatori){
            System.out.println("Giocatore: " + g.getNome());
            g.stampaPersonaggi();
        }
    }

    /** Fa iniziare il gioco tra i vari giocatori */
    void iniziaGioco() {
        while (giocatori.size() > 1) {
            eseguiAttacco(0, 1);

            if (giocatori.size() > 1) {
                eseguiAttacco(1, 0);
            }

            stampaStatus();
            round++;
        }
    }

    // Metodo di supporto per non ripetere codice
    private void eseguiAttacco(int att, int dif) {
        int danni = giocatori.get(att).combatti();
        giocatori.get(dif).setVitaPersonaggio(danni);
        giocatori.get(dif).checkPersonaggi();
        checkVincitore(dif, att);
    }

    /** Controlla se un giocatore ha vinto il gioco */
    void checkVincitore(int difensore, int attaccante){
        if(giocatori.get(difensore).getPersonaggi() == null || giocatori.get(difensore).getPersonaggi().isEmpty()){
            System.out.println("Il giocatore " + giocatori.get(difensore).getNome() + " non ha più personaggi e viene eliminato dal gioco.");
            System.out.println("Vince: " + giocatori.get(attaccante).getNome());
            giocatori.remove(difensore);
        }
    }
}
