/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivers;

import java.util.Scanner;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.IA;
import othello.domain.Partida;
import othello.domain.tablero.Tablero;
import othello.domain.CtrlDomain;

/**
 *
 * @author Foster
 */
public class DriverPartida {
    private static CtrlDomain dominio;
    private static void menu() {
        System.out.println("\nEscoge una opción:\n"
                + "\t1 - testIAvsIA\n"
                + "\t2 - testMakeTree\n"
                + "\t0 - Salir\n");
    }
    /**
     * @param args the command line arguments
     */
    
    private static void testIAvsIA(Partida p) {
        dominio = CtrlDomain.getInstance();
        do {
            p.getT().print_tablero();
            dominio.printPartida(p);
            dominio.colocarFicha(p, new Pair(-1, -1));
        }while(!p.gameIsFinished());
            p.getT().print_tablero();
            int nB = p.getT().getBlancas().size();
            int nN = p.getT().getNegras().size();
            System.out.println("Fin de la partida!\n");
            System.out.println("Puntuaciones:\n"
                             + "\tBlanco: " + nB + " fichas!\n"
                             + "\tNegro: " + nN + " fichas!\n");
            if(nB > nN) {
                System.out.println("Felicidades blanco! WINNER!!");
            }
            if(nN > nB) {
                System.out.println("Felicidades negro! WINNER!!");
            }
            else {
                System.out.println("Empate!");
            }
    }
    
    private static void MakeTree(Partida p) {
        System.out.println("Tree IA 1 en tablero basico\n");
        System.out.println(p.createTree(p.getT(), p.getIa1()) + "\n");
        
        System.out.println("Tree IA 2 en tablero basico\n");
        System.out.println(p.createTree(p.getT(), p.getIa2()));
        
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opt;
        IA ia1 = new IA(Casilla.NEGRA);
        IA ia2 = new IA(Casilla.BLANCA);
        do {
            Tablero t = new Tablero();
           
            Partida p = new Partida(Partida.GameType.IAvsIA, t, 0, ia1, ia2);
            menu();

            opt = sc.nextInt();

            switch (opt) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    testIAvsIA(p);
                    break;
                case 2:
                    MakeTree(p);
                    break;
                default:
                    System.out.println("\nOpción incorrecta\n");
                    break;
            }
        } while (!exit);
        System.out.println("\nTest Escenarios finalizado...\n");
    }
    }
    
