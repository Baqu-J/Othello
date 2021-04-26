package othello.data;

/**
 *
 * @author Foster
 */
public enum Casilla {

    VACIA, BLANCA, NEGRA;

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
