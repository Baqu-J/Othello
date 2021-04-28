package othello.domain;

import java.io.Serializable;
import othello.data.Casilla;

/**
 *
 * @author 
 */
public abstract class GameState implements Serializable{
    
    // Attributes
    private Casilla color;
    private int numeroDeFichas;

    // Constructors
    public GameState(Casilla color, int numeroDeFichas) {
        this.color = color;
        this.numeroDeFichas = numeroDeFichas;
    }

    public GameState(Casilla color) {
        this.color = color;
        this.numeroDeFichas = 32;
    }
    
    // Getters and Setters
    public Casilla getColor() {
        return this.color;
    }

    public int getNumeroDeFichas() {
        return this.numeroDeFichas;
    }
    
    public void setNumeroDeFitxes(int numeroDeFichas) {
        this.numeroDeFichas = numeroDeFichas;
    }
    
    public void setColor(Casilla color) {
        this.color = color;
    }

    // Other Methods
}