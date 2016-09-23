/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;

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
public class PeliTest {

    //Testejä melko vähän. Luokka muuttuu käyttöliittymän myötä. 
    //Peli tehty valmiiksi vain, jotta ajatus muistipelin toiminnasta ja 
    //vaatimista huomioista selkiytyy.
    Peli peli;

    public PeliTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        peli = new Peli(3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void peliLoppuuJosPelaajaSyottaaLiianPienenLuvun() {
        assertTrue(peli.lopeta(0));
    }

    @Test
    public void peliLoppuuJosPelaajaSyottaaLiianIsonLuvun() {
        assertTrue(peli.lopeta(7));
    }

    //Tätä olisi hyvä testata. Syötteet testeissä hieman epäselviä. 
    //Selvitän asian seuraaville viikoille.
    @Test
    public void peliTunnistaaJosKorttiOnJoLoydettyEikaAnnaKaantaaSita() {

    }

}
