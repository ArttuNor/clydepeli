package clydegroup.clydepeli1.hahmot;

public class Hyokkays {

    private String nimi;
    private int voima;
    private final String tyyppi;

    public Hyokkays(String nimi, int voima, String tyyppi) {
        this.nimi = nimi;
        this.voima = voima;
        this.tyyppi = tyyppi;
    }

    public void kayta(Hahmo h) {
        int tehtyVahinko = this.voima;

        for (String heikkous : h.getHeikkoudet()) {
            if (this.tyyppi.equals(heikkous)) {
                tehtyVahinko = tehtyVahinko * 2;
            }
        }

        for (String vahvuus : h.getVahvuudet()) {
            if (this.tyyppi.equals(vahvuus)) {
                if ((tehtyVahinko - 2) > -1) {
                    tehtyVahinko = tehtyVahinko - 2;
                } else {
                    tehtyVahinko = 0;
                }
            }
        }

        h.menetaElamaa(tehtyVahinko);
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
