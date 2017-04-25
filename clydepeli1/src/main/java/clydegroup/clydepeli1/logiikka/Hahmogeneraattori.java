package clydegroup.clydepeli1.logiikka;

import clydegroup.clydepeli1.hahmot.Hahmo;
import clydegroup.clydepeli1.hahmot.Hyokkays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Arttu
 */
public class Hahmogeneraattori {

    private final List<Hahmo> lista;
    private final List<Hahmo> vihulista;

    /**
     *
     * Metodi luo uuden Hahmogeneraattorin.
     *
     */
    public Hahmogeneraattori() {
        this.lista = new ArrayList<>();
        this.vihulista = new ArrayList<>();
    }

    /**
     *
     * Metodi lisää generaattorin listalle hahmoja. Tämä metodi on
     * aikataulusyistä aika kamala ja täynnä kovakoodattua hömppää. Siistin sen
     * alkavalla viikolla.
     *
     */
    public void luoHahmot() {
        Hyokkays solvaus = new Hyokkays("Solvaus", 2, "henkilokohtaisuus");
        Hyokkays rationalisointi = new Hyokkays("Rationalisointi", 3,
                "valelogiikka");
        Hyokkays asiantuntemus = new Hyokkays("Oma asiantuntemus", 2, "ego");
        Hyokkays lapset = new Hyokkays("Entä lapset!?", 3, "tunteet");
        Hyokkays klassikko = new Hyokkays("Klassinen trolli", 1, "trolli");

        //Jantsu
        List jantsuniskut = new ArrayList<>();
        jantsuniskut.add(rationalisointi);
        jantsuniskut.add(klassikko);

        List jantsunheikkoudet = new ArrayList<>();
        jantsunheikkoudet.add("rationalisointi");
        jantsunheikkoudet.add("ego");

        List jantsunvahvuudet = new ArrayList<>();
        jantsunvahvuudet.add("tunteet");

        Hahmo jantsu = new Hahmo("Jantsu", 17, jantsuniskut, jantsunvahvuudet,
                jantsunheikkoudet);

        //Kukkis
        List kukkikseniskut = new ArrayList<>();
        kukkikseniskut.add(solvaus);
        kukkikseniskut.add(lapset);

        List kukkiksenheikkoudet = new ArrayList<>();
        kukkiksenheikkoudet.add("henkilökohtaisuus");
        kukkiksenheikkoudet.add("trolli");
        kukkiksenheikkoudet.add("tunteet");

        List kukkiksenvahvuudet = new ArrayList<>();
        kukkiksenvahvuudet.add("valelogiikka");
        kukkiksenvahvuudet.add("ego");

        Hahmo kukkis = new Hahmo("Kukkis", 13, kukkikseniskut,
                kukkiksenheikkoudet, kukkiksenvahvuudet);

        //Dosentti
        List dosentiniskut = new ArrayList<>();
        dosentiniskut.add(rationalisointi);
        dosentiniskut.add(asiantuntemus);

        List dosentinheikkoudet = new ArrayList<>();
        dosentinheikkoudet.add("henkilökohtaisuus");
        dosentinheikkoudet.add("ego");

        List dosentinvahvuudet = new ArrayList<>();
        dosentinvahvuudet.add("valelogiikka");

        Hahmo dosentti = new Hahmo("Dosentti", 15, dosentiniskut,
                dosentinheikkoudet, dosentinvahvuudet);

        this.lista.add(jantsu);
        this.lista.add(kukkis);
        this.lista.add(dosentti);
    }

    public void luoVihut() {
        Hyokkays klassikko = new Hyokkays("Klassinen trolli", 1, "trolli");
        
        Hyokkays aitis = new Hyokkays("Äitis on!", 1, "henkilokohtaisuus");
        Hyokkays laskukaava = new Hyokkays("Tarpeeton laskukaava", 1,
                "valelogiikka");
        Hyokkays isanKaveri = new Hyokkays("Mun isän kaveri on töissä...",
                2, "ego");
        Hyokkays pahaMieli = new Hyokkays("Nyt minun tuli paha mieli...",
                3, "tunteet");

        //Pikku-Pena
        List penaniskut = new ArrayList<>();
        penaniskut.add(aitis);
        penaniskut.add(isanKaveri);

        List penanheikkoudet = new ArrayList<>();
        penanheikkoudet.add("valelogiikka");
        penanheikkoudet.add("ego");

        List penanvahvuudet = new ArrayList<>();
        penanvahvuudet.add("henkilökohtaisuus");
        penanvahvuudet.add("tunteet");

        Hahmo pena = new Hahmo("Pikku-Pena", 4, penaniskut,
                penanheikkoudet, penanvahvuudet);
        
        //Mielensäpahoittaja
        List mpniskut = new ArrayList<>();
        mpniskut.add(pahaMieli);

        List mpnheikkoudet = new ArrayList<>();
        List mpnvahvuudet = new ArrayList<>();
        mpnvahvuudet.add("ego");

        Hahmo mielensapahoittaja = new Hahmo("Mielensäpahoittaja", 4, mpniskut,
                mpnheikkoudet, mpnvahvuudet);
        
        //"Nuori nero"
        List neroniskut = new ArrayList<>();
        neroniskut.add(laskukaava);
        neroniskut.add(klassikko);

        List neronheikkoudet = new ArrayList<>();
        neronheikkoudet.add("henkilökohtaisuus");
        neronheikkoudet.add("trolli");
        neronheikkoudet.add("tunteet");

        List neronvahvuudet = new ArrayList<>();
        neronvahvuudet.add("valelogiikka");
        
        Hahmo nuoriNero = new Hahmo("\"Nuori nero\"", 4, neroniskut,
                neronheikkoudet, neronvahvuudet);
        
        this.vihulista.add(pena);
        this.vihulista.add(mielensapahoittaja);
        this.vihulista.add(nuoriNero);
    }

    /**
     *
     * @return
     */
    public List<Hahmo> getLista() {
        return lista;
    }
    
    public Hahmo arvoVihu() {
        Random random = new Random();
        luoVihut();
        return this.vihulista.get(random.nextInt(2));
    }

}
