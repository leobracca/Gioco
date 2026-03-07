package Gioco.Classi;
import java.util.*;

class FileManager{
    FilePersonaggi fp = new FilePersonaggi();
    FileRegistro fr = new FileRegistro();

    ArrayList<Personaggio> personaggi(ArrayList<Personaggio> allPersonaggi){
        fp.leggiPersonaggi(allPersonaggi);
        return allPersonaggi;
    }

    void componenti(String nome, ArrayList<Personaggio> personaggi){
        fr.addComponenti(nome, personaggi);
    }

    void risultato(){
        fr.addRisultato();
    }
}