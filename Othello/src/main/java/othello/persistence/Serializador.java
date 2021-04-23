/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.persistence;

import com.google.gson.Gson;
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
public class Serializador {
    private static Gson serializador;
   
    
    public void createJSONfromJugador(Jugador n) throws IOException {
        File json = new File("JSON/Ranking/" + Jugador.getId() + ".json");
        json.createNewFile();
        serializador = new Gson();
        FileWriter w = new FileWriter(json.getPath());
        w.write(serializador.toJson(n.Estadistiques()));
        w.close();
    }
    
    public Estadistica getEstadisticafromFile(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner reader = new Scanner(f);
        String json = reader.next();
        serializador = new Gson();
        return serializador.fromJson(json, Estadistica.class);
    }
    
    public void createJSONfromPartida(Partida n) throws IOException {
        File json = new File("JSON/Partida/SavedGame.json");
        json.createNewFile();
        serializador = new Gson();
        FileWriter w = new FileWriter(json.getPath());
        w.write(serializador.toJson(n));
        w.close();
    }
    
    public Partida getPartidafromFile() throws FileNotFoundException {
        File f = new File("JSON/Partida/SavedGame.json");
        Scanner reader = new Scanner(f);
        String json = reader.next();
        serializador = new Gson();
        return serializador.fromJson(json, Partida.class);
    }
    
    public void createJSONfromEscenario(Escenario e) throws IOException {
        File json = new File("JSON/Escenarios/" + e.getId() + ".json");
        json.createNewFile();
        serializador = new Gson();
        FileWriter w = new FileWriter(json.getPath());
        w.write(serializador.toJson(e));
        w.close();
    }
    
    public Escenario getEscenariofromFile(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner reader = new Scanner(f);
        String json = reader.next();
        serializador = new Gson();
        return serializador.fromJson(json, Escenario.class);
    }
    
}
