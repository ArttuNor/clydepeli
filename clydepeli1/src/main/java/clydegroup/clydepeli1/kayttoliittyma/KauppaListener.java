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
     * @param frame
     * @param esine
     * @param hahmo
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
        this.hahmo.setEsineet(hahmonEsineet);
        this.hahmo.setRaha(this.hahmo.getRaha() - this.esine.getHinta());
        
        TaisteluGUI taistelu = null;
        try {
            taistelu = new TaisteluGUI(this.hahmo, 0);
        } catch (IOException ex) {
            Logger.getLogger(KauppaListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.dispose();
        taistelu.run();
        taistelu.paivitaEsine();
    }

}
