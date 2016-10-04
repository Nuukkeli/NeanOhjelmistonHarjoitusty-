package muistipeli.neanmuistipeli;

import muistipeli.neanmuistipeli.kortti.*;
import muistipeli.neanmuistipeli.peli.*;

/**
 * Main luokka, joka käynnistää pelin.
 */
public class PeliMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Peli peli = new Peli(9, true);
        peli.aloita();
    }

}
