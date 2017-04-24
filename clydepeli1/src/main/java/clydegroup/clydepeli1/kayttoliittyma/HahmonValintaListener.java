package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hahmo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        TaisteluGUI taistelu = new TaisteluGUI(this.hahmo, 0);
        this.frame.dispose();
        taistelu.run();
    }

}
