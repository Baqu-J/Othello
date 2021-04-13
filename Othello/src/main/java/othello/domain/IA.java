
package othello.domain;
import othello.data.Pair;
import othello.data.Node;
import othello.data.Tree;

enum dificultad{FACIL, NORMAL, DIFICIL};

/**/
public class IA extends GameState {
    
     private dificultad opcion;

    public void setOpcion(dificultad opcion) {
        this.opcion = opcion;
    }
     
     IA(){
         opcion = dificultad.NORMAL;
     }
     
     IA(dificultad op){
         opcion = op;
     }
     
    public dificultad getDificultad(){
         return dificultad.FACIL;
    }

    /*private Pair alpha_beta(Node id, int profundidad, int alpha, int beta, boolean maximizing_player ){
        if (profundidad == 0) return id.getCord();
 
	if (maximizing_player){
		int maxEval = -(int)Double.POSITIVE_INFINITY;
                ArrayList<Node> hijos_aux1 = id.getHijos(); // corregir
                for( Node d : hijos_aux1 ){
                    int eval = alpha_beta(d,profundidad-1,alpha,beta,false);
                    maxEval = Math.max(maxEval,eval);
                    alpha = Math.max(alpha,eval);
                    if(beta <= alpha) break;
                }      
		return maxEval;
        }
        else{
		int minEval = (int)Double.POSITIVE_INFINITY;
		ArrayList<Node> hijos_aux2 = id.getHijos(); // corregir
                for( Node d : hijos_aux2 ){
                    int eval = alpha_beta(d,profundidad-1,alpha,beta,true);
                    minEval = Math.min(minEval,eval);
                    alpha = Math.min(beta,eval);
                    if(beta <= alpha) break;
                }      
                return minEval;
        }
    }*/
    
    Node alpha_beta(Tree<Node> t, int depth, int alpha, int beta, boolean maximizingPlayer) {
        if(depth == 0 || (t.getSubTrees()).isEmpty())
            return t.getRoot();

        if(maximizingPlayer) {
            Node maxEval = new Node(-1000);
            for(Tree<Node> child : t.getSubTrees()) {
                Node eval = alpha_beta(child, depth - 1, alpha, beta, false);
                maxEval = ((maxEval.getScore() > eval.getScore()) ? maxEval : eval);
                alpha = ((alpha > eval.getScore()) ? alpha : eval.getScore());
                if(beta <= alpha)   break;
            }
            return maxEval;
        }else {
            Node minEval = new Node(+1000);
            for(Tree<Node> child : t.getSubTrees()) {
                Node eval = alpha_beta(child, depth - 1, alpha, beta, true);
                minEval = ((minEval.getScore() < eval.getScore()) ? minEval : eval);
                beta = ((beta < eval.getScore()) ? beta : eval.getScore());
                if(beta <= alpha)   break;
            }
            return minEval;
        }
    }
    
    public Node elegir_movimiento(Node raiz){
        Node movimiento = null;
        
        return movimiento;
    }

}
