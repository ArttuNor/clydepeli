package clydegroup.clydepeli1.kauppa;

import clydegroup.clydepeli1.logiikka.Esinegeneraattori;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Luokka, joka sisältää listan Esine-olioita. Luodaan, kun peli tarjoaa
 * pelaajalle eri esineitä joista valita.
 *
 * @author Arttu
 */
public class Kauppa {

    private List<Esine> tarjonta;

    /**
     *
     */
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

    /**
     *
     * @return
     */
    public List<Esine> getTarjonta() {
        return tarjonta;
    }

    /**
     *
     * @param tarjonta
     */
    public void setTarjonta(List<Esine> tarjonta) {
        this.tarjonta = tarjonta;
    }

}
