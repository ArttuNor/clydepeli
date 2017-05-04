package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

/**
 *
 * Luokka, jonka olioita pelaaja voi ostaa kaupasta. Tekee paljon vahinkoa
 * kohteeseensa, eli siis viholliseen.
 *
 * @author Arttu
 */
public class KilautaModelle extends Esine {

    /**
     * Konstruktori.
     * @param hinta Kuinka paljon maksaa.
     */
    public KilautaModelle(int hinta) {
        super(hinta);
        super.setNimi("Kilauta modelle -oljenkorsi");
        super.setKuvaus("Hanki riitakumppanillesi välittömät bännit!");
    }

    @Override
    public void kayta(Hahmo kohde) {
        kohde.menetaElamaa(6);
    }
}
