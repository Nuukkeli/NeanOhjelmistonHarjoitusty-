package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;

public class Korttipakka {

    ArrayList<Kortti> kortit = new ArrayList<>();
    private int pareja; //Vakiomäärä vai valittava? Ja tarvitaanko muualla kuin luokan alustuksessa? 

    //Korttipakan konstruktori. Muutetaan mahdollisesti niin, että tietyissä tilanteissa kortit ovat järjestyslukuja.
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

    //Palauttaa listan korteista.
    public ArrayList<Kortti> kortit() {
        return this.kortit;
    }

    //Kääntää kaikki kortit, joita ei ole löydetty.
    public void kaannaKortit() {
        for (Kortti kortti : kortit) {
            if (!kortti.onkoLoydetty()) {
                kortti.kuvaPiiloon();
            }
        }
    }

    //Palauttaa kortin tietystä sijainnista.
    public Kortti korttiSijainnilla(int sijainti) {
        return kortit.get(sijainti - 1);
    }

    //Palauttaa tietyn kortin sijainnin.
    public int kortinSijainti(Kortti kortti) {
        int sijainti = kortit.indexOf(kortti) + 1;
        return sijainti;
    }

    //Palauttaa parien määrän.
    public int parienMaara() {
        return this.pareja;
    }

    //Kertoo ovatko kaikki kortit löydetty.
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

    //Kertoo ovatko kortit pari. Mahdollisesti turha metodi, nyt kun peli toimii käyttöliittymässä.
    public boolean ovatkoPari(Kortti eka, Kortti toka) {

        if (eka.arvo() == toka.arvo()) {
            return true;
        } else {
            return false;
        }
    }

    //Kertoo ovatko käännetyt kortit pari.
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
