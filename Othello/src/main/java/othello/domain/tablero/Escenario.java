/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain.tablero;

import othello.data.Pair;

/**
 *
 * @author Foster
 */
public class Escenario extends Tablero {
    
    public void Erase(Pair p) {
        if(matrix.get(p.first()).get(p.second()) != Casilla.VACIA) {
            matrix.get(p.first()).set(p.second(), Casilla.VACIA);
        }
    }
    
}
