package algoritmit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class minimaxTest {

    private String[][] lauta;
    private Minimax minimax;

    public minimaxTest() {
        lauta = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "_", "_"}};
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
        assertEquals("2 2", minimax.parasLiike(lauta, "X"));
    }

    @Test
    public void parasLiikeOMerkilla() {
        assertEquals("2 1", minimax.parasLiike(lauta, "O"));
    }

}
