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
        if(!ctrlDominio.getTipoPartida().equals("IAvsIA")) {
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Quieres guardar la partida?",
                    "Salir",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null, 2);
            if(seleccion != 2) {
                if (seleccion == 0) {
                    gameView.guardarPartida();
                }
                ctrlDominio.guardarEscenarios();
                ctrlDominio.guardarUsuarios();
                System.exit(0);
            }
        }
        else {
            int seleccion = JOptionPane.showOptionDialog(
                        null,
                        "Quieres salir de la partida?",
                        "Salir",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        null, 1);
                if(seleccion != 1) {
                    ctrlDominio.guardarEscenarios();
                    ctrlDominio.guardarUsuarios();
                    System.exit(0);
                }
            }
    }
};
    
    /**
     * Método para cambiar de frame
     * @param window 
     */
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

    /**
     * Método para volver al frame principañ
     * @param window 
     */
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

    /**
     * Método para volver al frame anterior
     * @param window 
     */
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

    /**
     * Función para obtener el ranking actual
     * @return ranking
     */
    public ArrayList<String> getRanking() {
        return ctrlDominio.getRanking();
    }

    /**
     * Función para obtener la estadística de un perfil
     * @param id
     * @return estadística de perfil "id"
     */
    public String estadistica_perfil(String id) {
        return ctrlDominio.consultaPerfil(id);
    }
    
    /**
     * Función para obtener la lista de los perfiles actuales
     * @return lista perfiles
     */
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
    
    /**
     * Función para obtener lista de jugadores + usuario GUEST
     * @return lista
     */
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

    /**
     * Función para crear un perfil
     * @param nombre
     * @param password
     * @return 1:creado satisfactoriamente, -1:ya existe perfil
     */
    public int crearPerfil(String nombre, String password) {
        return ctrlDominio.crearPerfil(nombre, password);
    }

    /**
     * Función para borrar un perfil
     * @param id
     * @param password
     * @return 1:borrado con exito, -1:no existe perfil o no se pudo borrar
     */
    public int borrar_perfil(String id, String password) {
        return ctrlDominio.borrarPerfil(id, password);
    }
    
    /**
     * Función para borrar un escenario identificado con "id"
     * @param id
     * @return 1:borrado existosamente, -1:no se pudo borrar escenario
     */
    public int borrar_escenario(String id) {
        return ctrlDominio.borrarEscenario(id);
    }
    
    /**
     * Función para crear un nuevo escenario
     * @param nombre
     * @return 1:creado satisfactoriamente, -1:ya existe escenario o no se pudo crear
     */
    public int crearEscenario(String nombre) {
        return ctrlDominio.crearEscenario(nombre);
    }
    
    /**
     * Método para editar un escenario existente
     * @param name 
     */
    public void editEscenario(String name) {
        ctrlDominio.setCurrentEscenario(name);
        String[] parts = ctrlDominio.getCurrentEscenarioGrid();
        editEscenario.drawGrid(parts);
        editEscenario.setNameEscenario(name);
        changeWindow("EditarEscenario");
        
    }
    
    public boolean isIABlack_in_PvsIA() {
        return ctrlDominio.isIABlack_in_PvsIA();
    }
    
    /**
     * Método para realizar un movimiento en el tablero del escenario
     * @param first
     * @param second 
     */
    public void commitPlayCurrentEscenario(int first, int second) {
        ctrlDominio.CommitPlayCurrentEscenario(first, second);
        redrawEscenario();
    }
    
    /**
     * Método para mostrar el movimiento en el tablero del escenario
     */
    public void redrawEscenario() {
        String[] parts = ctrlDominio.getCurrentEscenarioGrid();
        editEscenario.drawGrid(parts);
    }
       
    /**
     * Método para deshacer un movimiento en el tablero del escenario
     */
    public void undoCurrentEscenario() {
        ctrlDominio.undoCurrentEscenario();
    }
    
    /**
     * Método para rehacer un movimiento en el tablero del escenario
     */
    public void redoCurrentEscenario() {
        ctrlDominio.reCurrentEscenario();
    }
    
    /**
     * Función para obtener todos los escenarios
     * @return escenarios
     */
    public ArrayList<String> getEscenarios() {
        return ctrlDominio.getEscenarios();
    }
    
    /**
     * Método para cargar un escenario en una partida
     * @param s 
     */
    public void setEscenarioCrearPartida(String s) {
        createGameView.setEscenario(s);
    }
    
    /**
     * Método para iniciar una partida
     * @param J1
     * @param J2
     * @param IA1
     * @param IA2
     * @param Opc1
     * @param Opc2
     * @param P1White
     * @param nameEscenario 
     */
    public void setupGame(Boolean J1, Boolean J2, Boolean IA1, Boolean IA2, String Opc1, String Opc2, Boolean P1White, String nameEscenario) {
        ctrlDominio.setupGame(J1, J2, IA1, IA2, Opc1, Opc2, P1White, nameEscenario);
    }
    
    /**
     * Método para cargar una partida
     */
    public void loadGame() {
        String s = ctrlDominio.loadGame();
        if(s.equals("ok")) {
            changeWindow("Partida");
        }
    }
    
    /**
     * Método para realizar un movimiento en una partida
     * @param x
     * @param y 
     */
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
    
    /**
     * Método para mostrar las fichas actuales de cada jugador en una partida
     */
    public void printFichas() {
        int[] moves = ctrlDominio.currentGameMoves();
        
        gameView.setFichas(moves[0], moves[1]);
    }
    
    /**
     * Método para verificar si el juego ha terminado
     */
    public void checkGameisFinished() {
        if(ctrlDominio.currentGameisFinished()) {
            ctrlDominio.updateEstadisticas();
            gameView.stopIATimer();
            gameView.disablePausa();
            gameView.printGameFinished(ctrlDominio.currentGameScores());
            ctrlDominio.borrarPartida();
            gameView.setVisible(false);
            backToMainWindow("Partida");
        }
    }
    
    /**
     * Método que asigna un tiempo a cada jugada de la IA
     */
    public void restartIATimer() {
        if(gameView.getTypeGame().equals("IAvsIA") || (gameView.getTypeGame().equals("PLAYERvsIA") && turnPlayer().equals("IA"))){
                gameView.restartIATimer();
            }
    }

    /**
     * Método para mostrar el movimiento de la ficha en el tablero de partida
     */
    public void redrawTablero() {
        String[] parts = ctrlDominio.getTableroCurrentGame();
        gameView.reloadGrid(parts);
    }
    
    /**
     * Método para mostrar el tipo de partida durante la partida
     */
    public void printTypeGame() {
        String type = ctrlDominio.getTipoPartida();
        gameView.setTypeGame(type);
    }
    
    /**
     * Método para mostrar el turno actual en una partida
     */
    public void printTurn() {
        String turn = ctrlDominio.getTurnoPartida();
        gameView.setTurnGame(String.valueOf(Integer.parseInt(turn)+1));
    }
    
    /**
     * Método para mostrar el turno de la partida
     * @return 
     */
    public String getCurrentGameTurn() {
        return ctrlDominio.getTurnoPartida();
    }
    
    /**
     * Método para mostrar el color del turno en una partida
     */
    public void printColorTurn() {
        String color = ctrlDominio.getTurnoColorPartida();
        gameView.printColorTurn(color);
    }

    /**
     * Método para mostrar los jugadores actuales de una partida
     */
    public void printPlayers() {
        String[] players = ctrlDominio.getJugadoresPartida();
        gameView.printPlayers(players);
    }
    
    /**
     * Método para mostrar el nombre del jugador a quien le toca el turno en una partida
     * @return nombre usuario o IA
     */
    public String turnPlayer() {
        return ctrlDominio.getJugadoresTurno();
    }
    
    /**
     * Método para obtener el historial de las jugadas de una partida
     * @return movimientos de la partida
     */
    public String[] getLogMoves() {
        return ctrlDominio.getLogMoves();
    }
    
    /**
     * Método para guardar una partida
     * @return confirmación
     */
    public String guardarPartida() {
        return ctrlDominio.guardarPartida();
    }
}
