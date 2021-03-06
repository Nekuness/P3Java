package edu.ub.prog2.UrciuoliGonzalo.model;

import java.io.File;
import java.util.ArrayList;

public class CarpetaFitxers {
    int tamany = 100;
    ArrayList<FitxerMultimedia> carpeta = new ArrayList<>(tamany);
    int size;

    public CarpetaFitxers() {
        
    }
    
    public CarpetaFitxers(int tamany) {
        this.tamany = tamany;
    }

    public int getSize() {
        this.size = carpeta.size();
        return carpeta.size();
    }

    public void addFitxer(FitxerMultimedia fitxer) {
        boolean check = false;
        for(int i = 0; i < carpeta.size(); i++){
            if(fitxer.getNom().equals(carpeta.get(i).getNom())){
                check = true;
            }
        }
        if(!check){
            carpeta.add(fitxer);
        }
        else{
            System.out.println("Ya existeix el arxiu a la Biblioteca");
        }
    }

    public void removeFitxer(FitxerMultimedia fitxer) {
        carpeta.remove(fitxer);
    }

    public File getAt(int position) {
        return carpeta.get(position);
    }

    public void clear() {
        carpeta.clear();
    }

    public boolean isFull() {
        boolean isFull = false;
        if (carpeta.get(tamany) != null)
            isFull = true;
        return isFull;
    } 

    public String toString(int i) {
        if(!carpeta.isEmpty()){
        String toString = " ";
            toString += "[" + (i+1) + "] " + "Descripció: " + carpeta.get(i).getDescripcio() + "\n" +
                    "Data: " + carpeta.get(i).getUltimaModificacio() + "\n" +
                    "Nom : " + carpeta.get(i).getNom() + "\n" +
                    "Extensió: " + carpeta.get(i).getExtensio() + "\n" +
                    "Camí: " + carpeta.get(i).getAbsolutePath() + "\n";
        
        return toString;
        }
        else{
            return "La biblioteca esta buida";
        }
    }

}
