package othello.domain;

import java.util.ArrayList;
import othello.data.Pair;
import othello.data.Node;
import othello.data.Tree;

enum dificultad {
    FACIL, NORMAL, DIFICIL
};

/**/
public class IA extends GameState {

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

    private dificultad opcion;
    private int depth;

    public void setOpcion(dificultad opcion) {
        this.opcion = opcion;
    }

    IA() {
        opcion = dificultad.NORMAL;
        this.depth = 3;
    }

    IA(dificultad op) {
        opcion = op;
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

    public dificultad getDificultad() {
        return this.opcion;
    }

    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    //Recibo las posiciones de las fichas y calculo su heuristica
    //en base a su dificultad
    public int obtener_score(ArrayList<Pair> A) {
        int score = 0;
        for (Pair d : A) {
            if (this.opcion == dificultad.FACIL) {
                score += PESOS_FACIL[d.first()][d.second()];
            } else if (this.opcion == dificultad.NORMAL) {
                score += PESOS_NORMAL[d.first()][d.second()];
            } else if (this.opcion == dificultad.DIFICIL) {
                score += PESOS_DIFICIL[d.first()][d.second()];
            }
        }
        return score;
    }

    Node alpha_beta(Tree<Node> t, int depth, int alpha, int beta, boolean maximizingPlayer) {
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

    public Pair escogerMovimiento(Tree<Node> t) {
        Node movimiento = alpha_beta(t, this.depth, NEGATIVE_INFINITY, POSITIVE_INFINITY, true);
        return movimiento.getCord();
    }

}
