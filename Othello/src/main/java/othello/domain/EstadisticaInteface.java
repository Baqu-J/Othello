package othello.domain;

/**
 *
 * @author Aleix Velasco Calvo
 */
public interface EstadisticaInteface {

    /**
     * incrementa la variable victories
     */
    void incVictories();

    /**
     * incrementa la variable derrotes
     */
    void incDerrotes();

    /**
     * incrementa la variable empat
     */
    void incEmpat();

    /*
     @return 
     */
    public int getPunts();
}
