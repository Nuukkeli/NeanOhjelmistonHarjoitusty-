package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka tarjoaa korttien yhteyksien selvittämiseen tarvittavia metodeita
 * pelattaessa muistipeliä, jossa etsitään kortteja suuruusjärjestyksessä.
 *
 * Perii luokan Korttipakka metodit.
 */
public class JarjestysPakka extends Korttipakka {

    ArrayList<Kortti> kaannetyt = new ArrayList<>();
    int kortteja;
    Kortti edellinen;
    Kortti edellinenKaannetty;

    /**
     * Luokan konstruktori, jossa luodaan korttipakka.
     *
     * @param parienMaara Kertoo kuinka monta paria kortteja halutaan (vaikka ei
     * etsitäkään pareja).
     * 
     * @param sekoituskortti Kertoo onko pelissä mukana sekoituskortti, 
     * jonka löytyessä kortit sekoittuvat uudelleen.
     */
    public JarjestysPakka(int parienMaara, boolean sekoituskortti) {
        super(parienMaara, sekoituskortti);
        super.luoKorttipakka(false);
        kortteja = parienMaara * 2;
    }

    /**
     * Metodi kertoo onko parametriksi annettu kortti seuraavana
     * suuruusjärjestyksessä. Jos kortti on seuraava suuruusjärjestyksessä
     * metodi asettaa kortin edelliseksi kortiksi, johon seuraavaa korttia 
     * verrataan.
     *
     * @param k Kortti, josta halutaan tietää, onko se seuraava
     * suuruusjärjestyksessä.
     *
     * @return Totuusarvo, joka kertoo onko parametriksi annettu kortti
     * seuraava.
     */
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

    /**
     * Metodi nollaa edellisen löydetyn kortin.
     */
    public void nollaaEdellinen() {
        edellinen = null;
    }

}
