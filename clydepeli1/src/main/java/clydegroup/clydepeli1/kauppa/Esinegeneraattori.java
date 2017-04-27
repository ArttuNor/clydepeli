
package clydegroup.clydepeli1.kauppa;

import java.util.Random;

public class Esinegeneraattori {
    
    public Esine arvoEsine(){
        Random random = new Random();
        int tulos = random.nextInt(2);
        
        if(tulos == 0){
            return (new Kofeiini(5));
        } else {
            return (new KilautaModelle(3));
        }
        
    }
}
