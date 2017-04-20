package clydegroup.clydepeli1.taistelu;

import clydegroup.clydepeli1.hahmot.Hahmo;
import java.util.Random;

/**
 *
 * @author Arttu
 */
public class Taistelu {

    private final Hahmo pelaaja;
    private Hahmo vihollinen;
    private int voitot;

    /**
     *
     * Luo taisteluolion.
     * 
     * @param pelaaja
     * @param vihollinen
     * @param voitot
     */
    public Taistelu(Hahmo pelaaja, Hahmo vihollinen, int voitot) {
        this.pelaaja = pelaaja;
        this.vihollinen = vihollinen;
        this.voitot = voitot;
    }

    /**
     *
     * Metodi toimii taistelutilanteen peruslooppina. Se kysyy käyttäjältä,
     * mitä hyökkäystä käytetään (kesken), jonka jälkeen se tarkistaa, onko
     * vihollisella hp jäljellä. Jos ei, siirrytään pois loopista seuraavaan
     * taisteluun. Jos on, vihollinen hyökkää. Jos käyttäjällä on tämän jälkeen
     * hp, taisto jatkuu. Muuten peli päättyy. (Kesken.)
     * 
     */
    public void aloita() {
        while (true) {
            int hyokkaysnro = 0; //Lue tätä ennen pelaajalta hyökkäyskäsky.
            pelaaja.kaytaHyokkaysta(hyokkaysnro, vihollinen);

            // Laita omaan metodiinsa, kun ehdit.
            if (vihollinen.getHp() < 1) {
                voitot++;
                // Näytä voitot, mahdollinen matsien välinen tilanne.
                Taistelu seuraava = new Taistelu(pelaaja, pelaaja, voitot);
                seuraava.aloita();
            }

            Random random = new Random();
            vihollinen.kaytaHyokkaysta(random.nextInt
        (vihollinen.getHyokkaykset().size())-1, pelaaja);
            
            if(pelaaja.getHp()<1){
                // Kerro pelin päättyneen ja palaa valikkoon.
            }
        }
    }

}
