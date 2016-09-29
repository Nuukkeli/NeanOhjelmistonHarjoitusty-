package muistipeli.neanmuistipeli.kortti;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;

public class Korttipakka {

    ArrayList<Kortti> kortit = new ArrayList<>();
    private int pareja; //Vakiomäärä vai valittava? Ja tarvitaanko muualla kuin luokan alustuksessa? 
    
    

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

    public ArrayList<Kortti> kortit() {
        return this.kortit;
    }

    public void kaannaKortit() {
        for (Kortti kortti : kortit) {
            if (!kortti.onkoLoydetty()) {
                kortti.kuvaPiiloon();
            }
        }
    }

    public Kortti korttiSijainnilla(int sijainti) {
        return kortit.get(sijainti - 1);
    }

    public int kortinSijainti(Kortti kortti) {
        int sijainti = kortit.indexOf(kortti) + 1;
        return sijainti;
    }

    public int parienMaara() {
        return this.pareja;
    }

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

    public boolean ovatkoPari(Kortti eka, Kortti toka) {

        if (eka.arvo() == toka.arvo()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat(){
        boolean ovatkoPari = false;
        Kortti eka = null;
        Kortti toka = null;
        
        for(Kortti k : kortit()){
            
            if(k.nakyykoKuva() && !k.onkoLoydetty()){
                eka = k;
                break;
            }
            
        }
        
        for(Kortti k : kortit()){
            
            if(k.nakyykoKuva() && !k.onkoLoydetty() && this.kortinSijainti(k) != this.kortinSijainti(eka)){
                toka = k;
            }
        }
        
        if(eka.arvo() == toka.arvo()){
            ovatkoPari = true;
            eka.loydettiin();
            toka.loydettiin();
        }
        
        return ovatkoPari;
    }
    
    

}
