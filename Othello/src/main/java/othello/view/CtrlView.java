package othello.view;

import java.util.ArrayList;
import othello.domain.CtrlDomain;


/**
 *
 * @author 
 */
public class CtrlView {
        
    // Attributes
    private static CtrlView instance;
    private CtrlDomain ctrlDominio;
    private OthelloUI mainView;
    
    public static CtrlView getInstance() {
        if (instance == null) {
            instance = new CtrlView();
        }
        return instance;
    }
    
    // Private Constructor
    private CtrlView() {
        ctrlDominio = CtrlDomain.getInstance();
        mainView = new OthelloUI(this);
        mainView.setVisible(true);
    }
    
    public static void crearPartida() {
        CrearPartidaUI cp = new CrearPartidaUI();
    }

    /*public String crearPerfil(String nombre) {
        return ctrlDominio.crearPerfil(nombre);
    }

    public ArrayList<String> getEstadisticaPerfil(String nombre) {
        ctrlDominio.searchEstadistica(nombre);
        return new ArrayList<String>();
    }
    
    public ArrayList<String> getRanking() {
        return ctrlDominio.getRanking();
    }
    
    
    public ArrayList<String> listEscenarios() {
        return ctrlDominio.listEscenarios();
    }*/
}