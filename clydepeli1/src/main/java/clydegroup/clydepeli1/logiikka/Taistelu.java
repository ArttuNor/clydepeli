package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.kayttoliittyma.AloitusGUI;
import clydegroup.clydepeli1.kayttoliittyma.KauppaGUI;
import clydegroup.clydepeli1.kayttoliittyma.TaisteluGUI;
import java.io.IOException;
import java.util.Random;
import javax.swing.SwingUtilities;

/**
 *
 * Luokka, jonka olio pyörittää taistelun logiikkaa. Metodi "hyokkaa()" on tässä
 * keskeisin.
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
     * @param gui
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
     * hyökkäystä käytetään, jonka jälkeen se tarkistaa, onko
     * vihollisella hp jäljellä. Jos ei, siirrytään pois loopista seuraavaan
     * taisteluun. Jos on, vihollinen hyökkää. Jos käyttäjällä on tämän jälkeen
     * hp, taisto jatkuu. Muuten peli päättyy. 
     * 
     * @param hyokkaysnro
     * @throws java.io.IOException
     */
    public void hyokkaa(int hyokkaysnro) throws IOException {

        // Pelaajan hyökkäys (ja debuggausviesti).
        pelaaja.kaytaHyokkaysta(hyokkaysnro, vihollinen);
        System.out.println("Iskit"
                + pelaaja.getHyokkaykset().get(hyokkaysnro).getNimi()
                + vihollinen.getHp());

        // Tarkistetaan selvisikö vihollinen, eli mennäänkö eteenpäin kohti
        // seuraavaa taistelua, vai iskeekö vihollinen takaisin.
        if (vihollinen.getHp() < 1) {
            this.voitot++;
            this.pelaaja.setRaha(this.pelaaja.getRaha() + 2);
            // Näytä voitot, mahdollinen matsien välinen tilanne.
            this.gui.lopetaTaistelu();

            if (voitot == 3 || voitot == 6 || voitot == 9) {
                KauppaGUI avattavaKauppa = new KauppaGUI(this.pelaaja);
                avattavaKauppa.run();
            } else {
                TaisteluGUI uusiTaisteluGUI = new TaisteluGUI(this.pelaaja,
                        this.voitot);
                uusiTaisteluGUI.run();
            }

        } else {

            //Vihollisen hyökkäys.
            int vihunIsku = arvoVihollisenHyokkays();
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

            //Tarkistetaan, onko selvisikö pelaaja.
            if (pelaaja.getHp() < 1) {
                // Kerro pelin päättyneen ja palaa valikkoon.
                this.gui.lopetaTaistelu();
                AloitusGUI kayttoliittyma = new AloitusGUI();
                SwingUtilities.invokeLater(kayttoliittyma);
            }
        }

        //Päivitetään HP.
        this.gui.paivitaHP();

    }

    private int arvoVihollisenHyokkays() {
        Random random = new Random();
        int maksimi = vihollinen.getHyokkaykset().size();
        int vihunIsku = random.nextInt(maksimi);
        return vihunIsku;
    }

    /**
     *
     * @return
     */
    public Hahmo getVihollinen() {
        return vihollinen;
    }

    /**
     *
     * @param vihollinen
     */
    public void setVihollinen(Hahmo vihollinen) {
        this.vihollinen = vihollinen;
    }

    /**
     *
     * @return
     */
    public int getVoitot() {
        return voitot;
    }

    /**
     *
     * @param voitot
     */
    public void setVoitot(int voitot) {
        this.voitot = voitot;
    }

    /**
     *
     * @return
     */
    public Hahmo getPelaaja() {
        return pelaaja;
    }

    /**
     *
     * @param pelaaja
     */
    public void setPelaaja(Hahmo pelaaja) {
        this.pelaaja = pelaaja;
    }

    /**
     *
     * @return
     */
    public TaisteluGUI getGui() {
        return gui;
    }

}
