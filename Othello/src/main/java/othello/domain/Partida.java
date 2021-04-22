package othello.domain;

import java.util.ArrayList;
import othello.data.Casilla;
import othello.data.Node;
import othello.data.Pair;
import othello.data.Tree;
import othello.domain.tablero.Tablero;

/**
 *
 * @author
 */
public class Partida {

    private static final int PESOS_HARD[][]
            = {{4, -3, 2, 2, 2, 2, -3, 4},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {4, -3, 2, 2, 2, 2, -3, 4}};

    private static final int PESOS_NORMAL[][]
            = {{4, -3, 2, 2, 2, 2, -3, 4},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {4, -3, 2, 2, 2, 2, -3, 4}};

    private static final int PESOS_EASY[][]
            = {{4, -3, 2, 2, 2, 2, -3, 4},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 0, 1, 1, 0, -1, 2},
            {2, -1, 1, 0, 0, 1, -1, 2},
            {-3, -4, -1, -1, -1, -1, -4, -3},
            {4, -3, 2, 2, 2, 2, -3, 4}};

    private Tablero t;

    private static void createTree_rec(Tree tree, int depth, Tablero tablero, Casilla player) {
        if (depth != 0) {
            ArrayList<Pair> legalMoves = tablero.getLegalMoves(player);
            for(Pair p : legalMoves) {
                Tablero tDeepCopy = tablero.DeepCopy();
                ArrayList<Pair> pa = tDeepCopy.commitPlay(p, player);
                int score = 0;
                for (Pair coord : pa) {
                    score += PESOS_EASY[coord.first()][coord.second()];
                }

                Tree tr = tree.addLeaf(new Node(p, player, score));
                createTree_rec(tr, depth - 1, tDeepCopy, player.contrary());

            }
        }
    }
    
    
    Tree createTree(int depth, Tablero tablero, Casilla player) {
        Tree jugadas = new Tree(new Node());
        createTree_rec(jugadas, depth, tablero, player);
        return jugadas;
    }
}
