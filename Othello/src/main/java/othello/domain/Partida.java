package othello.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import othello.data.Casilla;
import othello.data.Node;
import othello.data.Pair;
import othello.data.Tree;
import othello.domain.tablero.Tablero;

/**
 * Clase Partida que simula en un tablero determinado una partida de Othello
 * entre dos jugadores asignados.
 *
 * @author Aleix Velasco Calvo
 */
public class Partida implements Serializable {

    // Attributes
    public enum GameType {
        IAvsIA, PLAYERvsIA, PLAYERvsPLAYER
    };

    private GameType type;
    private Tablero t;
    private IA ia1;
    private IA ia2;
    private Jugador j1;
    private Jugador j2;
    private int turn;
    private Stack<String> logMoves;

        // Constructors
    /**
     * Constructor de partida por defecto
     */
    public Partida() {
        this.type = null;
        this.t = null;
        this.turn = 0;
        this.ia1 = null;
        this.ia2 = null;
        this.j1 = null;
        this.j2 = null;
        this.logMoves = new Stack<String>();
    }

    /**
     * Constructor de partida IA vs IA
     *
     * @param type
     * @param t
     * @param turno
     * @param player1
     * @param player2
     */
    public Partida(GameType type, Tablero t, int turno, IA player1, IA player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;
        this.logMoves = new Stack<String>();

        this.ia1 = player1;
        this.ia2 = player2;
        this.j1 = null;
        this.j2 = null;
        swapPlayersColors();
    }

    /**
     * Constructor de partida IA vs Jugador
     *
     * @param type
     * @param t
     * @param turno
     * @param player1
     * @param player2
     */
    public Partida(GameType type, Tablero t, int turno, IA player1, Jugador player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;
        this.logMoves = new Stack<String>();

        this.ia1 = player1;
        this.ia2 = null;
        this.j1 = null;
        this.j2 = player2;

        swapPlayersColors();
    }

    /**
     * Constructor de partida Jugador vs Jugador
     *
     * @param type
     * @param t
     * @param turno
     * @param player1
     * @param player2
     */
    public Partida(GameType type, Tablero t, int turno, Jugador player1, Jugador player2) {
        this.type = type;
        this.t = t;
        this.turn = turno;
        this.logMoves = new Stack<String>();

        this.ia1 = null;
        this.ia2 = null;
        this.j1 = player1;
        this.j2 = player2;
        swapPlayersColors();
    }

    /**
     * Método que sirve para asignar el color de ficha blanca a una IA antes de
     * empezar una partida de jugador vs IA
     */
    private void swapPlayersColors() {
        if (this.type == GameType.PLAYERvsPLAYER) {
            if (this.j1.getColor() == Casilla.BLANCA) {
                Jugador aux = this.j1;
                this.j1 = this.j2;
                this.j2 = aux;
            }
        }else if (this.type == GameType.PLAYERvsIA) {
            if (this.ia1.getColor() == Casilla.BLANCA) {
                this.ia2 = this.ia1;
                this.ia1 = null;
                this.j1 = this.j2;
                this.j2 = null;
            }
        }else if(this.type == GameType.IAvsIA) {
            if (this.ia1.getColor() == Casilla.BLANCA) {
                IA aux = this.ia1;
                this.ia1 = this.ia2;
                this.ia2 = aux;
            }
        }
    }

