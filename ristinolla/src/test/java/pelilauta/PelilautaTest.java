package pelilauta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    private Pelilauta pelilauta;

    public PelilautaTest() {
        this.pelilauta = new Pelilauta(3);
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

    @Test
    public void konskruktoriLuoOikeanKokoisenLaudan() {
        assertEquals(3, pelilauta.getLauta().length);
    }

    @Test
    public void lisaaMerkkiTesti() {
        pelilauta.lisaaMerkki("X", 1, 0);
        assertEquals("X", pelilauta.getLauta()[1][0]);
    }

}
