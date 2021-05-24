package othello.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aleix
 */
public class CtrlDomainTest {

    CtrlDomain instance;
    private double expected, valueOne, valueTwo;

    public CtrlDomainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
         instance = CtrlDomain.getInstance();
    }

    @After
    public void tearDown() {
    }

    
    /**
     * Test of crearPerfil method, of class CtrlDomain.
     */
    @Test
    public void testCrearPerfil() {
        System.out.println("crearPerfil");
        String nombre = "franco";
        String password = "acevedo";
        int expResult = -1;
        //USUARIO YA EXISTE
        int result = instance.crearPerfil(nombre,password);
        assertEquals(expResult, result);
    }

    /**
     * Test of searchEstadistica method, of class CtrlDomain.
     */
    @Test
    public void testSearchEstadistica() {
        System.out.println("searchEstadistica");
        String nombre = "";
        String expResult = "<html><p>Puntos: 0<p>Victorias: 0<p>Derrotas: 0<p>Empates: 0<html>";
        String result = instance.consultaPerfil(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrarPerfil method, of class CtrlDomain.
     */
    @Test
    public void testBorrarPerfil() {
        System.out.println("borrarPerfil");
        String nombre = "";
        String password = "";
        int expResult = -1;
        int result = instance.borrarPerfil(nombre,password);
        assertEquals(expResult, result);
    }

    /**
     * Test of DisplayRanking method, of class CtrlDomain.
     */
    @Test
    public void testDisplayRanking() {
        System.out.println("DisplayRanking");

        ArrayList<Estadistica> result = instance.displayRanking();
        assertEquals(instance.listPerfiles(), result);
    }
}
