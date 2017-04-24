package clydegroup.clydepeli1.kayttoliittyma;

import clydegroup.clydepeli1.hahmot.Hyokkays;
import clydegroup.clydepeli1.logiikka.Taistelu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaisteluListener implements ActionListener {

    private int hyokkaysnro;
    private Taistelu taistelu;

    public TaisteluListener(int hyokkaysnro, Taistelu taistelu) {
        this.hyokkaysnro = hyokkaysnro;
        this.taistelu = taistelu;
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.taistelu.hyokkaa(this.hyokkaysnro);
        
    }
    
}
