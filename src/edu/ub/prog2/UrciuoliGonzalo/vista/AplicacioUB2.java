package edu.ub.prog2.UrciuoliGonzalo.vista;
import edu.ub.prog2.UrciuoliGonzalo.controlador.Controlador;
import edu.ub.prog2.UrciuoliGonzalo.model.AplicationException;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AplicacioUB2 {
    
    String cami;
    Controlador c1;

    public AplicacioUB2() {
        this.c1 = new Controlador();
    }
    
    static private enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_OPCIO1, MENU_PRINCIPAL_OPCIO2, MENU_PRINCIPAL_OPCIO3, MENU_PRINCIPAL_SORTIR
    };
    
    static private enum OpcionsSubmenu1 {
        MENU_S1_OPCIO1, MENU_S1_OPCIO2, MENU_S1_OPCIO3, MENU_S1_SORTIR
    };
    
    static private enum OpcionsSubmenu2 {
        MENU_S2_OPCIO1, MENU_S2_OPCIO2, MENU_S2_OPCIO3, MENU_S2_SORTIR
    };

    static private String[] descMenuPrincipal = {"Gestió biblioteca",
        "Guardar dades",
        "Recuperar dades",
        "Sortir"};

    static private String[] descMenu2 = {"Afegir video",
        "Afegir audio",
        "Menú anterior"};
    
    static private String[] descMenu3 = {"Afegir fitxer multimedia a la biblioteca",
        "Mostrar biblioteca",
        "Eliminar fitxer multimedia",
        "Menú anterior"};

    public void gestioAplicacioUB() throws IOException, FileNotFoundException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);

        AplicacioUB2 app = new AplicacioUB2();

        app.manager(sc);
    }

    private void manager(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException {
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());
        menu.setDescripcions(descMenuPrincipal);
        OpcionsMenuPrincipal opcio = null;
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            switch (opcio) {
                case MENU_PRINCIPAL_OPCIO1:
                    MenuPrincipalOP1();
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    MenuPrincipalOP2();
                    break;
                case MENU_PRINCIPAL_OPCIO3:
                    MenuPrincipalOP3();
                    break;

                case MENU_PRINCIPAL_SORTIR:
                    MenuPrincipalOP4();
                    break;
            }

        } while (opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }

    private void gestioMenuSecundari(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException {

        Menu<OpcionsSubmenu1> subMenu = new Menu<OpcionsSubmenu1>("Menu Secundari", OpcionsSubmenu1.values());

        subMenu.setDescripcions(descMenu3);

        OpcionsSubmenu1 opcio = null;
        do {
            subMenu.mostrarMenu();

            opcio = subMenu.getOpcio(sc);

            switch (opcio) {
                case MENU_S1_OPCIO1:
                    Scanner teclat = new Scanner(System.in);
                    try {
                        gestioMenuTerciari(teclat);
                    } catch (AplicationException ex) {
                        Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case MENU_S1_OPCIO2:
                    System.out.println(c1.mostrarBiblioteca());
                    break;
                case MENU_S1_OPCIO3:
                    SubmenuOP3(sc);
                    break;
                    
                case MENU_S1_SORTIR:
                    manager(sc);
                    break;
            }

        } while (opcio != OpcionsSubmenu1.MENU_S1_SORTIR);
    }
    
    void MenuPrincipalOP1() throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner teclado = new Scanner(System.in);
        System.out.println("Has triat la opció 1");
        gestioMenuSecundari(teclado);
    }
    
    void MenuPrincipalOP2() throws IOException{
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introdueix on guardar les dades del fitxer");
        String camiDades  = teclado.next();
        try{
        c1.guardarDadesDisc(camiDades);
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void MenuPrincipalOP3() throws IOException, FileNotFoundException, ClassNotFoundException{
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introdueix desde on carregar les dades del fitxer");
        String camiDades  = teclado.next();
        try {
            c1.carregarDadesDisc(camiDades);
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void MenuPrincipalOP4(){
        System.out.println("Fins aviat!");
        exit(0);
        
    }
    
    void SubmenuOP3(Scanner sc){
        System.out.println("Selecciona la ID del arxiu a esborrar");
        int id = sc.nextInt();
        try {
            c1.esborrarFitxer(id);
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void gestioMenuTerciari(Scanner sc) throws AplicationException, IOException, FileNotFoundException, ClassNotFoundException{
        System.out.println("Has triat la opció afegir fitxer multimedia a la biblioteca");
        int opcio;
        do {
            System.out.println("----------------------");
            System.out.println("1.- Afegir video");
            System.out.println("2.- Afegir audio");
            System.out.println("3.- Tornar enrere");
            System.out.println("----------------------");
            opcio = sc.nextInt();
            switch(opcio){
                    case 1:
                        Submenu2OP1(sc);
                        break;
                    case 2:
                        Submenu2OP2(sc);
                    case 3:
                        gestioMenuSecundari(sc);
                        
                }
        }
        while(opcio != 4);
    }
    
    void Submenu2OP1(Scanner sc){
        String path, nomVideo, codec;
        float durada, fps;
        int amplada, alcada;
        System.out.println("Introdueix el cami del arxiu");
        path = sc.next();
        System.out.println("Introdueix el nom del arxiu");nomVideo = sc.next();
        System.out.println("Introdueix el codec del arxiu");codec = sc.next();
        System.out.println("Introdueix la durada del arxiu");durada = sc.nextFloat();
        System.out.println("Introdueix els fps del arxiu");
        fps = sc.nextFloat();
        System.out.println("Introdueix la amplada del arxiu");
        amplada = sc.nextInt();
        System.out.println("Introdueix la alcada del arxiu");
        alcada = sc.nextInt();
        try {
            c1.afegirVideo(path, nomVideo, codec, durada, alcada, amplada, fps);
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AplicationException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Submenu2OP2(Scanner sc) throws AplicationException{
        String path, pathImatge,nomAudio, codec;
        float durada;
        int kbps;
        System.out.println("Introdueix el cami del arxiu");
        path = sc.next();
        System.out.println("introdueix el cami de l'imatge de l'arxiu");
        pathImatge = sc.next();
        System.out.println("Introdueix el nom del arxiu");
        nomAudio = sc.next();
        System.out.println("Introdueix el codec del arxiu");
        codec = sc.next();
        System.out.println("Introdueix la durada del arxiu");
        durada = sc.nextFloat();
        System.out.println("Introdueix els kbps del arxiu");
        kbps = sc.nextInt();
        try {
            c1.afegirAudio(path, pathImatge, nomAudio, codec, durada, kbps);
        } catch (AplicacioException | AplicationException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

