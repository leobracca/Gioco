package Gioco.Classi;
import java.io.*;
import java.util.*;

public class FilePersonaggi{
    String file = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Personaggi.csv";

    /**
     * Lettura file contenente i personaggi
     * 
     * Lettura di tutto il file contenente i personaggi saltando l'intestazione,
     * si crea il personaggio con le sue caratteristiche e viene inserito in un
     * arrayList di tipo Personaggio
     */
    ArrayList<Personaggio> leggiPersonaggi(ArrayList<Personaggio> personaggi) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] colonna = line.split(",");
                Personaggio pers = new Personaggio(colonna[0], Integer.parseInt(colonna[1]), Integer.parseInt(colonna[2]));
                personaggi.add(pers);
            }
        }

        catch (IOException e) {
            System.out.println("Errore nella lettura del file");
        }

        return personaggi;
    }
}