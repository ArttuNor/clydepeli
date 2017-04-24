package clydegroup.clydepeli1.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Arttu
 */
public class OhjeidenantajaGUI implements ActionListener, Runnable {

    private JFrame frame;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.run();
    }

    @Override
    public void run() {
        frame = new JFrame("Clydepeli - ohjeet");
        frame.setPreferredSize(new Dimension(400, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new BorderLayout());

        JLabel teksti = new JLabel("Clydepelissä tarkoituksesi on voittaa vihollisia.");
        container.add(teksti);

        container.add(new JButton(new AbstractAction("Takaisin") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }), BorderLayout.SOUTH);
    }

}
