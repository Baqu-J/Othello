
package othello.domain;
import othello.domain.tablero.Tablero;
import othello.data.Pair;
import java.util.ArrayList;
import othello.data.Nodo;

enum dificultad{FACIL, NORMAL, DIFICIL};

/**/
public class IA extends GameState {
    
     private final dificultad opcion;
     
     IA(){
         opcion = dificultad.NORMAL;
     }
     
     IA(dificultad op){
         opcion = op;
     }
     
    public dificultad getDificultad(){
         return dificultad.FACIL;
    }

    /*
    private void funcionFacil(Tablero tab) {};

    private void funcionNormal(Tablero tab) {};

    private void funcionDificil(Tablero tab) { };
    
    
    */
    
    private int alpha_beta(Nodo id, int profundidad, int alpha, int beta, boolean maximizing_player ){
        if (profundidad == 0) return id.calcularScore();
 
	if (maximizing_player){
		int maxEval = -(int)Double.POSITIVE_INFINITY;
                ArrayList<Nodo> hijos_aux1 = id.getHijos(); // corregir
                for( Nodo d : hijos_aux1 ){
                    int eval = alpha_beta(d,profundidad-1,alpha,beta,false);
                    maxEval = Math.max(maxEval,eval);
                    alpha = Math.max(alpha,eval);
                    if(beta <= alpha) break;
                }      
		return maxEval;
        }
        else{
		int minEval = (int)Double.POSITIVE_INFINITY;
		ArrayList<Nodo> hijos_aux2 = id.getHijos(); // corregir
                for( Nodo d : hijos_aux2 ){
                    int eval = alpha_beta(d,profundidad-1,alpha,beta,true);
                    minEval = Math.min(minEval,eval);
                    alpha = Math.min(beta,eval);
                    if(beta <= alpha) break;
                }      
                return minEval;
        }
    }
    
    public void realizar_jugada(Nodo raiz){
        switch(opcion) {
            case FACIL:
                /*alpha_beta();*/
            break;

            case NORMAL:
                /*alpha_beta();*/
            break;

            case DIFICIL:
                double inf = Double.POSITIVE_INFINITY;
                int aux = alpha_beta(raiz,3,(int)-inf,(int)inf,true);
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
