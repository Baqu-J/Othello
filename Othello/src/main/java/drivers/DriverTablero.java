/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivers;

import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.tablero.Tablero;

/**
 *
 * @author Foster
 */
public class DriverTablero {

     private static void menu() {
        System.out.println("\nEscoge una opción:\n"
                + "\t1 - testPrint\n"
                + "\t2 - testLegal\n"
                + "\t3 - testGetLegal\n"
                + "\t0 - Salir\n");
    }
    /**
     * @param args the command line arguments
     */
     
    private static void testLegal(Tablero t) {
        t.print_tablero();
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
        
        if(!t.commitPlay(new Pair(x, y), c).isEmpty()) {
            System.out.println("Jugada legal! el tablero resultante seria:");
            t.print_tablero();
        }
        else System.out.println("Jugada ilegal.");
    }
    
    private static void testgetLegal(Tablero t) {
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
        System.out.println(t.getLegalMoves(c).toString());
    }
    
    public static void main(String[] args) {
        Tablero t = new Tablero();
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
                    t.print_tablero();
                    break;
                case 2:
                    testLegal(t);
                    break;
                case 3:
                    testgetLegal(t);
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!exit);
        System.out.println("\nTest Escenarios finalizado...\n");
    }
    
}
