/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Foster
 */
package othello.domain;
import java.util.ArrayList;
import othello.data.Node;
import othello.data.Tree;

public interface GameStateInterface {
    public Node elegir_movimiento(Tree<Node> t); //elige movimiento
    public int Temps(); //retorna temps invertit pel jugador
    public int Nfitxes(); //retorna el nombre de fitxes del jugador al taulell
    //...
}
