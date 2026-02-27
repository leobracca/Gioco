package Gioco.Classi;
import java.util.*;

 class InputManager {
    Scanner sc = new Scanner(System.in);

    String[] scegliPersonaggio(Giocatore g, List<Personaggio> allPersonaggi){
        
        System.out.println("Personaggio giocatore " + g.getNome());
        String nome = sc.nextLine();

        String[] personaggi = {nome};       

        return personaggi;
    }

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
