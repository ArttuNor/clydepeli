package clydegroup.clydepeli1.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Osa käyttöliittymälogiikkaa, sulkee pelin.
 * 
 * @author Arttu
 */
public class Lopettaja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
