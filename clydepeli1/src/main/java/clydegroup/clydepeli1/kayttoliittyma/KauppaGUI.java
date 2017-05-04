package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.kauppa.Esine;
import clydegroup.clydepeli1.kauppa.Kauppa;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * Kaupan käyttöliittymä.
 *
 * @author Arttu
 */
public class KauppaGUI implements Runnable {

    private JFrame frame;
    private Kauppa kauppa;
    private Hahmo pelaajaHahmo;

    /**
     *
     * @param pelaajaHahmo
     */
    public KauppaGUI(Hahmo pelaajaHahmo) {
        this.pelaajaHahmo = pelaajaHahmo;
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
        container.setLayout(new GridLayout(0, 1));

        JLabel teksti = new JLabel("Voit ostaa sälää!");
        container.add(teksti
        );

        this.kauppa = new Kauppa();

        for (Esine e : this.kauppa.getTarjonta()) {
            JButton lisattava = new JButton(e.getNimi());
            container.add(lisattava);
            lisattava.addActionListener(new KauppaListener(this.frame,
                    e, this.pelaajaHahmo));
            String kokoKuvaus = new String(e.getKuvaus() + " Hinta: "
            + e.getHinta());
            container.add(new JLabel(kokoKuvaus));
        }

        container.add(new JLabel(""));

        container.add(new JButton(new AbstractAction("Lopeta peli") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }), BorderLayout.SOUTH);
    }
}
