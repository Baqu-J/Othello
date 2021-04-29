package othello.data;

import java.io.Serializable;

/**
 *
 * @author Foster
 */
public class Pair implements Serializable{

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

    public void setFirst(int f) {
        first = f;
    }

    public void setSecond(int s) {
        second = s;
    }

    public Pair sum(Pair p) {
        return new Pair(this.first() + p.first(), this.second() + p.second());
    }
    
    public Pair sub(Pair p) {
        return new Pair(this.first() - p.first(), this.second() - p.second());
    }
    
    public String convertString() {
        String s = String.valueOf(this.first) + "/" + String.valueOf(this.second);
        return s;
    } 

    @Override
    public String toString() {
        return "Pair{" + "first=" + first + ", second=" + second + '}';
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
