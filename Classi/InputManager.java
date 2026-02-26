package Gioco.Classi;
import java.util.*;

 class InputManager {
    Scanner sc = new Scanner(System.in);

    String[] addPersonaggio(Giocatore g, List<Personaggio> allPersonaggi){
        
        System.out.println("Personaggio giocatore " + g.getNome());
        String nome = sc.nextLine();

        String[] personaggi = {nome};       

        return personaggi;
    }

    void chiudiScanner(){
        sc.close();
    }
}
