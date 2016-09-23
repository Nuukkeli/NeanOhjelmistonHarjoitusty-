/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli;

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
public class KorttiTest {

    Kortti kortti;

    public KorttiTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kortti = new Kortti(1);
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
    public void konstruktoriLuoKortinArvonOikein() {
        assertEquals(1, kortti.arvo());
    }

    @Test
    public void konstruktoriLuoKortinNakyvyydenOikein() {
        assertEquals(false, kortti.nakyykoKuva());
    }

    @Test
    public void konstruktoriKorttiEiVielaLoydetty() {
        assertEquals(false, kortti.onkoLoydetty());
    }

    @Test
    public void kuvaNakyviinKaantaaKuvanNakyviin() {
        kortti.kuvaNakyviin();
        assertEquals(true, kortti.nakyykoKuva());
    }

    @Test
    public void kuvaPiiloonPiilottaaKuvan() {
        kortti.kuvaNakyviin();
        kortti.kuvaPiiloon();
        assertEquals(false, kortti.nakyykoKuva());
    }

    @Test
    public void loydettyAsettaaKortinLoydetyksi() {
        kortti.loydettiin();
        assertEquals(true, kortti.onkoLoydetty());
    }
    
    @Test
    public void loydettyKorttiOnMyosNakyva(){
        kortti.loydettiin();
        assertEquals(true, kortti.nakyykoKuva());
    }

}
