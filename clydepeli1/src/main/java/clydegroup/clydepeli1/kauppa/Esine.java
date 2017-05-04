package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

/**
 *
 * Luokka, joka toimii yliluokkana muille Esineille.
 *
 * @author Arttu
 */
public class Esine {

    private int hinta;
    private String kuvaus;
    private String nimi;

    /**
     * Konstruktori.
     * @param hinta Kuinka paljon maksaa.
     */
    public Esine(int hinta) {
        this.hinta = hinta;
    }

    /**
     *
     * Ei tee itsessään mitään, Override kaikissa esineissä.
     *
     * @param kohde Mihin hahmoon vaikutus kohdistuu.
     */
    public void kayta(Hahmo kohde) {

    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

}
