/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.kortti;

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
public class PariTest {

    PariPakka pakka;

    public PariTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pakka = new PariPakka(4);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void korttipakkaSisaltaaKaikkiaArvojaKaksiKpl() {
        ArrayList<Kortti> kortit = pakka.kortit;

        for (int i = 1; i < 5; i++) {
            int n = 0;
            for (Kortti kortti : kortit) {
                if (kortti.arvo() == i) {
                    n++;
                }
            }
            assertEquals(n, 2);
        }
    }

    @Test
    public void ovatkoPariTunnistaaJosKortitOvatPari() {
        Kortti eka = new Kortti(1);
        Kortti toka = new Kortti(1);

        assertEquals(true, pakka.ovatkoPari(eka, toka));
    }

    @Test
    public void ovatkoPariTunnistaaJosKortitEivatOlePari() {
        Kortti eka = new Kortti(10);
        Kortti toka = new Kortti(11);

        assertEquals(false, pakka.ovatkoPari(eka, toka));
    }

    @Test
    public void ovatkoKaannetytPariPalauttaaTrueJosKaannetytOvatPari() {
        Kortti eka = pakka.korttiSijainnilla(1);
        Kortti toka = pakka.korttiSijainnilla(2);

        for (int i = 1; i < pakka.parienMaara() * 2 - 1; i++) {

            if (eka.arvo() != toka.arvo()) {
                toka = pakka.korttiSijainnilla(2 + i);
            }
        }

        eka.kuvaNakyviin();
        toka.kuvaNakyviin();

        assertTrue(pakka.ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat());
        assertTrue(toka.onkoLoydetty());
        assertTrue(eka.onkoLoydetty());
    }

    @Test
    public void ovatkoKaannetytPariPalauttaaFalseJosKaannetytEivatOlePari() {
        Kortti eka = pakka.korttiSijainnilla(1);
        Kortti toka = pakka.korttiSijainnilla(2);

        if (eka.arvo() == toka.arvo()) {
            toka = pakka.korttiSijainnilla(3);
        }

        eka.kuvaNakyviin();
        toka.kuvaNakyviin();

        assertFalse(pakka.ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat());
        assertFalse(toka.onkoLoydetty());
        assertFalse(eka.onkoLoydetty());
    }
}
