package othello.domain;

import java.io.Serializable;
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
public class Partida implements Serializable {

    // Attributes
    enum GameType {
        IAvsIA, PLAYERvsIA, PLAYERvsPLAYER
    };

    private GameType type;
    private Tablero t;
    private IA ia1;
    private IA ia2;
    private Jugador j1;
    private Jugador j2;
    private int turn;

    private Pair coord;

    // Constructors
    public Partida(GameType type, Tablero t, int turno, IA player1, IA player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;

        this.ia1 = player1;
        this.ia2 = player2;
        this.j1 = null;
        this.j2 = null;
    }

    public Partida(GameType type, Tablero t, int turno, IA player1, Jugador player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;

        this.ia1 = player1;
        this.ia2 = null;
        this.j1 = null;
        this.j2 = player2;

        swapPlayersColors();
    }

    public Partida(GameType type, Tablero t, int turno, Jugador player1, Jugador player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;

        this.ia1 = null;
        this.ia2 = null;
        this.j1 = player1;
        this.j2 = player2;
    }

    private void swapPlayersColors() {
        if (this.type == GameType.PLAYERvsIA) {
            if (this.ia1.getColor() == Casilla.BLANCA) {
                this.ia2 = this.ia1;
                this.ia1 = null;
                this.j1 = this.j2;
                this.j2 = null;
            }
        }
    }

    // Getters and Setters
    public Casilla[][] getT() {
        return t.getMatrix();
    }

    public void setT(Tablero t) {
        this.t = t;
    }

    public GameType getType() {
        return type;
    }

    public void setType(GameType type) {
        this.type = type;
    }

    public Pair getCoord() {
        return coord;
    }

    public void setCoord(Pair coord) {
        this.coord = coord;
    }

    // Other Methods
    public void playGame() {
        boolean negrasHasMoves = true;
        boolean blancasHasMoves = true;
        do {
            move();
            if (t.getLegalMoves(Casilla.NEGRA).isEmpty()) {
                negrasHasMoves = false;
            }
            if (t.getLegalMoves(Casilla.BLANCA).isEmpty()) {
                blancasHasMoves = false;
            }
        } while (negrasHasMoves || blancasHasMoves);

        updateEstadisticas();
    }

    private void updateEstadisticas() {
        int b = t.getBlancas().size();
        int n = t.getNegras().size();
        if (this.type != GameType.IAvsIA) {

            if (b == n) {

                if (this.j1 != null) {
                    this.j1.updateStats(false, false, true);
                } else {
                    this.j2.updateStats(false, false, true);
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    this.j2.updateStats(false, false, true);
                }

            } else if (b > n) {
                if (this.j1 != null) {
                    this.j1.updateStats(false, true, false);
                } else {
                    this.j2.updateStats(true, false, false);
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    this.j2.updateStats(true, false, false);
                }
            } else if (b < n) {
                if (this.j1 != null) {

                    this.j1.updateStats(true, false, false);
                } else {
                    this.j2.updateStats(false, true, false);
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    this.j2.updateStats(false, true, false);
                }
            }
        }
    }

    public void move() {
        switch (this.type) {

            case IAvsIA:
                if (this.turn % 2 == 0) {
                    iaMove(this.ia1);
                } else {
                    iaMove(this.ia2);
                }
                break;

            case PLAYERvsIA:
                if (this.turn % 2 == 0) {
                    if (this.j1 == null) {
                        iaMove(this.ia1);
                    } else {
                        t.commitPlay(coord, this.j1.getColor());
                    }
                } else {
                    if (this.j2 == null) {
                        iaMove(this.ia2);
                    } else {
                        t.commitPlay(coord, this.j2.getColor());
                    }
                }
                break;

            case PLAYERvsPLAYER:
                if (this.turn % 2 == 0) {
                    t.commitPlay(coord, this.j1.getColor());
                } else {
                    t.commitPlay(coord, this.j2.getColor());
                }
                break;

            default:
                break;
        }
        this.turn++;
    }

    private void iaMove(IA ia) {
        Tree jugadas = createTree(t, ia);
        Pair c = ia.escogerMovimiento(jugadas);
        t.commitPlay(c, ia.getColor());
    }

    private static void createTree_rec(Tree tree, int depth, Tablero tablero, IA player, Casilla color) {
        if (depth >= 0) {
            ArrayList<Pair> legalMoves = tablero.getLegalMoves(color);
            for (Pair p : legalMoves) {
                Tablero tDeepCopy = tablero.DeepCopy();
                ArrayList<Pair> pa = tDeepCopy.commitPlay(p, color);

                Tree tr;
                if (depth == 0) {
                    int score = player.obtener_score(pa);
                    tr = tree.addLeaf(new Node(p, color, score));
                } else {
                    tr = tree.addLeaf(new Node(p, color, -1));
                }
                createTree_rec(tr, depth - 1, tDeepCopy, player, color.contrary());

            }
        }
    }

    Tree createTree(Tablero tablero, IA ia) {
        Tree jugadas = new Tree(new Node());
        createTree_rec(jugadas, ia.getDepth(), tablero, ia, ia.getColor());
        return jugadas;
    }
}
