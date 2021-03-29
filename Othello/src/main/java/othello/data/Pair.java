package othello.data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Foster
 */
public class Pair {
    private int first;
    private int second;
    
    public Pair(int f, int s) {
        first = f;
        second = s;
    }
    
    public int first() {
        return first;
    }
    
    public int second() {
        return second;
    }
    
    public void setfirst(int f) {
        first = f;
    }
    
    public void setsecond(int s) {
        second = s;
    }
    
}
