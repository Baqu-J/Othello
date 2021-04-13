
package othello.domain;

import othello.data.Node;
import othello.data.Tree;

/**
 *
 * @author Aleix
 */
public abstract class GameState implements GameStateInterface{
    
    private int FitxesRestants;
    private int TempsInvertit;

    @Override
    public Node elegir_movimiento(Tree<Node> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public int Temps() {
        return TempsInvertit;
    }
    
    @Override
    public int Nfitxes() {
        return FitxesRestants;
    }
}
