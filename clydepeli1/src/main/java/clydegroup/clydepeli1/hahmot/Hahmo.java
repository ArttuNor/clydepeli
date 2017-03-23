package clydegroup.clydepeli1.hahmot;

import java.util.List;

public class Hahmo {

    private String nimi;
    private int hp;
    private List<Hyokkays> hyokkaykset;

    public Hahmo(String nimi, int hp, List<Hyokkays> hyokkaykset) {
        this.nimi = nimi;
        this.hp = hp;
        this.hyokkaykset = hyokkaykset;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public List<Hyokkays> getHyokkaykset() {
        return hyokkaykset;
    }

    public void setHyokkaykset(List<Hyokkays> hyokkaykset) {
        this.hyokkaykset = hyokkaykset;
    }

    public void menetaElamaa(int menetys) {
        if (menetys > this.hp) {
            this.hp = 0;
        } else {
            this.hp = this.hp - menetys;
        }
    }

    public void opiHyokkays(Hyokkays h) {
        this.hyokkaykset.add(h);
    }
}
