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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getHyokkayslistaToimii() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        assertEquals(hyokkayslista, h.getHyokkaykset());
    }

    @Test
    public void konstruktoriAsettaaNimenOikein() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        assertEquals("mauri", h.getNimi());
    }

    @Test
    public void konstruktoriAsettaaHpnOikein() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        assertEquals(3, h.getHp());
    }

    @Test
    public void konstruktoriAsettaaHyokkayksetOikein() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        assertEquals(hyokkayslista, h.getHyokkaykset());
    }

    @Test
    public void menetaElamaaVahentaaOikeanMaaran() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        h.menetaElamaa(1);
        assertEquals(2, h.getHp());

    }

    @Test
    public void menetaElamaaEiVahennaAlleNollan() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        h.menetaElamaa(5);
        assertEquals(0, h.getHp());

    }

    @Test
    public void opiHyokkaysLisaaHyokkayksen() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo h = new Hahmo("mauri", 3, hyokkayslista);

        Hyokkays hyokkays2 = new Hyokkays("hyokkays2", 3);
        h.opiHyokkays(hyokkays2);
        hyokkayslista.add(hyokkays2);

        assertEquals(hyokkayslista, h.getHyokkaykset());
    }
}
