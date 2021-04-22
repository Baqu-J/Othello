package othello.view;

import othello.domain.CtrlDomain;

/**
 *
 * @author 
 */
public class CtrlView {
        
    // Attributes
    private static CtrlView instance;
    private CtrlDomain ctrlDominio;
    
    public static CtrlView getInstance() {
        if (instance == null) {
            instance = new CtrlView();
        }
        return instance;
    }
    
    // Private Constructor
    private CtrlView() {
        ctrlDominio = CtrlDomain.getInstance();
    }
    
}