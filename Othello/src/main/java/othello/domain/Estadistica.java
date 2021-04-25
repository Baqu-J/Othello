package othello.domain;

import java.util.ArrayList;

/**
 *
 * @author Aleix Velasco Calvo
 */
public class Estadistica implements EstadisticaInteface {

    // Attributes
    private static String id;
    private int victoria;
    private int derrota;
    private int empat;
    private int punts;

    // Constructors
    public Estadistica(String id) {
        this.id = id;
        this.victoria = 0;
        this.derrota = 0;
        this.empat = 0;
        this.punts = 0;
    }

    public Estadistica(String id, int victoria, int derrota, int empat, int punts) {
        this.id = id;
        this.victoria = victoria;
        this.derrota = derrota;
        this.empat = empat;
        this.punts = punts;
    }

    // Getters and Setters
    public String getId() {
        return this.id;
    }

    public int getVictoria() {
        return this.victoria;
    }

    public int getDerrota() {
        return this.derrota;
    }

    public int getEmpat() {
        return this.empat;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public int getPunts() {
        return this.punts;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public void setEmpat(int empat) {
        this.empat = empat;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    @Override
    public void incVictories() {
        setVictoria(getVictoria() + 1);
        this.punts = this.punts + 3;
    }

    @Override
    public void incDerrotes() {
        setDerrota(getDerrota() + 1);
    }

    @Override
    public void incEmpat() {
        setEmpat(getEmpat() + 1);
        ++this.punts;
    }


    public ArrayList<String> toStringStat() {
        //return "Estadistica{" + "victoria=" + victoria + ", derrota=" + derrota + ", empat=" + empat + ", punts=" + punts + '}';
        return new ArrayList<>();
    }

}
