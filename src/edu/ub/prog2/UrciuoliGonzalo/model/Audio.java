/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.model;

import edu.ub.prog2.UrciuoliGonzalo.controlador.Reproductor;
import java.io.File;

/**
 *
 * @author digit
 */
public class Audio extends FitxerReproduible{
    
    int kbps;
    File fitxerimatge;

    public Audio(String cami, File fitxerimatge, String nom, String codec, float durada, Reproductor r, int kbps) {
        super(cami, nom, codec, durada, r);
        this.kbps = kbps;
        this.fitxerimatge = fitxerimatge;
    }

    @Override
    protected void reproduir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
