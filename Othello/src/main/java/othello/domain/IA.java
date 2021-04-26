package othello.domain;

import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Pair;
import othello.data.Node;
import othello.data.Tree;

/**
 *
 * @author 
 */
public class IA extends GameState {

    //Attributes
    private static final int POSITIVE_INFINITY = +1000;
    private static final int NEGATIVE_INFINITY = -1000;

    private static final int PESOS_DIFICIL[][]
            = {{5, -3, 2, 2, 2, 2, -3, 5},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {5, -3, 2, 2, 2, 2, -3, 5}};

    private static final int PESOS_NORMAL[][]
            = {{2, -2, 2, 2, 2, 2, -2, 2},
            {-2, -4, -1, -1, -1, -1, -4, -2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {-2, -4, -1, -1, -1, -1, -4, -2},
            {2, -2, 2, 2, 2, 2, -2, 2}};

    private static final int PESOS_FACIL[][]
            = {{-5, 3, -2, -2, -2, -2, 3, -5},
            {3, 4, 1, 1, 1, 1, 4, 3},
            {-2, 1, -1, 0, 0, -1, 1, -2},
            {-2, 1, 0, -1, -1, 0, 1, -2},
            {-2, 1, 0, -1, -1, 0, 1, -2},
            {-2, 1, -1, 0, 0, -1, 1, -2},
            {3, 4, 1, 1, 1, 1, 4, 3},
            {-5, 3, -2, -2, -2, -2, 3, -5}};

    enum Dificultad {
        FACIL, NORMAL, DIFICIL
    };

    private Dificultad opcion;
    private int depth;

    //Constructors
    IA(Casilla color, int numeroDeFichas) {
        super(color, numeroDeFichas);
        this.opcion = Dificultad.NORMAL;
        this.depth = 3;
    }

    IA(Dificultad op, Casilla color, int numeroDeFichas) {
        super(color, numeroDeFichas);
        this.opcion = op;
        switch (this.opcion) {
            case FACIL:
                this.depth = 2;
                break;
            case NORMAL:
                this.depth = 3;
                break;
            case DIFICIL:
                this.depth = 4;
                break;
            default:
                this.depth = 3;
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
     * fichas basándose en su dificultad.
     *
     * @param A Listado de posiciones para calcular el score total.
     * @return Score total.
     */
    public int obtenerScore(ArrayList<Pair> A) {
        int score = 0;
        for (Pair d : A) {
            if (this.opcion == Dificultad.FACIL) {
                score += PESOS_FACIL[d.first()][d.second()];
            } else if (this.opcion == Dificultad.NORMAL) {
                score += PESOS_NORMAL[d.first()][d.second()];
            } else if (this.opcion == Dificultad.DIFICIL) {
                score += PESOS_DIFICIL[d.first()][d.second()];
            }
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
        if (depth == 0 || (t.getSubTrees()).isEmpty()) {
            return t.getRoot();
        }

        if (maximizingPlayer) {
            Node maxEval = new Node(NEGATIVE_INFINITY);
            for (Tree<Node> child : t.getSubTrees()) {
                Node eval = alpha_beta(child, depth - 1, alpha, beta, false);
                maxEval = ((maxEval.getScore() > eval.getScore()) ? maxEval : eval);
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
                minEval = ((minEval.getScore() < eval.getScore()) ? minEval : eval);
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
        Node movimiento = alpha_beta(t, this.depth, NEGATIVE_INFINITY, POSITIVE_INFINITY, true);
        return movimiento.getCord();
    }
}
