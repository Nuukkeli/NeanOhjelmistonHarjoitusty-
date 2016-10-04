
package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita 
 * pelattaessa muistipeliä, jossa etsitään kortteja suuruusjärjestyksessä.
 */
public class Jarjestys extends Korttipakka {
    ArrayList<Kortti> kortit = new ArrayList<>();
    int kortteja;
    Kortti edellinen;
    
    /**
     * Luokan konstruktori, jossa luodaan korttipakka.
     * 
     * @param parienMaara Kertoo kuinka monta paria kortteja halutaan (vaikka ei 
     * etsitäkään pareja).
     */
    public Jarjestys(int parienMaara) {
        super(parienMaara);
        super.luoKorttipakka(false);
        kortteja = parienMaara * 2;
    }

    public void asetaEdelliseksi(Kortti k){
        edellinen = k;
    }
    
    public boolean ovatkoPerakkain(Kortti k){
        if(edellinen.arvo() == k.arvo()-1){
            return true;
        }
        
        return false;
    }
    
    
}
