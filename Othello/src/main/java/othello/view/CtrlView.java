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
    
    private MenuPrincipalUI mainView;
    private RankingUI rankingView;
    private MenuPerfilUI perfilMenuView;
    private CrearPerfilUI createPerfilView;
    private ConsultarEstadisticaUI perfilView;
    private CrearPartidaUI createGameView;
    private PartidaUI gameView;
    
    public static CtrlView getInstance() {
        if (instance == null) {
            instance = new CtrlView();
        }
        return instance;
    }
    
    // Private Constructor
    private CtrlView() {
        ctrlDominio = CtrlDomain.getInstance();
        mainView = new MenuPrincipalUI(this);
        rankingView = new RankingUI(this);
        perfilMenuView = new MenuPerfilUI(this);
        createPerfilView = new CrearPerfilUI(this);
        perfilView = new ConsultarEstadisticaUI(this); 
        createGameView = new CrearPartidaUI(this);
        gameView = new PartidaUI(this);
        
        mainView.setVisible(true);
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
    
    public void changeWindow(String window) {
        mainView.setVisible(false);
        switch(window) {
            case "Ranking":
                rankingView.setVisible(true);
                break;
            case "MenuPerfil":
                perfilMenuView.setVisible(true);
                break;
            case "CrearPerfil":
                perfilMenuView.setVisible(false);
                createPerfilView.setVisible(true);
                break;
            case "Perfil":
                perfilMenuView.setVisible(false);
                perfilView.setVisible(true);
                break;
            case "CrearPartida":
                createGameView.setVisible(true);
                break;
            case "Partida":
                gameView.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void backToMainWindow(String window) {
        switch(window) {
            case "Ranking":
                rankingView.setVisible(false);
                break;
            case "MenuPerfil":
                perfilMenuView.setVisible(false);
                break;
            case "CrearPartida":
                createGameView.setVisible(false);
                break;
            case "Escenario":
                break;
            default:
                break;
        }
        mainView.setVisible(true);
    }
    
    public void backToWindow(String window) {
        switch(window) {
            case "Perfil":
                perfilView.setVisible(false);
                createPerfilView.setVisible(false);
                perfilMenuView.setVisible(true);
                break;
            default:
                break;
        }
    }
    
    public ArrayList<String> getRanking() {
        return ctrlDominio.getRanking();
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