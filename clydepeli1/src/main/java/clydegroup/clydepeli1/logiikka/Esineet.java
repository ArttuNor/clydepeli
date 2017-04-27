package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.kauppa.Esine;
import java.util.ArrayList;
import java.util.List;

public class Esineet {

    private List<Esine> esineet = new ArrayList<>();

    public Esineet() {
    }

    public List<Esine> getEsineet() {
        return esineet;
    }

    public void setEsineet(List<Esine> esineet) {
        this.esineet = esineet;
    }
    
    
}
