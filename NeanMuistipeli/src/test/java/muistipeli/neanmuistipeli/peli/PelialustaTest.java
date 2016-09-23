/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;

import muistipeli.neanmuistipeli.peli.Pelialusta;
import muistipeli.neanmuistipeli.kortti.Korttipakka;
import muistipeli.neanmuistipeli.kortti.Kortti;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collections;
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
public class PelialustaTest {

    //Testit alustavia ja vähäisiä, sillä luokka muuttuu varmasti kun siirrytään käyttöliittymään.
    Korttipakka pakka;
    Pelialusta alusta;
    
    public PelialustaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pakka = new Korttipakka(3);
        alusta = new Pelialusta(pakka);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void kortinArvoKertooKortinArvonKunKuvaOnNakyvissa(){
        Kortti kortti = pakka.korttiSijainnilla(1);
        kortti.kuvaNakyviin();
        
        assertEquals(kortti.arvo(), alusta.kortinArvo(kortti));
    }
    
    @Test
    public void kortinArvoKertooKortinArvonKunKorttiOnLoydetty(){
        Kortti kortti = pakka.korttiSijainnilla(3);
        kortti.loydettiin();
        
        assertEquals(kortti.arvo(), alusta.kortinArvo(kortti));
    }
    
    @Test
    public void kortinArvoEiKerroKortinArvoaKunKuvaEiOleNakyvissa(){
        Kortti kortti = pakka.korttiSijainnilla(2);
        
        assertEquals(0, alusta.kortinArvo(kortti));
    }
}
