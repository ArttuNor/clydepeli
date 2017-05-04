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
     * Konstruktori.
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

    public List<Esine> getTarjonta() {
        return tarjonta;
    }

    public void setTarjonta(List<Esine> tarjonta) {
        this.tarjonta = tarjonta;
    }

}
