/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;


//MUUTTUU JA PALJON! TARKOITUS, ETTÄ SAA VALITA PARIEN MÄÄRÄN (NAPPULAT) JA PELIMUODON (AINAKIN AIKAA JA YRITYKSIÄ VASTAAN, EHKÄ MYÖS KAKSINPELI)
//Mahdollisesti myös muoto, jossa pitää löytää kortit 1-korttien määrä oikeassa järjestyksessä. Tämä tarkoittaa myös korttipakkaluokan muuttamista.

/**
 * Luokka käynnistää pelin. Myöhemmin tekee varmasti muutakin.
 */
public class Peli  {
 
    Pelialusta alusta;
    int pareja;
    
    /**
     * Luokan konstruktori. 
     * 
     * @param parienMaara Korttiparien määrä, joka halutaan peliin.
     */
    public Peli(int parienMaara){
        pareja = parienMaara;
    }
    
    /**
     * Metodi aloittaa pelin.
     */
    public void aloita(){
        alusta = new Pelialusta(pareja);
        alusta.pelaa();
        
    }
}
