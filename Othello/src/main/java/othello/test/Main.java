package othello.test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.CtrlDomain;
import othello.domain.Estadistica;
import othello.domain.IA;
import othello.domain.IA.Dificultad;
import othello.domain.Jugador;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;
import othello.domain.tablero.Tablero;

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
        dominio = CtrlDomain.getInstance();
        boolean exit = false;
        int opt;
        Estadistica s = new Estadistica("Default");
        Escenario e = new Escenario("Default");
        e.commitPlay(new Pair(0, 0), Casilla.BLANCA);

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
                    gestionEscenarios();
                    break;
                case 4:
                    gestionPartida();
                    break;
                case 5:
                    displayRanking();
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
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
        Boolean exit = false;
        int ret = -1;
        while (!exit) {
            System.out.println("Tu nombre: ");
            String name = sc.nextLine();

            if ("0".equals(name)) {
                break;
            }

            ret = dominio.crearPerfil(name);

            switch (ret) {
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
        Boolean exit = false;
        int ret;
        while (!exit) {
            System.out.println("Perfil a borrar: ");
            String name = sc.nextLine();

            if ("0".equals(name)) {
                break;
            }

            ret = dominio.borrarPerfil(name);

            switch (ret) {
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

        String nombre = sc.nextLine();

        Estadistica e = dominio.searchEstadistica(nombre);
        if (e == null) {
            System.out.println("\nEl Perfil " + nombre + " no existe!\n");
        } else {
            System.out.println("\n" + e.toString() + "\n");;
        }

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
                System.out.println("\nOpción incorrecta\n");
                break;
        }

    }

    private static void gestionEscenarios() {
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
                    crearEscenario();
                    break;
                case 2:
                    modificarEscenario();
                    break;
                default:
                    break;
            }
        } while (!back);
    }

    private static void crearEscenario() {
        Scanner sc = new Scanner(System.in);
        Boolean exit = false;
        int ret = -1;
        while (!exit) {
            System.out.println("Nombre para el escenario: ");
            String name = sc.nextLine();

            if ("0".equals(name)) {
                break;
            }

            ret = dominio.crearEscenario(name);

            switch (ret) {
                case 1:
                    System.out.println("Escenario " + name + " creado con exito!");
                    editarTablero(dominio.searchEscenario(name));
                    exit = true;
                    break;
                case -1:
                    System.out.println("Escenario " + name + " ya existe, prueba de nuevo");
                    break;
                default:
                    System.out.println("ha habido un error, prueba de nuevo");
                    break;
            }
        }

    }

    private static void modificarEscenario() {
        //editarTablero(e);
        Scanner sc = new Scanner(System.in);
        Boolean exit = false;
        System.out.println("Escenarios disponibles: ");
        for (Escenario e : dominio.listEscenarios()) {
            System.out.println(e.getId());
            e.print_tablero();
        }
        while (!exit) {
            System.out.println("Nombre del escenario a seleccionar: ");
            String name = sc.nextLine();

            if ("0".equals(name)) {
                break;
            }

            Escenario e = dominio.searchEscenario(name);

            if (e != null) {
                System.out.println("Escenario " + name + " seleccionado con exito!");
                editarTablero(dominio.searchEscenario(name));
                exit = true;
            } else {
                System.out.println("Escenario " + name + " no existe, prueba de nuevo");
            }
        }
    }

    private static void editarTablero(Escenario e) {

        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        Casilla c = Casilla.NEGRA;
        int x;
        int y;
        do {
            e.print_tablero();
            System.out.println("Colocar ficha en: " + c);
            System.out.println("\t u - UNDO, r - REDO, s - SAVE AND QUIT");
            String s = sc.nextLine();

            switch (s) {
                case ("u"):
                    e.undo();
                    break;
                case ("r"):
                    e.redo();
                    break;
                case ("s"):
                    exit = true;
                    break;
                default:
                    x = Character.getNumericValue(s.charAt(0));
                    y = Character.getNumericValue(s.charAt(2));
                    ArrayList<Pair> a = e.commitPlay(new Pair(x, y), c);
                    if (a.isEmpty()) {
                        System.out.println("Movimiento ilegal. Prueba otra vez!");
                    } else {
                        c = c.contrary();
                    }
                    break;
            }

        } while (!exit);
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
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!back);
    }

    private static void crearPartida() {
        Partida p;
        int opt;
        System.out.println("\nTipo de Partida: (IAvsIA:1, PLAYERvsIA:2, PLAYERvsPLAYER:3)\n");
        Scanner sc = new Scanner(System.in);
        do {
            opt = sc.nextInt();
        } while (opt < 1 && opt > 3);

        Tablero t = seleccionarEscenario();
        Casilla c = seleccionarColor();
        if (opt == 1) { // IAvsIA

            IA ia1 = createIA(c);
            IA ia2 = createIA(c.contrary());
            p = new Partida(Partida.GameType.IAvsIA, t, 0, ia1, ia2);
        } else if (opt == 2) { // PLAYERvsIA
            Jugador j2 = seleccionarJugador(c);
            IA ia1 = createIA(c.contrary());
            p = new Partida(Partida.GameType.PLAYERvsIA, t, 0, ia1, j2);
        } else if (opt == 3) { // PLAYERvsPLAYER
            Jugador j1 = seleccionarJugador(c);
            Jugador j2 = seleccionarJugador(c.contrary());
            p = new Partida(Partida.GameType.PLAYERvsPLAYER, t, 0, j1, j2);
        }
    }

    private static void cargarPartida() {
        System.out.println("No implementado!!!");
    }

    private static void displayRanking() {
        dominio.DisplayRanking();
    }

    private static void guardarDatos() {
        dominio.guardarEscenarios();
        dominio.guardarUsuarios();
    }

    private static Tablero seleccionarEscenario() {
        System.out.println("\nQuieres seleccionar un Escenario? (Y/N)\n");
        Scanner sc = new Scanner(System.in);
        String c = sc.nextLine();

        do {
            c = sc.nextLine();
            if (!c.equals("Y") && !c.equals("N")) {
                System.out.println("\nIntroduzca un valor correcto!!!\n");
            }
        } while (!c.equals("Y") && !c.equals("N"));

        if (c.equals("Y")) {
            System.out.println("\nSeleccionar Escenario:\n");
            for (Escenario esc : dominio.listEscenarios()) {
                System.out.println(esc.toString());
            }
            String name;
            Escenario e;
            do {
                name = sc.nextLine();
                e = dominio.searchEscenario(name);
                if (e == null) {
                    System.out.println("\nEl Escenario " + name + " no existe!\nnIntroduzca un nombre correcto!\n");
                }
            } while (e == null);

            return e.getTop();
        }
        return new Tablero();
    }

    private static Jugador seleccionarJugador(Casilla c) {
        System.out.println("\nQuieres seleccionar un Jugador? (Y/N)\n");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        do {
            s = sc.nextLine();
            if (!c.equals("Y") && !c.equals("N")) {
                System.out.println("\nIntroduzca un valor correcto!!!\n");
            }
        } while (!c.equals("Y") && !c.equals("N"));

        if (c.equals("Y")) {
            System.out.println("\nSeleccionar Perfil:\n");
            for (Estadistica j : dominio.listPerfiles()) {
                System.out.println(j.toStringOnlyName());
            }
            String name;
            Estadistica j;
            do {
                name = sc.nextLine();
                j = dominio.searchEstadistica(name);
                if (j == null) {
                    System.out.println("\nEl Perfil " + name + " no existe!\nnIntroduzca un nombre correcto!\n");
                }
            } while (j == null);

            return new Jugador(j, c);
        }
        return new Jugador(c);
    }

    private static Casilla seleccionarColor() {
        System.out.println("\nSelecciona un Color:\n"
                + "\t1 - Negro\n"
                + "\t2 - Blanco\n"
                + "\t0 - Aleatorio\n");
        Scanner sc = new Scanner(System.in);
        Casilla c = null;
        int opt;
        do {
            opt = sc.nextInt();
            switch (opt) {
                case 0:
                    Random rand = new Random();
                    int r = rand.nextInt(1);
                    if (r % 2 == 0) {
                        c = Casilla.NEGRA;
                    } else {
                        c = Casilla.BLANCA;
                    }
                    break;
                case 1:
                    c = Casilla.NEGRA;
                    break;
                case 2:
                    c = Casilla.BLANCA;
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (c == null);
        return c;
    }

    private static IA createIA(Casilla c) {
        IA ia = null;
        Dificultad d = null;
        System.out.println("\nSelecciona una Dificultad:\n"
                + "\t1 - Facil\n"
                + "\t2 - Normal\n"
                + "\t2 - Dificil\n"
                + "\t0 - Aleatorio\n");
        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            opt = sc.nextInt();
            switch (opt) {
                case 0:
                    Random rand = new Random();
                    int r = rand.nextInt(1);
                    if (r % 3 == 0) {
                        d = Dificultad.FACIL;
                    } else if (r % 3 == 1) {
                        d = Dificultad.NORMAL;
                    } else {
                        d = Dificultad.DIFICIL;
                    }
                    break;
                case 1:
                    d = Dificultad.FACIL;
                    break;
                case 2:
                    d = Dificultad.NORMAL;
                    break;
                case 3:
                    d = Dificultad.DIFICIL;
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
            if (d != null) {
                ia = new IA(d, c);
            }
        } while (ia == null);
        return ia;
    }
}
