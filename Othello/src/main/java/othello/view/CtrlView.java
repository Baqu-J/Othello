package othello.view;

import java.util.ArrayList;
import othello.domain.CtrlDomain;
import othello.domain.Estadistica;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

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
    private MenuEscenarioUI escenarioMenuView;
    private CrearEscenarioUI createEscenarioView;

    private SeleccionarEscenarioUI selectEscenario;

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
        createGameView = new CrearPartidaUI(this);
        escenarioMenuView = new MenuEscenarioUI(this);

        createPerfilView = new CrearPerfilUI(this);
        perfilView = new ConsultarEstadisticaUI(this);

        gameView = new PartidaUI(this);

        createEscenarioView = new CrearEscenarioUI(this);
        selectEscenario = new SeleccionarEscenarioUI(this);

        mainView.setVisible(true);
    }

    public String[] getProfileModel() {
        ArrayList<String> profiles = new ArrayList<>();
        Iterable<Estadistica> temp = ctrlDominio.listPerfiles();

        for (Estadistica e : temp) {
            profiles.add(e.getId());
        }
        String[] ret = new String[]{};
        ret = profiles.toArray(ret);
        return ret;

    }

    public void changeWindow(String window) {

        switch (window) {
            case "Ranking":
                mainView.setVisible(false);
                rankingView.setVisible(true);
                rankingView.actualiza_ranking();
                break;
            case "MenuPerfil":
                mainView.setVisible(false);
                perfilMenuView.setVisible(true);
                break;
            case "CrearPartida":
                mainView.setVisible(false);
                createGameView.setVisible(true);
                createGameView.actualiza_boxs();
                break;
            case "MenuEscenario":
                mainView.setVisible(false);
                escenarioMenuView.setVisible(true);
                break;

            case "CrearPerfil":
                perfilMenuView.setVisible(false);
                createPerfilView.setVisible(true);
                break;
            case "Perfil":
                perfilMenuView.setVisible(false);
                perfilView.setVisible(true);
                perfilView.actualiza_frame();
                break;

            case "CrearEscenario":
                escenarioMenuView.setVisible(false);
                createEscenarioView.setVisible(true);
                break;

            case "SeleccionarEscenario":
                escenarioMenuView.setVisible(false);
                selectEscenario.setVisible(true);
                selectEscenario.initEscenario();
                break;
                
            /*case "Partida":
                gameView.setVisible(true);
                break;*/
            default:
                break;
        }
    }

    public void backToMainWindow(String window) {
        switch (window) {
            case "Ranking":
                rankingView.setVisible(false);
                mainView.setVisible(true);
                break;
            case "MenuPerfil":
                perfilMenuView.setVisible(false);
                mainView.setVisible(true);
                break;
            case "CrearPartida":
                createGameView.setVisible(false);
                mainView.setVisible(true);
                break;
            case "MenuEscenario":
                escenarioMenuView.setVisible(false);
                mainView.setVisible(true);
                break;
            default:
                break;
        }
    }

    public void backToWindow(String window) {
        switch (window) {

            case "CrearPerfil":
                createPerfilView.setVisible(false);
                perfilMenuView.setVisible(true);
                break;
            case "Perfil":
                perfilView.setVisible(false);
                perfilMenuView.setVisible(true);
                break;

            case "CrearEscenario":
                createEscenarioView.setVisible(false);
                escenarioMenuView.setVisible(true);
                break;
                
            case "SeleccionarEscenario":
                selectEscenario.setVisible(false);
                escenarioMenuView.setVisible(true);
                break;
            case "ModificarEscenario":

                escenarioMenuView.setVisible(true);
                break;
            default:
                break;
        }
    }

    public ArrayList<String> getRanking() {
        return ctrlDominio.getRanking();
    }

    
    public String estadistica_perfil(String id) {
        Estadistica p = ctrlDominio.searchEstadistica(id);
        return ("<html>" + p.getId() + "<p>Puntos: " + p.getPuntos() + "<p>Victorias: " + p.getVictoria() + "<p>Derrotas: " + p.getDerrota() + "<p>Empates: " + p.getEmpate() + "<html>");
    }

    public int borrar_perfil(String id, String password) {
        return ctrlDominio.borrarPerfil(id, password);
    }

    public int crearPerfil(String nombre, String password) {
        return ctrlDominio.crearPerfil(nombre, password);
    }

    public void setupGame(Partida.GameType Type) {

    }
    
    public int crearEscenario(String nombre) {
        return ctrlDominio.crearEscenario(nombre);
    }
    
    public void editEscenario(String name) {
        ctrlDominio.setCurrentEscenario(name);
    }
        
    public ArrayList<String> getEscenarios() {
        return ctrlDominio.getEscenarios();
    }
    /*  
    
    public ArrayList<String> getEstadisticaPerfil(String nombre) {
        ctrlDominio.searchEstadistica(nombre);
        return new ArrayList<String>();
    }
    
    public ArrayList<String> listEscenarios() {
        return ctrlDominio.listEscenarios();
    }*/
}
