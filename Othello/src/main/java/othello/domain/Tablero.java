/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain;

import java.util.ArrayList;
import othello.data.Pair;
enum Casilla {
    VACIA, BLANCA, NEGRA;
    
    Casilla contrary () {
        switch(this) {
            case BLANCA:
                return NEGRA;
            case NEGRA:
                return BLANCA;
            default: return VACIA;
        }
    }
};

/**
 *
 * @author Aleix
 */
       
        
public class Tablero {
     
    private ArrayList<ArrayList<Casilla>> matrix;
    private ArrayList<Pair> blancas;
    private ArrayList<Pair> negras;
    
    //PRIVATE METHODS
    
    //construye el tablero standard
    private void build_matrix(ArrayList<ArrayList<Casilla>> matrix) {
        
        for(int i=0; i < 8; i++) {
            ArrayList<Casilla> aux = new ArrayList<>(8);
            for (int k = 0; k < aux.size(); k++) {
                aux.add(Casilla.VACIA);
            }
            matrix.add(aux);
        }
        matrix.get(4).add(4, Casilla.BLANCA);
        matrix.get(4).add(5, Casilla.NEGRA);
        matrix.get(5).add(4, Casilla.NEGRA);
        matrix.get(5).add(5, Casilla.BLANCA);
    }
    
    //PUBLIC METHODS

    public Tablero() {
        matrix = new ArrayList<ArrayList<Casilla>>(8);
        build_matrix(matrix);
        
        blancas = new ArrayList<Pair>(0);
        negras = new ArrayList<Pair>(0);
    }

    public Tablero(ArrayList<ArrayList<Casilla>> matrix,  ArrayList<Pair> blancas, ArrayList<Pair> negras) {
        this.matrix = matrix;
        this.blancas = blancas;
        this.negras = negras;
    }
    
    public Tablero DeepCopy() {
        Tablero t = new Tablero();
        
        for(int x = 0; x < this.matrix.size(); ++x) {
            for(int y = 0; y < this.matrix.get(0).size();++y) {
                t.matrix.get(x).add(y, this.matrix.get(x).get(y));
            }
        }
        
        for(int i = 0; i < blancas.size(); ++i) {
            t.blancas.add(i, this.blancas.get(i));
        }
        for(int i = 0; i < negras.size(); ++i) {
            t.negras.add(i, this.negras.get(i));
        }
        
        return t;
    }
    
    public ArrayList<Pair> getBlancas() {
        return blancas;
    }
    
    public ArrayList<Pair> getNegras() {
        return negras;
    }

    public ArrayList<ArrayList<Casilla>> getMatrix() {
        return matrix;
    }
    
    /**
     *
     * @param v
     */
    public void setBlancas(ArrayList<Pair> v) {
        blancas = v;
    }
    
    public void setNegras(ArrayList<Pair> v) {
        negras = v;
    }
    
    public void setMatrix(ArrayList<ArrayList<Casilla>> matrix) {
        this.matrix = matrix;
    }
    
    public void addBlancas(Pair p) {
        blancas.add(p);
    }
    
    public void addNegras(Pair p) {
        negras.add(p);
    }
    
    public void delBlancas(Pair p) {
        blancas.remove(p);
    }
    
    public void delNegras(Pair p) {
        negras.remove(p);
    }
    
    //evalua una si un movimiento es legal para un color.
    public boolean is_legal(Pair p, Casilla c) {
        
        //Por cada dirección evalua si se pueden encerrar fichas.
            //UP
            int start = p.first() - 1;
            if(start >= 0){
                if(matrix.get(start).get(p.second()).contrary() == c) { //comprova que el adjacent sigui del color contrari.
                    for(--start; start >= 0; start = start + -1) {
                        if(matrix.get(start).get(p.second()) == c) break;
                        else if(matrix.get(start).get(p.second()) == Casilla.VACIA) return true;
                    }
                }
            }
            //DOWN
            start = p.first() + 1;
            if(start < 8) {
                if(matrix.get(start).get(p.second()).contrary() == c) { //comprova que el adjacent sigui del color contrari.
                    for(--start; start < matrix.size(); start = start + 1) {
                        if(matrix.get(start).get(p.second()) == c) break;
                        else if(matrix.get(start).get(p.second()) == Casilla.VACIA) return true;
                    }
                }
            }
            //LEFT
            start = p.second() - 1;
            if(start >= 0){
                if(matrix.get(p.first()).get(start).contrary() == c) { //comprova que el adjacent sigui del color contrari.
                    for(--start; start >= 0; start = start + -1) {
                        if(matrix.get(p.first()).get(start) == c) break;
                        else if(matrix.get(p.first()).get(start) == Casilla.VACIA) return true;
                    }
                }
            }
            //RIGHT
            start = p.second() + 1;
            if(start < 8) {
                if(matrix.get(p.first()).get(start).contrary() == c) { //comprova que el adjacent sigui del color contrari.
                    for(--start; start < matrix.size(); start = start + 1) {
                        if(matrix.get(p.first()).get(start) == c) break;
                        else if(matrix.get(p.first()).get(start) == Casilla.VACIA) return true;
                    }
                }
            }
            return false;
    }
    
    public ArrayList<Pair> getLegalMoves(Casilla c) {
        ArrayList<Pair> p;
        if(c == Casilla.BLANCA){
            p = (ArrayList<Pair>)blancas.clone();
        }
        else {
            p = (ArrayList<Pair>)negras.clone();
        }
        ArrayList<Pair> Legals = new ArrayList<Pair>(0);
        for(int i = 0; i < p.size(); ++i) {
            if(is_legal(p.get(i), c)) {
                Legals.add(p.get(i));
            }
        }
        return Legals;
    }
}
