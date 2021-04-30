package othello.domain.Test;

import java.util.ArrayList;
import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Node;
import othello.data.Pair;
import othello.data.Tree;
import othello.domain.IA;

/**
 * Clase para testear la IA.
 *
 * @author
 */
public class DriverIA {

    /**
     * Metodo para mostrar el menu por pantalla
     */
    private static void menu() {
        System.out.println("\nEscoge una opción:\n"
                + "\t1 - testCreateIAWithColor\n"
                + "\t2 - testCreateIAWithDifficultyAndColor\n"
                + "\t3 - testScore\n"
                + "\t4 - testAlphaBeta\n"
                + "\t0 - Salir\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IA ia = new IA(Casilla.NEGRA);
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opt = -1;
        do {
            menu();

            opt = sc.nextInt();

            switch (opt) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    ia = testCreateIAWithColor();
                    break;
                case 2:
                    ia = testCreateIAWithDifficultyAndColor();
                    break;
                case 3:
                    testScore(ia);
                    break;
                case 4:
                    testAlphaBeta(ia);
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!exit);
        System.out.println("\nTest Escenarios finalizado...\n");
    }

    /**
     * Método para testear el Constructor de una IA con un color.
     *
     * @return ia con un color determinado
     */
    private static IA testCreateIAWithColor() {
        Scanner sc = new Scanner(System.in);
        String s;
        Casilla c = Casilla.VACIA;
        do {
            System.out.println("\nIndica el color:\n"
                    + "\t1 - Negra\n"
                    + "\t2 - Blanca\n");
            s = sc.nextLine();
            if (s.equals("1")) {
                c = Casilla.NEGRA;
            } else if (s.equals("2")) {
                c = Casilla.BLANCA;
            }
        } while (!s.equals("1") && !s.equals("2"));
            System.out.println("Se ha creado con exito!\n Color IA = " + c);
        return new IA(c);
    }

    /**
     * Método para testear el Constructor de una IA con una dificultad y un
     * colory.
     *
     * @return ia con una dificultad y un color determinados
     */
    private static IA testCreateIAWithDifficultyAndColor() {
        Scanner sc = new Scanner(System.in);
        String s;
        Casilla c = Casilla.VACIA;
        do {
            System.out.println("\nIndica el color:\n"
                    + "\t1 - Negra\n"
                    + "\t2 - Blanca\n");
            s = sc.nextLine();
            if (s.equals("1")) {
                c = Casilla.NEGRA;
            } else if (s.equals("2")) {
                c = Casilla.BLANCA;
            }
        } while (!s.equals("1") && !s.equals("2"));
        IA.Dificultad d = IA.Dificultad.NORMAL;
        do {
            System.out.println("\nIndica la dificultad:\n"
                    + "\t1 - Facil\n"
                    + "\t2 - Normal\n"
                    + "\t3 - Dificil\n");
            s = sc.nextLine();
            if (s.equals("1")) {
                d = IA.Dificultad.FACIL;
            } else if (s.equals("2")) {
                d = IA.Dificultad.NORMAL;
            } else if (s.equals("3")) {
                d = IA.Dificultad.DIFICIL;
            }
        } while (!s.equals("1") && !s.equals("2") && !s.equals("3"));
        IA ia = new IA(d, c);
        System.out.println("Se ha creado con éxito!\n \tEl color es: " + ia.getColor() + "\n + \tBusca en profundidad: " + ia.getDepth());
        return ia;
    }

    /**
     * Método para testear el calcular score a partir de un listado de
     * cordenadas.
     *
     * @param ia para calcular score total
     */
    private static void testScore(IA ia) {
        ArrayList<Pair> a = new ArrayList<Pair>();
        Scanner sc = new Scanner(System.in);
        String s;
        int x = 0, y = 0;
        boolean exit = false;
        do {
            System.out.println("\nIntroducir cordenadas: (x y)(Introduce S para salir y calcular el score total)\n");
            s = sc.nextLine();
            switch (s) {
                case ("S"):
                    exit = true;
                    break;
                default:
                    x = Character.getNumericValue(s.charAt(0));
                    y = Character.getNumericValue(s.charAt(2));
                    a.add(new Pair(x, y));
                    break;
            }
        } while (!exit);
        System.out.println(ia.obtenerScore(a));
    }

    /**
     * Método para testear el obtener coordenada del alpha beta.
     *
     * @param ia para obtener la cordenada escogida
     */
    private static void testAlphaBeta(IA ia) {
        Tree t = new Tree(new Node());
        Scanner sc = new Scanner(System.in);
        String s;
        Casilla c = Casilla.NEGRA;
        int x = 0, y = 0, v = 0, lvl = 0;
        boolean exit = false;
        do {
            System.out.println("\nIntroducir cordenadas+score: (x y v)(Introduce S para salir)\n");
            System.out.println("Altura:" + lvl);
            s = sc.nextLine();
            switch (s) {
                case ("S"):
                    exit = true;
                    break;
                default:
                    x = Character.getNumericValue(s.charAt(0));
                    y = Character.getNumericValue(s.charAt(2));
                    v = Character.getNumericValue(s.charAt(4));
                    t.addLeaf(new Node(new Pair(x, y), c, v));
                    break;
            }
        } while (!exit);
        System.out.println(ia.escogerMovimiento(t));
    }
}
