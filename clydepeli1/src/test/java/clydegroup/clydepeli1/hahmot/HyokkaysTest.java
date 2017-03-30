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
        Hyokkays h = new Hyokkays("suora", 1, "oletus");
        
        assertEquals("suora", h.getNimi());
    }
    
    @Test
    public void konstruktoriAsettaaVoimanOikein() {
        Hyokkays h = new Hyokkays("suora", 1, "oletus");
        
        assertEquals(1, h.getVoima());
    }
    
    @Test
    public void kayttaminenVahentaaKohteenElamaa() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1, "oletus"));
        Hahmo hahmo = new Hahmo("mauri", 3, hyokkayslista);
        
        Hyokkays h = new Hyokkays("suora", 1, "oletus");
        h.kayta(hahmo);
        
        assertEquals(2, hahmo.getHp());
    }
    
    @Test
    public void heikkousTyypinKayttaminenVahentaaElamaaTuplasti() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1, "oletus"));
        Hahmo hahmo = new Hahmo("mauri", 3, hyokkayslista);
        List<String> heikkoudet = new ArrayList<>();
        heikkoudet.add("oletus");
        hahmo.setHeikkoudet(heikkoudet);
        
        Hyokkays h = new Hyokkays("suora", 1, "oletus");
        h.kayta(hahmo);
        
        assertEquals(1, hahmo.getHp());
    }
    
    @Test
    public void vahvuusTyypinKayttaminenVahentaaElamaaTuplasti() {
        List<Hyokkays> hyokkayslista = new ArrayList<>();
        hyokkayslista.add(new Hyokkays("hyokkays1", 1, "oletus"));
        Hahmo hahmo = new Hahmo("mauri", 3, hyokkayslista);
        List<String> vahvuudet = new ArrayList<>();
        vahvuudet.add("oletus");
        hahmo.setVahvuudet(vahvuudet);
        
        Hyokkays h = new Hyokkays("suora", 1, "oletus");
        h.kayta(hahmo);
        
        assertEquals(3, hahmo.getHp());
    }
    
}
