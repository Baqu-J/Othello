/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain;

/**
 *
 * @author Foster
 * @param <T>
 * @param <U>
 */
public class Pair<T, U> {
    private T first;
    private U second;
    
    public Pair(T f, U s) {
        first = f;
        second = s;
    }
    
    public T first() {
        return first;
    }
    
    public U second() {
        return second;
    }
    
    public void setfirst(T f) {
        first = f;
    }
    
    public void setsecond(U s) {
        second = s;
    }
}
