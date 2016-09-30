package muistipeli.neanmuistipeli.peli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import muistipeli.neanmuistipeli.kortti.*;

/**
 * Luokan konstruktori.
 */
public class Pelialusta extends JFrame implements ActionListener {

    private JFrame ikkuna;
    private Panel pelilauta;
    private Korttipakka pakka;
    private int kaannettyja;
    private int pareja;
    JButton[] korttiNappulat;

    public Pelialusta(int parienMaara) {
        
        pakka = new Korttipakka(parienMaara);
        pareja = parienMaara;
        kaannettyja = 0;
        korttiNappulat = new JButton[pakka.parienMaara() * 2];
    }

    /**
     * Metodi avaa käyttöliittymän ja aloittaa pelin.
     */
    public void pelaa() {

        ikkuna = new JFrame("Muistipeli");
        ikkuna.setPreferredSize(new Dimension(1000, 1000));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoPelilauta();

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    /**
     * Metodi luo pelilaudalle nappulat.
     */
    private void luoPelilauta() {
        pelilauta = new Panel();
        pelilauta.setLayout(new GridLayout(2, pareja));

        for (int i = 0; i < korttiNappulat.length; i++) {
            String arvo = "";

            korttiNappulat[i] = new JButton(arvo);
            korttiNappulat[i].setFont(new Font("Times New Roman", Font.PLAIN, 40));
            korttiNappulat[i].setBackground(Color.LIGHT_GRAY);

            korttiNappulat[i].addActionListener(this);
            pelilauta.add(korttiNappulat[i]);
        }

        ikkuna.add(pelilauta);
    }

    /**
     * Metodi luo tapahtuman, kun kortteja (nappeja) klikataan.
     * 
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (kaannettyja == 2) {

            if (pakka.ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat()) {
                pareja++;
                piilotaKaikkiKortitJoitaEiOleLoydetty();
                kaannettyja = 0;

                if (pakka.onkoKaikkiLoytynyt()) {
                    kaikkiLoytyivat();
                    //System.exit(0);
                }

            } else {

                piilotaKaikkiKortitJoitaEiOleLoydetty();
                kaannettyja = 0;

            }

        }

        for (int i = 0; i < korttiNappulat.length; i++) {

            if (korttiNappulat[i] == e.getSource() && !pakka.kortit().get(i).nakyykoKuva()) {
                kaannettyja++;
                String arvo = "" + pakka.kortit().get(i).arvo();
                pakka.kortit().get(i).kuvaNakyviin();
                korttiNappulat[i].setText(arvo);
                korttiNappulat[i].setBackground(Color.orange);

            }
        }

    }

    /**
     * Metodi asettaa kaikkien löytämättömien korttien arvon piiloon.
     */
    private void piilotaKaikkiKortitJoitaEiOleLoydetty() {
        pakka.kaannaKortit();

        for (int i = 0; i < korttiNappulat.length; i++) {

            if (!pakka.kortit().get(i).nakyykoKuva()) {
                korttiNappulat[i].setText("");
                korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
            }

        }
    }
    
    /**
     * Metodi asettaa voittotekstin, kun kaikki kortit on löydetty.
     * Tämä muuttuu varmasti.
     */
    private void kaikkiLoytyivat() {
        for (int i = 0; i < korttiNappulat.length; i++) {
            korttiNappulat[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            korttiNappulat[i].setBackground(Color.pink);
            korttiNappulat[i].setText("Voitit!!!!! :D:D:D");

        }

    }

}
