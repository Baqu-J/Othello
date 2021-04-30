package drivers;

import java.util.ArrayList;
import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.tablero.Escenario;

/**
 * Clase para testear Escenario.
 *
 * @author Aleix Velasco Calvo
 */
public class DriverEscenario {

    /**
     * Metodo para mostrar el menu por pantalla
     */
    private static void menu() {
        System.out.println("\nEscoge una opción:\n"
                + "\t1 - testPrint\n"
                + "\t2 - testUndo\n"
                + "\t3 - testRedo\n"
                + "\t4 - testCommitPlay\n"
                + "\t0 - Salir\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Escenario e = new Escenario("Default");
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
                    testPrint(e);
                    break;
                case 2:
                    testUndo(e);
                    break;
                case 3:
                    testRedo(e);
                    break;
                case 4:
                    testCommitPlay(e);
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!exit);
        System.out.println("\nTest Escenarios finalizado...\n");
    }

    /**
     * Método para testear el print de un escenario.
     *
     * @param e Escenario
     */
    private static void testPrint(Escenario e) {
        System.out.println(e.getId());
        e.getTop().print_tablero();
    }

    /**
     * Método para testear el realizar una jugada de un escenario.
     *
     * @param e Escenario
     */
    private static void testCommitPlay(Escenario e) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Colocar ficha en: (x y)");
        String s = sc.nextLine();
        int x = Character.getNumericValue(s.charAt(0));
        int y = Character.getNumericValue(s.charAt(2));
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
        ArrayList<Pair> a = e.commitPlay(new Pair(x, y), c);
        if (a.isEmpty()) {
            System.out.println("Movimiento ilegal. Prueba otra vez!");
        }
    }

    /**
     * Método para testear el Redo de un escenario.
     *
     * @param e Escenario
     */
    private static void testRedo(Escenario e) {
        e.redo();
    }

    /**
     * Método para testear el Undo de un escenario.
     *
     * @param e Escenario
     */
    private static void testUndo(Escenario e) {
        e.undo();
    }
}
