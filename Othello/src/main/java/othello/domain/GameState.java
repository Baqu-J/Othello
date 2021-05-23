package othello.domain;

import java.io.Serializable;
import othello.data.Casilla;

/**
 * Clase abstracta GameState que será utilizada en la simulación de
 * la partida.
 * 
 * @author Franco Acevedo Montañez
 */
public abstract class GameState implements Serializable{
    
    // Attributes
    private Casilla color;
    protected int numeroDeFichas;

    // Constructors
    /**
     * Constructor asignándole numero de fichas y color
     * @param color
     * @param numeroDeFichas 
     */
    public GameState(Casilla color, int numeroDeFichas) {
        this.color = color;
        this.numeroDeFichas = numeroDeFichas;
    }

    /**
     * Constructor por defecto asignándole color
     * @param color 
     */
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
    /**
     * Método que decrementa el numero actual de fichas
     */
    public void decreaseFichas() {
        --numeroDeFichas;
    }
}