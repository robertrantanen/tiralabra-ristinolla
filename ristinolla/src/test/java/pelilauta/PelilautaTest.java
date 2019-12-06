package pelilauta;

import algoritmit.Minimax;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    private Pelilauta pelilauta;
    private Minimax minimax;

    @Before
    public void setUp() {
        this.pelilauta = new Pelilauta(3);
        this.minimax = new Minimax();
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

    @Test
    public void lisaaMerkkiTestiMinimaxinKanssa() {
        this.pelilauta = new Pelilauta(3);
        pelilauta.lisaaMerkki("X", 0, 0);
        pelilauta.lisaaMerkki("O", 0, 1);
        pelilauta.lisaaMerkki("X", 1, 1);
        assertEquals("2 2", minimax.parasLiike(pelilauta.getLauta(), "O"));
    }
}
