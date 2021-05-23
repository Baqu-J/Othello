package othello.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private MenuEscenarioUI escenarioMenuView;
    private CrearEscenarioUI createEscenarioView;
    private SeleccionarEscenarioUI selectEscenario;
    private EditarEscenarioUI editEscenario;
    
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
        mainView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        mainView.addWindowListener(exitListener);
        
        
        rankingView = new RankingUI(this);
        rankingView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        rankingView.addWindowListener(exitListener);
        
        perfilMenuView = new MenuPerfilUI(this);
        perfilMenuView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        perfilMenuView.addWindowListener(exitListener);
        
        createGameView = new CrearPartidaUI(this);
        createGameView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        createGameView.addWindowListener(exitListener);
        
        escenarioMenuView = new MenuEscenarioUI(this);
        escenarioMenuView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        escenarioMenuView.addWindowListener(exitListener);
        
        createPerfilView = new CrearPerfilUI(this);
        createPerfilView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        createPerfilView.addWindowListener(exitListener);
        
        perfilView = new ConsultarEstadisticaUI(this);
        perfilView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        perfilView.addWindowListener(exitListener);

        gameView = new PartidaUI(this);
        gameView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        gameView.addWindowListener(exitListenerinGame);
        
        createEscenarioView = new CrearEscenarioUI(this);
        createEscenarioView.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        createEscenarioView.addWindowListener(exitListener);
        
        selectEscenario = new SeleccionarEscenarioUI(this);
        selectEscenario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        selectEscenario.addWindowListener(exitListener);
        
        editEscenario = new EditarEscenarioUI(this);
        editEscenario.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        editEscenario.addWindowListener(exitListener);
        
        mainView.setVisible(true);
    }
    
    WindowListener exitListener = new WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent e) {
            ctrlDominio.guardarEscenarios();
            ctrlDominio.guardarUsuarios();
            System.exit(0);
        }
    };
    
    WindowListener exitListenerinGame = new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        gameView.PauseExit();
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Quieres guardar la partida?",
                "Salir",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null, 3);
        if(seleccion != 3) {
            if (seleccion == 0) {
                gameView.guardarPartida();
            }
            ctrlDominio.guardarEscenarios();
            ctrlDominio.guardarUsuarios();
            System.exit(0);
        }
    }
};
    
    public String[] getProfileModel() {
        ArrayList<String> profiles = new ArrayList<>();
        Iterable<Estadistica> temp = ctrlDominio.listPerfiles();

        for (Estadistica e : temp) {
            profiles.add(e.getId());
        }
        profiles.add("Guest");
        String[] ret = new String[]{};
        ret = profiles.toArray(ret);
        return ret;

    }
    
    public String[] getProfileModelConsulta() {
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
                selectEscenario.setVisible(false);
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

            case "SeleccionarEscenarioEdit":
                escenarioMenuView.setVisible(false);
                selectEscenario.setVisible(true);
                selectEscenario.disableSelect();
                selectEscenario.enableEdit();
                selectEscenario.initEscenario();
                selectEscenario.enableBack();
                
                break;
            
            case "SeleccionarEscenarioPartida":
                createGameView.setVisible(false);
                selectEscenario.setVisible(true);
                selectEscenario.enableSelect();
                selectEscenario.disableEdit();
                selectEscenario.initEscenario();
                selectEscenario.disableBack();
                break;
            case "EditarEscenario":
                selectEscenario.setVisible(false);
                editEscenario.setVisible(true);
                break;
                
            case "Partida":
                gameView.setVisible(true);
                gameView.initGame();
                break;
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
            case "Partida":
                gameView.setVisible(false);
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
                editEscenario.setVisible(false);
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
        return ctrlDominio.consultaPerfil(id);
    }

    public int borrar_perfil(String id, String password) {
        return ctrlDominio.borrarPerfil(id, password);
    }
    
    public int borrar_escenario(String id) {
        return ctrlDominio.borrarEscenario(id);
    }

    public int crearPerfil(String nombre, String password) {
        return ctrlDominio.crearPerfil(nombre, password);
    }

    public void setupGame(Boolean J1, Boolean J2, Boolean IA1, Boolean IA2, String Opc1, String Opc2, Boolean P1White, String nameEscenario) {
        ctrlDominio.setupGame(J1, J2, IA1, IA2, Opc1, Opc2, P1White, nameEscenario);
    }
    
    public void loadGame() {
        String s = ctrlDominio.loadGame();
        if(s.equals("ok")) {
            changeWindow("Partida");
        }
    }
    public int crearEscenario(String nombre) {
        return ctrlDominio.crearEscenario(nombre);
    }
    
    public void editEscenario(String name) {
        ctrlDominio.setCurrentEscenario(name);
        String[] parts = ctrlDominio.getCurrentEscenarioGrid();
        editEscenario.drawGrid(parts);
        editEscenario.setNameEscenario(name);
        changeWindow("EditarEscenario");
        
    }
    
    public void commitPlayCurrentEscenario(int first, int second) {
        ctrlDominio.CommitPlayCurrentEscenario(first, second);
        redrawEscenario();
    }
    
    public void redrawEscenario() {
        String[] parts = ctrlDominio.getCurrentEscenarioGrid();
        editEscenario.drawGrid(parts);
    }
       
    public void undoCurrentEscenario() {
        ctrlDominio.undoCurrentEscenario();
    }
    
    public void redoCurrentEscenario() {
        ctrlDominio.reCurrentEscenario();
    }
    
    public ArrayList<String> getEscenarios() {
        return ctrlDominio.getEscenarios();
    }
    
    public void setEscenarioCrearPartida(String s) {
        createGameView.setEscenario(s);
    }
    
    public void commitPlayCurrentGame(int x, int y) {
        String ret = ctrlDominio.colocarFicha(x, y);
        if(!ret.equals("Movimiento Ilegal")){
            if(ret.equals("Movimiento Realizado"))gameView.addLog(x,y);
            else gameView.popUpMessage(ret);
            printTurn();
            redrawTablero();
            printTypeGame();
            printColorTurn();
            printFichas();
            restartIATimer();
            checkGameisFinished();
        }else{
            gameView.popUpMessage(ret);
        }
    }
    
    public void printFichas() {
        int[] moves = ctrlDominio.currentGameMoves();
        
        gameView.setFichas(moves[0], moves[1]);
    }
    
    public void checkGameisFinished() {
        if(ctrlDominio.currentGameisFinished()) {
            ctrlDominio.updateEstadisticas();
            gameView.stopIATimer();
            gameView.disablePausa();
            gameView.printGameFinished(ctrlDominio.currentGameScores());
        }
    }
    
    public void restartIATimer() {
        if(gameView.getTypeGame().equals("IAvsIA") || (gameView.getTypeGame().equals("PLAYERvsIA") && turnPlayer().equals("IA"))){
                gameView.restartIATimer();
            }
    }

    public void redrawTablero() {
        String[] parts = ctrlDominio.getTableroCurrentGame();
        /*for(int i = 0;i < parts.length;i++){
            System.out.println(parts[i]);
        }*/
        gameView.reloadGrid(parts);
    }
    
    public void printTypeGame() {
        String type = ctrlDominio.getTipoPartida();
        gameView.setTypeGame(type);
    }
    
    public void printTurn() {
        String turn = ctrlDominio.getTurnoPartida();
        gameView.setTurnGame(turn);
    }
    
    public String getCurrentGameTurn() {
        return ctrlDominio.getTurnoPartida();
    }
    
    public void printColorTurn() {
        String color = ctrlDominio.getTurnoColorPartida();
        gameView.printColorTurn(color);
    }

    public void printPlayers() {
        String[] players = ctrlDominio.getJugadoresPartida();
        gameView.printPlayers(players);
    }
    
    public String turnPlayer() {
        return ctrlDominio.getJugadoresTurno();
    }
    
    public String guardarPartida() {
        return ctrlDominio.guardarPartida();
    }
}
