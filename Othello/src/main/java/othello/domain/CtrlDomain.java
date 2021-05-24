package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.tablero.Escenario;
import othello.domain.tablero.Tablero;
import othello.persistence.CtrlPersistence;

/**
 *
 * @author Aleix Velasco Calvo
 */
public class CtrlDomain {

    // Attributes
    private static CtrlDomain instance;
    private CtrlPersistence ctrlPersistencia;

    private ArrayList<Estadistica> perfiles;
    private ArrayList<Escenario> escenarios;
    private Partida currentGame;
    private Escenario currentEscenario;

    /**
     * Método que crea una única instancia de CtrlDomain.
     *
     * @return Instancia de la clase CtrlDomain.
     */
    public static CtrlDomain getInstance() {
        if (instance == null) {
            instance = new CtrlDomain();
        }
        return instance;
    }

    // Private Constructor
    private CtrlDomain() {
        ctrlPersistencia = CtrlPersistence.getInstance();

        cargarUsuarios();
        cargarEscenarios();
    }

    // Others Methods
    /**
     * Método que carga todas las Estadisticas.
     */
    private void cargarUsuarios() {
        perfiles = ctrlPersistencia.CargarPerfiles();
    }

    /**
     * Método que guarda cada Estadistica.
     */
    public void guardarUsuarios() {
        for (Estadistica e : perfiles) {
            ctrlPersistencia.GuardarPerfil(e);
        }
    }
    
