/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.controlador;

import edu.ub.prog2.UrciuoliGonzalo.model.AlbumFitxersMultimedia;
import edu.ub.prog2.UrciuoliGonzalo.model.AplicationException;
import edu.ub.prog2.UrciuoliGonzalo.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InControlador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author digit
 */
public class Controlador implements InControlador {

    Dades d1 = new Dades();

    public Controlador() {
    }

    public void afegirVideo(String path, String nomVideo, String codec, float durada, int alcada, int amplada, float fps) throws AplicacioException {
        try {
            d1.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
        } catch (AplicationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
        try {
            d1.afegirAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
        } catch (AplicationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> mostrarBiblioteca() {
        return d1.mostrarBiblioteca();

    }

    public void esborrarFitxer(int id) throws AplicacioException {
        d1.esborrarFitxer(id);
    }

    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        try {
            d1.guardarDadesDisc(camiDesti);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        try {
            d1.carregarDadesDisc(camiOrigen);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afegirAlbum(String titolAlbum) {
        d1.afegirAlbum(titolAlbum);
    }

    @Override
    public void reproduirFitxer(int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> mostrarLlistatAlbums() {
        return d1.mostrarLlistatAlbums();
    }

    @Override
    public void esborrarAlbum(String string) throws AplicacioException {
        d1.esborrarAlbum(string);
    }

    @Override
    public boolean existeixAlbum(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afegirFitxer(String string, int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> mostrarAlbum(String string) throws AplicacioException {
        return d1.mostrarAlbum(string);
    }

    @Override
    public void esborrarFitxer(String string, int i) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obrirFinestraReproductor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reproduirCarpeta() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reproduirCarpeta(String string) throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reemprenReproduccio() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pausaReproduccio() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aturaReproduccio() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saltaReproduccio() throws AplicacioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public AlbumFitxersMultimedia seleccionAlbum(int id) {
        return d1.seleccionAlbum(id);
    }

    public File seleccionBiblio(int id) {
        return d1.seleccionBiblio(id);
    }
}
