package clydegroup.clydepeli1.taistelu;

import clydegroup.clydepeli1.logiikka.Taistelu;
import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.hahmot.Hyokkays;
import clydegroup.clydepeli1.kayttoliittyma.TaisteluGUI;
import java.io.IOException;
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
public class TaisteluTest {

    List<Hyokkays> hyokkayslista = new ArrayList<>();
    List<String> heikkouslista = new ArrayList<>();
    List<String> vahvuuslista = new ArrayList<>();
    Hahmo pelaaja = new Hahmo("mauri", 3, hyokkayslista, heikkouslista,
            vahvuuslista, "src/main/resources/dosentti");
    Hahmo vihollinen = new Hahmo("pekka", 3, hyokkayslista, heikkouslista,
            vahvuuslista, "src/main/resources/jantsu");
    Taistelu taistelu;

    public TaisteluTest() throws IOException {
        this.taistelu = new Taistelu(pelaaja, vihollinen,
                0, new TaisteluGUI(pelaaja, 0));
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
     public void generaattoriAsettaaOikeatNimet() {
         assertEquals("mauri", this.pelaaja.getNimi());
         assertEquals("pekka", this.pelaaja.getNimi());
     }
     
     //Taisteluiden testit eivät ole tällä hetkellä superkattavia: tähän on
     //aikataulusyitä. Alkavan viikon pitäisi auttaa.
}
