
package muistipeli.neanmuistipeli.kortti;

import java.util.Collections;

/**
 *Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita 
 *pelattaessa muistipeliä, jossa etsitään pareja. 
 * 
 * Perii luokan Korttipakka metodit.
 */
public class PariPakka extends Korttipakka {
    
    /**
     * Luokan konstruktori.
     * 
     * @param pareja Peliin haluttu korttiparien määrä.
     * 
     * @param sekoituskortti Totuusarvo, joka kertoo lisätäänkö korttipakkaan 
     * sekoituskortti.
     */
    public PariPakka(int pareja, boolean sekoituskortti) {
        super(pareja, sekoituskortti);
        
        super.luoKorttipakka(true);
    }

    /**
     * Metodi kertoo ovatko käännetyt (kaksi) korttia pari. Jos kortit ovat pari
     * metodi asettaa kortit löytyneiksi. Käännettyjä kortteja voi olla pelilaudalla
     * enemmän kuin kaksi, mutta muut ovat löytyneet. Metodi siis selvittää ovatko
     * kaksi käännettyä, mutta ei löydettyä, korttia pari.
     *
     * @return Totuusarvo, joka kertoo ovatko käännetyt kortit pari.
     */
    public boolean ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat() {
        boolean ovatkoPari = false;
        Kortti eka = null;
        Kortti toka = null;

        for (Kortti k : kortit()) {

            if (k.nakyykoKuva() && !k.onkoLoydetty()) {
                eka = k;
                break;
            }

        }

        for (Kortti k : kortit()) {

            if (k.nakyykoKuva() && !k.onkoLoydetty() && this.kortinSijainti(k) != this.kortinSijainti(eka)) {
                toka = k;
            }
        }

        if (eka.arvo() == toka.arvo()) {
            ovatkoPari = true;
            eka.loydettiin();
            toka.loydettiin();
        }

        return ovatkoPari;
    }

}
