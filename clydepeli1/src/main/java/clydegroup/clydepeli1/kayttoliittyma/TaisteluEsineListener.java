package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.kauppa.Esine;
import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * Osa käyttöliittymän logiikkaa, kuuntelee taistelussa käytettyjä esineitä.
 *
 * @author Arttu
 */
public class TaisteluEsineListener implements ActionListener {

    private Taistelu taistelu;
    private Esine esine;

    /**
     *
     * @param taistelu
     * @param esine
     */
    public TaisteluEsineListener(Taistelu taistelu, Esine esine) {
        this.taistelu = taistelu;
        this.esine = esine;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.taistelu.kaytaEsine(esine);
        } catch (IOException ex) {
            Logger.getLogger(TaisteluEsineListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
