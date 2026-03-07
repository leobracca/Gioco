package Gioco.Classi;
import java.util.*;

 class Gestore {
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    ArrayList<Personaggio> allPersonaggi = new ArrayList<>();
    String[] personaggi = new String[3];
    InputManager im = new InputManager();
    OutputManager om = new OutputManager();
    FileManager fm = new FileManager();
    int round = 1;

    /** 
     * Metodo che richiama altri metodi per impostare il gioco 
     * 
     * Richiama metodo per aggiungere i giocatori, per poter leggere i personaggi
     * che un giocatore può scegliere da un file, sistema il gioco aggiungendo per
     * ogni giocatore i personaggi scelti, inizia il gioco 
    */
    void impostaGioco(){
        addGiocatore();
        caricaPersonaggi();
        sistemazionePersonaggi();
        iniziaGioco();
    }

    /** 
     * Aggiunge 2 giocatori e gli assegna il nome scelto 
     * 
     * In input viene chiesto il nome del giocatore e lo crea
     * con il nome scelto
    */
    void addGiocatore() {
        String nome;
        for(int i = 0; i < 2; i++){
            nome = im.scegliNome();
            Giocatore g = new Giocatore(nome);
            giocatori.add(g);
        }
    }

    /** 
     * Legge tutti i personaggi disponibili dal file 
     * 
     * Legge tutti i personaggi da un file e li aggiunge in un 
     * arrayList di tipo personaggio
    */
    void caricaPersonaggi(){
        allPersonaggi = fm.personaggi(allPersonaggi);
    }

    /** 
     * Il giocatore sceglie i personaggi e poi li aggiunge 
     * 
     * Per ogni giocatore sceglie i giocatori da usare in input 
     * e vengono salvati i nomi in un array
    */
    void sistemazionePersonaggi(){
        for(int i = 0; i < giocatori.size(); i++){
            Giocatore g = giocatori.get(i);
            personaggi = im.scegliPersonaggio(g, allPersonaggi);
            g.assegnaPersonaggio(personaggi, allPersonaggi);
            fm.componenti(giocatori.get(i).getNome(), giocatori.get(i).getPersonaggi());
        }
    }

    /** 
     * Fa iniziare il gioco tra i vari giocatori 
     * 
     * Inizia il gioco, chiamando il metodo eseguiAttacco e 
     * definire l'attaccante e il difensore, se ancora nessuno a perso
     * si riesegue lo stesso metodo ma invertendo l'attaccante e il difensore,
     * alla fine si stampa lo stato dei vari giocatori
    */
    void iniziaGioco() {
        while (giocatori.size() > 1) {
            om.stampaStatus(giocatori, round);

            eseguiAttacco(0, 1);

            if (giocatori.size() > 1) {
                eseguiAttacco(1, 0);
            }

            round++;
        }
    }

    /**
     * Esecuzione dell' attacco da l'attaccante verso il difensore
     * 
     * Eseguzione dell'attacco, nella variabile danni c'è la quantità di danni
     * che il difensore subisce, dopo aver tolto vita al difensore si controlla se
     * il suo personaggio è stato sconfitto e se l' attaccante ha vinto
     */
    private void eseguiAttacco(int att, int dif) {
        boolean check = false;
        int danni = giocatori.get(att).combatti();
        giocatori.get(dif).setVitaPersonaggio(danni);
        check = giocatori.get(dif).checkPersonaggi();
        cambiaPunteggio(check, att);
        checkVincitore(dif, att);
    }

    void cambiaPunteggio(boolean check, int att) {
        if (check == true) {
            giocatori.get(att).setPunteggio(1);
        }
    }

    /** 
     * Controlla se un giocatore ha vinto il gioco 
     * 
     * Controlla se l'arrayList del difensore risulta vuoto oppure null,
     * in casi affermativo toglie il giocatore dal gioco e ha perso, proclamando il vincitore
     * e stampa lo stato dei personaggi del vincitore
    */
    void checkVincitore(int difensore, int attaccante){
        if(giocatori.get(difensore).getPersonaggi() == null || giocatori.get(difensore).getPersonaggi().isEmpty()){
            om.stampaVincitore(difensore, attaccante, giocatori);
            //fm.risultato(difensore, attaccante, giocatori);
            giocatori.remove(difensore);         
        }
    }
}