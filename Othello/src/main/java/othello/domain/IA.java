package othello.domain;

import java.util.ArrayList;
import java.util.Random;
import othello.data.Casilla;
import othello.data.Pair;
import othello.data.Node;
import othello.data.Tree;

/**
 * Clase IA que hereda de GameState y contiene la dificultad
 * (fácil, normal, difícil) de la IA y una profundidad asociada
 * a su dificultad, junto a métodos que gestionan la heurística
 * de cada nivel de dificultad y el algoritmo de inteligencia 
 * artificial.
 * 
 * @author Franco Acevedo Montañez
 */
public class IA extends GameState {

    //Attributes
    private static final int POSITIVE_INFINITY = +1000;
    private static final int NEGATIVE_INFINITY = -1000;

    private static final int HEURISTIC[][]
            =   {{99, -18, 8, 6,6, 8, -18, 99},
                {-18, -24, -14, -12, -12, -14, -24, -18},
                {8, -14, 15, 15, 15, 15, -14, 8},
                {6, -12, 15, 10, 10, 15, -12, 6},
                {6, -12, 15, 10, 10, 15, -12, 6},
                {8, -14, 15, 15, 15, 15, -14, 8},
                {-18, -24, -14, -12, -12, -14, -24, -18},
                {99, -18, 8, 6, 6, 8, -18, 99}};
    
    public enum Dificultad {
        FACIL, NORMAL, DIFICIL
    };

    private Dificultad opcion;
    private int depth;

    //Constructors
    
    /**
     * Constructor de IA por defecto
     * @param color 
     */
    public IA(Casilla color) {
        super(color);
        this.opcion = Dificultad.NORMAL;
        this.depth = 2;
    }

    /**
     * Constructor de IA asignándole dificultad
     * @param op
     * @param color 
     */
    public IA(Dificultad op, Casilla color) {
        super(color);
        this.opcion = op;
        switch (this.opcion) {
            case FACIL:
                this.depth = 0;
                break;
            case NORMAL:
                this.depth = 2;
                break;
            case DIFICIL:
                this.depth = 4;
                break;
            default:
                this.depth = 2;
                break;
        }
    }

    // Getters and Setters
    public Dificultad getOpcion() {
        return opcion;
    }

    public int getDepth() {
        return depth;
    }

    public void setOpcion(Dificultad opcion) {
        this.opcion = opcion;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Other Methods
    /**
     * Método que calcula el score total a partir de un listado de posiciones de
     * fichas.
     *
     * @param A Listado de posiciones para calcular el score total.
     * @return Score total.
     */
    public int obtenerScore(ArrayList<Pair> A) {
        int score = 0;
        for (Pair d : A) {
                score += HEURISTIC[d.first()][d.second()];
        }
        return score;
    }

    /**
     * Método que escoge un nodo del árbol mediante el algoritmo alpha_beta.
     *
     * @param t Árbol con nodos (Nodo objects).
     * @param depth Profundidad hasta la que mirara.
     * @param alpha
     * @param beta
     * @param maximizingPlayer Boleano para seleccionar el nodo con el máximo o
     * mínimo score.
     * @return Nodo seleccionado.
     */
    private Node alpha_beta(Tree<Node> t, int depth, int alpha, int beta, boolean maximizingPlayer) {
        if (depth == 0 || t.getSubTrees().isEmpty()) {
            return t.getRoot();
        }

        if (maximizingPlayer) {
            Node maxEval = new Node(NEGATIVE_INFINITY);
            for (Tree<Node> child : t.getSubTrees()) {
               
                Node eval = alpha_beta(child, depth - 1, alpha, beta, false);
                
                    int scr = ((maxEval.getScore() > eval.getScore()) ? maxEval.getScore() : eval.getScore());
                   
                    maxEval.setScore(scr); 
                
                
                alpha = ((alpha > eval.getScore()) ? alpha : eval.getScore());
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        } else {
            Node minEval = new Node(POSITIVE_INFINITY);
            for (Tree<Node> child : t.getSubTrees()) {
                
                
                Node eval = alpha_beta(child, depth - 1, alpha, beta, true);
                
                    int scr = ((minEval.getScore() < eval.getScore()) ? minEval.getScore() : eval.getScore());
                   
                    minEval.setScore(scr);
                     
                
                beta = ((beta < eval.getScore()) ? beta : eval.getScore());
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }

    /**
     * Método que devuelve el movimiento que la IA ha seleccionado.
     *
     * @param t Árbol con posibles jugadas.
     * @return Coordenada escogida.
     */
    public Pair escogerMovimiento(Tree<Node> t) {
    
        Node maxEval = new Node(NEGATIVE_INFINITY);
        
        for (Tree<Node> child : t.getSubTrees()) {
              

                Node eval = alpha_beta(child, this.depth, NEGATIVE_INFINITY, POSITIVE_INFINITY, true);
              
                if(maxEval.getScore() < eval.getScore()) {
               
                    maxEval.setScore(eval.getScore());
                    maxEval.setCord(child.getRoot().getCord());
                }
            }
        
        Node movimiento = maxEval;
        return movimiento.getCord();
    }
}
