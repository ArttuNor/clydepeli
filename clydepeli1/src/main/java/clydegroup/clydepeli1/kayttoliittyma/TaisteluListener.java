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
     * @param hyokkaysnro
     * @param taistelu
     */
    public TaisteluListener(int hyokkaysnro, Taistelu taistelu) {
        this.hyokkaysnro = hyokkaysnro;
        this.taistelu = taistelu;
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.taistelu.hyokkaa(this.hyokkaysnro);
        } catch (IOException ex) {
            Logger.getLogger(TaisteluListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
