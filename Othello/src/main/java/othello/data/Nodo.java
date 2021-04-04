
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
