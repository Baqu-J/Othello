package othello.test;

import java.util.ArrayList;
import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.CtrlDomain;
import othello.domain.Estadistica;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

/**
 *
 * @author Aleix Velasco Calvo
 */
public class Main {
    private static CtrlDomain dominio;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean exit = false;
        int opt;
        Estadistica s = new Estadistica("Default");
        Escenario e = new Escenario("Default");
        e.commitPlay(new Pair(0,0), Casilla.BLANCA);
        
        Scanner sc = new Scanner(System.in);
        do {
            menuApp();
            
            opt = sc.nextInt();
            
            switch (opt) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    gestionPerfiles();
                    break;
                case 2:
                    consultarEstadisticas();
                    break;
                case 3:
                    e = gestionEscenarios(e);
                    break;
                case 4:
                    gestionPartida();
                    break;
                case 5:
                   displayRanking(); 
                    break;
                default:
                    break;
            }
        } while (!exit);
        
        guardarDatos();
        
        System.out.println("Has salido de la App...");
    }

    /**
     * Metodo para mostrar el menu de la App por pantalla
     */
    private static void menuApp() {
        System.out.println("\nMenu Principal\n"
                + "\t1 - Crear/Borrar Perfil\n"
                + "\t2 - Consultar Estadistiques\n"
                + "\t3 - Crear/Modificar Escenario\n"
                + "\t4 - Jugar Partida\n"
                + "\t5 - Consultar Ranking\n"
                + "\t0 - Salir\n");
    }

    /**
     * Metodo para mostrar el menu de de gestión de Escenarios por pantalla
     */
    private static void menuPerfiles() {
        System.out.println("\nMenu Perfiles\n"
                + "\t1 - Crear Perfil\n"
                + "\t2 - Borrar Perfil\n"
                + "\t0 - Atras\n");
    }
    
    private static void menuEscenarios() {
        System.out.println("\nMenu Escenarios\n"
                + "\t1 - Crear Escenario\n"
                + "\t2 - Modificar Escenario\n"
                + "\t0 - Atras\n");
    }
    
    /**
     * Metodo para mostrar el menu de de gestión de Partida por pantalla
     */
    private static void menuPartida() {
        System.out.println("\nMenu Partida\n"
                + "\t1 - Crear Partida\n"
                + "\t2 - Cargar Partida\n"
                + "\t0 - Atras\n");
    }
    
    private static void crearPerfil() {
        Scanner sc = new Scanner(System.in);
        Boolean exit= false;
        int ret = -1;
        while(!exit){
            System.out.println("Tu nombre: ");
            String name = sc.nextLine();
            
            if("0".equals(name)) {break;}
            
            dominio = CtrlDomain.getInstance();
            ret = dominio.crearPerfil(name);
            
            switch(ret) {
                case 1:
                    System.out.println("Perfil " + name + " creado con exito!");
                    exit = true;
                    break;
                case -1:
                    System.out.println("Perfil " + name + " ya existe, prueba de nuevo");
                    break;
                default:
                    System.out.println("ha habido un error, prueba de nuevo");
                    break;
            }
        }
        
    }
    
    private static void borrarPerfil() {
        Scanner sc = new Scanner(System.in);
        Boolean exit= false;
        int ret;
        while(!exit){
            System.out.println("Perfil a borrar: ");
            String name = sc.nextLine();
            
            if("0".equals(name)) {break;}
            
            dominio = CtrlDomain.getInstance();
            ret = dominio.borrarPerfil(name);
            
            switch(ret) {
                case 1:
                    System.out.println("Perfil " + name + " borrado con exito!");
                    exit = true;
                    break;
                case -1:
                    System.out.println("Perfil " + name + " no existe, prueba de nuevo");
                    break;
                default:
                    System.out.println("ha habido un error, prueba de nuevo");
                    break;
            }
        }
        
    }

    private static void consultarEstadisticas() {
        System.out.println("Introduce nombre del perfil:");
        Scanner sc = new Scanner(System.in);
        dominio = CtrlDomain.getInstance();
        
        String nombre = sc.nextLine();
        dominio.verEstadisticasPerfil(nombre);
    }
    
    private static void gestionPerfiles() {
        int opt;
        Scanner sc = new Scanner(System.in);
        
            menuPerfiles();
          
            opt = sc.nextInt();
            
            switch (opt) {
                case 0:
                    break;
                case 1:
                    crearPerfil();
                    break;
                case 2:
                    borrarPerfil();
                    break;
                default:
                    break;
            }
 
       
    }
    
    private static Escenario gestionEscenarios(Escenario e) {
        int opt;
        boolean back = false;
        Scanner sc = new Scanner(System.in);
        do {
            menuEscenarios();
          
            opt = sc.nextInt();
            
            switch (opt) {
                case 0:
                    back = true;
                    break;
                case 1:
                    e = crearEscenario();
                    break;
                case 2:
                    e = modificarEscenario(e);
                    break;
                default:
                    break;
            }
            e.print_tablero();
        } while (!back);
        return e;
    }

    private static Escenario crearEscenario() {
        Escenario e = new Escenario("?");
        //editarTablero(e);
        // Añadir a la lista de escenarios
        return e;
    }

    private static Escenario modificarEscenario(Escenario e) {
        //editarTablero(e);
        e.commitPlay(new Pair(0,0), Casilla.NEGRA);
        return e;
    }

    private static void editarTablero(Escenario e) {
        
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Colocar ficha en:(color)");
            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair coord = new Pair(x,y);
            
            
        }while(!exit);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static void gestionPartida() {
        int opt;
        boolean back = false;
        Scanner sc = new Scanner(System.in);
        
        do {
            menuPartida();
          
            opt = sc.nextInt();
            
            switch (opt) {
                case 0:
                    back = true;
                    break;
                case 1:
                    crearPartida();
                    break;
                case 2:
                    cargarPartida();
                    break;
                default:
                    break;
            }
        } while (!back);
    }
    
    private static void crearPartida() {
        Partida p;
        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();
        if(opt == 1) { // IAvsIA
            //p = new Partida(0,);
        }else if(opt == 2) { // PLAYERvsIA
            
        }else if(opt == 3) { // PLAYERvsPLAYER
            
        }
    }

    private static void cargarPartida() {
        System.out.println("No implementado!!!");
    }
    
    private static void displayRanking() {
        dominio = CtrlDomain.getInstance();
        dominio.DisplayRanking();
    }

    private static void guardarDatos() {
        dominio = CtrlDomain.getInstance();
        dominio.guardarEscenarios();
        dominio.guardarUsuarios();
    }

}

    
