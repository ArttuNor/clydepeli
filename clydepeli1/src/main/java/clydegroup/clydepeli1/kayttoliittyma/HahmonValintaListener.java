package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class HahmonValintaListener implements ActionListener {
    
    private JFrame frame;
    private Hahmo hahmo;
    
    public HahmonValintaListener(JFrame frame, Hahmo hahmo) {
        this.frame = frame;
        this.hahmo = hahmo;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        TaisteluGUI taistelu = null;
        try {
            taistelu = new TaisteluGUI(this.hahmo, 0);
        } catch (IOException ex) {
            Logger.getLogger(HahmonValintaListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.frame.dispose();
        taistelu.run();
    }

}
