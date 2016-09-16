
package muistipeli.neanmuistipeli;

import java.util.ArrayList;
import java.util.Collections;

public class Korttipakka {
    ArrayList<Kortti> kortit = new ArrayList<>();
    private int pareja; //Vakiomäärä vai valittava? Ja tarvitaanko muualla kuin luokan alustuksessa? 
    
    public Korttipakka(int pareja){
        this.pareja = pareja; //Luodaan pareille min ja max määrät myöhemmin 
        
        for(int i = 1; i <= pareja ; i++){
            Kortti ekaKortti = new Kortti(i);
            Kortti tokaKortti = new Kortti(i);
            
            kortit.add(ekaKortti);
            kortit.add(tokaKortti);
        }
        
        Collections.shuffle(kortit);
    }
    
    public ArrayList<Kortti> kortit(){
        return this.kortit;
    }
    
    public void kaannaKortit(){
        for(Kortti kortti : kortit){
            if(!kortti.onkoLoydetty()){
                kortti.kuvaPiiloon();
            }
        }
    }
    
    //Kortin arvolla vai sijainnilla? Alustavasti sijainnilla, koska arvoa ei tiedetä etsittäessä
    public Kortti korttiSijainnilla(int sijainti){
        return kortit.get(sijainti);
    }
    
    public int parienMaara(){
        return pareja;
    }
}
