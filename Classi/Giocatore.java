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

    int combatti(){
        return personaggi.get(0).getDanni();
    }

    /** 
     * Aggiorna la vita del personaggio difensore 
     * 
     * Preso come parametro i danni che deve subire il personaggio difensore
    */
    void setVitaPersonaggio(int danni){
        personaggi.get(0).setVita(danni);
    }

    /** 
     * Aggiunge i personaggi scelti ai giocatori 
     * 
     * Per ogni nome di personaggi scelti controlla se il nome equivale a quello
     * del personaggio corrente dell' arrayList di tutti i personaggi, in caso affermativo
     * aggiunge il personaggio all' arrayList
    */
    void assegnaPersonaggio(String[] p, ArrayList<Personaggio> allPersonaggi){
        for(String nome: p){
            for(Personaggio pers : allPersonaggi){
                if(pers.getNome().equals(nome)){
                    personaggi.add(pers);
                }
            }
        }
    }

    /**
     * Controllo se il personaggio è stato sconfitto
     * 
     * Se la vita del personaggio difensore è minore o ugguale a 0 si elimina
     * il personaggio dal giocatore dato che è stato sconfitto
     */
    void checkPersonaggi(){
        if(personaggi.get(0).getVita() <= 0){
            personaggi.remove(0);
        }
    }

    /** 
     * Stampa i personaggi 
     * 
     * Stampa i personaggi del giocatore in formato:
     * nome, vita, danni
    */
    void stampaPersonaggi(){
        for(Personaggio p : personaggi){
            System.out.println("Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni());
        }
    }
}