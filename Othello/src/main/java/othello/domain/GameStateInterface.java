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

public interface GameStateInterface {
    public void FerJugada(); //implementa les normes del joc
    public int Temps(); //retorna temps invertit pel jugador
    public int Nfitxes(); //retorna el nombre de fitxes del jugador al taulell
    public ArrayList FitxesJugador(); //retorna una llista de les posicions de les fitxes
    //...
}
