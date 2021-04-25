/**
 *
 * @author Foster
 */
package othello.domain;

import java.util.ArrayList;
import othello.data.Node;
import othello.data.Tree;
import othello.domain.Estadistica;

public class Jugador extends GameState {

    //Attributes
    private int Fitxes;
    private Estadistica stats;

    //Constructors
    public Jugador() { //Para usuarios GUEST
        Fitxes = 0;
    }

    public Jugador(String id1) {
        Fitxes = 0;
        stats = new Estadistica(id1);
    }

    public Jugador(int F, Estadistica E) {
        Fitxes = F;
        stats = E;
    }

    // Getters and Setters
    public void SetFitxes(int F) {
        Fitxes = F;
    }

    public void SetStats(Estadistica E) {
        stats = E;
    }

    @Override
    public int Nfitxes() { //retorna el nombre de fitxes del jugador al taulell
        return Fitxes;
    }

    public Estadistica Estadistiques() {
        return stats;
    }

    @Override
    public Node elegir_movimiento(Tree<Node> t) {
        return null;
    }
}
