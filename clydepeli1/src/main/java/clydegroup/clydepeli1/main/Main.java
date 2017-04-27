package clydegroup.clydepeli1.main;

import clydegroup.clydepeli1.kayttoliittyma.AloitusGUI;
import javax.swing.SwingUtilities;

/**
 *
 * Käynnistää pelin.
 * 
 * @author Arttu
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        AloitusGUI kayttoliittyma = new AloitusGUI();
        SwingUtilities.invokeLater(kayttoliittyma);

    }
}
