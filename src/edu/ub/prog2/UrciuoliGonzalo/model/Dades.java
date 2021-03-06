/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.model;

import edu.ub.prog2.UrciuoliGonzalo.controlador.Reproductor;
import com.sun.jna.Native;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author digit
 */
public class Dades implements Serializable {
    
    int MAX_SIZE = 100;
    BibliotecaFitxerMultimedia biblio = new BibliotecaFitxerMultimedia(MAX_SIZE);
    Reproductor r = new Reproductor();

    public Dades() {
    }
    
    
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException, AplicationException{
        
        try{
            Video v1 = new Video(path,nomVideo,codec,durada,alcada,amplada,fps,r);
            if(v1.isFile()){
                biblio.addFitxer(v1);
            }
            else{
                System.out.println("El arxiu especificat a la ruta no existe");
            }
        }
        catch(RuntimeException e){
            System.out.println("No s'ha pogut carregar el VLC");
        }
        
        if(biblio.getSize() >= MAX_SIZE){
            throw new AplicationException("La biblioteca esta plena");
        }
        
        
        
    }
    
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException, AplicationException{
        try{
            FitxerMultimedia img1 = new FitxerMultimedia(camiImatge);
            Audio a1 = new Audio(cami,img1,nomAudio,codec,durada,r,kbps);
            if(a1.isFile()){
                biblio.addFitxer(a1);
            }
            else{
                System.out.println("El arxiu especificat a la ruta no existeix");
            }
        }
        catch(RuntimeException e){
            System.out.println("No s'ha pogut carregar el VLC");
        }
        if(biblio.getSize() >= MAX_SIZE){
            throw new AplicationException("La biblioteca esta plena");
        }
        
    }
    
    public List<String> mostrarBiblioteca(){
        List<String> s1 = new ArrayList<String>();
        for(int i = 0; i < biblio.getSize(); i++){
            s1.add(biblio.toString(i));
        }
        return s1;
        
    }
    
    public void esborrarFitxer(int id) throws AplicacioException{
        biblio.carpeta.remove(id);
    }
    
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, FileNotFoundException, IOException{
        File fitxer = new File(camiDesti + "dades.ser");
        if(fitxer.createNewFile()){
            System.out.println("Fitxer creat");
        }
        else{
            throw new IOException("El fitxer ya esta creat");
        }
        FileOutputStream fout = new FileOutputStream(fitxer);
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        oos.writeObject(this.biblio);
        
        
        
        
        
        
    }
    
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, FileNotFoundException, IOException, ClassNotFoundException{
        File fitxer = new File(camiOrigen);
        FileInputStream fin = new FileInputStream(fitxer);
        ObjectInputStream ois = new ObjectInputStream(fin);
        BibliotecaFitxerMultimedia d2 = (BibliotecaFitxerMultimedia) ois.readObject();
        this.biblio = d2;
        ois.close();
        System.out.println("Fitxer carregat amb exit");
        
        
        
    }
    
}

