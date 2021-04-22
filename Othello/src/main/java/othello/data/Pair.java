package othello.data;

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
}
