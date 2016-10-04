package muistipeli.neanmuistipeli;

import muistipeli.neanmuistipeli.peli.*;

/**
 * Main luokka, joka käynnistää pelin.
 */
public class PeliMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Peli peli = new Peli(20, true);
        peli.aloita();
    }

}
