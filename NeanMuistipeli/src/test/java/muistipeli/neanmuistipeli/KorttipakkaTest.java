/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author euro
 */
public class KorttipakkaTest {
    Korttipakka pakka;
    
    public KorttipakkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pakka = new Korttipakka(4);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test //Tätä olisi varmasti hyvä testata, mutten vielä tiedä miten
    public void korttipakkaSisaltaaKaikkiaArvojaKaksiKpl() {
    
    }
    
    @Test
    public void kaantyvatkoKaikkiKortitPiiloonKunYhtakaanEiOleLoydetty(){
        boolean jokinKuvaNakyy = false;
        
        pakka.kortit().get(0).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        
        pakka.kaannaKortit();
        
        for(Kortti k : pakka.kortit()){
            if(k.nakyykoKuva()){
                jokinKuvaNakyy = true;
                break;
            }
        }
        
        assertEquals(false, jokinKuvaNakyy);
    }
    
    @Test
    public void kaantyvatkoVainLoytamattomatKortitPiiloon(){
        boolean jokinKuvaNakyy = false;
        
        pakka.kortit().get(0).loydettiin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        
        pakka.kaannaKortit();
        
        for(Kortti k : pakka.kortit()){
            if(k.nakyykoKuva() && !k.onkoLoydetty()){
                jokinKuvaNakyy = true;
                break;
            }
        }
        
        assertEquals(false, jokinKuvaNakyy);
    }
}
