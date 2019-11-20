package pelilauta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelilautaTest {

    private Pelilauta pelilauta;

    @Before
    public void setUp() {
        this.pelilauta = new Pelilauta(3);
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
