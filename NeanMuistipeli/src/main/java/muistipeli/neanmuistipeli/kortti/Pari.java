/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.kortti;

import java.util.Collections;

/**
 *Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita 
 *pelattaessa muistipeliä, jossa etsitään pareja. 
 * 
 * Perii luokan Korttipakka metodit.
 */
public class Pari extends Korttipakka {

    public Pari(int pareja) {
        super(pareja);
        
        super.luoKorttipakka(true);
    }

    /**
     * Metodi kertoo ovatko parametreiksi annetut kortit pari.
     *
     * @param eka Kortti, josta halutaan tietää onko se pari toisen kortin
     * kanssa.
     *
     * @param toka Kortti, josta halutaan tietää onko se pari ensimmäisen kortin
     * kanssa.
     *
     * @return Totuusarvo, joka kertoo ovatko parametreiksi annetut kortit pari.
     */
    public boolean ovatkoPari(Kortti eka, Kortti toka) {

        if (eka.arvo() == toka.arvo()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodi kertoo ovatko käännetyt (kaksi) korttia pari.
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
