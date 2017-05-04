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

    /**
     *
     */
    public String nimi;

    /**
     *
     * @param hinta
     */
    public Esine(int hinta) {
        this.hinta = hinta;
    }

    /**
     *
     * Ei tee itsessään mitään, Override kaikissa esineissä.
     * 
     * @param kohde
     */
    public void kayta(Hahmo kohde) {

    }

    /**
     *
     * @return
     */
    public int getHinta() {
        return hinta;
    }

    /**
     *
     * @param hinta
     */
    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    /**
     *
     * @return
     */
    public String getNimi() {
        return nimi;
    }

    /**
     *
     * @param nimi
     */
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     *
     * @return
     */
    public String getKuvaus() {
        return kuvaus;
    }

    /**
     *
     * @param kuvaus
     */
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    
    
}
