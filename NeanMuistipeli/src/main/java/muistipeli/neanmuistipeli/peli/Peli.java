/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;

//MUUTTUU JA PALJON! TARKOITUS, ETTÄ SAA VALITA PARIEN MÄÄRÄN (NAPPULAT) JA PELIMUODON.

/**
 * Luokka käynnistää pelin. Myöhemmin tekee varmasti muutakin.
 */
public class Peli {

    private Pelialusta alusta;
    int pareja;
    boolean pelaaPariMuistipeli;

    /**
     * Luokan konstruktori.
     *
     * @param parienMaara Korttiparien määrä, joka halutaan peliin.
     * 
     * @param pelataankoPariMuistipeli Kertoo pelataanko muistipeli, jossa 
     * etsitään pareja.
     */
    public Peli(int parienMaara, boolean pelataankoPariMuistipeli) {
        pareja = parienMaara;
        pelaaPariMuistipeli = pelataankoPariMuistipeli;
    }    

    /**
     * Metodi aloittaa pelin.
     */
    public void aloita() {
        alusta = new Pelialusta(pareja, pelaaPariMuistipeli);
        alusta.pelaa();

    }
}
