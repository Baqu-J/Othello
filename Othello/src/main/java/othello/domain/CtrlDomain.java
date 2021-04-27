package othello.domain;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Vector;
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
    
    private PriorityQueue<Estadistica> perfiles;
    //private HashSet<String, Escenario> escenarios;
    
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
    private void cargarUsuarios() {
        perfiles = ctrlPersistencia.CargarRanking();
    }
    
    private void guardarUsuarios() {

    }
    
    private void cargarEscenarios() {
        
    }
    
    private void guardarEscenarios() {
        
    }
    
    public int crearPerfil(String nombre) {
        return ctrlPersistencia.CrearPerfil(nombre);
    }
    
    /*public String verEstadisticasPerfil(String nombre) {
        return buscarPerfilPorNombre(nombre).toString();
    }
    
    private Perfil buscarPerfilPorNombre(String nombre) {
        return perfiles.get(nombre);
    }
    */
    public void DisplayRanking() {
        for(Estadistica e: perfiles) {
            System.out.println(e.getId() + ":");
            System.out.println("\tPuntos: " + e.getPuntos());
            System.out.println("\tVictorias: "+ e.getVictoria());
            System.out.println("\tDerrotas: "+ e.getDerrota());
            System.out.println("\tEmpates: "+ e.getEmpate());
        }
    }
}
