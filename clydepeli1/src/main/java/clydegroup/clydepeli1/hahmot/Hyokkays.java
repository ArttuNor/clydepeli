package clydegroup.clydepeli1.hahmot;

public class Hyokkays {

    private String nimi;
    private int voima;

    public Hyokkays(String nimi, int voima) {
        this.nimi = nimi;
        this.voima = voima;
    }

    public void kayta(Hahmo h) {
        h.menetaElamaa(voima);
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getVoima() {
        return voima;
    }

    public void setVoima(int voima) {
        this.voima = voima;
    }

}
