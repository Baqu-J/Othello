
package othello.domain;
import java.util.ArrayList;
import othello.data.Pair;
import othello.data.Node;
import othello.data.Tree;

enum dificultad{FACIL, NORMAL, DIFICIL};

/**/
public class IA extends GameState {
    
    private static final int PESOS_DIFICIL[][]
            = {{ 5,-3, 2, 2, 2, 2,-3, 5},
               {-3,-4,-1,-1,-1,-1,-4,-3},
               { 2,-1, 1, 0, 0, 1,-1, 2},
               { 2,-1, 0, 1, 1, 0,-1, 2},
               { 2,-1, 0, 1, 1, 0,-1, 2},
               { 2,-1, 1, 0, 0, 1,-1, 2},
               {-3,-4,-1,-1,-1,-1,-4,-3},
               { 5,-3, 2, 2, 2, 2,-3, 5}};

    private static final int PESOS_NORMAL[][]
            = {{ 2, -2, 2, 2, 2, 2,-2, 2},
               {-2, -4,-1,-1,-1,-1,-4,-2},
               { 2, -1, 1, 0, 0, 1,-1, 2},
               { 2, -1, 0, 1, 1, 0,-1, 2},
               { 2, -1, 0, 1, 1, 0,-1, 2},
               { 2, -1, 1, 0, 0, 1,-1, 2},
               {-2, -4,-1,-1,-1,-1,-4,-2},
               { 2, -2, 2, 2, 2, 2,-2, 2}};

    private static final int PESOS_FACIL[][]
            = {{-5, 3,-2,-2,-2,-2, 3,-5},
               { 3, 4, 1, 1, 1, 1, 4, 3},
               {-2, 1,-1, 0, 0,-1, 1,-2},
               {-2, 1, 0,-1,-1, 0, 1,-2},
               {-2, 1, 0,-1,-1, 0, 1,-2},
               {-2, 1,-1, 0, 0,-1, 1,-2},
               { 3, 4, 1, 1, 1, 1, 4, 3},
               {-5, 3,-2,-2,-2,-2, 3,-5}};

    
    
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
    
    private int score_facil(ArrayList<Pair> A){
        int score_aux = 0;
        for(Pair d : A) 
            score_aux += PESOS_FACIL[d.first()][d.second()] ;
        return score_aux;
    }
    
    private int score_normal(ArrayList<Pair> A){
        int score_aux = 0;
        for(Pair d : A) 
            score_aux += PESOS_NORMAL[d.first()][d.second()] ;
        return score_aux;
    }
    
    //En la evaluacion del score DIFICIL se podria agregar la diferencia actual
    //de fichas en el tablero
    private int score_dificil(ArrayList<Pair> A){
        int score_aux = 0;
        for(Pair d : A) 
            score_aux += PESOS_DIFICIL[d.first()][d.second()] ;
        return score_aux;
    }
    
    
    //Recibo las posiciones de las fichas y calculo su heuristica
    //en base a su dificultad
    public int obtener_score(ArrayList<Pair> A, dificultad d){
        int score = 0;
        if(d == dificultad.FACIL) score = score_facil(A);
        else if(d == dificultad.NORMAL) score = score_normal(A);
        else score = score_dificil(A);
        return score;
    }
    
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
