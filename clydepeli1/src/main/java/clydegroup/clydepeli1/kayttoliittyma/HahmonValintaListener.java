package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * Osa käyttöliittymälogiikkaa, kuuntelee valittua hahmoa.
 * 
 * @author Arttu
 */
public class HahmonValintaListener implements ActionListener {
    
    private JFrame frame;
    private Hahmo hahmo;
    
    /**
     *
     * @param frame Kuunnellun HahmonValintaGUIn frame.
     * @param hahmo Mikä hahmo valittiin.
     */
    public HahmonValintaListener(JFrame frame, Hahmo hahmo) {
        this.frame = frame;
        this.hahmo = hahmo;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TaisteluGUI taistelu = null;
        taistelu = new TaisteluGUI(this.hahmo, 0);
        this.frame.dispose();
        taistelu.run();
    }

}
