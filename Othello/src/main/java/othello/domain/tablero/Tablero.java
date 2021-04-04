/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain.tablero;

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
 * @author Jaume
 */
       
        
public class Tablero {
    private static final Pair directions[] = {
        new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1),
        new Pair(-1, -1), new Pair(-1, 1), new Pair(1, -1), new Pair(1, 1)
    };
    protected ArrayList<ArrayList<Casilla>> matrix;
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
        matrix.get(4).set(4, Casilla.BLANCA);
        blancas.add(new Pair(4, 4));
        matrix.get(4).set(5, Casilla.NEGRA);
        negras.add(new Pair(4, 5));
        matrix.get(5).set(4, Casilla.NEGRA);
        negras.add(new Pair(5, 4));
        matrix.get(5).set(5, Casilla.BLANCA);
        blancas.add(new Pair(5, 5));
    }
    
    private boolean inBounds(Pair p) {
        if(p.first() >= 0 && p.first() < 8 && p.second() >= 0 && p.second() < 8) {
            return true;
        }
        else return false;
    }
    
    private boolean Get_empty_nearby(Pair p, ArrayList<Pair> Empty) {
        Pair ret;
        boolean found = false;
        for(Pair dir: directions) {
            ret = p.sum(dir);
            if(inBounds(ret)){
                if(matrix.get(ret.first()).get(ret.second()) == Casilla.VACIA) {
                    if(!Empty.contains(ret)){
                        Empty.add(ret);
                        found = true;
                    }
                }
            }
        }
        return found;
    }
    
    //PUBLIC METHODS

    public Tablero() {
        matrix = new ArrayList<ArrayList<Casilla>>(8);
        blancas = new ArrayList<Pair>(0);
        negras = new ArrayList<Pair>(0);
        
        build_matrix(matrix);
        
        
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
        if(matrix.get(p.first()).get(p.second()) != Casilla.VACIA) return false;
        for(Pair dir: directions) {
            Pair start = p.sum(dir);
            if(inBounds(start) && matrix.get(start.first()).get(start.second()) == c.contrary()) {
                while(inBounds(start)){
                    if(matrix.get(start.first()).get(start.second()) == c) {
                        return true;
                    }
                    if(matrix.get(start.first()).get(start.second()) == Casilla.VACIA) {
                        break;
                    }
                    start = start.sum(dir);
                }
            }
        }
        return false;
    }
    
    public ArrayList<Pair> getLegalMoves(Casilla c) {
        ArrayList<Pair> positions;
        if(c == Casilla.BLANCA){
            positions = (ArrayList<Pair>)negras.clone();
        }
        else {
            positions = (ArrayList<Pair>)blancas.clone();
        }
        ArrayList<Pair> Legals = new ArrayList<Pair>(0);
        for(int i = 0; i < positions.size(); ++i) {
            Get_empty_nearby(positions.get(i), Legals);
        }
        if(!Legals.isEmpty()) {
            for(int j = 0; j < Legals.size(); ++j) {
                if(!is_legal(Legals.get(j), c)) {
                    Legals.remove(j);
                }
            }
        }
        return Legals;
    }
    
    public boolean commitPlay(Pair p, Casilla c) {
        if(inBounds(p) && is_legal(p, c)) {
            matrix.get(p.first()).set(p.second(), c);
            return true;
        }
        return false;
    }
}
