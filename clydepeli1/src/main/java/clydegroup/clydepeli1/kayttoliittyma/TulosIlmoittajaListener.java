package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * Osa käyttöliittymälogiikkaa, kuuntelee pelaajaa TulosIlmoittaja-ikkunassa.
 * 
 * @author Arttu
 */
public class TulosIlmoittajaListener implements ActionListener {

    private Taistelu taistelu;
    private Boolean voititko;
    private TulosIlmoittaja ti;

    /**
     *
     * @param taistelu
     * @param voititko
     * @param ti
     */
    public TulosIlmoittajaListener(Taistelu taistelu, Boolean voititko,
            TulosIlmoittaja ti) {
        this.taistelu = taistelu;
        this.voititko = voititko;
        this.ti = ti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.taistelu.getGui().lopetaTaistelu();
        this.ti.getFrame().dispose();
        if (voititko) {
            if (this.taistelu.getVoitot() == 3 || this.taistelu.getVoitot() == 6
                    || this.taistelu.getVoitot() == 9) {
                KauppaGUI avattavaKauppa = new KauppaGUI(this.taistelu.getPelaaja());
                avattavaKauppa.run();
            } else {
                try {
                    TaisteluGUI uusiTaisteluGUI = new TaisteluGUI(this.taistelu.getPelaaja(),
                            this.taistelu.getVoitot());
                    uusiTaisteluGUI.run();
                } catch (IOException ex) {
                    Logger.getLogger(TulosIlmoittajaListener.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            AloitusGUI kayttoliittyma = new AloitusGUI();
            SwingUtilities.invokeLater(kayttoliittyma);

        }
        

    }

}
