package othello.persistence;

import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;
import othello.domain.Estadistica;

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
    public void CrearPerfil() { //Check si perfil existe
        Scanner s = new Scanner(System.in);
        String id = s.next();
        Estadistica e = new Estadistica(id);
        int resp = serializador.createJSONfromEstadistica(e);
        if(resp == 1) {System.out.println("Perfil creado con exito");}
        else if(resp == -1) {System.out.println("Perfil ya existe");}
        else {System.out.println("Ha habido un error, prueba de nuevo");}
    }
    
    public PriorityQueue CargarRanking() { //DEVUELVE Priority_queue
        Comparator c = new Comparator<Estadistica>() {
            @Override
            public int compare(Estadistica o1, Estadistica o2) {
                return o2.getPunts()- o1.getPunts();
            }
        };
        
        PriorityQueue<Estadistica> ranking = new PriorityQueue<>(c);
        
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