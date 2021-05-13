package othello.view;

import java.util.ArrayList;
import othello.domain.CtrlDomain;
import othello.domain.Estadistica;


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
    }
    
    public static void crearPartida() {
        CrearPartidaUI cp = new CrearPartidaUI(instance);
    }

    public String[] getProfileModel() {
        ArrayList<String> profiles = new ArrayList<>();
        Iterable<Estadistica> temp = ctrlDominio.listPerfiles();
        for(Estadistica e: temp) {
            profiles.add(e.getId());
        }
        String[] ret = new String[]{};
        ret =  profiles.toArray(ret);
        return ret;
        
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