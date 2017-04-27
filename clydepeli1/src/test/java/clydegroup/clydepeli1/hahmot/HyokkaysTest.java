package clydegroup.clydepeli1.hahmot;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arttu
 */
public class HyokkaysTest {

    /**
     *
     */
    public HyokkaysTest() {
    }
    Hyokkays h = new Hyokkays("suora", 1, "oletus");
    List<Hyokkays> hyokkayslista = new ArrayList<>();
    List<String> heikkouslista = new ArrayList<>();
    List<String> vahvuuslista = new ArrayList<>();
    Hahmo hahmo = new Hahmo("mauri", 3, hyokkayslista, heikkouslista,
    vahvuuslista, ".");

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
        hyokkayslista.add(new Hyokkays("hyokkays1", 1, "oletus"));
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    @Test
    public void konstruktoriAsettaaNimenOikein() {
        assertEquals("suora", h.getNimi());
    }

    /**
     *
     */
    @Test
    public void konstruktoriAsettaaVoimanOikein() {
        assertEquals(1, h.getVoima());
    }

    /**
     *
     */
    @Test
    public void kayttaminenVahentaaKohteenElamaa() {
        h.kayta(hahmo);

        assertEquals(2, hahmo.getHp());
    }

    /**
     *
     */
    @Test
    public void heikkousTyypinKayttaminenVahentaaElamaaTuplasti() {
        List<String> heikkoudet = new ArrayList<>();
        heikkoudet.add("oletus");
        hahmo.setHeikkoudet(heikkoudet);

        h.kayta(hahmo);

        assertEquals(1, hahmo.getHp());
    }

    /**
     *
     */
    @Test
    public void vahvuusTyypinKayttaminenVahentaaElamaaTuplasti() {
        List<String> vahvuudet = new ArrayList<>();
        vahvuudet.add("oletus");
        hahmo.setVahvuudet(vahvuudet);

        h.kayta(hahmo);

        assertEquals(3, hahmo.getHp());
    }

}
