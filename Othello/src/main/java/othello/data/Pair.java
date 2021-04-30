package othello.data;

import java.io.Serializable;

/**
 * Clase Pair, representa un par de enteros.
 * @author Jaume Baqueró Quesada
 */
public class Pair implements Serializable{

    private int first;
    private int second;

    /**
     * Constructor por defecto asignándole valores al par de enteros.
     * @param f
     * @param s 
     */
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

    public void setFirst(int f) {
        first = f;
    }

    public void setSecond(int s) {
        second = s;
    }

    /**
     * Función que suma el primer valor del par implícito con el primer valor 
     * del par del parámetro "p", y de igual manera con el 2do elemento.
     * @param p
     * @return pair
     */
    public Pair sum(Pair p) {
        return new Pair(this.first() + p.first(), this.second() + p.second());
    }
    
    /**
     * Función que resta el primer valor del par implícito con el primer valor 
     * del par del parámetro "p", y de igual manera con el 2do elemento.
     * @param p
     * @return pair
     */
    public Pair sub(Pair p) {
        return new Pair(this.first() - p.first(), this.second() - p.second());
    }
    
    
    public String convertString() {
        String s = String.valueOf(this.first) + "/" + String.valueOf(this.second);
        return s;
    } 

    @Override
    public String toString() {
        String s = String.valueOf(this.first) + "/" + String.valueOf(this.second);
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.first;
        hash = 89 * hash + this.second;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.first != other.first) {
            return false;
        }
        if (this.second != other.second) {
            return false;
        }
        return true;
    }
    
}
