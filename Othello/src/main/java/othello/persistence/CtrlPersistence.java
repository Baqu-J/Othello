package othello.persistence;

import java.io.File;
import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;
import othello.domain.Estadistica;
import othello.domain.tablero.Escenario;

/**
 *
 * @author 
 */
public class CtrlPersistence {
    private Serializador serializador;
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
        
    }
    //methods
    public int CrearPerfil() { //Check si perfil existe
        Scanner s = new Scanner(System.in);
        String id = s.next();
        Estadistica e = new Estadistica(id);
        int resp = serializador.createJSONfromEstadistica(e);
        return resp;
    }
    
    public PriorityQueue CargarRanking() { //DEVUELVE Priority_queue
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos()- o1.getPuntos();
        
        PriorityQueue<Estadistica> ranking = new PriorityQueue<>(c);
        File dir = new File("/JSON/Ranking");
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
    
    public void BorrarSavedGame() {  //se llama al acabar partida o al sobreescribir
        
    }
    
    public void GuardarPartida() { //check si guarda bien y borrar existente antes de guardar
    
    }
    
    public void CargarPartida() { //check si existe NO DEBE BORRAR
    
    }
    
    public void GuardarEscenario() { //check si guarda bien
    
    }
    
    public void CargarEscenario() { //check si existe
    
    }
}