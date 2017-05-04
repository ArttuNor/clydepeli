package clydegroup.clydepeli1.logiikka;

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

public class TaisteluTest {

    List<Hyokkays> hyokkayslista = new ArrayList<>();
    List<String> heikkouslista = new ArrayList<>();
    List<String> vahvuuslista = new ArrayList<>();
    Hahmo pelaaja = new Hahmo("mauri", 3, hyokkayslista, heikkouslista,
            vahvuuslista, "dosentti.png");
    Hahmo vihollinen = new Hahmo("pekka", 3, hyokkayslista, heikkouslista,
            vahvuuslista, "jantsu.png");
    Taistelu taistelu;

    public TaisteluTest() throws IOException {
        this.taistelu = new Taistelu(pelaaja, vihollinen,
                0, new TaisteluGUI(pelaaja, 0));
        this.taistelu.getGui().run();
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
        assertEquals("pekka", this.vihollinen.getNimi());
    }

    @Test
    public void pelaajanHyokkaysVahentaaElamaaOikein() throws IOException {
        this.hyokkayslista.add(new Hyokkays("heh", 1, "trolli"));
        this.pelaaja.setHyokkaykset(hyokkayslista);
        this.vihollinen.setHyokkaykset(hyokkayslista);

        this.taistelu.hyokkaa(0);

        assertEquals(2, this.taistelu.getVihollinen().getHp());

    }

    @Test
    public void vihunHyokkaysVahentaaElamaaOikein() throws IOException {
        this.hyokkayslista.add(new Hyokkays("heh", 1, "trolli"));
        this.pelaaja.setHyokkaykset(hyokkayslista);
        this.vihollinen.setHyokkaykset(hyokkayslista);

        this.taistelu.hyokkaa(0);

        assertEquals(2, this.taistelu.getPelaaja().getHp());
    }

    @Test
    public void rahaKasvaaVoitosta() throws IOException {
        this.hyokkayslista.add(new Hyokkays("heh", 1, "trolli"));
        this.pelaaja.setHyokkaykset(hyokkayslista);
        this.vihollinen.setHyokkaykset(hyokkayslista);

        this.taistelu.hyokkaa(0);
        this.taistelu.hyokkaa(0);
        this.taistelu.hyokkaa(0);

        assertEquals(2, pelaaja.getRaha());
    }
    
    @Test
    public void voitotKasvavatVoitosta() throws IOException {
        this.hyokkayslista.add(new Hyokkays("heh", 1, "trolli"));
        this.pelaaja.setHyokkaykset(hyokkayslista);
        this.vihollinen.setHyokkaykset(hyokkayslista);

        this.taistelu.hyokkaa(0);
        this.taistelu.hyokkaa(0);
        this.taistelu.hyokkaa(0);

        assertEquals(1, this.taistelu.getVoitot());
    }

}
