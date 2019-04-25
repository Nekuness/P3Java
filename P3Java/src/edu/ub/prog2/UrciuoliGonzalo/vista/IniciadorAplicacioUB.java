package edu.ub.prog2.UrciuoliGonzalo.vista;
import edu.ub.prog2.utils.Menu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IniciadorAplicacioUB {

    public static void main(String[] args) {
        AplicacioUB2 vista = new AplicacioUB2();
        try {
            vista.gestioAplicacioUB();
        } catch (IOException ex) {
            Logger.getLogger(IniciadorAplicacioUB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IniciadorAplicacioUB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
