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
import othello.domain.Estadistica;

public class Jugador extends GameState{
    
    //Attributes
    private static String id;
    private int Fitxes;
    private Estadistica stats;

    
    //Constructors
    public Jugador() { //Para usuarios GUEST
        Fitxes = 0;
    }
    
    public Jugador(String id1){
        this.id = id1;
        Fitxes = 0;
        stats = new Estadistica ();
    }
    
    public Jugador(String id1, int F, Estadistica E) {
        this.id = id1;
        Fitxes = F;
        stats = E;
    }
    

    //Setters
     public void SetFitxes (int F) {
         Fitxes = F;
     }

     public void SetStats (Estadistica E) {
         stats = E;
     }

     public void setId(String id) {
        this.id = id;
    }
   
    
     //Getters

    @Override
    public int Nfitxes(){ //retorna el nombre de fitxes del jugador al taulell
        return Fitxes;
    }
    public Estadistica Estadistiques() {
        return stats;
    }

    public static String getId() {
        return id;
    }

    
    @Override
    public Node elegir_movimiento(Tree<Node> t){
        return null;
    }

    
}
