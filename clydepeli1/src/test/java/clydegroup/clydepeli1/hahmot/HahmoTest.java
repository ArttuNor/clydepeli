package clydegroup.clydepeli1.hahmot;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HahmoTest {

    List<Hyokkays> hyokkayslista = new ArrayList<>();
    List<String> heikkouslista = new ArrayList<>();
    List<String> vahvuuslista = new ArrayList<>();
    Hahmo h = new Hahmo("mauri", 3, hyokkayslista, heikkouslista, vahvuuslista,
            ".");

    public HahmoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hyokkayslista.add(new Hyokkays("hyokkays1", 1, "oletus"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getHyokkayslistaToimii() {
        assertEquals(hyokkayslista, h.getHyokkaykset());
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("mauri", h.getNimi());
    }

    @Test
    public void konstruktoriAsettaaHpnOikein() {
        assertEquals(3, h.getHp());
    }

    @Test
    public void konstruktoriAsettaaHyokkayksetOikein() {
        assertEquals(hyokkayslista, h.getHyokkaykset());
    }

    @Test
    public void menetaElamaaVahentaaOikeanMaaran() {
        h.menetaElamaa(1);
        assertEquals(2, h.getHp());

    }

    @Test
    public void menetaElamaaEiVahennaAlleNollan() {
        h.menetaElamaa(5);
        assertEquals(0, h.getHp());

    }

    @Test
    public void opiHyokkaysLisaaHyokkayksen() {
        Hyokkays hyokkays2 = new Hyokkays("hyokkays2", 3, "oletus");
        h.opiHyokkays(hyokkays2);
        hyokkayslista.add(hyokkays2);

        assertEquals(hyokkayslista, h.getHyokkaykset());
    }

    @Test
    public void kaytaHyokkaystaVahentaaKohteenElamaa() {
        Hahmo hyokkaaja = new Hahmo("mauri", 3, hyokkayslista, heikkouslista,
        vahvuuslista, ".");
        Hahmo hyokattava = new Hahmo("pekko", 3, hyokkayslista, heikkouslista,
        vahvuuslista, ".");

        hyokkaaja.kaytaHyokkaysta(0, hyokattava);

        assertEquals(2, hyokattava.getHp());
    }
}
