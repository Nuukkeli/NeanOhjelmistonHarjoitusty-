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
 * Luokka luo käyttöliittymän eli pelialustan, jolla muistipeliä pelataan.
 */
public class Pelialusta extends JFrame implements ActionListener {

    private JFrame ikkuna;
    private Panel pelilauta;
    private Pari parit;
    private Jarjestys jarj;
    private int kaannettyja;
    private int pareja;
    private int yritykset;
    JButton[] korttiNappulat;
    boolean pelaaPariMuistipeli;
    JLabel yrityksia;

    /**
     * Luokan konstruktori.
     *
     * @param parienMaara Montako paria kortteja peliin halutaan.
     *
     * @param pelataankoPariMuistipeli Totuusarvo, joka kertoo pelataanko
     * muistipeli, jossa etsitään pareja. Jos false, niin pelataan muistipeli,
     * jossa nappeja painetaan oikeassa järjestyksessä.
     */
    public Pelialusta(int parienMaara, boolean pelataankoPariMuistipeli) {
        pelaaPariMuistipeli = pelataankoPariMuistipeli;

        if (pelaaPariMuistipeli) {
            parit = new Pari(parienMaara);
        } else {
            jarj = new Jarjestys(parienMaara);
        }

        pareja = parienMaara;
        kaannettyja = 0;
        yritykset = 0;

        if (pelaaPariMuistipeli) {
            korttiNappulat = new JButton[parit.parienMaara() * 2];
        } else {
            korttiNappulat = new JButton[jarj.parienMaara() * 2];
        }
    }

    /**
     * Metodi avaa käyttöliittymän ja aloittaa pelin.
     */
    public void pelaa() {

        ikkuna = new JFrame("Muistipeli");
        ikkuna.setPreferredSize(new Dimension(1000, 1000));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //ikkuna.setLayout(new GridLayout(1, 2));

        //yrityksia = new JLabel("Yrityksiä: " + yritykset);
        //ikkuna.add(yrityksia);
        luoPelilauta();

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    /**
     * Metodi luo pelilaudalle nappulat.
     */
    private void luoPelilauta() {
        pelilauta = new Panel();

        if (pareja < 5) {
            pelilauta.setLayout(new GridLayout(2, pareja));

        } else if (pareja > 4 && pareja < 7) {
            pelilauta.setLayout(new GridLayout(3, 4));

        } else {
            pelilauta.setLayout(new GridLayout(4, 5));

        }

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

        if (this.pelaaPariMuistipeli) {
            if (kaannettyja == 2) {
                //yritykset++;
                //yrityksia.setText("Yrityksiä: " + yritykset);

                if (parit.ovatkoKaannetytPariJaAsetaLoytyneeksiJosOvat()) {
                    pareja++;
                    piilotaKaikkiKortitJoitaEiOleLoydetty();
                    kaannettyja = 0;

                    if (parit.onkoKaikkiLoytynyt()) {
                        kaikkiLoytyivat();
                        //System.exit(0);
                    }

                } else {

                    piilotaKaikkiKortitJoitaEiOleLoydetty();
                    kaannettyja = 0;

                }

            }

            for (int i = 0; i < korttiNappulat.length; i++) {

                if (korttiNappulat[i] == e.getSource() && !parit.kortit().get(i).nakyykoKuva()) {
                    kaannettyja++;
                    String arvo = "" + parit.kortit().get(i).arvo();
                    parit.kortit().get(i).kuvaNakyviin();
                    korttiNappulat[i].setText(arvo);
                    korttiNappulat[i].setBackground(Color.orange);

                }
            }

        } else {

            for (int i = 0; i < korttiNappulat.length; i++) {
                Kortti k = jarj.kortit().get(i);

                if (korttiNappulat[i] == e.getSource() && !k.nakyykoKuva()) {
                    String arvo = "" + k.arvo();
                    k.kuvaNakyviin();
                    korttiNappulat[i].setText(arvo);
                    korttiNappulat[i].setBackground(Color.orange);

                    if (jarj.onkoSeuraava(k)) {
                        kaannettyja++;

                        if (jarj.onkoKaikkiLoytynyt()) {
                            this.kaikkiLoytyivat();
                        }

                    } else {
                        jarj.nollaaEdellinen();
                        piilotaKaikki();
                    }

                }
            }
        }

    }

    /**
     * Metodi asettaa kaikkien löytämättömien korttien arvon piiloon.
     */
    private void piilotaKaikkiKortitJoitaEiOleLoydetty() {

        if (pelaaPariMuistipeli) {
            parit.kaannaKortit();

            for (int i = 0; i < korttiNappulat.length; i++) {

                if (!parit.kortit().get(i).nakyykoKuva()) {
                    korttiNappulat[i].setText("");
                    korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
                }

            }
        } else {
            jarj.kaannaKortit();

            for (int i = 0; i < korttiNappulat.length; i++) {

                if (!jarj.kortit().get(i).nakyykoKuva()) {
                    korttiNappulat[i].setText("");
                    korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
                }

            }
        }
    }

    private void piilotaKaikki() {
        for (int i = 0; i < korttiNappulat.length; i++) {
            jarj.kortit().get(i).kuvaPiiloon();
            korttiNappulat[i].setText("");
            korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
        }
    }

    /**
     * Metodi asettaa voittotekstin, kun kaikki kortit on löydetty. Tämä muuttuu
     * varmasti.
     */
    private void kaikkiLoytyivat() {
        for (int i = 0; i < korttiNappulat.length; i++) {
            korttiNappulat[i].setFont(new Font("Times New Roman", Font.BOLD, 15));
            korttiNappulat[i].setBackground(Color.pink);
            korttiNappulat[i].setText("Voitit!!!!! :D:D:D");
            //int yrityksiaLopuksi = yritykset - 1;
            //yrityksia.setText("Voitit! Yrityksiä kului " + yrityksiaLopuksi);

        }

    }

}
