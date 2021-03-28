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
import othello.domain.Estadistica;

public class Jugador extends GameState{
    
    //Attributes
    private ArrayList<int[]> Fitxes;
    private int TempsInvertit;
    private Estadistica stats;
    
    //Constructors
    public Jugador() {
        Fitxes = new ArrayList<int[]>(0);
        TempsInvertit = 0;
        stats = new Estadistica ();
    }
     public Jugador(ArrayList<int[]> F, int T, Estadistica E) {
        Fitxes = F;
        TempsInvertit = T;
        stats = E;
    }
    //Setters
     
     public void SetFitxes (ArrayList<int[]> F) {
         Fitxes = F;
     }
     public void SetTemps (int T) {
         TempsInvertit = T;
     }
     public void SetStats (Estadistica E) {
         stats = E;
     }
    
   
    @Override
    public void FerJugada(){ //implementa les normes del joc
        //STUFF
    }
    
     //Getters
    @Override
    public int Temps(){ //retorna temps invertit pel jugador
        return TempsInvertit;
    }
    @Override
    public int Nfitxes(){ //retorna el nombre de fitxes del jugador al taulell
        return Fitxes.size();
    }
    @Override
    public ArrayList<int[]> FitxesJugador(){ //retorna una llista de les posicions de les fitxes
        return Fitxes;
    }
    public Estadistica Estadistiques() {
        return stats;
    }
    
 
}
