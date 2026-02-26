package Gioco.Classi;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gestore g = new Gestore();
        int c = 0;

        g.addGiocatore();

        System.out.println("Personaggio giocatore 1");
        String nome = sc.nextLine();

        String[] personaggi1 = {nome};       
        g.assegnaPersonaggi(personaggi1, c);  
        
        c++;

        System.out.println("Personaggio giocatore 2");
        nome = sc.nextLine();

        String[] personaggi2 = {nome};
        g.assegnaPersonaggi(personaggi2, c);

        sc.close();

        g.stampaPers();
    }
}