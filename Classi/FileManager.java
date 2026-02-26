package Gioco.Classi;
import java.io.*;
import java.util.*;

public class FileManager {
    String filePersonaggi = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Personaggi.csv";

    public void leggiFile(ArrayList<Personaggio> personaggi, List<String> p){
        try(BufferedReader br = new BufferedReader(new FileReader(filePersonaggi))){
            String line;
            br.readLine();
            for(int i = 0; i < p.size(); i++){
                while ((line = br.readLine()) != null) {
                    String[] colonna = line.split(",");

                    if (p.contains(colonna[0])) {
                        Personaggio pers = new Personaggio(colonna[0], Integer.parseInt(colonna[1]));
                        personaggi.add(pers);
                    }
                }
            }
        }

        catch(IOException e){
            System.out.println("Errore nella lettura del file");
        }
    }
}