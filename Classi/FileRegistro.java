package Gioco.Classi;

import java.io.*;
import java.util.*;

public class FileRegistro {
    String file = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Registro.csv";
    String contatore = "C:\\Users\\lbrac\\OneDrive\\Desktop\\Programmazione casa\\Gioco\\File\\Contatore.csv";
    int nPartita;

    void nPartita(){
        leggiContatore();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.append("Partita: " + nPartita);
            bw.newLine();
            nPartita++;
        }

        catch(IOException e){
            System.out.println("Errore scrittura partita");
        }
    }
    
    void leggiContatore(){
        try(BufferedReader br = new BufferedReader(new FileReader(contatore))){
            String line;
            line = br.readLine();
            nPartita = Integer.parseInt(line) + 1;
        }

        catch(IOException e){
            System.out.println("Errore lettura contatore");
        }

        aggiornaContatore();
    }

    void aggiornaContatore(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(contatore))){
            bw.write(String.valueOf(nPartita++));
        }

        catch(IOException e){
            System.out.println("Errore aggiornamento contatore");
        }
    }
    
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

    void addRisultato(int difensore, int attaccante, ArrayList<Giocatore> giocatori){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.append("Risultato: ");
            bw.newLine();
            bw.append("Perdente: " + giocatori.get(difensore).getNome() + " punti: " + giocatori.get(difensore).getPunteggio());
            bw.newLine();
            bw.append("Vincitore: " + giocatori.get(attaccante).getNome() + " punti: " + giocatori.get(attaccante).getPunteggio());
        }

        catch(IOException e){
            System.out.println("Errore scrittura risultati");
        }
    }

    void pulisciFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            nPartita = 1;
        }

        catch(IOException e){
            System.out.println("Errore pulizia file");
        }
    }
}
