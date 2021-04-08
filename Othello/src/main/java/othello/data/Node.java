package othello.data;

/**
 * A Node of a Tree for Minimax
 * 
 * @author Aleix Velasco Calvo
 */
public class Node {
    
    // Attributes
    private Pair cord;
    private Casilla player;
    private int score;

    // Constructors
    public Node() {
        this.cord = new Pair(-1,-1);
        this.player = Casilla.VACIA;
        this.score = 0;
    }
    
    public Node(int score) {
        this.cord = new Pair(-1,-1);
        this.player = Casilla.VACIA;
        this.score = score;
    }
    
    public Node(Pair p, Casilla player) {
        this.cord = p;
        this.player = player;
        this.score = 0;
    }

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
}