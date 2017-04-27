package clydegroup.clydepeli1.hahmot;

import clydegroup.clydepeli1.kauppa.Esine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Luokka, jonka olioista pelaajahahmo ja viholliset muodostuvat. Vaikuttavat
 * toisiinsa luokan Hyokkays kautta.
 *
 * @author Arttu
 */
public class Hahmo {

    private String nimi;
    private int hp;
    private List<Hyokkays> hyokkaykset;
    private List<String> heikkoudet;
    private List<String> vahvuudet;
    private List<Esine> esineet;
    private int raha;
    private String kuva;

    /**
     *
     * Luo hahmon.
     *
     * @param nimi
     * @param hp
     * @param hyokkaykset
     * @param heikkoudet
     * @param vahvuudet
     * @param kuva
     */
    public Hahmo(String nimi, int hp, List<Hyokkays> hyokkaykset, List<String> heikkoudet, List<String> vahvuudet, String kuva) {
        this.nimi = nimi;
        this.hp = hp;
        this.hyokkaykset = hyokkaykset;
        this.heikkoudet = heikkoudet;
        this.vahvuudet = vahvuudet;
        this.esineet = new ArrayList<>();
        this.raha = 0;
        this.kuva = kuva;
    }

    /**
     * Hahmo menettää elämää parametrin menetys mukaan.
     *
     * @param menetys
     */
    public void menetaElamaa(int menetys) {
        if (menetys > this.hp) {
            this.hp = 0;
        } else {
            this.hp = this.hp - menetys;
        }
    }

    /**
     *
     * Hahmo kutsuu sille tallennetuista hyökkäyksistä numeroltaan parametria
     * nro vastaavan hyökkäyksen metodia kayta() ja antaa sille parameriksi
     * Hahmon kohde.
     *
     * @param nro
     * @param kohde
     */
    public void kaytaHyokkaysta(int nro, Hahmo kohde) {
        this.hyokkaykset.get(nro).kayta(kohde);
    }

    /**
     *
     * @return
     */
    public List<String> getHeikkoudet() {
        return heikkoudet;
    }

    /**
     *
     * @return
     */
    public List<String> getVahvuudet() {
        return vahvuudet;
    }

    /**
     *
     * @param heikkoudet
     */
    public void setHeikkoudet(List<String> heikkoudet) {
        this.heikkoudet = heikkoudet;
    }

    /**
     *
     * @param vahvuudet
     */
    public void setVahvuudet(List<String> vahvuudet) {
        this.vahvuudet = vahvuudet;
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
    public int getHp() {
        return hp;
    }

    /**
     *
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     *
     * @return
     */
    public List<Hyokkays> getHyokkaykset() {
        return hyokkaykset;
    }

    /**
     *
     * @param hyokkaykset
     */
    public void setHyokkaykset(List<Hyokkays> hyokkaykset) {
        this.hyokkaykset = hyokkaykset;
    }

    /**
     *
     * @return
     */
    public List<Esine> getEsineet() {
        return esineet;
    }

    /**
     *
     * @param esineet
     */
    public void setEsineet(List<Esine> esineet) {
        this.esineet = esineet;
    }

    /**
     *
     * @return
     */
    public int getRaha() {
        return raha;
    }

    /**
     *
     * @param raha
     */
    public void setRaha(int raha) {
        this.raha = raha;
    }

    /**
     *
     * @return
     */
    public String getKuva() {
        return kuva;
    }

    /**
     *
     * @param kuva
     */
    public void setKuva(String kuva) {
        this.kuva = kuva;
    }
}