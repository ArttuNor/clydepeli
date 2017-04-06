package clydegroup.clydepeli1.main;

import clydegroup.clydepeli1.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author Arttu
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
}