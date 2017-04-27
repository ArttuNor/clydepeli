package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

public class KilautaModelle extends Esine{
    
    public KilautaModelle(int hinta) {
        super(hinta);
        super.setNimi("Kilauta modelle -oljenkorsi");
    }
    
    @Override
    public void kayta(Hahmo kohde){
        kohde.menetaElamaa(6);
    }
}
