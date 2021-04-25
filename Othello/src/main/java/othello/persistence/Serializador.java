/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.persistence;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import othello.domain.Estadistica;
import othello.domain.Jugador;
import othello.domain.Partida;
import othello.domain.tablero.Escenario;

/**
 *
 * @author Foster
 */
public class Serializador { //CHECK IF FOLDER EXISTS IF NOT MAKE IT
    private static Gson serializador;
   
    
    public int createJSONfromEstadistica(Estadistica n){
        int ret = 1;
        try{
            File json = new File("JSON/Ranking/" + n.getId() + ".json");
            if(json.createNewFile()) {
                serializador = new Gson();
                FileWriter w = new FileWriter(json.getPath());
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
    
    public int getEstadisticafromFile(Estadistica e, String path) {
        int ret = 1;
        try {
            File f = new File(path);
            if(f.exists()){
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
                e = serializador.fromJson(json, Estadistica.class);
            }
            else ret = -1;
        }
        catch(JsonSyntaxException | FileNotFoundException f) {
            ret = 0;
        }
        
        return  ret;
        
    }
    
    public int createJSONfromPartida(Partida n) {
        int ret = 1;
        try{
            File json = new File("JSON/Partida/SavedGame.json");
            if(json.createNewFile()) {
                serializador = new Gson();
                FileWriter w = new FileWriter(json.getPath());
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
    
    public int getPartidafromFile(Partida p) {
        int ret = 1;
        try{
            File f = new File("JSON/Partida/SavedGame.json");
            if(f.exists()) {
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
                p = serializador.fromJson(json, Partida.class);
            }
            else ret = -1;
        }
        catch(FileNotFoundException f) {
            ret = 0;
        }
        return ret;
    }
    
    public int createJSONfromEscenario(Escenario e) {
        int ret = 1;
        try {
            File json = new File("JSON/Escenarios/" + e.getId() + ".json");
            if(json.createNewFile()) {
            serializador = new Gson();
            FileWriter w = new FileWriter(json.getPath());
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
    
    public int getEscenariofromFile(Escenario e, String path) {
        int ret = 1;
        try {
            File f = new File(path);
            if(f.exists()) {
                Scanner reader = new Scanner(f);
                String json = reader.next();
                serializador = new Gson();
                e = serializador.fromJson(json, Escenario.class);
            }
            else ret = -1;
        }
        catch(FileNotFoundException f) {
            ret = 0;
        }
        return ret;
    }
    
}
