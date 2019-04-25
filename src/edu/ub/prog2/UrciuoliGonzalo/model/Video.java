/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.model;

import edu.ub.prog2.UrciuoliGonzalo.controlador.Reproductor;

/**
 *
 * @author digit
 */
public class Video extends FitxerReproduible{
    
    int alcada;
    int amplada;
    float fps;

    public Video(String cami, String nom, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) {
        super(cami,nom,codec,durada,r);
        this.alcada = alcada;
        this.amplada = amplada;
        this.fps = fps;
        
    }

    @Override
    protected void reproduir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
