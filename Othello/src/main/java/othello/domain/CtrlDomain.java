package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    private ArrayList<Estadistica> perfiles;
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
        perfiles = ctrlPersistencia.CargarPerfiles();
    }
    
    private void guardarUsuarios() {
        
        for(Estadistica e: perfiles) {
            ctrlPersistencia.GuardarPerfil(e);
        }

    }
    
    private void cargarEscenarios() {
        
    }
    
    private void guardarEscenarios() {
        
    }
    
    public int crearPerfil(String nombre) {
        Estadistica e = new Estadistica(nombre);
        int ret = ctrlPersistencia.CrearPerfil(e);
        if(ret == 1)perfiles.add(e);
        return ret;
    }
    
    public int borrarPerfil(String nombre) {
        return ctrlPersistencia.BorrarPerfil(nombre);
    }
    
    /*public String verEstadisticasPerfil(String nombre) {
        return buscarPerfilPorNombre(nombre).toString();
    }
    
    private Perfil buscarPerfilPorNombre(String nombre) {
        return perfiles.get(nombre);
    }
    */
    public void DisplayRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos()- o1.getPuntos();
        Collections.sort(perfiles, c);
        for(Estadistica e: perfiles) {
            System.out.println(e.getId() + ":");
            System.out.println("\tPuntos: " + e.getPuntos());
            System.out.println("\tVictorias: "+ e.getVictoria());
            System.out.println("\tDerrotas: "+ e.getDerrota());
            System.out.println("\tEmpates: "+ e.getEmpate());
        }
    }
}
