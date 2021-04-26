package othello.domain;

import java.io.Serializable;

/**
 * Clase Estadistica que contiene un Id (Nombre de un jugador) con sus
 * estadísticas (Victorias, Derrotas, Empates ...).
 *
 * @author Aleix Velasco Calvo
 */
public class Estadistica implements Serializable {

    // Attributes
    private static String id;
    private int victoria;
    private int derrota;
    private int empate;
    private int puntos;

    // Constructors
    public Estadistica(String id) {
        this.id = id;
        this.victoria = 0;
        this.derrota = 0;
        this.empate = 0;
        this.puntos = 0;
    }

    public Estadistica(String id, int victoria, int derrota, int empate, int puntos) {
        this.id = id;
        this.victoria = victoria;
        this.derrota = derrota;
        this.empate = empate;
        this.puntos = puntos;
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

    public int getEmpate() {
        return this.empate;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Other Methods
    /**
     * Método que incrementa el atributo victoria + 1.
     */
    public void incVictorias() {
        setVictoria(getVictoria() + 1);
        this.puntos = this.puntos + 3;
    }

    /**
     * Método que incrementa el atributo derrota + 1.
     */
    public void incDerrotas() {
        setDerrota(getDerrota() + 1);
    }

    /**
     * Método que incrementa el atributo empate + 1.
     */
    public void incEmpates() {
        setEmpate(getEmpate() + 1);
        ++this.puntos;
    }
}
