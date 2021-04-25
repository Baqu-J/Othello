package othello.persistence;

/**
 *
 * @author 
 */
public class CtrlPersistence {
        
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
    
    }
    
    public void CargarRanking() { //DEVUELVE Priority_queue
    
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