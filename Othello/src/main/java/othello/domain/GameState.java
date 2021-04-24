
package othello.domain;

import java.io.Serializable;
import othello.data.Casilla;
import othello.data.Node;
import othello.data.Tree;

/**
 *
 * @author Aleix
 */
public abstract class GameState implements GameStateInterface, Serializable{
    
    private int FitxesRestants;
    private Casilla color;

    public Casilla getColor() {
        return color;
    }

    public void setColor(Casilla color) {
        this.color = color;
    }

    @Override
    public Node elegir_movimiento(Tree<Node> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public int Nfitxes() {
        return FitxesRestants;
    }
}
