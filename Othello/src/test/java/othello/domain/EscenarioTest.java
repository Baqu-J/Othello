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
public class EscenarioTest {
    private Escenario escenario;
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         escenario = new Escenario("test");
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testUndoWhenNotPossible() {
        System.out.println("Test undo when not possible:");
        escenario.undo();
        assertEquals(new Escenario("").getTop(), escenario.getTop());
        
    }
    @Test
    public void testRedoWhenNotPossible() {
        System.out.println("Test redo when not possible:");
        escenario.redo();
        assertEquals(new Escenario("test").getTop(), escenario.getTop());
        
    }
    @Test
    public void testPlayAfterUndo() {
        System.out.println("Test play after undo:");
        escenario.commitPlay(new Pair(2, 3), Casilla.NEGRA);
        escenario.undo();
        escenario.commitPlay(new Pair(5, 4), Casilla.NEGRA);
        Tablero aux = escenario.getTop().DeepCopy();
        escenario.redo();
        escenario.undo();
        escenario.redo();
        assertEquals(aux, escenario.getTop());
    
    }
}
