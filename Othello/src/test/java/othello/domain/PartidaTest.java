/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import othello.data.Casilla;
import othello.data.Pair;
import othello.domain.tablero.Escenario;
import othello.domain.tablero.Tablero;

/**
 *
 * @author Foster
 */
public class PartidaTest {
    private Partida partida;
    
     @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Jugador j1 = new Jugador(Casilla.NEGRA);
        Jugador j2 = new Jugador(Casilla.BLANCA);
        partida = new Partida(Partida.GameType.PLAYERvsPLAYER, new Tablero(), 0, j1, j2);
    }

    @After
    public void tearDown() {
        partida = null;
    }
    
    @Test
    public void testIllegalPlayDoesntCommit() {
        System.out.println("Test jugada ilegal no se ejecuta:");
        partida.move(new Pair(0, 0));
        assertEquals(new Tablero(), partida.getT());
        
    }
    @Test
    public void testIllegalPlayDoesntAdvanceTurn() {
        System.out.println("Test jugada ilegal no avanza turno:");
        partida.move(new Pair(0, 0));
        assertEquals(0, partida.getTurn());
    }
    @Test
    public void testGameChecksAvailableMoves() {
        System.out.println("Test Partida gestiona falta de jugadas disponibles correctamente");
        Tablero t = new Tablero();
        t.commitPlay(new Pair(2, 3), Casilla.NEGRA);
        Jugador j1 = new Jugador(Casilla.NEGRA);
        Jugador j2 = new Jugador(Casilla.BLANCA);
        partida = new Partida(Partida.GameType.PLAYERvsPLAYER, t, 0, j1, j2);
        partida.move(new Pair(5, 4));
        assertEquals(true, partida.gameIsFinished());
    }
    
}
