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
public class JarjestysTest {
    Jarjestys pakka;
    
    public JarjestysTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pakka = new Jarjestys(4);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void korttipakkaSisaltaaKaikkiaArvojaYhdenKappaleen() {

        for (int i = 1; i <= pakka.kortit().size(); i++) {
            int n = 0;

            for (Kortti k : pakka.kortit()) {
                if (k.arvo() == i) {
                    n++;
                }
            }

            assertEquals(1, n);
        }
    }
}
