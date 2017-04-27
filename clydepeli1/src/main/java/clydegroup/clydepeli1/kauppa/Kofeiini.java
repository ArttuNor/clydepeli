package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

public class Kofeiini extends Esine{
    
    public Kofeiini(int hinta) {
        super(hinta);
        super.setNimi("Kofeiinia");
    }
    
    @Override
    public void kayta(Hahmo kohde){
        kohde.setHp(kohde.getHp() + 5);
    }
    
    
    
}
