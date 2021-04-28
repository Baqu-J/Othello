package othello.domain.tablero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;
import othello.data.Casilla;
import othello.data.Pair;

/**
 *
 * @author Foster
 */

//hashmap i copiar constructora bucle modificacion escenario
public class Escenario extends Tablero implements Serializable{
    private String id;
    private Stack<Tablero> tableros;
    private Stack<Tablero> popped;
    
    public Escenario(String name) {
        id = name;
        Tablero t = new Tablero();
        tableros = new Stack();
        popped = new Stack();
        tableros.add(t);
    }
    
    public void setAll(String id, Stack<Tablero> tab, Stack<Tablero> pop) {
        this.id = id;
        this.tableros = tab;
        this.popped = pop;
    }
    
    public Tablero getTop() {
        return tableros.peek().DeepCopy();
    }
    
    public Stack getTab() {
        return tableros;
    }
    
    public Stack getPop() {
        return popped;
    }
    
    @Override
    public void print_tablero() {
        tableros.peek().print_tablero();
    }
    
    @Override
    public ArrayList<Pair> commitPlay(Pair p, Casilla c) {
        Tablero t = tableros.peek().DeepCopy();
        ArrayList<Pair> ret = t.commitPlay(p, c);
        if(!ret.isEmpty())tableros.add(t);
        if(tableros.size() > 10) tableros.removeElementAt(tableros.size()-1);
        return ret;
    }
    
    public void undo() {
        if(tableros.size() > 1) popped.add(tableros.pop());
    }
    
    public void redo() {
        if(!popped.empty()) tableros.add(popped.pop());
    }
    
    
    public String getId() {
        return id;
    }

}
