package othello.data;

/**
 * Enumeration Class
 * @author Jaume Baqueró Quesada
 */
public enum Casilla {

    VACIA, BLANCA, NEGRA;

    /**
     * Retorna el color de casilla contraria.
     * @return Casilla
     */
    public Casilla contrary() {
        switch (this) {
            case BLANCA:
                return NEGRA;
            case NEGRA:
                return BLANCA;
            default:
                return VACIA;
        }
    }
}
