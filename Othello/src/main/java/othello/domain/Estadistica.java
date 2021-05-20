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
    private String id;
    private String password;
    private int victoria;
    private int derrota;
    private int empate;
    private int puntos;

    // Constructors
    /**
     * Constructor de Estadística asignándole un identificador
     * @param id 
     * @param pass 
     */
    public Estadistica(String id, String pass) {
        this.id = id;
        this.password  = pass;
        this.victoria = 0;
        this.derrota = 0;
        this.empate = 0;
        this.puntos = 0;
    }

    /**
     * Constructor de Estadística asignándole un id, victoria, empate, puntos
     * @param id
     * @param victoria
     * @param derrota
     * @param empate
     * @param puntos 
     */
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setAll(String id, String pass, int puntos, int victoria, int derrota, int empate) {
        this.id = id;
        this.password = pass;
        this.puntos = puntos;
        this.victoria = victoria;
        this.derrota = derrota;
        this.empate = empate;
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
     * Método que incrementa el atributo victoria + 1, y aumenta
     * los puntos en 3 unidades
     */
    public void incVictorias() {
        setVictoria(getVictoria() + 1);
        this.puntos = this.puntos + 3;
    }

    /**
     * Método que incrementa el atributo derrota + 1, y disminuye
     * los puntos en 2 unidades
     */
    public void incDerrotas() {
        setDerrota(getDerrota() + 1);
        this.puntos = this.puntos - 2;
        if(this.puntos < 0) this.puntos = 0;
    }

    /**
     * Método que incrementa el atributo empate + 1, y aumenta
     * los puntos en 1 unidad
     */
    public void incEmpates() {
        setEmpate(getEmpate() + 1);
        this.puntos = this.puntos + 1;
    }
    
    @Override
    public String toString() {
        return (id + ":\n\tPuntos: " + puntos + "\n\tVictorias: " + victoria + "\n\tDerrotas: " + derrota + "\n\tEmpates: " + empate);
    }
    /**
     * Método que devuelve un string con el id del Usuario y sus puntos
     * @return id del usuario + puntos
     */
    public String toStringRanking() {
        return (id + ": Puntos: "+ puntos + "<html>");
    }
    
    /**
     * Método que devuelve un string con el id
     * @return string con id de la estadistica
     */
    public String toStringOnlyName() {
        return ("Nombre: " + id);
    }
}
