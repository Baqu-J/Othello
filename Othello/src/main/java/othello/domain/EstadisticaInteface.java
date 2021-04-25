package othello.domain;

/**
 *
 * @author Aleix Velasco Calvo
 */
public interface EstadisticaInteface {

    /**
     * incrementa la variable victories + 1
     */
    void incVictories();

    /**
     * incrementa la variable derrotes + 1
     */
    void incDerrotes();

    /**
     * incrementa la variable empat + 1
     */
    void incEmpat();
}
