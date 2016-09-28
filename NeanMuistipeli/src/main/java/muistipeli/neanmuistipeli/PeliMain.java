package muistipeli.neanmuistipeli;

import muistipeli.neanmuistipeli.peli.*;
import javax.swing.SwingUtilities;

public class PeliMain {

    /**
     * @param args the command line arguments
     */
    //Muistipeli toimii, mutta käyttöliittymää en ole vielä luonut. 
    //Itseäni vain helpottaa toteuttaa projekti ensin näin, jotta toiminta hahmottuu.
    public static void main(String[] args) {
        
        Peli peli = new Peli();
        peli.aloita();
    }

}
