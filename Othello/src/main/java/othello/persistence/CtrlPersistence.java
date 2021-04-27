package othello.persistence;

import java.io.File;
import java.io.IOException;
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
    public int CrearPerfil(String nombre) { //Check si perfil existe
        
        Estadistica e = new Estadistica(nombre);
        int resp = serializador.createJSONfromEstadistica(e);
        return resp;
    }
    
    public PriorityQueue CargarRanking() { //DEVUELVE Priority_queue
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos()- o1.getPuntos();
        
        PriorityQueue<Estadistica> ranking = new PriorityQueue<>(c);
        File dir = new File("JSON/Ranking");
        if(dir.exists()) {
            
            File[] list = dir.listFiles();
            for(int i = 0; i < list.length; ++i) {
                Estadistica e = new Estadistica("");
                serializador.getEstadisticafromFile(e, list[i].getPath());
                ranking.add(e);
            }
        }
        //STUFF
        
        return ranking;
    }
    
    public void BorrarSavedGame(Partida p) {  //se llama al acabar partida o al sobreescribir
        File file = new File("JSON/Escenarios/SavedGame.json");
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
    
    public int GuardarEscenario(Escenario e) { //check si guarda bien
        int ret = serializador.createJSONfromEscenario(e);
        return ret;
    }
    
    public Escenario CargarEscenario(String id) { //check si existe
        Escenario e = new Escenario("id");
        int ret = serializador.getEscenariofromFile(e, "JSON/Escenarios/"+id+".json");
        if(ret == 1) return e;
        return null;
    }
}