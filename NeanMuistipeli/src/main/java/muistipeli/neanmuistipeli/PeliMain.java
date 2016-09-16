
package muistipeli.neanmuistipeli;

public class PeliMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ei vielä juuri mitään lopulliseen peliin liittyvää.
        
        //Luokan Kortti toiminnan kokeilua
        
        /*Kortti kortti = new Kortti(5);
        System.out.println(kortti.arvo());
        System.out.println(kortti.onkoLoydetty());
        System.out.println(kortti.nakyykoKuva());
        
        kortti.kuvaNakyviin();
        System.out.println(kortti.nakyykoKuva());
        
        kortti.kuvaPiiloon();
        System.out.println(kortti.nakyykoKuva());
        
        kortti.loydettiin();
        System.out.println(kortti.onkoLoydetty());
        
        //Luokan Korttipakka toiminnan kokeilua
        Korttipakka pakka = new Korttipakka(5);
        
        for(Kortti k : pakka.kortit()){
            Kortti b = pakka.kortit().get(1);
            int a = b.arvo();
            
            if(k.arvo() == a && pakka.kortit().indexOf(k) != 1){
                k.loydettiin();
                b.loydettiin();
                k.kuvaNakyviin();
                b.kuvaNakyviin();
            }
        }
        
        pakka.kaannaKortit();
        
        for(Kortti k : pakka.kortit){
            System.out.println("Kortti " + k.arvo());
            System.out.println(k.nakyykoKuva());
            System.out.println(k.onkoLoydetty());
        }
        
        System.out.println("Kortteja pakassa: " + pakka.korttienMaara());*/
        
        Korttipakka pakka = new Korttipakka(6);
        Pelialusta alusta = new Pelialusta(pakka);
        
        alusta.tulostaAlusta();
        
        for(Kortti k : pakka.kortit()){
            Kortti b = pakka.kortit().get(1);
            int a = b.arvo();
            
            if(k.arvo() == a && pakka.kortit().indexOf(k) != 1){
                k.loydettiin();
                b.loydettiin();
                k.kuvaNakyviin();
                b.kuvaNakyviin();
            }
        }
        
        alusta.tulostaAlusta();
    }
    
}
