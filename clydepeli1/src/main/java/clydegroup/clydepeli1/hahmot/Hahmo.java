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
     * @param nimi Hahmon nimi.
     * @param hp Hahmon hp eli hit pointit.
     * @param hyokkaykset Lista hahmon hyökkäyksistä.
     * @param heikkoudet Lista hahmon heikkouksista.
     * @param vahvuudet Lista hahmon vahvuuksista.
     * @param kuva Hahmon kuvan sijainti.
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
     * @param menetys Kuinka paljon hahmo menettää elämää.
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
     * @param nro Minkä numeroista hyökkäystä käytetään.
     * @param kohde Mihin kohteeseen.
     */
    public void kaytaHyokkaysta(int nro, Hahmo kohde) {
        this.hyokkaykset.get(nro).kayta(kohde);
    }

    public List<String> getHeikkoudet() {
        return heikkoudet;
    }

    public List<String> getVahvuudet() {
        return vahvuudet;
    }

    public void setHeikkoudet(List<String> heikkoudet) {
        this.heikkoudet = heikkoudet;
    }

    public void setVahvuudet(List<String> vahvuudet) {
        this.vahvuudet = vahvuudet;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Hyokkays> getHyokkaykset() {
        return hyokkaykset;
    }

    public void setHyokkaykset(List<Hyokkays> hyokkaykset) {
        this.hyokkaykset = hyokkaykset;
    }

    public List<Esine> getEsineet() {
        return esineet;
    }

    public void setEsineet(List<Esine> esineet) {
        this.esineet = esineet;
    }

    public int getRaha() {
        return raha;
    }

    public void setRaha(int raha) {
        this.raha = raha;
    }

    public String getKuva() {
        return kuva;
    }

    public void setKuva(String kuva) {
        this.kuva = kuva;
    }
}