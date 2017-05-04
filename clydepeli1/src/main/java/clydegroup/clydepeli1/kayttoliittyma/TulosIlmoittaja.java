package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * Kertoo käyttäjälle, kuinka taistelu päättyi.
 * 
 * @author Arttu
 */
public class TulosIlmoittaja implements Runnable {

    private JFrame frame;
    private String ilmoitus;
    private Taistelu taistelu;
    private Boolean voititko;

    /**
     *
     * @param ilmoitus
     * @param taistelu
     * @param voititko
     */
    public TulosIlmoittaja(String ilmoitus, Taistelu taistelu, Boolean voititko) {
        this.ilmoitus = ilmoitus;
        this.taistelu = taistelu;
        this.voititko = voititko;
    }
         

    @Override
    public void run() {
        frame = new JFrame("Clydepeli - ohjeet");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        JTextArea teksti = new JTextArea(this.ilmoitus);
        container.add(teksti);

        JButton nappi = new JButton("OK");
        container.add(nappi, BorderLayout.SOUTH);
        nappi.addActionListener(new TulosIlmoittajaListener(taistelu, voititko, this));
    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *
     * @param frame
     */
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    
    
}
