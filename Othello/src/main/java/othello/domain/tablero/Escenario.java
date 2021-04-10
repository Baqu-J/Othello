package othello.domain.tablero;

import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Pair;

/**
 *
 * @author Foster
 */

//hashmap i copiar constructora bucle modificacion escenario
public class Escenario extends Tablero {
    
    public Escenario() {
        for (int i = 0; i < 8; i++) {
            ArrayList<Casilla> aux = new ArrayList<>(8);
            for (int k = 0; k < aux.size(); k++) {
                aux.add(Casilla.VACIA);
            }
            matrix.add(aux);
        }
        matrix.get(4).set(4, Casilla.BLANCA);
       
        matrix.get(4).set(5, Casilla.NEGRA);
        
        matrix.get(5).set(4, Casilla.NEGRA);
       
        matrix.get(5).set(5, Casilla.BLANCA);
    }
    
    public Escenario(ArrayList<ArrayList<Casilla>> matrix) {
        this.matrix = matrix;
    }
    
    @Override
    public ArrayList<Pair> commitPlay(Pair p, Casilla c) {
        ArrayList<Pair> swaps = new ArrayList<>(0);
        if (inBounds(p) && is_legal(p, c)) {
            matrix.get(p.first()).set(p.second(), c);
        }
        return swaps;
    }

    public void Erase(Pair p) {
        if (matrix.get(p.first()).get(p.second()) != Casilla.VACIA) {
            matrix.get(p.first()).set(p.second(), Casilla.VACIA);
        }
    }

}
