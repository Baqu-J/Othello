
package othello.domain;
import othello.data.Pair;
import java.util.ArrayList;

enum dificultad{FACIL, NORMAL, DIFICIL};


public class IA extends GameState {
    
     private final dificultad opcion;
     
     IA(){
         opcion = dificultad.NORMAL;
     }
     
     IA(dificultad op){
         opcion = op;
     }
     
    /**
     *
     * @return
     */
    public dificultad getDificultad(){
         return opcion;
    }
    
    private void funcionFacil(Tablero tab) {};

    private void funcionNormal(Tablero tab) {};

    private void funcionDificil(Tablero tab) { };
    
   
    public void realizar_jugada(Tablero tab){
        switch(opcion) {
            case FACIL:
                funcionFacil(tab);
            break;

            case NORMAL:
                funcionNormal(tab);
            break;

            case DIFICIL:
                funcionDificil(tab);
            break;
            
            default: break;
        }
    }

    
    
    Pair minimax(Tablero tab) {
        
        return new Pair(3, 3);
    }
    
    int min() {
        return 0;
    }
    
    
}
