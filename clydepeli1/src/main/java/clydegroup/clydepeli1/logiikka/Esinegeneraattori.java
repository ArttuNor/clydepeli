package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.kauppa.Energiajuoma;
import clydegroup.clydepeli1.kauppa.Esine;
import clydegroup.clydepeli1.kauppa.KilautaModelle;
import clydegroup.clydepeli1.kauppa.Kofeiini;
import java.util.Random;

/**
 *
 * Luokka, joka arpoo sattumanvaraisen esineen.
 *
 * @author Arttu
 */
public class Esinegeneraattori {

    /**
     *
     * @return
     */
    public Esine arvoEsine() {
        Random random = new Random();
        int tulos = random.nextInt(2);

        if (tulos == 0) {
            return (new Kofeiini(6));
        } else if (tulos == 1) {
            return (new KilautaModelle(2));
        } else if (tulos == 2) {
            return (new Energiajuoma(10));
        } else {
            return (new Energiajuoma(19));
        }

    }
}
