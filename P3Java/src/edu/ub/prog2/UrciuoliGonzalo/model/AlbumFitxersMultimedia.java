package edu.ub.prog2.UrciuoliGonzalo.model;

import java.util.ArrayList;

public class AlbumFitxersMultimedia {

    String titol;
    CarpetaFitxers carpeta;

    public AlbumFitxersMultimedia(String titol) {
        carpeta = new CarpetaFitxers(10);
        this.titol = titol;
    }

}

