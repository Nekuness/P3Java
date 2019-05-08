package edu.ub.prog2.UrciuoliGonzalo.vista;
import edu.ub.prog2.UrciuoliGonzalo.model.AplicationException;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IniciadorAplicacioUB {

    public static void main(String[] args) throws AplicacioException, FileNotFoundException {
        AplicacioUB2 vista = new AplicacioUB2();
        try {
            vista.gestioAplicacioUB();
        } catch (IOException | ClassNotFoundException | AplicationException ex) {
            Logger.getLogger(IniciadorAplicacioUB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
