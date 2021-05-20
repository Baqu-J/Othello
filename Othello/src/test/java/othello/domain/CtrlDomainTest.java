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
import othello.data.Pair;
import othello.domain.tablero.Escenario;

/**
 *
 * @author Aleix
 */
public class CtrlDomainTest {

    private ArrayList<Estadistica> perfiles;

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
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class CtrlDomain.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        CtrlDomain expResult = null;
        CtrlDomain result = CtrlDomain.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearPerfil method, of class CtrlDomain.
     */
    @Test
    public void testCrearPerfil() {
        System.out.println("crearPerfil");
        String nombre = "";
        String password = "";
        CtrlDomain instance = null;
        int expResult = 1;
        int result = instance.crearPerfil(nombre,password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchEstadistica method, of class CtrlDomain.
     */
    @Test
    public void testSearchEstadistica() {
        System.out.println("searchEstadistica");
        String nombre = "";
        CtrlDomain instance = null;
        String expResult = null;
        String result = instance.consultaPerfil(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarPerfil method, of class CtrlDomain.
     */
    @Test
    public void testBorrarPerfil() {
        System.out.println("borrarPerfil");
        String nombre = "";
        String password = "";
        CtrlDomain instance = null;
        int expResult = 1;
        int result = instance.borrarPerfil(nombre,password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DisplayRanking method, of class CtrlDomain.
     */
    @Test
    public void testDisplayRanking() {
        System.out.println("DisplayRanking");
        CtrlDomain instance = null;

        Comparator c = (Comparator<Estadistica>) (Estadistica o1, Estadistica o2) -> o2.getPuntos() - o1.getPuntos();
        Collections.sort(perfiles, c);

        ArrayList<Estadistica> result = instance.displayRanking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
