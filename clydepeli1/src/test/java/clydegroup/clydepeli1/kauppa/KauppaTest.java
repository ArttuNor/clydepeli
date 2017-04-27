package clydegroup.clydepeli1.kauppa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KauppaTest {

    public KauppaTest() {
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
    public void kaupassaOnOikeaMaaraEsineita() {
        Kauppa kauppa = new Kauppa();
        assertEquals(3, kauppa.getTarjonta().size());

    }
}