    // Getters and Setters
    public Tablero getT() {
        return t;
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

    public Jugador getJ1() {
        return j1;
    }

    public void setJ1(Jugador j1) {
        this.j1 = j1;
    }

    public int getTurn() {
        return turn;
    }

    public IA getIa1() {
        return ia1;
    }

    public IA getIa2() {
        return ia2;
    }

    public Jugador getJ2() {
        return j2;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Stack<String> getLogMoves() {
        return logMoves;
    }

    public void setLogMoves(Stack<String> logMoves) {
        this.logMoves = logMoves;
    }
    
    public void setAll(GameType type, Tablero t, int turno, IA ia1, IA ia2, Jugador j1, Jugador j2) {
        this.type = type;
        this.ia1 = ia1;
        this.ia2 = ia2;
        this.t = t;
        this.j1 = j1;
        this.j2 = j2;
        this.turn = turno;
    }

    /**
     * Función que verifica si la partida ha terminado
     *
     * @return true: partida terminada, false: partida
     */
    public boolean gameIsFinished() {
        if (t.getLegalMoves(Casilla.BLANCA).isEmpty() && t.getLegalMoves(Casilla.NEGRA).isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Método para actualizar las estadísticas de los jugadores una vez la
     * partida haya terminado
     */
    public void updateEstadisticas() {
        int b = t.getBlancas().size();
        int n = t.getNegras().size();
        if (this.type != GameType.IAvsIA) {
            if (b == n) {
                if (this.j1 != null) {
                    if (this.j1.getStats() != null) {
                        this.j1.updateStats(false, false, true);
                    }
                } else {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(false, false, true);
                    }
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(false, false, true);
                    }
                }

            } else if (b > n) {
                if (this.j1 != null) {
                    if (this.j1.getStats() != null) {
                        this.j1.updateStats(false, true, false);
                    }
                } else {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(true, false, false);
                    }
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(true, false, false);
                    }
                }
            } else if (b < n) {
                if (this.j1 != null) {
                    if (this.j1.getStats() != null) {
                        this.j1.updateStats(true, false, false);
                    }
                } else {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(false, true, false);
                    }
                }
                if (this.type == GameType.PLAYERvsPLAYER) {
                    if (this.j2.getStats() != null) {
                        this.j2.updateStats(false, true, false);
                    }
                }
            }
        }
    }

    /**
     * Función para obtener el nombre y color de los jugadores en una partida
     * @return players (texto)
     */
    public String getPlayers() {
        String ret = "";
        switch (this.type) {

            case IAvsIA:
                ret = "IA - Dificultad: " + this.ia1.getOpcion().toString() + ",IA - Dificultad: " + this.ia2.getOpcion().toString();
                ret+= "," + this.ia1.getColor().toString() + "," + this.ia2.getColor().toString();
                break;

            case PLAYERvsIA:
                if (this.j1 == null) {
                    if (j2.getStats() != null) {
                        ret = "IA - Dificultad: " + this.ia1.getOpcion().toString() + "," + this.j2.getStats().getId();
                        ret+= "," + this.ia1.getColor().toString() + "," + this.j2.getColor().toString();
                    } else {
                        ret = "IA - Dificultad: " + this.ia1.getOpcion().toString() + ",Guest";
                        ret+= "," + this.ia1.getColor().toString() + "," + this.j2.toString();
                    }
                } else {
                    if (j1.getStats() != null) {
                        ret = this.j1.getStats().getId() + ",IA - Dificultad: " + this.ia2.getOpcion().toString();
                        ret+= "," + this.j1.getColor().toString() + "," + this.ia2.getColor().toString();
                    } else {
                        ret = "Guest,IA - Dificultad: " + this.ia2.getOpcion().toString();
                        ret+= "," + this.j1.getColor().toString() + "," + this.ia2.getColor().toString();
                    }
                }
                break;

            default:
                if (j1.getStats() != null && j2.getStats() != null) {
                    ret = this.j1.getStats().getId() + "," + this.j2.getStats().getId();
                } else if (j1.getStats() != null) {
                    ret = this.j1.getStats().getId() + ",Guest";
                } else if (j2.getStats() != null) {
                    ret = "Guest," + this.j2.getStats().getId();
                }
                ret+= "," + this.j1.getColor().toString() + "," + this.j2.getColor().toString();
                break;
        }
        return ret;
    }

    /**
     * Función para obtener el turno actual durante una partida
     * @return turno(texto)
     */
    public String getPlayerTurn() {
        String ret = "";
        if (this.type == GameType.PLAYERvsIA) {

                if (this.turn % 2 == 0) { //Negro
                    if (this.j1 == null) {
                        ret = "IA";
                    } else {
                        ret = "JUGADOR";
                    }
                } else {//Blanco
                    if (this.j2 == null) {
                        ret = "IA";
                    } else {
                        ret = "JUGADOR";
                    }
                }
        }
        return ret;
    }
    
    /**
     * Método para obtener el color del turno en la partida
     * @return color de turno(texto)
     */
    public String getColorTurn() {
        String ret = "";
        switch (this.type) {

            case IAvsIA:
                if (this.turn % 2 == 0) {
                    ret = this.ia1.getColor().toString();
                } else {
                    ret = this.ia2.getColor().toString();
                }
                break;

            case PLAYERvsIA:
                if (this.turn % 2 == 0) {
                    if (this.j1 == null) {
                        ret = this.ia1.getColor().toString();
                    } else {
                        ret = this.j1.getColor().toString();
                    }
                } else {
                    if (this.j2 == null) {
                        ret = this.ia2.getColor().toString();
                    } else {
                        ret = this.j2.getColor().toString();
                    }
                }
                break;

            default:
                if (this.turn % 2 == 0) {
                    ret = this.j1.getColor().toString();
                } else {
                    ret = this.j2.getColor().toString();
                }
                break;
        }
        return ret;
    }

    /**
     * Función que realiza el movimiento de un jugador en una posicion "coord"
     *
     * @param coord
     * @return 0:no tiene movimientos, 1:jugada realizada, 2:jugada ilegal
     */
    public int move(Pair coord) {
        int b = -1;
        switch (this.type) {

            case IAvsIA:
                if (this.turn % 2 == 0) {

                    if (!t.getLegalMoves(this.ia1.getColor()).isEmpty() && ia1.getNumeroDeFichas() > 0) {
                        if (iaMove(this.ia1)) {
                            ia1.decreaseFichas();
                            b = 1;
                        }
                    } else {
                        System.out.println(this.ia1.getColor() + "has no moves!");
                    }
                } else {

                    if (!t.getLegalMoves(this.ia2.getColor()).isEmpty() && ia2.getNumeroDeFichas() > 0) {
                        if (iaMove(this.ia2)) {
                            ia2.decreaseFichas();
                            b = 1;
                        }
                    } else {
                        System.out.println(this.ia2.getColor() + "has no moves!");
                    }
                }
                break;

            case PLAYERvsIA:
                if (this.turn % 2 == 0) {
                    if (this.j1 == null) {

                        if (!t.getLegalMoves(this.ia1.getColor()).isEmpty() && ia1.getNumeroDeFichas() > 0) {
                            if (iaMove(this.ia1)) {
                                ia1.decreaseFichas();
                                b = 1;
                            }
                        } else {
                            System.out.println(this.ia1.getColor() + "has no moves!");
                        }
                    } else {

                        if (!t.getLegalMoves(this.j1.getColor()).isEmpty() && j1.getNumeroDeFichas() > 0) {
                            if (!t.commitPlay(coord, this.j1.getColor()).isEmpty()) {
                                logMoves.push(String.valueOf(coord.first())+";"+String.valueOf(coord.second()));
                                j1.decreaseFichas();
                                b = 1;
                            } else {
                                b = 0;
                            }
                        } else {
                            System.out.println(this.j1.getColor() + "has no moves!");
                        }
                    }
                } else {

                    if (this.j2 == null) {

                        if (!t.getLegalMoves(this.ia2.getColor()).isEmpty() && ia2.getNumeroDeFichas() > 0) {
                            if (iaMove(this.ia2)) {
                                ia2.decreaseFichas();
                                b = 1;
                            }
                        } else {
                            System.out.println(this.ia2.getColor() + "has no moves!");
                        }
                    } else {

                        if (!t.getLegalMoves(this.j2.getColor()).isEmpty() && j2.getNumeroDeFichas() > 0) {
                            if (!t.commitPlay(coord, this.j2.getColor()).isEmpty()) {
                                logMoves.push(String.valueOf(coord.first())+";"+String.valueOf(coord.second()));
                                j2.decreaseFichas();
                                b = 1;
                            } else {
                                b = 0;
                            }
                        } else {
                            System.out.println(this.j2.getColor() + "has no moves!");
                        }
                    }
                }
                break;

            default:
                if (this.turn % 2 == 0) {

                    if (!t.getLegalMoves(this.j1.getColor()).isEmpty() && j2.getNumeroDeFichas() > 0) {
                        if (!t.commitPlay(coord, this.j1.getColor()).isEmpty() && j1.getNumeroDeFichas() > 0) {
                            logMoves.push(String.valueOf(coord.first())+";"+String.valueOf(coord.second()));
                            j1.decreaseFichas();
                            b = 1;
                        } else {
                            b = 0;
                        }
                    } else {
                        System.out.println(this.j1.getColor() + "has no moves!");
                    }
                } else {

                    if (!t.getLegalMoves(this.j2.getColor()).isEmpty() && j2.getNumeroDeFichas() > 0) {
                        if (!t.commitPlay(coord, this.j2.getColor()).isEmpty()) {
                            logMoves.push(String.valueOf(coord.first())+";"+String.valueOf(coord.second()));
                            j2.decreaseFichas();
                            b = 1;
                        } else {
                            b = 0;
                        }
                    } else {
                        System.out.println(this.j2.getColor() + "has no moves!");
                    }
                }
                break;
        }
        if (b != 0) {
            this.turn++;
        }
        return b;
    }

    /**
     * Función para realizar el movimiento de una IA
     *
     * @param ia
     * @return true: movimiento realizado, false:no existe movimientos
     */
    private boolean iaMove(IA ia) {
        
        Tree jugadas = createTree(t, ia);
        Pair c = ia.escogerMovimiento(jugadas, ia);
        if(!(t.commitPlay(c, ia.getColor()).isEmpty())) {
            logMoves.push(String.valueOf(c.first())+";"+String.valueOf(c.second()));
            return true;
        }
        else return false;
    }

    /**
     * Método que crea el árbol de posibles jugadas que será evaluada por la IA
     *
     * @param tree
     * @param depth
     * @param tablero
     * @param player
     * @param color
     */
    private static void createTree_rec(Tree tree, int depth, Tablero tablero, IA player, Casilla color) {
        if (depth >= 0) {
            ArrayList<Pair> legalMoves = tablero.getLegalMoves(color);
            for (Pair p : legalMoves) {
                Tablero tDeepCopy = tablero.DeepCopy();
                ArrayList<Pair> pa = tDeepCopy.commitPlay(p, color);

                Tree tr;
                int score = player.obtenerScore(pa);
                tr = tree.addLeaf(new Node(p, color, score));
                createTree_rec(tr, depth - 1, tDeepCopy, player, color.contrary());

            }
        }
    }
    
    /**
     * Método para obtener el número de fichas de cada jugador de una partida
     * @return res[2]: res[0]->nºfichas jugador1
     *                 res[1]->,ºfichas jugador2
     */
    public int[] getFichas() {
        int[] res = new int[2];
        switch (this.type) {

            case IAvsIA:
                res[0] = ia1.getNumeroDeFichas();
                res[1] = ia2.getNumeroDeFichas();
                break;

            case PLAYERvsIA:
                if (this.j1 == null) {
                    res[0] = ia1.getNumeroDeFichas();
                    res[1] = j2.getNumeroDeFichas();
                } else {
                    res[0] = j1.getNumeroDeFichas();
                    res[1] = ia2.getNumeroDeFichas();
                }
                break;

            default:
               res[0] = j1.getNumeroDeFichas();
               res[1] = j2.getNumeroDeFichas();
               break;
        }
        return res;
    }
    
    /**
     * Función que busca un movimiento para la IA
     *
     * @param tablero
     * @param ia
     * @return movimiento de IA
     */
    public Tree createTree(Tablero tablero, IA ia) {
        Tree jugadas = new Tree(new Node());
        createTree_rec(jugadas, ia.getDepth(), tablero, ia, ia.getColor());
        return jugadas;
    }
    
    public boolean isIABlack_in_PvsIA() {
        if(type == GameType.PLAYERvsIA) {
            if(j1 == null) return true;
        }
        return false;
    }
}
