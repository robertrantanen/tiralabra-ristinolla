package algoritmit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pelilauta.Pelilauta;

public class minimaxTest {

    private String[][] lauta;
    private String[][] lauta2;
    private Pelilauta lauta3;
    private Minimax minimax;

    public minimaxTest() {
        lauta = new String[][]{
            {"X", "X", "_"},
            {"O", "O", "_"},
            {"X", "O", "_"}};
        lauta2 = new String[][]{
            {"_", "_", "X"},
            {"_", "O", "X"},
            {"O", "_", "_"}};
        lauta3 = new Pelilauta(5);
        minimax = new Minimax();
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
    public void parasLiikeXMerkilla() {
        assertEquals("0 2", minimax.parasLiike(lauta, "X"));
    }

    @Test
    public void parasLiikeOMerkilla() {
        assertEquals("1 2", minimax.parasLiike(lauta, "O"));
    }

    @Test
    public void algoritmiValitseeNopeimmanVoiton() {
        assertEquals("2 2", minimax.parasLiike(lauta2, "X"));
    }

    @Test
    public void laudanTulosTesti() {
        assertEquals(0, minimax.laudanTulos(lauta2));
    }

    @Test
    public void tyhjiaJaljellaTesti() {
        assertEquals(5, minimax.tyhjiaJaljella(lauta2));
    }

    @Test
    public void aloitusSyvyysTesti() {
        assertEquals(10, minimax.aloitusSyvyys(lauta));
    }

    @Test
    public void aloitusSyvyysIsollaLaudalla() {
        assertEquals(2, minimax.aloitusSyvyys(lauta3.getLauta()));
    }

}