    /**
     * Función que crea una Estadistica si no existe ninguna con el mismo id y lo
     * añade al listado perfiles y crea su archivo.
     *
     * @param nombre id de la Estadistica
     * @param password
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int crearPerfil(String nombre, String password) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e == null) {
            e = new Estadistica(nombre,password);
            ret = ctrlPersistencia.CrearPerfil(e);
            if (ret == 1) {
                perfiles.add(e);
            }
        }
        return ret;
    }

    /**
     * Función que elimina una Estadistica del listado perfiles y su archivo.
     *
     * @param nombre id de la Estadistica
     * @param password
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int borrarPerfil(String nombre, String password) {
        int ret = -1;
        Estadistica e = searchEstadistica(nombre);
        if (e != null){
            if(password == null ? e.getPassword() == null : password.equals(e.getPassword())){
                ret = ctrlPersistencia.BorrarPerfil(nombre);
                if (ret == 1) {
                    perfiles.remove(e);
                }
            }
        }
        return ret;
    }
    
    /**
     * Función para obtener el ranking actual
     * @return ranking
     */
    public ArrayList<String> getRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);
        ArrayList<String> ranking = new ArrayList<>(); 
        int pos = 1;
        for (int i = 0; i < perfiles.size(); i++) { 
            ranking.add("<html>" + pos + "-" + perfiles.get(i).toStringRanking());
            ++pos;
        }
        return ranking;
    }
    
    /**
     * Método que devulve todos las Estadisticas.
     *
     * @return Listado de Estadisticas.
     */
    public Iterable<Estadistica> listPerfiles() {
        return perfiles;
    }

    /**
     * Método que busca una Estadistica en el listado de perfiles.
     *
     * @param nombre id de la Estadistica
     * @return Devuelve una Estadistica si existe, si no un null.
     */
    public Estadistica searchEstadistica(String nombre) {
        for (Estadistica p : perfiles) {
            if (p.getId().equals(nombre)) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Función para consultar las estadísticas de un perfil
     * @param nombre
     * @return estadisticas de "nombre"
     */
    public String consultaPerfil(String nombre) {
        Estadistica p = searchEstadistica(nombre);
        if(p !=null) return ("<html>" + p.getId() + "<p>Puntos: " + p.getPuntos() + "<p>Victorias: " + p.getVictoria() + "<p>Derrotas: " + p.getDerrota() + "<p>Empates: " + p.getEmpate() + "<html>");
        return "";
    }
    
    /**
     * Método que carga todos los Escenarios.
     */
    private void cargarEscenarios() {
        escenarios = ctrlPersistencia.CargarEscenarios();
    }

    /**
     * Método que guarda cada Escenario.
     */
    public void guardarEscenarios() {
        for (Escenario e : escenarios) {
            ctrlPersistencia.GuardarEscenario(e);
        }
    }

    /**
     * Función que crea un Escenario si no existe ningunO con el mismo id y lo
     * añade al listado ESCENARIOS y crea su archivo.
     *
     * @param nombre id deL Escenario
     * @return -1 en caso de error y 1 en caso de operación realizada con éxito.
     */
    public int crearEscenario(String nombre) {

        int ret = -1;
        Escenario e = searchEscenario(nombre);
        if (e == null) {
            e = new Escenario(nombre);
            ret = ctrlPersistencia.CrearEscenario(e);
            if (ret == 1) {
                escenarios.add(e);
            }
        }
        return ret;
    }
    
    /**
     * Función para borrar un escenario
     * @param nombre
     * @return 1:Borrado satisfactoriamente, -1:Escenario no existe o no se pudo borrar
     */
    public int borrarEscenario(String nombre) {
        int ret = -1;
        Escenario e = searchEscenario(nombre);
        if (e != null){
            
                ret = ctrlPersistencia.BorrarEscenario(nombre);
                if (ret == 1) {
                    escenarios.remove(e);
                }
        }
        return ret;
    }

    /**
     * Método que devulve todos las Estadisticas.
     *
     * @return Listado de Estadisticas.
     */
    public Iterable<Escenario> listEscenarios() {
        return escenarios;
    }

    /**
     * Función que retorna una lista con todos los escenario actuales
     * @return lista escenarios
     */
    public ArrayList<String> getEscenarios() {
        ArrayList<String> esc = new ArrayList<>(); 
        for (int i = 0; i < escenarios.size(); i++) { 
            esc.add(escenarios.get(i).toStringGrid());
        }
        return esc;
    }
    
    /**
     * Método que busca un Escenario en el listado de escenarios.
     *
     * @param nombre id del Escenario
     * @return Devuelve un Escenario si existe, si no un null.
     */
    private Escenario searchEscenario(String nombre) {
        for (Escenario e : escenarios) {
            if (e.getId().equals(nombre)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Método para cargar el Escenario con id "name"
     * @param name 
     */
    public void setCurrentEscenario(String name){
        currentEscenario = searchEscenario(name);
    }
    
    /**
     * Función para obtener el escenario actual
     * @return escenario
     */
    public String[] getCurrentEscenarioGrid() {
        String[] parts = currentEscenario.toStringGrid().split(",");
        return parts;
    }
    
    /**
     * Método para deshacer un movimiento en un escenario 
     */
    public void undoCurrentEscenario() {
        currentEscenario.undo();
    }
    
    /**
     * Método para rehacer un movimiento en un escenario
     */
    public void reCurrentEscenario() {
        currentEscenario.redo();
    }
    
    /**
     * Método para realizar un movimiento en un escenario
     * @param first
     * @param second 
     */
    public void CommitPlayCurrentEscenario(int first, int second) {
        currentEscenario.commitPlay(new Pair(first, second), currentEscenario.getColor());
    }
    
    /**
     * Función para comprobar el turno en un partida
     * @param p:Partida
     * @return true:turno correcto, false:turno incorrecto
     */
    public boolean turno(Partida p) {
        if (p.getType() == Partida.GameType.PLAYERvsPLAYER) {
            return true;
        }
        if (p.getJ1() == null) {
            if (p.getTurn() % 2 == 1) {
                return true;
            }
        } else {
            if (p.getTurn() % 2 == 0) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Función para obtener el tipo de partida
     * @return tipo de partida(texto)
     */
    public String getTipoPartida() {
        return currentGame.getType().toString();
    }
    
    /**
     * Función para obtener el turno actual en la partida
     * @return turno(texto)
     */
    public String getTurnoPartida() {
        return String.valueOf(currentGame.getTurn());
    }
    
    /**
     * Función para obtener el color del turno de la partida
     * @return turnoColor(texto)
     */
    public String getTurnoColorPartida() {
        return currentGame.getColorTurn();
    }
    
    /**
     * Función para obtener los jugadores de una partida
     * @return jugadores(texto)
     */
    public String[] getJugadoresPartida() {
         return currentGame.getPlayers().split(",");
    }
    
    /**
     * Función para obtener el jugador con el turno actual
     * @return Jugador en turno(texto)
     */
    public String getJugadoresTurno() {
         return currentGame.getPlayerTurn();
    }

    /**
     * Función para colocar una ficha en el tablero
     * @param x
     * @param y
     * @return confirmación de dicho movimiento
     */
    public String colocarFicha(int x, int y) {
        String ret = "";
        Pair p = new Pair(x,y);
        int r = currentGame.move(p);
        switch (r) {
            case -1:
                ret = "No tengo movimientos";
                break;
            case 0:
                ret = "Movimiento Ilegal"; 
                break;
            default:
                ret = "Movimiento Realizado";
                break;
        }
        return ret;
    }

    /**
     * Función para guardar una partida
     * @return confirmación de si se guardó o no la partida
     */
    public String guardarPartida() {
        String ret = "Error al guardar Partida";
        int r = ctrlPersistencia.GuardarPartida(currentGame);
        if(r == 1) {
            ret = "Partida guardada corectamente";
        }
        return ret;
    }

    /**
     * Función para cargar una partida
     * @return partida elegida
     */
    public Partida cargarPartida() {
        return ctrlPersistencia.CargarPartida();
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
        Partida.GameType gt;
        if(J1 && J2) gt = Partida.GameType.PLAYERvsPLAYER;
        else if(IA1 && IA2) gt = Partida.GameType.IAvsIA;
        else gt = Partida.GameType.PLAYERvsIA;
        
        Jugador j1 = null;
        if(J1) {
            Casilla c1;
            if(P1White) c1 = Casilla.BLANCA;
            else c1 = Casilla.NEGRA;
            if(Opc1.equals("Guest")) j1 = new Jugador(c1);
            else {
                Estadistica e = searchEstadistica(Opc1);
                j1 = new Jugador(e, c1);
            }
        }
        
        IA ia1 = null;
        if(IA1) {
            Casilla c1;
            if(P1White) c1 = Casilla.BLANCA;
            else c1 = Casilla.NEGRA;
            if(Opc1.equals("Facil")) ia1 = new IA(IA.Dificultad.FACIL, c1);
            else if(Opc1.equals("Normal")) ia1 = new IA(IA.Dificultad.NORMAL, c1);
            else ia1 = new IA(IA.Dificultad.DIFICIL, c1);
        }
        
        Jugador j2 = null;
        if(J2) {
            Casilla c2;
            if(P1White) c2 = Casilla.NEGRA;
            else c2 = Casilla.BLANCA;
            if(Opc2.equals("Guest")) j2 = new Jugador(c2);
            else {
                Estadistica e = searchEstadistica(Opc2);
                j2 = new Jugador(e, c2);
            }
        }
        IA ia2 = null;
        if(IA2) {
            Casilla c2;
            if(P1White) c2 = Casilla.NEGRA;
            else c2 = Casilla.BLANCA;
            if(Opc2.equals("Facil")) ia2 = new IA(IA.Dificultad.FACIL, c2);
            else if(Opc2.equals("Normal")) ia2 = new IA(IA.Dificultad.NORMAL, c2);
            else ia2 = new IA(IA.Dificultad.DIFICIL, c2);
        }
        
        if(nameEscenario.equals("Tablero standard")) {
            if(gt == Partida.GameType.PLAYERvsPLAYER) currentGame = new Partida(gt, new Tablero(), 0, j1, j2);
            else if (gt == Partida.GameType.IAvsIA) currentGame = new Partida(gt, new Tablero(), 0, ia1, ia2);
            else {
                if(J1) {
                    currentGame = new Partida(gt, new Tablero(), 0, ia2, j1);
                }
                else currentGame = new Partida(gt, new Tablero(), 0, ia1, j2);
            }
        }
        
        else {
            Tablero t = searchEscenario(nameEscenario).getTop();
            if(gt == Partida.GameType.PLAYERvsPLAYER) currentGame = new Partida(gt, t, 0, j1, j2);
            else if (gt == Partida.GameType.IAvsIA) currentGame = new Partida(gt, t, 0, ia1, ia2);
            else {
                if(J1) {
                    currentGame = new Partida(gt, t, 0, ia2, j1);
                }
                else currentGame = new Partida(gt, t, 0, ia1, j2);
            }
            
        }
    }
    
    /**
     * Función para cargar una partida
     * @return confirmación de la acción
     */
    public String loadGame() {
        Partida p = cargarPartida();
        if(p == null) return "error";
        else {
            currentGame = p;
            return "ok";
        }
    }
    
    /**
     * Función para mostrar el ranking actual
     * @return lista de jugadores con estadisticas
     */
    public ArrayList<Estadistica> displayRanking() {
        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);
        return perfiles;
    }
    
    /**
     * Método para obtener el tablero actual
     * @return tablero(texto)
     */
    public String[] getTableroCurrentGame() {
        //System.out.println(currentGame);
        return currentGame.getT().toString().split(",");
    }
    
    /**
     * Función para obtener el score de una partida
     * @return score (texto)
     */
    public int[] currentGameScores() {
        int[] res = new int[2];
        
        res[0] = currentGame.getT().getNegras().size();
        res[1] = currentGame.getT().getBlancas().size();
        
        return res;
    }
    
    /**
     * Función que verifica si una partida ha terminado
     * @return true:Partida terminada, false:Partida en curso
     */
    public Boolean currentGameisFinished() {
        return currentGame.gameIsFinished();
    }
    
    /**
     * Método para actualizar estadísticas al finalizar una partida
     */
    public void updateEstadisticas() {
        currentGame.updateEstadisticas();
    }
    
    /**
     * Función para obtener número de fichas actuales de cada jugador para colocar
     * en el tablero
     * @return fichas de cada jugador
     */
    public int[] currentGameMoves() {
        return currentGame.getFichas();
    }
}
