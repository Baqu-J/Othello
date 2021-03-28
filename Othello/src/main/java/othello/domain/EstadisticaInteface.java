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
    
    /**
     * incrementa la variable punts
     * @param p punts a incrementar
     */
    void incPunts(int p);
}
