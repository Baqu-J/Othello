package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import othello.data.Pair;
import othello.domain.tablero.Escenario;
import othello.persistence.CtrlPersistence;

/**
 *
 * @author
 */
public class CtrlDomain {

    // Attributes
    private static CtrlDomain instance;
    private CtrlPersistence ctrlPersistencia;

    private ArrayList<Estadistica> perfiles;
    private ArrayList<Escenario> escenarios;

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
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int crearPerfil(String nombre) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e == null) {
            e = new Estadistica(nombre);
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
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int borrarPerfil(String nombre) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e != null) {
            ret = ctrlPersistencia.BorrarPerfil(nombre);
            if (ret == 1) {
                perfiles.remove(e);
            }
        }
        return ret;
    }

    public void DisplayRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);
        for (Estadistica e : perfiles) {
            System.out.println(e.getId() + ":");
            System.out.println("\tPuntos: " + e.getPuntos());
            System.out.println("\tVictorias: " + e.getVictoria());
            System.out.println("\tDerrotas: " + e.getDerrota());
            System.out.println("\tEmpates: " + e.getEmpate());
        }
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
