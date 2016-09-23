package muistipeli.neanmuistipeli;

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

    public void pelaa() {

        System.out.println("Pelataan");
        System.out.println("Korttien sijainnit välillä 1-" + pakka.parienMaara() * 2);

        while (!pakka.onkoKaikkiLoytynyt()) {
            alusta.tulostaAlusta();

            System.out.println("Käännä ensimmäinen kortti");
            int eka = Integer.parseInt(lukija.nextLine());

            if (lopeta(eka)) {
                break;
            }

            Kortti ekaKortti = pakka.korttiSijainnilla(eka);
            ekaKortti.kuvaNakyviin();
            alusta.tulostaAlusta();

            System.out.println("Käännä toinen kortti");
            int toka = Integer.parseInt(lukija.nextLine());

            if (lopeta(toka)) {
                break;
            }

            Kortti tokaKortti = pakka.korttiSijainnilla(toka);
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

    private boolean lopeta(int num) {
        if (num < 0 || num > pakka.parienMaara() * 2) {
            System.out.println("Lopetetaan");
            return true;
        } else {
            return false;
        }
    }

    /*private Kortti kaannaKortti(){
     int sijainti = Integer.parseInt(lukija.nextLine());
        
     if (sijainti < 0 || sijainti > pakka.parienMaara() * 2) {
     System.out.println("Sijainti on välillä 0-" + pakka.parienMaara()*2);
     kaannaKortti();
     } 
        
     Kortti kortti = pakka.korttiSijainnilla(sijainti);
     kortti.kuvaNakyviin();
     alusta.tulostaAlusta();
        
     return kortti;
     }
    
     private void pariTarkastelu(){
        
     }*/
}
