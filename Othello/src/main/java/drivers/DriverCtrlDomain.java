package drivers;

import java.util.ArrayList;
import java.util.Scanner;
import othello.domain.CtrlDomain;
import othello.domain.Estadistica;

/**
 * Clase para testear la Estadistica y la creación del Ranking.
 *
 * @author Aleix Velasco Calvo
 */
public class DriverCtrlDomain {

    private static CtrlDomain ctrlDominio;

    /**
     * Metodo para mostrar el menu por pantalla
     */
    private static void menu() {
        System.out.println("\nEscoge una opción:\n"
                + "\t1 - testCreatePerfil\n"
                + "\t2 - testDeletePerfil\n"
                + "\t3 - testRanking\n"
                + "\t0 - Salir\n");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ctrlDominio = CtrlDomain.getInstance();
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
                    testCreatePerfil();
                    break;
                case 2:
                    testDeletePerfil();
                    break;
                case 3:
                    testRanking();
                    break;

                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!exit);
        System.out.println("\nTest Estadistica y Ranking finalizado...\n");
    }

    /**
     * Método para testear la creación de una Estadistica.
     */
    private static void testCreatePerfil() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu nombre: ");
        String name = sc.nextLine();
        int ret = ctrlDominio.crearPerfil(name);
        switch (ret) {
            case -1:
                System.out.println("Perfil " + name + " ya existe, prueba de nuevo");
                break;
            case 1:
                System.out.println("Perfil " + name + " creado con exito!");
                break;
            default:
                System.out.println("Ha ocurrido un error, prueba de nuevo");
                break;
        }
    }

    /**
     * Método para testear la eliminación de una Estadistica.
     */
    private static void testDeletePerfil() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tu nombre: ");
        String name = sc.nextLine();
        int ret = ctrlDominio.borrarPerfil(name);
        switch (ret) {
            case -1:
                System.out.println("Perfil " + name + " no existe, prueba de nuevo");
                break;
            case 1:
                System.out.println("Perfil " + name + " borrado con exito!");
                break;
            default:
                System.out.println("Ha ocurrido un error, prueba de nuevo");
                break;
        }
    }

    /**
     * Método para testear el print del Ranking.
     */
    private static void testRanking() {
        ArrayList<Estadistica> perfiles = ctrlDominio.displayRanking();
        for (Estadistica e : perfiles) {
            System.out.println(e.getId() + ":");
            System.out.println("\tPuntos: " + e.getPuntos());
            System.out.println("\tVictorias: " + e.getVictoria());
            System.out.println("\tDerrotas: " + e.getDerrota());
            System.out.println("\tEmpates: " + e.getEmpate());
        }
    }
}
