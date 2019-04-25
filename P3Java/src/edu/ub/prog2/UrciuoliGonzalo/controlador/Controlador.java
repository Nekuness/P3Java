/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.controlador;

import edu.ub.prog2.UrciuoliGonzalo.model.AplicationException;
import edu.ub.prog2.UrciuoliGonzalo.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author digit
 */
public class Controlador {
    
    Dades d1 = new Dades();

    public Controlador() {
    }
    
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException, AplicationException, IOException{
        d1.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
    }
    
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException, AplicationException{
        d1.afegirAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }
    
    public List<String> mostrarBiblioteca(){
        return d1.mostrarBiblioteca();
        
    }
    
    public void esborrarFitxer(int id) throws AplicacioException{
        d1.esborrarFitxer(id);
    }
    
    public void guardarDadesDisc(String camiDesti) throws AplicacioException, IOException{
        d1.guardarDadesDisc(camiDesti);
    }
    
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException, IOException, FileNotFoundException, ClassNotFoundException{
        d1.carregarDadesDisc(camiOrigen);
    }
    
}
