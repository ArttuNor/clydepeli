package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

/**
 *
 * Luokka, jonka olioita pelaaja voi ostaa kaupasta. Parantaa kohdetta, eli siis
 * pelaajaa.
 *
 * @author Arttu
 */
public class Kofeiini extends Esine {

    /**
     * Konstruktori.
     * @param hinta Kuinka paljon maksaa?
     */
    public Kofeiini(int hinta) {
        super(hinta);
        super.setNimi("Kofeiinia");
        super.setKuvaus("Kahvin parantava voima auttaa jaksamaan!");
    }

    @Override
    public void kayta(Hahmo kohde) {
        kohde.setHp(kohde.getHp() + 8);
    }

}
