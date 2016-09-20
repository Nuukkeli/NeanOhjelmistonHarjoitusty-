/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli;

import java.util.Scanner;

/**
 *
 * @author euro
 */
public class Peli {
    
    private Pelialusta alusta;
    private Korttipakka pakka;
    private Scanner lukija;
    
    public Peli(int parienMaara){
        pakka = new Korttipakka(parienMaara);
        alusta = new Pelialusta(pakka);
        lukija = new Scanner(System.in);
    }
    
    public void pelaa(){
     
        System.out.println("Pelataan");
        System.out.println("Lopeta peli painamalla 0");
        
        
        while(!pakka.onkoKaikkiLoytynyt()){
            alusta.tulostaAlusta();
            
            System.out.println("Käännä ensimmäinen kortti");
            int ekaKortti = Integer.parseInt(lukija.nextLine());
            
            if(lopeta(ekaKortti)){
                break;
            }
            
            System.out.println("Käännä toinen kortti");
            int tokaKortti = Integer.parseInt(lukija.nextLine());
            
            
            if(lopeta(tokaKortti)){
                break;
            }
            
            Kortti eka = pakka.korttiSijainnilla(ekaKortti);
            Kortti toka = pakka.korttiSijainnilla(tokaKortti);
            
            eka.kuvaNakyviin();
            toka.kuvaNakyviin();
            
            alusta.tulostaAlusta();
            
            if(pakka.ovatkoPari(eka, toka)){
                eka.loydettiin();
                toka.loydettiin();
            } else {
                pakka.kaannaKortit();
            }
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
}
