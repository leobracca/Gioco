package Gioco.Classi;
import java.io.*;
import java.util.*;

 class FileManager {
    String filePersonaggi = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Personaggi.csv";

    /** Lettura file contenente i personaggi */
    ArrayList<Personaggio> leggiPersonaggi(ArrayList<Personaggio> personaggi){
        try(BufferedReader br = new BufferedReader(new FileReader(filePersonaggi))){
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] colonna = line.split(",");
                Personaggio pers = new Personaggio(colonna[0], Integer.parseInt(colonna[1]), Integer.parseInt(colonna[2]));
                personaggi.add(pers);
            }
        }

        catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }

        return personaggi;
    }
}