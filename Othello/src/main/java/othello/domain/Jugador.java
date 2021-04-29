package othello.domain;

import othello.data.Casilla;

/**
 * Clase Jugador que hereda de GameState y contiene las estadísticas del Jugador
 * junto a métodos de actualización de dichas estadísticas.
 *
 * @author Franco Acevedo Montañez
 */
public class Jugador extends GameState {

    //Attributes
    private Estadistica stats;

    //Constructors
    /**
     * Constructor por defecto - usuarios GUEST"
     * @param color 
     */
    public Jugador(Casilla color) {
        super(color);
        this.stats = null;
    }

    /**
     * Constructor de jugador asignando stats(estadistica) y color
     * @param s
     * @param color 
     */
    public Jugador(Estadistica s, Casilla color) {
        super(color);
        this.stats = s;
    }

    // Getters and Setters
    public Estadistica getStats() {
        return stats;
    }

    public void setStats(Estadistica stats) {
        this.stats = stats;
    }

    // Other Methods
    /**
     * Método que actualiza las estadísticas del jugador
     *
     * @param victoria booleano que indica si ha ganado o no
     * @param derrota booleano que indica si ha perdido o no
     * @param empate booleano que indica si ha quedado empate o no
     */
    public void updateStats(boolean victoria, boolean derrota, boolean empate) {
        if (victoria) {
            stats.incVictorias();
        } else if (derrota) {
            stats.incDerrotas();
        } else if (empate) {
            stats.incEmpates();
        }
    }
}
