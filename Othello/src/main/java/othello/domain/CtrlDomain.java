package othello.domain;

import java.util.HashSet;
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
    
    //private HashSet<String, Perfil> perfiles;
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
        /*vector<String> usuarios = ctrlPersistencia.();
        
        for(int i = 0; i < usuarios.size(); i++) {
            
        }*/
    }
    
    private void guardarUsuarios() {

    }
    
    private void cargarEscenarios() {
        
    }
    
    private void guardarEscenarios() {
        
    }
    
    public void crearPerfil(String nombre) {
        /*Perfil p = new Perfil(nombre);
        // Añadir al set
        System.out.println(p.toString());*/
    }
    
    /*public String verEstadisticasPerfil(String nombre) {
        return buscarPerfilPorNombre(nombre).toString();
    }
    
    private Perfil buscarPerfilPorNombre(String nombre) {
        return perfiles.get(nombre);
    }
    
    public Vector<String> crearRanking() {
        Vector<String> v();
        return v;
    }*/
}
