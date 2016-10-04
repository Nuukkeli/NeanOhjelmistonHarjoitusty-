/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.kortti;

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
        pakka.luoKorttipakka(true);
    }

    @After
    public void tearDown() {
    }

    //Kaikkia metodeja ei testattu. Listan testaaminen vähän hakusessa. 
    //Testeille on tehty kyllä otsikoita, mutta sisältö puuttuu.
    @Test
    public void luoKorttiPakkaLuoParillisenPakanKunParametriOnTrue() {
        Korttipakka kp = new Korttipakka(3);
        kp.luoKorttipakka(true);

        for (int i = 1; i < 4; i++) {
            int n = 0;

            for (Kortti k : kp.kortit()) {
                if (k.arvo() == i) {
                    n++;
                }
            }
            assertEquals(2, n);
        }
    }
    
    @Test
    public void korttipakkaanEiVoiTullaLiikaaKortteja() {
        Korttipakka kp = new Korttipakka(32);
        kp.luoKorttipakka(false);

        assertEquals(10, kp.parienMaara());
    }

    @Test
    public void korttiPakkaanEiVoiTullaLiianVahanKortteja() {
        Korttipakka kp = new Korttipakka(0);
        kp.luoKorttipakka(true);

        assertEquals(2, kp.parienMaara());
    }

    @Test
    public void kaantyvatkoKaikkiKortitPiiloonKunYhtakaanEiOleLoydetty() {
        boolean jokinKuvaNakyy = false;

        pakka.kortit().get(0).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara() - 1).kuvaNakyviin();

        pakka.kaannaKortit();

        for (Kortti k : pakka.kortit()) {
            if (k.nakyykoKuva()) {
                jokinKuvaNakyy = true;
                break;
            }
        }

        assertEquals(false, jokinKuvaNakyy);
    }

    @Test
    public void kaantyvatkoVainLoytamattomatKortitPiiloon() {
        boolean loytamattomiaNakyy = false;

        pakka.kortit().get(0).loydettiin();
        pakka.kortit.get(pakka.parienMaara()).kuvaNakyviin();
        pakka.kortit.get(pakka.parienMaara() - 1).kuvaNakyviin();

        pakka.kaannaKortit();

        for (Kortti k : pakka.kortit()) {
            if (k.nakyykoKuva() && !k.onkoLoydetty()) {
                loytamattomiaNakyy = true;
                break;
            }
        }

        assertEquals(false, loytamattomiaNakyy);
    }

    
    @Test
    public void onkoKaikkiLoytynytPalauttaaTrueJosKaikkiOnLoytynyt() {

        for (Kortti k : pakka.kortit()) {
            k.loydettiin();
        }

        assertEquals(true, pakka.onkoKaikkiLoytynyt());
    }

    @Test
    public void ovatkoKaikkiLoytynytPalauttaaFalseJosKaikkiEiOleLoytynyt() {

        pakka.kortit.get(0).loydettiin();
        pakka.kortit.get(pakka.parienMaara() - 1).loydettiin();

        assertFalse(pakka.onkoKaikkiLoytynyt());
    }

    @Test
    public void kortinSijaintiPalauttaaKortinSijainnin() {
        Kortti k = pakka.kortit().get(pakka.parienMaara() * 2 - 2);
        int sijainti = pakka.kortinSijainti(k);

        assertEquals(pakka.parienMaara() * 2 - 1, sijainti);
    }

    @Test
    public void korttiSijainnillaPalauttaaOikeanKortin() {
        Kortti k = pakka.kortit.get(1);
        Kortti kortti = pakka.korttiSijainnilla(2);

        assertEquals(k.arvo(), kortti.arvo());
    }

}
