package othello.persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;
import othello.domain.Estadistica;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

/**
 *
 * @author 
 */
public class CtrlPersistence {
    private final Serializador serializador;
    // Attributes
    private static CtrlPersistence instance;
    
    public static CtrlPersistence getInstance() {
        if (instance == null) {
            instance = new CtrlPersistence();
        }
        return instance;
    }
    
    // Private Constructor
    private CtrlPersistence() {
        serializador = new Serializador();
    }
    //methods
    public int CrearPerfil(Estadistica e) { //Check si perfil existe
        
        
        int resp = serializador.createJSONfromEstadistica(e);
        return resp;
    }
    
    /**
     *
     * @param nombre
     * @return 
     */
    public int BorrarPerfil(String nombre) { //Check si perfil existe
        Boolean success = false;
        File file = new File("JSON/Ranking/" + nombre +".json");

        if(file.exists()) success = file.delete();
        
        if(success) return 1;
        else return -1;
    }
    
    /**
     *
     * @return
     */
    public ArrayList CargarPerfiles() { //DEVUELVE Priority_queue
        
        ArrayList<Estadistica> perfiles = new ArrayList();
        File dir = new File("JSON/Ranking");
        if(dir.exists()) {
            
            File[] list = dir.listFiles();
            for(int i = 0; i < list.length; ++i) {
                Estadistica e = new Estadistica("");
                serializador.getEstadisticafromFile(e, list[i].getPath());
                perfiles.add(e);
            }
        }
        //STUFF
        
        return perfiles;
    }
    
    public ArrayList CargarEscenarios() {
        ArrayList<Escenario> escenarios = new ArrayList();
        File dir = new File("JSON/Escenarios");
        if(dir.exists()) {
            
            File[] list = dir.listFiles();
            for(int i = 0; i < list.length; ++i) {
                Escenario e = new Escenario("");
                serializador.getEscenariofromFile(e, list[i].getPath());
                escenarios.add(e);
            }
        }
        return escenarios;
    }
    
    public int GuardarEscenario(Escenario e) {
        return serializador.updateJSONfromEscenario(e);
    }
    
    public int GuardarPerfil(Estadistica e) {
        
        return serializador.updateJSONfromEstadistica(e);
    }
    
    public void BorrarSavedGame(Partida p) {  //se llama al acabar partida o al sobreescribir
        File file = new File("JSON/Partida/SavedGame.json");
        if(file.exists()) file.delete();
    }
    
    public int GuardarPartida(Partida p) { //borrar existente antes de guardar y check si guarda bien
        BorrarSavedGame(p);
        int ret = serializador.createJSONfromPartida(p);
        return ret;
    }
    
    public Partida CargarPartida() { //check si existe NO DEBE BORRAR
        Partida p = null;
        int ret = serializador.getPartidafromFile(p);
        if(ret == 1) return p;
        return null;
    }
    

}