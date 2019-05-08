package edu.ub.prog2.UrciuoliGonzalo.vista;

import edu.ub.prog2.UrciuoliGonzalo.controlador.Controlador;
import edu.ub.prog2.UrciuoliGonzalo.model.AlbumFitxersMultimedia;
import edu.ub.prog2.UrciuoliGonzalo.model.AplicationException;
import edu.ub.prog2.UrciuoliGonzalo.model.Audio;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ub.prog2.UrciuoliGonzalo.model.Dades;
import edu.ub.prog2.UrciuoliGonzalo.model.Video;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AplicacioUB2 {

    String cami;
    Controlador c1;
    AlbumFitxersMultimedia album;

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
        MENU_S2_OPCIO1, MENU_S2_OPCIO2, MENU_S2_OPCIO3, MENU_S2_OPCIO4, MENU_S2_SORTIR
    };

    static private enum OpcionsSubmenu3 {
        MENU_S3_OPCIO1, MENU_S3_OPCIO2, MENU_S3_OPCIO3, MENU_S3_OPCIO4, MENU_S3_OPCIO5, MENU_S3_OPCIO6, MENU_S3_SORTIR
    };

    static private String[] descMenuPrincipal = {"Gestió biblioteca",
        "Gestió àlbums",
        "Control reproducció/visió",
        "Sortir"};

    static private String[] descMenu2 = {"Afegir video",
        "Afegir audio",
        "Menú anterior"};

    static private String[] descMenu3 = {"Afegir fitxer multimèdia a la biblioteca",
        "Mostrar biblioteca",
        "Eliminar fitxer multimèdia",
        "Menú anterior"};

    static private String[] descMenu4 = {"Afegir àlbum",
        "Mostrar àlbums",
        "Eliminar àlbum",
        "Gestionar àlbum",
        "Menú anterior"};

    static private String[] descMenu5 = {"Reproduir un fitxer reproduible",
        "Reproduir tota la biblioteca",
        "Reproduir un àlbum",
        "Activar/Desactivar reproducció continua",
        "Activar/Desactivar reproducció aleatoria",
        "Gestió reproducció en curs",
        "Sortir"};

    public void gestioAplicacioUB() throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {

        Scanner sc = new Scanner(System.in);

        AplicacioUB2 app = new AplicacioUB2();

        app.manager(sc);
    }

    private void manager(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {
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

    private void gestioMenuSecundari(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {

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

    private void gestioMenuSecundariOP2(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {

        Menu<OpcionsSubmenu2> subMenu2 = new Menu<OpcionsSubmenu2>("Menu Secundari", OpcionsSubmenu2.values());
        Scanner teclat = new Scanner(System.in);
        String titolAlbum = null;
        subMenu2.setDescripcions(descMenu4);

        OpcionsSubmenu2 opcio = null;
        do {
            subMenu2.mostrarMenu();

            opcio = subMenu2.getOpcio(sc);

            switch (opcio) {
                case MENU_S2_OPCIO1:
                    System.out.println("Introdueix el titol del àlbum");
                    titolAlbum = teclat.next();
                    c1.afegirAlbum(titolAlbum);
                    break;
                case MENU_S2_OPCIO2:
                    System.out.println(c1.mostrarLlistatAlbums());
                    break;
                case MENU_S2_OPCIO3:
                    System.out.println("Introdueix el titol del àlbum a esborrar");
                    titolAlbum = teclat.next();
                    c1.esborrarAlbum(titolAlbum);
                    break;

                case MENU_S2_OPCIO4:
                    gestioMenuTerciariS2OP4(teclat);
                    break;

                case MENU_S2_SORTIR:
                    manager(sc);
                    break;
            }

        } while (opcio != OpcionsSubmenu2.MENU_S2_SORTIR);
    }

    private void gestioMenuSecundariOP3(Scanner sc) throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {

        Menu<OpcionsSubmenu3> subMenu3 = new Menu<OpcionsSubmenu3>("Menu Secundari", OpcionsSubmenu3.values());
        Scanner teclat = new Scanner(System.in);
        String titolAlbum = null;
        subMenu3.setDescripcions(descMenu5);

        OpcionsSubmenu3 opcio = null;
        do {
            subMenu3.mostrarMenu();

            opcio = subMenu3.getOpcio(sc);

            switch (opcio) {
                case MENU_S3_OPCIO1:
                    
                    break;
                case MENU_S3_OPCIO2:
                    SubmenuControlOP2(teclat);
                    break;
                case MENU_S3_OPCIO3:
                    
                    break;

                case MENU_S3_OPCIO4:
                    
                    break;

                case MENU_S3_OPCIO5:
                    
                    break;
                case MENU_S3_OPCIO6:
                    
                    break;
            }

        } while (opcio != OpcionsSubmenu3.MENU_S3_SORTIR);
    }

    void MenuPrincipalOP1() throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Has triat la opció 1");
        gestioMenuSecundari(teclado);
    }

    void MenuPrincipalOP2() throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Has triat la opció 2");
        gestioMenuSecundariOP2(teclado);
    }

    void MenuPrincipalOP3() throws IOException, FileNotFoundException, ClassNotFoundException, AplicacioException, AplicationException {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Has triat la opció 3");
        gestioMenuSecundariOP3(teclado);
    }

    void MenuPrincipalOP4() {
        System.out.println("Fins aviat!");
        exit(0);

    }

    void SubmenuOP3(Scanner sc) {
        System.out.println("Selecciona la ID del arxiu a esborrar");
        int id = sc.nextInt();
        try {
            c1.esborrarFitxer(id);
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void gestioMenuTerciari(Scanner sc) throws AplicationException, IOException, FileNotFoundException, ClassNotFoundException, AplicacioException {
        System.out.println("Has triat la opció afegir fitxer multimedia a la biblioteca");
        int opcio;
        do {
            System.out.println("----------------------");
            System.out.println("1.- Afegir video");
            System.out.println("2.- Afegir audio");
            System.out.println("3.- Tornar enrere");
            System.out.println("----------------------");
            opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    Submenu2OP1(sc);
                    break;
                case 2:
                    Submenu2OP2(sc);
                case 3:
                    gestioMenuSecundari(sc);

            }
        } while (opcio != 4);
    }

    void gestioMenuTerciariS2OP4(Scanner sc) throws AplicationException, IOException, FileNotFoundException, ClassNotFoundException, AplicacioException {
        Scanner teclat = new Scanner(System.in);
        String titolAlbum;
        int id;
        System.out.println("Has triat la opció gestionar àlbum\n");
        System.out.println("Seleccioneu la ID d'un àlbum per gestionar\n");
        c1.mostrarLlistatAlbums();
        id = teclat.nextInt() - 1;
        this.album = c1.seleccionAlbum(id);
        String titol = album.toString();

        int opcio;
        do {
            System.out.println("----------------------");
            System.out.println("1.- Afegir fitxer multimedia");
            System.out.println("2.- Mostrar àlbum");
            System.out.println("3.- Eliminar fitxer multimedia");
            System.out.println("4.- Tornar enrere");
            System.out.println("----------------------");
            opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    Submenu3OP1(sc, album);
                    break;
                case 2:
                    titolAlbum = teclat.next();
                    List<String> titols = new ArrayList();
                    titols = c1.mostrarAlbum(titol);
                    for(String temp: titols){
                        System.out.println(temp);
                    }
                case 3:
                    gestioMenuSecundari(sc);
                case 4:
                    break;

            }
        } while (opcio != 4);
    }

    void Submenu2OP1(Scanner sc) throws IOException {
        String path, nomVideo, codec;
        float durada, fps;
        int amplada, alcada;
        System.out.println("Introdueix el cami del arxiu");
        path = sc.next();
        System.out.println("Introdueix el nom del arxiu");
        nomVideo = sc.next();
        System.out.println("Introdueix el codec del arxiu");
        codec = sc.next();
        System.out.println("Introdueix la durada del arxiu");
        durada = sc.nextFloat();
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
        }
    }

    void Submenu2OP2(Scanner sc) throws AplicationException {
        String path, pathImatge, nomAudio, codec;
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
        } catch (AplicacioException ex) {
            Logger.getLogger(AplicacioUB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Submenu3OP1(Scanner sc, AlbumFitxersMultimedia alb) throws IOException {
        Scanner teclat = new Scanner(System.in);
        int id;
        System.out.println("Seleccioneu un fitxer de la biblioteca per afegir a l'àlbum\n");
        c1.mostrarBiblioteca();
        id = teclat.nextInt() - 1;
        File file = c1.seleccionBiblio(id);
        if (file instanceof Audio) {
            alb.addFitxerAudio((Audio) file);
        } else {
            alb.addFitxerVideo((Video) file);
        }
    }

    void SubmenuControlOP1(Scanner sc) throws AplicacioException{
        Scanner teclat = new Scanner(System.in);
        int id;
        String op;
        System.out.println("Vols  visualitzar la llista d'arxius per seleccionar la reproducció? (S/N)");
        op = teclat.next();
        if(op.equals("S")){
            c1.mostrarBiblioteca();
        }
        System.out.println("Selecciona la ID de l'arxiu a reproduir");
        id = teclat.nextInt();
        c1.reproduirFitxer(id);
        
    }
    
    void SubmenuControlOP2(Scanner sc) throws AplicacioException{
        c1.reproduirCarpeta();
    }

}
