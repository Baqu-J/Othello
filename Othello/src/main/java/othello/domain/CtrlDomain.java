package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.tablero.Escenario;
import othello.persistence.CtrlPersistence;

/**
 *
 * @author Aleix Velasco Calvo
 */
public class CtrlDomain {

    // Attributes
    private static CtrlDomain instance;
    private CtrlPersistence ctrlPersistencia;

    private ArrayList<Estadistica> perfiles;
    private ArrayList<Escenario> escenarios;
    private Partida currentGame;
    private Escenario currentEscenario;

    /**
     * Método que crea una única instancia de CtrlDomain.
     *
     * @return Instancia de la clase CtrlDomain.
     */
    public static CtrlDomain getInstance() {
        if (instance == null) {
            instance = new CtrlDomain();
        }
        return instance;
    }

    // Private Constructor
    private CtrlDomain() {
        ctrlPersistencia = CtrlPersistence.getInstance();

        cargarUsuarios();
        cargarEscenarios();
    }

    // Others Methods
    /**
     * Método que carga todas las Estadisticas.
     */
    private void cargarUsuarios() {
        perfiles = ctrlPersistencia.CargarPerfiles();
    }

    /**
     * Método que guarda cada Estadistica.
     */
    public void guardarUsuarios() {
        for (Estadistica e : perfiles) {
            ctrlPersistencia.GuardarPerfil(e);
        }
    }

    /**
     * Método que carga todos los Escenarios.
     */
    private void cargarEscenarios() {
        escenarios = ctrlPersistencia.CargarEscenarios();
    }

    /**
     * Método que guarda cada Escenario.
     */
    public void guardarEscenarios() {
        for (Escenario e : escenarios) {
            ctrlPersistencia.GuardarEscenario(e);
        }
    }

    /**
     * Método que crea un Escenario si no existe ningunO con el mismo id y lo
     * añade al listado ESCENARIOS y crea su archivo.
     *
     * @param nombre id deL Escenario
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int crearEscenario(String nombre) {

        int ret = -1;
        Escenario e = searchEscenario(nombre);
        if (e == null) {
            e = new Escenario(nombre);
            ret = ctrlPersistencia.CrearEscenario(e);
            if (ret == 1) {
                escenarios.add(e);
            }
        }
        return ret;
    }

    /**
     * Método que crea una Estadistica si no existe ninguna con el mismo id y lo
     * añade al listado perfiles y crea su archivo.
     *
     * @param nombre id de la Estadistica
     * @param password
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int crearPerfil(String nombre, String password) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e == null) {
            e = new Estadistica(nombre,password);
            ret = ctrlPersistencia.CrearPerfil(e);
            if (ret == 1) {
                perfiles.add(e);
            }
        }
        return ret;
    }

    /**
     * Método que elimina una Estadistica del listado perfiles y su archivo.
     *
     * @param nombre id de la Estadistica
     * @param password
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int borrarPerfil(String nombre, String password) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e != null){
            if(password == null ? e.getPassword() == null : password.equals(e.getPassword())){
                ret = ctrlPersistencia.BorrarPerfil(nombre);
                if (ret == 1) {
                    perfiles.remove(e);
                }
            }
        }
        return ret;
    }

    public ArrayList<Estadistica> displayRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);
        return perfiles;
    }
    
    
    public ArrayList<String> getRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);
        ArrayList<String> ranking = new ArrayList<>(); 
        int pos = 1;
        for (int i = 0; i < perfiles.size(); i++) { 
            ranking.add("<html>" + pos + "-" + perfiles.get(i).toStringRanking());
            ++pos;
        }
        return ranking;
    }
    
    /**
     * Método que devulve todos las Estadisticas.
     *
     * @return Listado de Estadisticas.
     */
    public Iterable<Estadistica> listPerfiles() {
        return perfiles;
    }

    /**
     * Método que busca una Estadistica en el listado de perfiles.
     *
     * @param nombre id de la Estadistica
     * @return Devuelve una Estadistica si existe, si no un null.
     */
    public Estadistica searchEstadistica(String nombre) {
        for (Estadistica p : perfiles) {
            if (p.getId().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Método que devulve todos las Estadisticas.
     *
     * @return Listado de Estadisticas.
     */
    public Iterable<Escenario> listEscenarios() {
        return escenarios;
    }

    
    public ArrayList<String> getEscenarios() {
        ArrayList<String> esc = new ArrayList<>(); 
        for (int i = 0; i < escenarios.size(); i++) { 
            esc.add(escenarios.get(i).toStringGrid());
        }
        return esc;
    }
    
    /**
     * Método que busca un Escenario en el listado de escenarios.
     *
     * @param nombre id del Escenario
     * @return Devuelve un Escenario si existe, si no un null.
     */
    public Escenario searchEscenario(String nombre) {
        for (Escenario e : escenarios) {
            if (e.getId().equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void setCurrentEscenario(String name){
        currentEscenario = searchEscenario(name);
    }
    
    public String[] getCurrentEscenarioGrid() {
        String[] parts = currentEscenario.toStringGrid().split(",");
        return parts;
    }
    
    public void undoCurrentEscenario() {
        currentEscenario.undo();
    }
    
    public void reCurrentEscenario() {
        currentEscenario.redo();
    }
    
    public void CommitPlayCurrentEscenario(int first, int second) {
        currentEscenario.commitPlay(new Pair(first, second), currentEscenario.getColor());
    }
    
    public boolean turno(Partida p) {
        if (p.getType() == Partida.GameType.PLAYERvsPLAYER) {
            return true;
        }
        if (p.getJ1() == null) {
            if (p.getTurn() % 2 == 1) {
                return true;
            }
        } else {
            if (p.getTurn() % 2 == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void printPartida(Partida p) {
        p.printTurn();
    }
    
    public int colocarFicha(Partida p, Pair pair) {
        int ret = -1;
        if (p.move(pair) != 0 ) {
            return 1;
        }
        
        return ret;
    }

    public int guardarPartida(Partida p) {
        int ret = -1;
        ret = ctrlPersistencia.GuardarPartida(p);
        return ret;

    }

    public Partida cargarPartida() {
        return ctrlPersistencia.CargarPartida();
    }
}
