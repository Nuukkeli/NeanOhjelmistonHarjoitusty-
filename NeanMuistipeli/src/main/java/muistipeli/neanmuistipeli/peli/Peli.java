package muistipeli.neanmuistipeli.peli;

import muistipeli.neanmuistipeli.kortti.Korttipakka;
import muistipeli.neanmuistipeli.kortti.Kortti;
import java.util.Scanner;

public class Peli {

    private Pelialusta alusta;
    private Korttipakka pakka;
    private Scanner lukija;

    public Peli(int parienMaara) {
        pakka = new Korttipakka(parienMaara);
        alusta = new Pelialusta(pakka);
        lukija = new Scanner(System.in);
    }

    //Tässä vielä hieman toistoa. Yritän poistaa sitä myöhemmin.
    public void pelaa() {

        System.out.println("Pelataan");
        System.out.println("Korttien sijainnit välillä 1-" + pakka.parienMaara() * 2);
        System.out.println("Muut arvot lopettavat pelin");

        while (!pakka.onkoKaikkiLoytynyt()) {
            alusta.tulostaAlusta();

            System.out.println("Käännä ensimmäinen kortti");
            int eka = Integer.parseInt(lukija.nextLine());

            if (lopeta(eka)) {
                break;
            }

            Kortti ekaKortti = voikoKortinKaantaa(pakka.korttiSijainnilla(eka));
            ekaKortti.kuvaNakyviin();
            alusta.tulostaAlusta();

            System.out.println("Käännä toinen kortti");
            int toka = Integer.parseInt(lukija.nextLine());

            if (lopeta(toka)) {
                break;
            }

            Kortti tokaKortti = voikoKortinKaantaa(pakka.korttiSijainnilla(toka));
            tokaKortti.kuvaNakyviin();
            alusta.tulostaAlusta();

            if (pakka.ovatkoPari(ekaKortti, tokaKortti)) {
                System.out.println("Pari löytyi!");
                ekaKortti.loydettiin();
                tokaKortti.loydettiin();
            } else {
                System.out.println("Eivät ole pari. Yritä uudestaan.");
                pakka.kaannaKortit();
            }
        }

        if (pakka.onkoKaikkiLoytynyt()) {
            System.out.println("Voitit!");
        }

    }

    public boolean lopeta(int num) {
        if (num < 1 || num > pakka.parienMaara() * 2) {
            System.out.println("Lopetetaan");
            return true;
        } else {
            return false;
        }
    }

    public Kortti voikoKortinKaantaa(Kortti kortti) {

        while (kortti.onkoLoydetty() || kortti.nakyykoKuva()) {
            System.out.println("Korttia ei voi kääntää. Käännä toinen kortti.");
            int uusi = Integer.parseInt(lukija.nextLine());
            kortti = pakka.korttiSijainnilla(uusi);
        }

        return kortti;
    }

}
