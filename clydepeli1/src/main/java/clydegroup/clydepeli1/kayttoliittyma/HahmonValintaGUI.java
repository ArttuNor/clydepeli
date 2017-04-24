package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.logiikka.Hahmogeneraattori;
import clydegroup.clydepeli1.hahmot.Hahmo;
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
public class HahmonValintaGUI implements Runnable {

    private JFrame frame;

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

        JLabel teksti = new JLabel("Valitse hahmosi!");
        container.add(teksti
        );

        //Seuraavaksi jatkan tästä: lisään nappeihin toiminnallisuuden, ja vien
        //pelaajan valitseman hahmon taisteluun.
        List<Hahmo> hahmot = hahmojenLuonti();
        for (Hahmo h : hahmot) {
            JButton lisattava = new JButton(h.getNimi());
            container.add(lisattava);
            lisattava.addActionListener(new HahmonValintaListener(this.frame,
            h));
        }
        
        container.add(new JLabel(""));

        container.add(new JButton(new AbstractAction("Takaisin") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }), BorderLayout.SOUTH);
    }

    private List hahmojenLuonti() {
        Hahmogeneraattori generaattori = new Hahmogeneraattori();
        generaattori.luoHahmot();
        return generaattori.getLista();
    }

}
