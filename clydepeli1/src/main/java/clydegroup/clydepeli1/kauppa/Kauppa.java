package clydegroup.clydepeli1.kauppa;

import java.util.ArrayList;
import java.util.List;

public class Kauppa {

    private List<Esine> tarjonta;

    public Kauppa() {
        this.tarjonta = new ArrayList<>();

        Esinegeneraattori eg = new Esinegeneraattori();

        int i = 0;
        while (true) {
            if (i > 2) {
                break;
            }
            tarjonta.add(eg.arvoEsine());
            i++;
        }
    }

    public List<Esine> getTarjonta() {
        return tarjonta;
    }

    public void setTarjonta(List<Esine> tarjonta) {
        this.tarjonta = tarjonta;
    }   
    
}
