package othello.domain.tablero;

import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Pair;

/**
 *
 * @author Jaumes
 */
public class Tablero implements java.io.Serializable{

    protected static final Pair directions[] = {
        new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1),
        new Pair(-1, -1), new Pair(-1, 1), new Pair(1, -1), new Pair(1, 1)
    };
    protected Casilla[][] matrix;
    
    //CAMBIAR POR HASHMAP<PAIR, CASILLA> also GSON
    protected ArrayList<Pair> blancas;
    protected ArrayList<Pair> negras;

    //PRIVATE METHODS
    //construye el tablero standard
    private void build_matrix() {
        matrix = new Casilla[8][8];
        
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                matrix[i][k] = Casilla.VACIA;
            }
        }
        matrix[3][3] = Casilla.BLANCA;
        blancas.add(new Pair(3, 3));
        matrix [3][4] = Casilla.NEGRA;
        negras.add(new Pair(3, 4));
        matrix [4][3] = Casilla.NEGRA;
        negras.add(new Pair(4, 3));
        matrix [4][4] = Casilla.BLANCA;
        blancas.add(new Pair(4, 4));
    }

    protected boolean inBounds(Pair p) {
        if (p.first() >= 0 && p.first() < 8 && p.second() >= 0 && p.second() < 8) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean Get_empty_nearby(Pair p, ArrayList<Pair> Empty) {
        Pair ret;
        boolean found = false;
        for (Pair dir : directions) {
            ret = p.sum(dir);
            if (inBounds(ret)) {
                if (matrix[ret.first()][ret.second()] == Casilla.VACIA) {
                    if (!Empty.contains(ret)) {
                        Empty.add(ret);
                        found = true;
                    }
                }
            }
        }
        return found;
    }
    
    protected void addtoColor(Pair p, Casilla c) {
        if(c == Casilla.BLANCA) {
            blancas.add(p);
        }
        else if(c == Casilla.NEGRA) {
            negras.add(p);
        }
    }
    
    protected void removefromColor(Pair p, Casilla c) {
        if(c == Casilla.BLANCA) {
            blancas.remove(p);
        }
        else if(c == Casilla.NEGRA) {
            negras.remove(p);
        }
    }

    protected void swapTile(Pair p) {
        Casilla c = matrix[p.first()][p.second()];
        matrix[p.first()][p.second()] = c.contrary();
    }

    protected void swapEnemy(Pair p, Casilla c, ArrayList<Pair> swaps) {
       
        if (matrix[p.first()][p.second()] == c) {
            for (Pair dir : directions) {
                Pair start = p.sum(dir);
                if (inBounds(start) && matrix[start.first()][start.second()] == c.contrary()) {
               
                    while(inBounds(start)){
                         
                        if (matrix[start.first()][start.second()] == c) {
                            start = start.sub(dir);
                            while(!start.convertString().equals(p.convertString())) {
                                removefromColor(start ,c.contrary());
                                addtoColor(start, c);
                                swaps.add(start);
                                start = start.sub(dir);
                            }
                            break;
                        }
                        if (matrix[start.first()][start.second()] == Casilla.VACIA) {
                            break;
                        }
                         start = start.sum(dir);
                    }
                }
            }
            
            for(int i = 1; i < swaps.size(); ++i) {
                 swapTile(swaps.get(i));
            }
        }
    }

    //evalua una si un movimiento es legal para un color.
    protected boolean is_legal(Pair p, Casilla c) {
        if (matrix[p.first()][p.second()] != Casilla.VACIA) {
            return false;
        }
        for (Pair dir : directions) {
            Pair start = p.sum(dir);
            if (inBounds(start) && matrix[start.first()][start.second()] == c.contrary()) {
                while (inBounds(start)) {
                    if (matrix[start.first()][start.second()] == c) {
                        
                        return true;
                    }
                    if (matrix[start.first()][start.second()] == Casilla.VACIA) {
                       
                        break;
                    }
                    start = start.sum(dir);
                }
            }
           
        }
        return false;
    }

    //PUBLIC METHODS
    public Tablero() {
        blancas = new ArrayList<Pair>(0);
        negras = new ArrayList<Pair>(0);

        build_matrix();

    }

    public Tablero(Casilla[][] matrix, ArrayList<Pair> blancas, ArrayList<Pair> negras) {
        this.matrix = matrix;
        this.blancas = blancas;
        this.negras = negras;
    }

    public Tablero DeepCopy() {
        Tablero t = new Tablero();

        for (int x = 0; x < this.matrix.length; ++x) {
            for (int y = 0; y < this.matrix[0].length; ++y) {
                t.matrix[x][y] = this.matrix[x][y];
            }
        }

        for (int i = 0; i < blancas.size(); ++i) {
            t.blancas.add(i, this.blancas.get(i));
        }
        for (int i = 0; i < negras.size(); ++i) {
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

    public Casilla[][] getMatrix() {
        return matrix;
    }

    public void setBlancas(ArrayList<Pair> v) {
        blancas = v;
    }

    public void setNegras(ArrayList<Pair> v) {
        negras = v;
    }

    public void setMatrix(Casilla[][] matrix) {
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

    public ArrayList<Pair> getLegalMoves(Casilla c) { 
        ArrayList<Pair> positions;
        if (c == Casilla.BLANCA) {
            positions = (ArrayList<Pair>) negras.clone();
        } else {
            positions = (ArrayList<Pair>) blancas.clone();
        }
        ArrayList<Pair> Legals = new ArrayList<Pair>(0);
        for (int i = 0; i < positions.size(); ++i) {
            Get_empty_nearby(positions.get(i), Legals);
        }
        int s = Legals.size();
        if (!Legals.isEmpty()) {
            for (int j = s-1; j >= 0; --j) {
                if (!is_legal(Legals.get(j), c)) {
                    Legals.remove(j);
                    
                }
            }
        }
        for(int i = 0; i < Legals.size(); ++i) {
            System.out.print(Legals.get(i).convertString() + " ");
        }
        System.out.println("");
        return Legals;
    }

    public ArrayList<Pair> commitPlay(Pair p, Casilla c) {
        ArrayList<Pair> swaps = new ArrayList<>(0);
        
        if (inBounds(p) && is_legal(p, c)) {
            matrix[p.first()][p.second()] = c;
            addtoColor(p, c);
            swaps.add(p);
            swapEnemy(p, c, swaps);
        }
        return swaps;
    }
    public void print_tablero() {
        String nums = "  |1|2|3|4|5|6|7|8|";
        String letters = "12345678";
        System.out.println(nums);
        for(int i = 0; i < 8; ++i) {
            System.out.print(letters.charAt(i) + "| ");
            for(int j = 0; j < 8; ++j) {
                
                if(this.matrix[i][j] == Casilla.VACIA) System.out.print("- ");
                else if(this.matrix[i][j] == Casilla.BLANCA) System.out.print("B ");
                else System.out.print("N ");
            }
            System.out.println("");
        }
    }
}
