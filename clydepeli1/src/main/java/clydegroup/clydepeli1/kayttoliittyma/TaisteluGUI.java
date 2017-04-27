package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.logiikka.Hahmogeneraattori;
import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.hahmot.Hyokkays;
import clydegroup.clydepeli1.kauppa.Esine;
import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

/**
 *
 * @author Arttu
 */
public class TaisteluGUI implements Runnable {

    private JFrame frame;
    private Taistelu taistelu;
    private JTextArea infoboksi = new JTextArea("");
    private JButton esineenKaytto = new JButton("");
    private JLabel pelaajaTeksti = new JLabel("");
    private JLabel pelaajaKuva = new JLabel("");
    private JLabel vihuTeksti = new JLabel("");
    private JLabel vihuKuva = new JLabel("");

    public TaisteluGUI(Hahmo valittuHahmo, int voitot) throws IOException {
        Hahmogeneraattori hg = new Hahmogeneraattori();
        this.taistelu = new Taistelu(valittuHahmo, hg.arvoVihu(), voitot, this);
        paivitaHP();
        
        BufferedImage pKuvaTiedosto
                = ImageIO.read(new File(valittuHahmo.getKuva()));
        this.pelaajaKuva = new JLabel(new ImageIcon(pKuvaTiedosto));
        
        BufferedImage vKuvaTiedosto
                = ImageIO.read(new File(this.taistelu.getVihollinen().getKuva()));
        this.vihuKuva = new JLabel(new ImageIcon(vKuvaTiedosto));
        
        this.esineenKaytto = new JButton("Sinulla ei ole esineitä.");
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
        container.setLayout(new GridLayout(0, 2));

        //Hahmojen kuvat ja nimet tähän väliin.
        container.add(pelaajaTeksti);
        container.add(vihuTeksti);
        container.add(pelaajaKuva);
        container.add(vihuKuva);

        JLabel teksti = new JLabel("Voitot: " + this.taistelu.getVoitot());
        container.add(teksti);
        
        container.add(new JLabel(""));

        int hyokkaysnro = 0;
        for (Hyokkays h : this.taistelu.getPelaaja().getHyokkaykset()) {
            JButton lisattava = new JButton(h.getNimi());
            container.add(lisattava);
            lisattava.addActionListener(new TaisteluListener(hyokkaysnro,
                    this.taistelu ));
            hyokkaysnro++;
        }

        container.add(new JLabel("Esineesi:"));

        container.add(this.esineenKaytto);

        container.add(infoboksi);

        container.add(new JButton(new AbstractAction("Lopeta peli") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        }), BorderLayout.SOUTH);
    }

    public void paivitaHP() {
        this.pelaajaTeksti.setText(this.taistelu.getPelaaja().getNimi()
                + " HP: " + this.taistelu.getPelaaja().getHp()
                + " Raha: " + this.taistelu.getPelaaja().getRaha());
        this.vihuTeksti.setText(this.taistelu.getVihollinen().getNimi()
                + " HP: " + this.taistelu.getVihollinen().getHp());
    }

    public void kerroInfo(String teksti) {
        this.infoboksi.setText(teksti);
    }
    
    public void paivitaEsine(){
        this.esineenKaytto.setText(this.taistelu.getPelaaja().getEsineet().get(0).getNimi());
        this.esineenKaytto.addActionListener(new TaisteluEsineListener(this.taistelu,
                    this.taistelu.getPelaaja().getEsineet().get(0)));
    }

    public void lopetaTaistelu() {
        this.frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Taistelu getTaistelu() {
        return taistelu;
    }

    public void setTaistelu(Taistelu taistelu) {
        this.taistelu = taistelu;
    }

    public JTextArea getInfoboksi() {
        return infoboksi;
    }

    public void setInfoboksi(JTextArea infoboksi) {
        this.infoboksi = infoboksi;
    }

    public JButton getEsineenKaytto() {
        return esineenKaytto;
    }

    public void setEsineenKaytto(JButton esineenKaytto) {
        this.esineenKaytto = esineenKaytto;
    }

    public JLabel getPelaajaTeksti() {
        return pelaajaTeksti;
    }

    public void setPelaajaTeksti(JLabel pelaajaTeksti) {
        this.pelaajaTeksti = pelaajaTeksti;
    }

    public JLabel getPelaajaKuva() {
        return pelaajaKuva;
    }

    public void setPelaajaKuva(JLabel pelaajaKuva) {
        this.pelaajaKuva = pelaajaKuva;
    }

    public JLabel getVihuTeksti() {
        return vihuTeksti;
    }

    public void setVihuTeksti(JLabel vihuTeksti) {
        this.vihuTeksti = vihuTeksti;
    }

    public JLabel getVihuKuva() {
        return vihuKuva;
    }

    public void setVihuKuva(JLabel vihuKuva) {
        this.vihuKuva = vihuKuva;
    }

    
    
}
