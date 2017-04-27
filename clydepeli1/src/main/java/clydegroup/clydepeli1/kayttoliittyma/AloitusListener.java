package clydegroup.clydepeli1.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * Osa käyttöliittymälogiikkaa, kuuntelee aloitusvalikkoa.
 * 
 * @author Arttu
 */
public class AloitusListener implements ActionListener {
    
    private JFrame frame;

    /**
     *
     * @param frame
     */
    public AloitusListener(JFrame frame) {
        this.frame = frame;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        HahmonValintaGUI hv = new HahmonValintaGUI();
        this.frame.dispose();
        hv.run();
    }

}
