package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;


/**
 * Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita.
 */
public class Korttipakka {

    ArrayList<Kortti> kortit;
    int pareja;

    /**
     * Luokan konstruktori.
     *
     * @param pareja Korttipakan sisältämien korttiparien määrä.
     */
    public Korttipakka(int pareja) {
        this.pareja = pareja;
        kortit = new ArrayList<>();
    }
    
    /**
     * Metodi luo korttipakan, eli listan joka sisältää pelin kortit. 
     * 
     * @param pareilla Totuusarvo kertoo tuleeko korteille olla parit vai onko 
     * jokaista kortti vain yksi.
     */
    public void luoKorttipakka(boolean pareilla) {

        if (pareja > 10) {
            this.pareja = 10;
        } else if (pareja < 2) {
            this.pareja = 2;
        }

        if (pareilla) {

            for (int i = 1; i <= this.pareja; i++) {
                Kortti ekaKortti = new Kortti(i);
                Kortti tokaKortti = new Kortti(i);

                kortit.add(ekaKortti);
                kortit.add(tokaKortti);
            }

            Collections.shuffle(kortit);
            
        } else {

            for (int i = 1; i <= pareja * 2; i++) {
                Kortti k = new Kortti(i);
                kortit.add(k);
            }

            Collections.shuffle(kortit);
        }
    }

    /**
     * Metodi palauttaa listan, joka sisältää korttipakan kortit.
     *
     * @return Lista korteista.
     */
    public ArrayList<Kortti> kortit() {
        return this.kortit;
    }

    /**
     * Metodi asettaa kaikkien löytämättömien korttien näkyvyyden totuusarvoksi
     * "false", eli asettaa korttien arvot piiloon.
     */
    public void kaannaKortit() {
        for (Kortti kortti : kortit) {
            if (!kortti.onkoLoydetty()) {
                kortti.kuvaPiiloon();
            }
        }
    }

    /**
     * Metodi palauttaa kortin tietystä sijainnista.
     *
     * @param sijainti Sijainti, josta kortti haetaan. Sijainnit ovat välillä
     * 1-n, jossa n on korttien määrä.
     *
     * @return Kortti, joka sijaitsee haetussa sijainnissa.
     */
    public Kortti korttiSijainnilla(int sijainti) {
        return kortit.get(sijainti - 1);
    }

    /**
     * Metodi palauttaa parametriksi annetun kortin sijainnin.
     *
     * @param kortti Kortti, jonka sijainti pakassa halutaan tietää.
     *
     * @return Parametriksi annetun kortin sijainti. Sijainnit ovat välillä 1-n,
     * jossa n on korttien määrä.
     */
    public int kortinSijainti(Kortti kortti) {
        int sijainti = kortit.indexOf(kortti) + 1;
        return sijainti;
    }

    /**
     * Metodi palauttaa korttipakan parien määrän.
     *
     * @return Korttipakan korttiparien määrä.
     */
    public int parienMaara() {
        return this.pareja;
    }

    /**
     * Metodi kertoo ovatko kaikki korttipakan kortit löytyneet, eli palauttaa
     * totuusarvon true, jos kaikki kortit on löydetty.
     *
     * @return Totuusarvo, joka kertoo ovatko kaikki kortit löytyneet.
     */
    public boolean onkoKaikkiLoytynyt() {

        boolean kaikkiLoytynyt = true;

        for (Kortti k : kortit) {
            if (!k.onkoLoydetty()) {
                kaikkiLoytynyt = false;
                break;
            }
        }

        return kaikkiLoytynyt;
    }
}
