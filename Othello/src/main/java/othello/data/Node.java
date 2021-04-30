package othello.data;

/**
 * Un nodo de un árbol para Minimax
 * 
 * @author Franco Acevedo Montañez
 */
public class Node {
    
    // Attributes
    private Pair cord;
    private Casilla player;
    private int score;

    // Constructors
    /**
     * Constructor por defecto
     */
    public Node() {
        this.cord = new Pair(-1,-1);
        this.player = Casilla.VACIA;
        this.score = 0;
    }
    
    /**
     * Constructor con score asignado
     * @param score 
     */
    public Node(int score) {
        this.cord = new Pair(-1,-1);
        this.player = Casilla.VACIA;
        this.score = score;
    }
    
    /**
     * Constructor con pair y color asignados
     * @param p
     * @param player 
     */
    public Node(Pair p, Casilla player) {
        this.cord = p;
        this.player = player;
        this.score = 0;
    }

    /**
     * Constructor con pair, color y score asignados
     * @param p
     * @param player
     * @param score 
     */
    public Node(Pair p, Casilla player, int score) {
        this.cord = p;
        this.player = player;
        this.score = score;
    }

    // Getters and Setters
    public Pair getCord() {
        return cord;
    }
    
    public void setCord(Pair p) {
        this.cord = p;
    }
    
    public int getX() {
        return cord.first();
    }

    public void setX(int x) {
        this.cord.setFirst(x);
    }

    public int getY() {
        return this.cord.second();
    }

    public void setY(int y) {
        this.cord.setSecond(y);
    }

    public Casilla getPlayer() {
        return player;
    }

    public void setPlayer(Casilla player) {
        this.player = player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }   

    @Override
    public String toString() {
        return "Node{" + "cord=" + cord + ", player=" + player + ", score=" + score + '}';
    }
    
    
}