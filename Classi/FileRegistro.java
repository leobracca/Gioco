package Gioco.Classi;

import java.io.*;
import java.util.*;

public class FileRegistro {
    String file = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Registro.csv";

    void addComponenti(String nome, ArrayList<Personaggio> personaggi){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.append("Nome: " + nome);
            
            for(Personaggio p: personaggi){
                bw.newLine();
                bw.append("{Nome: " + p.getNome() + " vita: " + p.getVita() + " danni: " + p.getDanni() + "}");
            }

            bw.newLine();
            bw.newLine();
        }

        catch(IOException e){
            System.out.println("Errore scrittura componenti");
        }
    }

    void addRisultato(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){

        }

        catch(IOException e){
            System.out.println("Errore scrittura risultati");
        }
    }
}
