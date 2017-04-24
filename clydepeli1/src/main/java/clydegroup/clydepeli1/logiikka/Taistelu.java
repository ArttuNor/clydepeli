package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.kayttoliittyma.AloitusGUI;
import clydegroup.clydepeli1.kayttoliittyma.TaisteluGUI;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arttu
 */
public class Taistelu {

    private Hahmo pelaaja;
    private Hahmo vihollinen;
    private int voitot;
    private final TaisteluGUI gui;

    /**
     *
     * Luo taisteluolion.
     *
     * @param pelaaja
     * @param vihollinen
     * @param voitot
     */
    public Taistelu(Hahmo pelaaja, Hahmo vihollinen, int voitot,
            TaisteluGUI gui) {
        this.pelaaja = pelaaja;
        this.vihollinen = vihollinen;
        this.voitot = voitot;
        this.gui = gui;
    }

    /**
     *
     * Metodi toimii taistelutilanteen peruslooppina. Se kysyy käyttäjältä, mitä
     * hyökkäystä käytetään (kesken), jonka jälkeen se tarkistaa, onko
     * vihollisella hp jäljellä. Jos ei, siirrytään pois loopista seuraavaan
     * taisteluun. Jos on, vihollinen hyökkää. Jos käyttäjällä on tämän jälkeen
     * hp, taisto jatkuu. Muuten peli päättyy. (Kesken.)
     *
     * @param hyokkaysnro
     */
    public void hyokkaa(int hyokkaysnro) {

        pelaaja.kaytaHyokkaysta(hyokkaysnro, vihollinen);
        System.out.println("Iskit"
                + pelaaja.getHyokkaykset().get(hyokkaysnro).getNimi()
                + vihollinen.getHp());

        // Laita omaan metodiinsa, kun ehdit.
        if (vihollinen.getHp() < 1) {
            this.voitot++;
            // Näytä voitot, mahdollinen matsien välinen tilanne.
            this.gui.lopetaTaistelu();
            TaisteluGUI uusiTaisteluGUI = new TaisteluGUI(this.pelaaja,
                    this.voitot);
            uusiTaisteluGUI.run();
        } else {

            Random random = new Random();
            int maksimi = vihollinen.getHyokkaykset().size();
            int vihunIsku = random.nextInt(maksimi);
            vihollinen.kaytaHyokkaysta(vihunIsku, pelaaja);
            System.out.println("Vihu iskee"
                    + vihollinen.getHyokkaykset().get(vihunIsku).getNimi()
                    + pelaaja.getHp());

            //Päivitetään infoboksin teksti.
            this.gui.kerroInfo("Sinä hyökkäsit vihollisesi kimppuun hyökkäyksellä "
                    + pelaaja.getHyokkaykset().get(hyokkaysnro).getNimi()
                    + "." + System.lineSeparator() + "Vihollisellasi on jäljellä "
                    + vihollinen.getHp() + " elämää." + System.lineSeparator()
                    + "Vihollinen hyökkäsi kimppusi hyökkäyksellä "
                    + vihollinen.getHyokkaykset().get(vihunIsku).getNimi()
                    + "." + System.lineSeparator() + "Sinulla on jäljellä "
                    + pelaaja.getHp() + " elämää.");

            if (pelaaja.getHp() < 1) {
                // Kerro pelin päättyneen ja palaa valikkoon.
                this.gui.lopetaTaistelu();
                AloitusGUI kayttoliittyma = new AloitusGUI();
                SwingUtilities.invokeLater(kayttoliittyma);
            }
        }

    }

    public Hahmo getVihollinen() {
        return vihollinen;
    }

    public void setVihollinen(Hahmo vihollinen) {
        this.vihollinen = vihollinen;
    }

    public int getVoitot() {
        return voitot;
    }

    public void setVoitot(int voitot) {
        this.voitot = voitot;
    }

    public Hahmo getPelaaja() {
        return pelaaja;
    }

    public void setPelaaja(Hahmo pelaaja) {
        this.pelaaja = pelaaja;
    }

}
