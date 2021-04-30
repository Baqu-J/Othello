package othello.domain.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Pair;

/**
 * Clase Tablero que contiene una matriz con las posiciones del tablero 
 * de juego, y una lista de posiciones de fichas para cada color(blancas,negras)
 * junto a métodos que permiten gestionar movimientos de fichas en el tablero,
 * verificar si una jugada es legal, obtener las posiciones legales para colocar
 * una ficha y hacer los cambios de color necesarios al ejecutar el movimiento
 * 
 * @author Jaume Baqueró Quesada
 */
public class Tablero implements Serializable{

    protected static final Pair directions[] = {
        new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1),
        new Pair(-1, -1), new Pair(-1, 1), new Pair(1, -1), new Pair(1, 1)
    };
    
    private Casilla[][] matrix;
    private ArrayList<Pair> blancas;
    private ArrayList<Pair> negras;

    //PRIVATE METHODS
    /**
     * Método para construir el tablero estándar
     */
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

    /**
     * Método que sirve para verificar si la posición p es válida, es decir
     * que está dentro del tablero.
     * @param p
     * @return 
     */
    protected boolean inBounds(Pair p) {
        if (p.first() >= 0 && p.first() < 8 && p.second() >= 0 && p.second() < 8) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método para obtener posiciones vacías que rodean una posición dada
     * @param p
     * @param Empty
     * @return true-> si existe posiciones vacías cerca a posición "p" y lo
     *                guarda en la lista "Empty"
     *         false-> no existe posiciones vacías cerca a posición "p" y lo
     *                 guarda en la lista "Empty"
     */
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
    
    /**
     * Método para asignar agregar una nueva posición a la lista de fichas de color "c"
     * @param p
     * @param c 
     */
    protected void addtoColor(Pair p, Casilla c) {
        if(c == Casilla.BLANCA) {
            blancas.add(p);
        }
        else if(c == Casilla.NEGRA) {
            negras.add(p);
        }
    }
    
    /**
     * Método para remover una posición de la lista del color "c".
     * @param p
     * @param c 
     */
    protected void removefromColor(Pair p, Casilla c) {
        if(c == Casilla.BLANCA) {
            blancas.remove(p);
        }
        else if(c == Casilla.NEGRA) {
            negras.remove(p);
        }
    }

    /**
     * Método que cambia el color de una casilla
     * @param p 
     */
    protected void swapTile(Pair p) {
        Casilla c = matrix[p.first()][p.second()];
        matrix[p.first()][p.second()] = c.contrary();
    }

    /**
     * Método que cambia el color de las fichas enemigas en todas las
     * direcciones en las cuales encierra a su enemigo
     * @param p
     * @param c
     * @param swaps 
     */
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

    /**
     * Método que evalua si una posición es legal para jugarla
     * @param p
     * @param c
     * @return 
     */
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
    /**
     * Constructor por defecto
     */
    public Tablero() {
        blancas = new ArrayList<Pair>(0);
        negras = new ArrayList<Pair>(0);
        build_matrix();
    }

    /**
     * Constructor asignando matriz de posiciones y listas de posiciones de
     * blancas y negras.
     * @param matrix
     * @param blancas
     * @param negras 
     */
    public Tablero(Casilla[][] matrix, ArrayList<Pair> blancas, ArrayList<Pair> negras) {
        this.matrix = matrix;
        this.blancas = blancas;
        this.negras = negras;
    }

    /**
     * Función que realiza una copia por valor del tablero implícito
     * @return copia de tablero
     */
    public Tablero DeepCopy() {
        Casilla[][] m2 = new Casilla[8][8];
        
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, m2[i], 0, matrix[0].length);
        }

        ArrayList<Pair> b2 = new ArrayList<>();
        
        for (Pair p : blancas) {
            b2.add(new Pair(p.first(), p.second()));
        }
        
        ArrayList<Pair> n2 = new ArrayList<>();
        
        for (Pair p : negras) {
            n2.add(new Pair(p.first(), p.second()));
        }
        
        Tablero t = new Tablero(m2, b2, n2);

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

    /**
     * Método para agregar una posición a la lista de fichas blancas
     * @param p 
     */
    public void addBlancas(Pair p) {
        blancas.add(p);
    }

    /**
     * Método para agregar una posición a la lista de fichas negras
     * @param p 
     */
    public void addNegras(Pair p) {
        negras.add(p);
    }

    /**
     * Método para remover una posición de la lista de fichas blancas.
     * @param p 
     */
    public void delBlancas(Pair p) {
        blancas.remove(p);
    }

    /**
     * Método para remover una posición de la lista de fichas negras.
     * @param p 
     */
    public void delNegras(Pair p) {
        negras.remove(p);
    }
    
    /**
     * Función para obtener los posibles movimientos legales del color "c"
     * @param c
     * @return lista de posiciones
     */
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
        /*for(int i = 0; i < Legals.size(); ++i) {
            System.out.print(Legals.get(i).convertString() + " ");
        }
        System.out.println("");*/
        return Legals;
    }

    /**
     * Función para colocar una ficha de color "c" en la posición "p"
     * y realizar los cambios de color de las fichas encerradas 
     * enemigas. 
     * @param p
     * @param c
     * @return lista de fichas cambiadas de color
     */
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
        String nums = "  |0|1|2|3|4|5|6|7|";
        String letters = "01234567";
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
