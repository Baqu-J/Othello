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

    /*public TestingAdd(double e, double v1, double v2) {
        this.expected = e;
        this.valueOne = v1;
        this.valueTwo = v2;
    }

    @Parameters
    public static Collection<Double[]> getTestParameters() {
        return Arrays.asList(new Double[][]{
            {0.0, 1.0, -1.0}, // expected, valueOne, valueTwo
            {10.0, 90.0, -80.0},
            {100.0, -1000.0, 1100.0},
            {5.0, 2.0, 3.0},
            {2.0, 1.0, 1.0}});
    }

    @Test
    public void add() {
        Calculator calculator = new Calculator();
        assertEquals(expected, calculator.add(valueOne, valueTwo), 0);
    }*/

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
        Estadistica expResult = null;
        Estadistica result = instance.searchEstadistica(nombre);
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
        /*for ( ) {
            assertEquals();
        }*/
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
