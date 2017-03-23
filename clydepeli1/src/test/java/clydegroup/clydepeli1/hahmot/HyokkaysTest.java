package clydegroup.clydepeli1.hahmot;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HyokkaysTest {
    
    public HyokkaysTest() {
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
    public void konstruktoriAsettaaNimenOikein() {
        Hyokkays h = new Hyokkays("suora", 1);
        
        assertEquals("suora", h.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaVoimanOikein() {
        Hyokkays h = new Hyokkays("suora", 1);
        
        assertEquals(1, h.getVoima());
    }
    
    @Test
    public void kayttaminenVahentaaKohteenElamaa() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1));
        Hahmo hahmo = new Hahmo("mauri", 3, hyokkayslista);
        
        Hyokkays h = new Hyokkays("suora", 1);
        h.kayta(hahmo);
        
        assertEquals(2, hahmo.getHp());
    }
    
}
