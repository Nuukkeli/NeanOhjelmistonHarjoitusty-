
package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita 
 * pelattaessa muistipeliä, jossa etsitään kortteja suuruusjärjestyksessä.
 * 
 * Perii luokan Korttipakka metodit. 
 */
public class Jarjestys extends Korttipakka {
    ArrayList<Kortti> kaannetyt = new ArrayList<>();
    int kortteja;
    Kortti edellinen;
    Kortti edellinenKaannetty;
    
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
    
    public boolean onkoSeuraava(Kortti k) {

        if (edellinen == null) {
            if (k.arvo() == 1) {
                edellinen = k;
                k.loydettiin();
                return true;
            }

        } else if (edellinen.arvo() == k.arvo() - 1) {
            edellinen = k;
            k.loydettiin();
            return true;

        }

        k.kuvaPiiloon();
        return false;

    }
    
    public void nollaaEdellinen(){
        edellinen = null;
    }
    
    public Kortti edellinenKaannetty(){
        return edellinenKaannetty;
    }
    
    public void korttiKaannettiin(Kortti k){
        edellinenKaannetty = k;
    }
    
    
}
