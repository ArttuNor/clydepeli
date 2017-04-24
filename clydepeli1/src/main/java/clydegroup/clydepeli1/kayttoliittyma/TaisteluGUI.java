package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.logiikka.Hahmogeneraattori;
import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.hahmot.Hyokkays;
import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author Arttu
 */
public class TaisteluGUI implements Runnable {

    private JFrame frame;
    private Taistelu taistelu;
    private JLabel infoboksi = new JLabel("");

    public TaisteluGUI(Hahmo valittuHahmo, int voitot) {
        this.taistelu = new Taistelu(valittuHahmo, valittuHahmo, voitot, this);

    }

    @Override
    public void run() {
        frame = new JFrame("Clydepeli");
        frame.setPreferredSize(new Dimension(800, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(0, 1));

        //Hahmojen kuvat ja nimet tähän väliin.
        JLabel teksti = new JLabel("Voitot: " + this.taistelu.getVoitot()
                + "Valitse hyökkäyksesi.");
        container.add(teksti
        );

        int hyokkaysnro = 0;
        for (Hyokkays h : this.taistelu.getPelaaja().getHyokkaykset()) {
            JButton lisattava = new JButton(h.getNimi());
            container.add(lisattava);
            lisattava.addActionListener(new TaisteluListener(hyokkaysnro,
                    this.taistelu));
            hyokkaysnro++;
        }

        container.add(infoboksi);

        container.add(new JButton(new AbstractAction("Lopeta peli") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }), BorderLayout.SOUTH);
    }

    public void kerroInfo(String teksti) {
        this.infoboksi.setText(teksti);
    }

    public void lopetaTaistelu() {
        this.frame.dispose();
    }

}
