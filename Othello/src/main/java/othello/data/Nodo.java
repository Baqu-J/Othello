
package othello.data;

import java.util.ArrayList;
import othello.domain.tablero.Tablero;

public class Nodo {

    // ESTO PUEDE IR EN OTRO LUGAR
    private static final int PESOS_HARD[][] = 
        {{ 4,-3, 2, 2, 2, 2,-3, 4},
         {-3,-4,-1,-1,-1,-1,-4,-3},
         { 2,-1, 1, 0, 0, 1,-1, 2},
         { 2,-1, 0, 1, 1, 0,-1, 2},
         { 2,-1, 0, 1, 1, 0,-1, 2},
         { 2,-1, 1, 0, 0, 1,-1, 2},
         {-3,-4,-1,-1,-1,-1,-4,-3},
         { 4,-3, 2, 2, 2, 2,-3, 4}};
    
    private int score;
    private ArrayList<Nodo> hijos;
    private Tablero tab;

    public Nodo(ArrayList<Nodo> hijos, Tablero tab) {
        this.hijos = hijos;
        this.tab = tab;
        this.score = calcularScore();
    }
  
    
    public static int calcularScore (/*CASILLA C*/){
        
        // AQUI VA EL CODIGO:
        // -> sumar los pesos de las posiciones de las fichas de casilla c
        //    restandole los pesos de las posiciones de las fichas del 
        //    contrario usando la tabla PESOS. 
        //    SUmando la cantidad de fichas c menos el contrario
        // -> formula = SUM(pesos(c)) - SUM(pesos(contrario)) + #fichas(c) - #fichas(contrario)
        
        return 3;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //OBTIENE LOS HIJOS PARTIENDO DEL TABLERO
    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }
}
/*package othello.data;

/**
 * A Node of a Tree for Minimax
 * 
 * @author Aleix Velasco Calvo
 *
public class Node {
    
    // Attributes
    private int x, y;
    private int player;
    private int score;

    // Constructors
    public Node(int x, int y, int player) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.score = 0;
    }

    public Node(int x, int y, int player, int score) {
        this.x = x;
        this.y = y;
        this.player = player;
        this.score = score;
    }
    
    public Node(int score) {
        this.x = -1;
        this.y = -1;
        this.player = -1;
        this.score = score;
    }
    
    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    } 
}*/