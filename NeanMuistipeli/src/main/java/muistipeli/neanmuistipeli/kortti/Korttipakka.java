package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;


/**
 * Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita. 
 */
public class Korttipakka {

    ArrayList<Kortti> kortit = new ArrayList<>();
    private int pareja;  
    
    /**
     * Luokan konstruktori. 
     * 
     * @param pareja Korttipakan sisältämien korttiparien määrä.
     */
    public Korttipakka(int pareja) {

        if (pareja > 8) {
            this.pareja = 8;
        } else if (pareja < 2) {
            this.pareja = 2;
        } else {
            this.pareja = pareja; //Parien max määrä alustava ja toiminta "väärissä" tilanteissa alustavaa 
        }

        for (int i = 1; i <= this.pareja; i++) {
            Kortti ekaKortti = new Kortti(i);
            Kortti tokaKortti = new Kortti(i);

            kortit.add(ekaKortti);
            kortit.add(tokaKortti);
        }

        Collections.shuffle(kortit);
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

    /**
     * Metodi kertoo ovatko parametreiksi annetut kortit pari.
     * 
     * @param eka Kortti, josta halutaan tietää onko se pari toisen kortin kanssa.
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
