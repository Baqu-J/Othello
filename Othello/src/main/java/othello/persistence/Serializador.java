package othello.persistence;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import othello.domain.Estadistica;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

/**
 * Clase Serializador que gestiona la conversión de objetos en datos que se 
 * almacenan para que posteriormente puedan ser leídos y restaurar el objeto
 * original
 * 
 * @author Jaume Baqueró Quesada
 */
public class Serializador {
    
    private static Gson serializador;
   
    /**
     * Función que actualiza la Estadistica de un jugador y lo guarda en 
     * el archivo de datos correspondiente
     * @param n
     * @return 1:ejecutado satisfactoriamente, 0:error
     */
    public int updateJSONfromEstadistica(Estadistica n){
        int ret = 1;
        try{
            File directory = new File("JSON/Ranking/");
            if(!directory.exists()) directory.mkdirs();
            File json = new File("JSON/Ranking/" + n.getId() + ".json");
            json.createNewFile() ;
            serializador = new Gson();
            FileWriter w = new FileWriter(json.getPath(), false);
            w.write(serializador.toJson(n));
            w.close();
        }
        catch(IOException io) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que desde un objeto Estadística guarda la información que ésta
     * contiene en el archivo de datos correspondiente.
     * @param n
     * @return 1:ejecutado satisfactoriamente, -1:error, 0:Exeception
     */
    public int createJSONfromEstadistica(Estadistica n){
        int ret = 1;
        try{
            File directory = new File("JSON/Ranking/");
            if(!directory.exists()) {directory.mkdirs(); directory.setWritable(true, false);}
            File json = new File("JSON/Ranking/" + n.getId() + ".json");
            if(json.createNewFile()) {
                serializador = new Gson();
                FileWriter w = new FileWriter(json.getPath(), false);
                w.write(serializador.toJson(n));
                w.close();
            }
            else ret = -1;
        }
        catch(IOException io) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que obtiene el objeto Estadística si este existe
     * @param e
     * @param path
     * @return 1:ejecutado satisfactoriamente, -1:no existe archivo, 0:Exeception
     */
    public int getEstadisticafromFile(Estadistica e, String path) {
        int ret = 1;
        try {
            File f = new File(path);
            if(f.exists()){
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
                Estadistica aux = serializador.fromJson(json, Estadistica.class);
                e.setAll(aux.getId(), aux.getPassword(), aux.getPuntos(), aux.getVictoria(), aux.getDerrota(), aux.getEmpate());
            }
            else ret = -1;
        }
        catch(FileNotFoundException f) {
            ret = 0;
        }
        
        return  ret;
        
    }
    
    /**
     * Función que desde un objeto Partida guarda la información que ésta
     * contiene en el archivo de datos correspondiente.
     * @param n
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int createJSONfromPartida(Partida n) {
        int ret = 1;
        try{
            File directory = new File("JSON/Partida/");
            if(!directory.exists()) directory.mkdirs();
            File json = new File("JSON/Partida/SavedGame.json");
            json.createNewFile();
            serializador = new Gson();
            FileWriter w = new FileWriter(json.getPath(), false);
            w.write(serializador.toJson(n));
            w.close();
        }
        
        catch(IOException io) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que obtiene el objeto Partida si este existe.
     * @param p
     * @return 1:ejecutado satisfactoriamente, -1:no existe archivo, 0:Exeception
     */
    public int getPartidafromFile(Partida p) {
        int ret = 1;
        try{
            File f = new File("JSON/Partida/SavedGame.json");
            if(f.exists()) {
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
               Partida aux = serializador.fromJson(json, Partida.class);
               p.setAll(aux.getType(), aux.getT(), aux.getTurn(), aux.getIa1(), aux.getIa2(), aux.getJ1(), aux.getJ2());
            }
            else ret = -1;
        }
        catch(FileNotFoundException f) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que actualiza un Escenario guardado.
     * @param e
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int updateJSONfromEscenario(Escenario e){
        int ret = 1;
        try{
            File directory = new File("JSON/Escenarios/");
            if(!directory.exists()) directory.mkdirs();
            File json = new File("JSON/Escenarios/" + e.getId() + ".json");
            json.createNewFile() ;
            serializador = new Gson();
            FileWriter w = new FileWriter(json.getPath(), false);
            w.write(serializador.toJson(e));
            w.close();
        }
        catch(IOException io) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que desde un objeto Escenario guarda la información que ésta
     * contiene en el archivo de datos correspondiente.
     * @param e
     * @return 1:ejecutado satisfactoriamente, 0:Exeception
     */
    public int createJSONfromEscenario(Escenario e) {
        int ret = 1;
        try {
            File directory = new File("JSON/Escenarios/");
            if(!directory.exists()) directory.mkdirs();
            File json = new File("JSON/Escenarios/" + e.getId() + ".json");
            if(json.createNewFile()) {
                serializador = new Gson();
                FileWriter w = new FileWriter(json.getPath(), false);
                w.write(serializador.toJson(e));
                w.close();
            }
            else ret = -1;
        }
        catch(IOException io) {
            ret = 0;
        }
        return ret;
    }
    
    /**
     * Función que obtiene el objeto Escenario si éste existe.
     * @param e
     * @param path
     * @return 1:ejecutado satisfactoriamente, -1:no existe archivo, 0:Exeception
     */
    public int getEscenariofromFile(Escenario e, String path) {
        int ret = 1;
        try {
            File f = new File(path);
            if(f.exists()) {
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
                Escenario aux = serializador.fromJson(json, Escenario.class);
                e.setAll(aux.getId(), aux.getTab(), aux.getPop());
            }
            else ret = -1;
        }
        catch(FileNotFoundException f) {
            ret = 0;
        }
        return ret;
    }
    
}
