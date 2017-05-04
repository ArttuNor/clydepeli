package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.kauppa.Esine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * Osa käyttöliittymälogiikkaa, kuuntelee kaupassa valittuja esineitä.
 *
 * @author Arttu
 */
public class KauppaListener implements ActionListener {

    private JFrame frame;
    private Hahmo hahmo;
    private Esine esine;

    /**
     *
     * @param frame Kuunnellun KauppaGUIn frame.
     * @param esine Mikä esine valittiin.
     * @param hahmo Minkä hahmon esineisiin esine lisätään.
     */
    public KauppaListener(JFrame frame, Esine esine, Hahmo hahmo) {
        this.frame = frame;
        this.hahmo = hahmo;
        this.esine = esine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Esine> hahmonEsineet = this.hahmo.getEsineet();
        hahmonEsineet.add(this.esine);
        if (this.hahmo.getRaha() - this.esine.getHinta() >= 0) {
            this.hahmo.setRaha(this.hahmo.getRaha() - this.esine.getHinta());
            this.hahmo.setEsineet(hahmonEsineet);
        }

        TaisteluGUI taistelu = null;

        taistelu = new TaisteluGUI(this.hahmo, 0);

        this.frame.dispose();
        taistelu.run();
        taistelu.paivitaEsine();
    }

}
