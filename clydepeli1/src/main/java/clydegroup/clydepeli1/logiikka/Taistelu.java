package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.kauppa.Esine;
import clydegroup.clydepeli1.kayttoliittyma.TaisteluGUI;
import clydegroup.clydepeli1.kayttoliittyma.TulosIlmoittaja;
import java.io.IOException;
import java.util.Random;

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
     * @param pelaaja Käyttäjän hallitsema hahmo.
     * @param vihollinen Vihollishahmo.
     * @param voitot Pelaajan voitot tällä kierroksella.
     * @param gui Käytettävä TaisteluGUI-olio.
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
     * hyökkäystä käytetään, jonka jälkeen se tarkistaa, onko vihollisella hp
     * jäljellä. Jos ei, siirrytään pois loopista seuraavaan taisteluun. Jos on,
     * vihollinen hyökkää. Jos käyttäjällä on tämän jälkeen hp, taisto jatkuu.
     * Muuten peli päättyy.
     *
     * @param hyokkaysnro Sen hyökkäyksen numero, jota käytetään.
     */
    public void hyokkaa(int hyokkaysnro) {
        // Pelaajan hyökkäys
        pelaaja.kaytaHyokkaysta(hyokkaysnro, vihollinen);
        // Tarkistetaan selvisikö vihollinen, eli mennäänkö eteenpäin kohti
        // seuraavaa taistelua, vai iskeekö vihollinen takaisin.
        if (!selvisiko(vihollinen)) {
            voitaTaistelu();
        } else {
            //Vihollisen hyökkäys.
            int vihunIsku = arvoVihollisenHyokkays();
            vihuIskee(vihunIsku);

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
            if (!selvisiko(pelaaja)) {
                // Kerro pelin päättyneen ja palaa valikkoon.
                haviaTaistelu();
            }
        }
        //Päivitetään HP.
        this.gui.paivitaHP();
    }

    /**
     *
     * Toimii kuin hyökkääminen, mutta kutsutaan, jos pelaaja käyttääkin
     * esinettä.
     *
     * @param esine Se esine, jota käytetään.
     */
    public void kaytaEsine(Esine esine) {
        if (esine.getNimi().equals("Kofeiinia")) {
            esine.kayta(pelaaja);
        } else {
            esine.kayta(vihollinen);
        }

        if (this.pelaaja.getEsineet().size() > 0) {
            this.pelaaja.getEsineet().remove(0);
        }

        if (!selvisiko(vihollinen)) {
            voitaTaistelu();
        } else {
            //Vihollisen hyökkäys.
            int vihunIsku = arvoVihollisenHyokkays();
            vihuIskee(vihunIsku);

            //Päivitetään infoboksin teksti.
            this.gui.kerroInfo("Sinä käytit esinettä." + System.lineSeparator()
                    + "Vihollinen hyökkäsi kimppusi hyökkäyksellä "
                    + vihollinen.getHyokkaykset().get(vihunIsku).getNimi()
                    + "." + System.lineSeparator() + "Sinulla on jäljellä "
                    + pelaaja.getHp() + " elämää.");

            //Tarkistetaan, onko selvisikö pelaaja.
            if (!selvisiko(pelaaja)) {
                // Kerro pelin päättyneen ja palaa valikkoon.
                haviaTaistelu();
            }
        }
        this.gui.paivitaEsine();
        this.gui.paivitaHP();
    }

    private void vihuIskee(int vihunIsku) {
        vihollinen.kaytaHyokkaysta(vihunIsku, pelaaja);
    }

    private boolean selvisiko(Hahmo hahmo) {
        if (hahmo.getHp() < 1) {
            return false;
        } else {
            return true;
        }
    }

    private void haviaTaistelu() {
        this.gui.lopetaTaistelu();
        TulosIlmoittaja ti
                = new TulosIlmoittaja("Hävisit taistelun. Pelisi päättyy.", this, false);
        ti.run();
    }

    private void voitaTaistelu() {
        this.voitot++;
        this.pelaaja.setRaha(this.pelaaja.getRaha() + 2);
        // Näytä voitot, mahdollinen matsien välinen tilanne.
        this.gui.lopetaTaistelu();
        TulosIlmoittaja ti
                = new TulosIlmoittaja("Voitit taistelun!", this, true);
        ti.run();
    }

    private int arvoVihollisenHyokkays() {
        Random random = new Random();
        int maksimi = vihollinen.getHyokkaykset().size();
        int vihunIsku = random.nextInt(maksimi);
        return vihunIsku;
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

    public TaisteluGUI getGui() {
        return gui;
    }

}
