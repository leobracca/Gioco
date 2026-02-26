package Gioco.Classi;
import java.util.*;

public class InputManager {
    Scanner sc = new Scanner(System.in);

    String[] addPersonaggio(Giocatore g){
        
        System.out.println("Personaggio giocatore " + g.getNome());
        String nome = sc.nextLine();

        String[] personaggi = {nome};       
        g.assegnaPersonaggio(personaggi);

        return personaggi;
    }

    void chiudiScanner(){
        sc.close();
    }
}
