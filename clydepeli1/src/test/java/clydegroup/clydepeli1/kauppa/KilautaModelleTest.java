package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.hahmot.Hyokkays;
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
public class KilautaModelleTest {

    public KilautaModelleTest() {
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
    public void konstruktoriAsettaaHinnanOikein() {
        KilautaModelle km = new KilautaModelle(4);
        assertEquals(4, km.getHinta());
    }

    @Test
    public void kaytaTekeeOikeanVerranVahinkoa() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        List<String> heikkouslista = new ArrayList<>();
        List<String> vahvuuslista = new ArrayList<>();
        Hahmo h = new Hahmo("mauri", 10, hyokkayslista, heikkouslista, vahvuuslista,
                ".");
        
        KilautaModelle km = new KilautaModelle(4);
        km.kayta(h);
        
        assertEquals(4, h.getHp());
    }
}
