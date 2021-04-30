package othello.persistence;

import java.io.File;
import java.util.ArrayList;
import othello.domain.Estadistica;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

/**
 * Clase CtrlPersistence que gestiona el almacenamiento de datos
 * @author Franco Acevedo Montañez
 */
public class CtrlPersistence {
   
    // Attributes
    private final Serializador serializador;
    private static CtrlPersistence instance;
    
    public static CtrlPersistence getInstance() {
        if (instance == null) {
            instance = new CtrlPersistence();
        }
        return instance;
    }
    
    // Private Constructor
    /**
     * Constructor por defecto del CtrlPersistence
     */
    private CtrlPersistence() {
        serializador = new Serializador();
    }
    
    //methods
    /**
     * Función que almacena un perfil de usuario.
     * @param e
     * @return 1:ejecutado satisfactoriamente, -1:error, 0:Exeception
     */
    public int CrearPerfil(Estadistica e) { //Check si perfil existe    
        int resp = serializador.createJSONfromEstadistica(e);
        return resp;
    }
    
    /**
     * Función que borra un perfil de usuario almacenado si existe.
     * @param nombre
     * @return 1:borrado exitosamente, -1:no existe usuario o no se puede borrar
     */
    public int BorrarPerfil(String nombre) { //Check si perfil existe
        Boolean success = false;
        File file = new File("JSON/Ranking/" + nombre +".json");

        if(file.exists()) success = file.delete();
    
        if(success) return 1;
        else return -1;
    }
    
    /**
     * Función que carga todos los usuarios almacenados en una lista.
     * @return lista de usuarios con sus estadisticas respectivas.
     */
    public ArrayList CargarPerfiles() {
        ArrayList<Estadistica> perfiles = new ArrayList();
        File dir = new File("JSON/Ranking");
        if(dir.exists()) {
            
            File[] list = dir.listFiles();
            for(int i = 0; i < list.length; ++i) {
                Estadistica e = new Estadistica("");
                serializador.getEstadisticafromFile(e, list[i].getPath());
                perfiles.add(e);
            }
        }
        return perfiles;
    }
    
    /**
     * Función que carga todos lo escenarios almacenados.
     * @return lista de escenarios.
     */
    public ArrayList CargarEscenarios() {
        ArrayList<Escenario> escenarios = new ArrayList();
        File dir = new File("JSON/Escenarios");
        if(dir.exists()) {
            
            File[] list = dir.listFiles();
            for(int i = 0; i < list.length; ++i) {
                Escenario e = new Escenario("");
                serializador.getEscenariofromFile(e, list[i].getPath());
                escenarios.add(e);
            }
        }
        return escenarios;
    }
    
    /**
     * Función que almacena un Escenario.
     * @param e
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int CrearEscenario(Escenario e) {
        int resp = serializador.createJSONfromEscenario(e);
        return resp;
    }
    
    /**
     * Función que modifica y guarda un escenario ya almacenado.
     * @param e
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int GuardarEscenario(Escenario e) {
        return serializador.updateJSONfromEscenario(e);
    }
    
    /**
     * Función que actualiza la información de un usuario ya almacenado 
     * @param e
     * @return 1:ejecutado satisfactoriamente, 0:error
     */
    public int GuardarPerfil(Estadistica e) {
        return serializador.updateJSONfromEstadistica(e);
    }
    
    /**
     * Función que almacena un partida.
     * @param p
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int GuardarPartida(Partida p) {
        int ret = serializador.createJSONfromPartida(p);
        return ret;
    }
    
    /**
     * Función que obtiene una Partida que está almacenada si existe.
     * @return Partida
     */
    public Partida CargarPartida() {
        Partida p = new Partida();
        int ret = serializador.getPartidafromFile(p);
        if(ret == 1) return p;
        return null;
    }
}