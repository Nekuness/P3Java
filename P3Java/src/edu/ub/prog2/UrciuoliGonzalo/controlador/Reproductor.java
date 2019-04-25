/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.UrciuoliGonzalo.controlador;

import edu.ub.prog2.utils.ReproductorBasic;

/**
 *
 * @author digit
 */
public class Reproductor extends ReproductorBasic{
    
    public Reproductor() {
        super("C:\\Program Files\\VideoLAN\\VLC");
    }
    
    public Reproductor(String vlcPath) {
        super(vlcPath);
    }
    
    
}
