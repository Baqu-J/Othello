package othello.domain.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Pair;

/**
 *
 * @author Foster
 */

//hashmap i copiar constructora bucle modificacion escenario
public class Escenario extends Tablero implements Serializable{
    private String id;
    
    public Escenario(String name) {
        id = name;
         matrix = new Casilla[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                matrix[i][k] = Casilla.VACIA;
            }
        }
        matrix[4][4] = Casilla.BLANCA;
        blancas.add(new Pair(4, 4));
        matrix [4][5] = Casilla.NEGRA;
        negras.add(new Pair(4, 5));
        matrix [5][4] = Casilla.NEGRA;
        negras.add(new Pair(5, 4));
        matrix [5][5] = Casilla.BLANCA;
        blancas.add(new Pair(5, 5));
    }
    
    public Escenario(Casilla[][] matrix) {
        this.matrix = matrix;
    }
    
    @Override
    public ArrayList<Pair> commitPlay(Pair p, Casilla c) {
        ArrayList<Pair> swaps = new ArrayList<>(0);
        if (inBounds(p) && is_legal(p, c)) {
            matrix[p.first()][p.second()] = c;
        }
        return swaps;
    }

    public void Erase(Pair p) {
        if (matrix[p.first()][p.second()] != Casilla.VACIA) {
             matrix[p.first()][p.second()] = Casilla.VACIA;
        }
    }
    
    public String getId() {
        return id;
    }

}
