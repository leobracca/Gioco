package Gioco.Classi;
import java.util.*;

 class InputManager {
    Scanner sc = new Scanner(System.in);

    /** 
     * Assegna a tutti i giocatori i personaggi scelti 
     * 
     * Chiede in input i nomi dei personaggi e vengono salvati in un array
    */
    String[] scegliPersonaggio(Giocatore g, List<Personaggio> allPersonaggi){
        
        System.out.println("Personaggio giocatore " + g.getNome());
        String nome = sc.nextLine();

        String[] personaggi = {nome};       

        return personaggi;
    }

    /** 
     * Digitare il nome di ciascun giocatore 
     * 
     * Chiede in input i nomi dei giocatori
    */
    String scegliNome(){
        String nome;
        System.out.println("Come si chiama il giocatore");
        nome = sc.nextLine();
        return nome;
    }

    void chiudiScanner(){
        sc.close();
    }
}