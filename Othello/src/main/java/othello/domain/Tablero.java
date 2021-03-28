/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain;

import java.util.ArrayList;

enum Casilla {VACIA, BLANCA, NEGRA};

/**
 *
 * @author Aleix
 */
public class Tablero {
     
    private ArrayList<ArrayList<Casilla>> matrix;

    public Tablero() {
    }

    public Tablero(ArrayList<ArrayList<Casilla>> matrix) {
        this.matrix = matrix;
    }

    public ArrayList<ArrayList<Casilla>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Casilla>> matrix) {
        this.matrix = matrix;
    }
    
    public boolean comprobarPos() {
        
    }
     
    
}
