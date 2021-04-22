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
    
}