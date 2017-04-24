package clydegroup.clydepeli1.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Arttu
 */
public class AloitusGUI implements Runnable {

    private JFrame frame;

    /**
     *
     */
    public AloitusGUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("Clydepeli");
        frame.setPreferredSize(new Dimension(400, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        JButton aloitusNappi = new JButton("Aloita peli");
        container.add(aloitusNappi, BorderLayout.NORTH);
        aloitusNappi.addActionListener(new AloitusListener(this.frame));

        JButton ohjeetNappi = new JButton("Ohjeet");
        container.add(ohjeetNappi);
        ohjeetNappi.addActionListener(new OhjeidenantajaGUI());

        JButton lopetaNappi = new JButton("Lopeta peli");
        container.add(lopetaNappi, BorderLayout.SOUTH);
        lopetaNappi.addActionListener(new Lopettaja());

    }

    /**
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

}
