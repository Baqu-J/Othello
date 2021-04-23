
package othello.domain;

import java.io.Serializable;
import othello.data.Node;
import othello.data.Tree;

/**
 *
 * @author Aleix
 */
public abstract class GameState implements GameStateInterface, Serializable{
    
    private int FitxesRestants;

    @Override
    public Node elegir_movimiento(Tree<Node> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public int Nfitxes() {
        return FitxesRestants;
    }
}
