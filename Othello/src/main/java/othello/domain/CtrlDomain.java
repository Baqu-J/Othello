package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    
    public void guardarUsuarios() {
        
        for(Estadistica e: perfiles) {
            ctrlPersistencia.GuardarPerfil(e);
        }

    }
    
    private void cargarEscenarios() {
        escenarios = ctrlPersistencia.CargarEscenarios();
    }
    
    public void guardarEscenarios() {
        for(Escenario e: escenarios) {
            ctrlPersistencia.GuardarEscenario(e);
        }
    }
    
    public int crearEscenario(String nombre) {
        Escenario e = new Escenario(nombre);
        int ret = ctrlPersistencia.CrearEscenario(e);
        if(ret == 1)escenarios.add(e);
        return ret;
    }
    
    public int crearPerfil(String nombre) {
        Estadistica e = new Estadistica(nombre);
        int ret = ctrlPersistencia.CrearPerfil(e);
        if(ret == 1)perfiles.add(e);
        return ret;
    }
    
    public int borrarPerfil(String nombre) {
        int ret;
        ret = ctrlPersistencia.BorrarPerfil(nombre);
        if(ret ==1){
            for(Estadistica e: perfiles) {
                if(e.getId().equals(nombre)) perfiles.remove(e);
                break;
            }
        }
        return ret;
    }
    
    public Estadistica searchEstadistica(String nombre) {
        for(Estadistica e: perfiles) {
            if(e.getId().equals(nombre)) return e;
        }
        return null;
    }
    
     // Devolver una estadistica
    public void verEstadisticasPerfil(String nombre) {
       
        Estadistica e = searchEstadistica(nombre);
        if(e != null) {
            System.out.println(e.getId() + ":");
            System.out.println("\tPuntos: " + e.getPuntos());
            System.out.println("\tVictorias: " + e.getVictoria());
            System.out.println("\tDerrotas: " + e.getDerrota());
            System.out.println("\tEmpate: " + e.getEmpate());
        }
        else {
            System.out.println("El usuario no existe.");
        }
    }

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
    
    public void printEscenarios() {
        for(Escenario e: escenarios) {
            System.out.println(e.getId());
            e.print_tablero();
        }
    }
    
    public Escenario searchEscenario(String name) {
        for(Escenario e: escenarios) {
            if(e.getId().equals(name)) return e;
        }
        return null;
    }
}
