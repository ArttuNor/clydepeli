package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.hahmot.Hahmo;

public class Esine {

    private int hinta;
    public String nimi;

    public Esine(int hinta) {
        this.hinta = hinta;
    }

    public void kayta(Hahmo kohde) {

    }

    public int getHinta() {
        return hinta;
    }

    public void setHinta(int hinta) {
        this.hinta = hinta;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    
    

}
