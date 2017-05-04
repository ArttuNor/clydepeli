package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hyokkays;
import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Osa käyttöliittymän logiikkaa, kuuntelee valittuja iskuja.
 *
 * @author Arttu
 */
public class TaisteluListener implements ActionListener {

    private int hyokkaysnro;
    private Taistelu taistelu;

    /**
     *
     * @param hyokkaysnro Minkä numeroista hyökkäystä käytetään.
     * @param taistelu Mitä taistelua kuunnellaan.
     */
    public TaisteluListener(int hyokkaysnro, Taistelu taistelu) {
        this.hyokkaysnro = hyokkaysnro;
        this.taistelu = taistelu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.taistelu.hyokkaa(this.hyokkaysnro);

    }

}
