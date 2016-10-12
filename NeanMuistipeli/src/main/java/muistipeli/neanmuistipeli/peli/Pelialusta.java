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
    private PariPakka parit;
    private JarjestysPakka jarj;
    private int kaannettyja;
    private int pareja;
    private int yritykset;
    JButton[] korttiNappulat;
    boolean pelaaPariMuistipeli;
    JLabel yrityksia;
    boolean sekoitus;

    /**
     * Luokan konstruktori.
     *
     * @param parienMaara Montako paria kortteja peliin halutaan.
     *
     * @param pelataankoPariMuistipeli Totuusarvo, joka kertoo pelataanko
     * muistipeli, jossa etsitään pareja. Jos false, niin pelataan muistipeli,
     * jossa nappeja painetaan oikeassa järjestyksessä.
     *
     * @param sekoituskortti Totuusarvo, joka kertoo halutaanko peli, jossa on
     * mukana sekoituskortti, jonka löytyessä pakka sekoittuu.
     */
    public Pelialusta(int parienMaara, boolean pelataankoPariMuistipeli, boolean sekoituskortti) {
        pelaaPariMuistipeli = pelataankoPariMuistipeli;
        sekoitus = sekoituskortti;

        if (pelaaPariMuistipeli) {
            parit = new PariPakka(parienMaara, sekoituskortti);
        } else {
            jarj = new JarjestysPakka(parienMaara, sekoituskortti);
        }

        pareja = parienMaara;
        kaannettyja = 0;
        yritykset = 0;

        if (pelaaPariMuistipeli) {
            korttiNappulat = new JButton[parit.korttienMaara()];
        } else {
            korttiNappulat = new JButton[jarj.korttienMaara()];
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
                Kortti k = parit.kortit().get(i);

                if (korttiNappulat[i] == e.getSource() && !k.nakyykoKuva()) {

                    String arvo = "" + k.arvo();
                    k.kuvaNakyviin();

                    if (k.arvo() == 0 && sekoitus) {
                        k.loydettiin();
                        parit.sekoitaKortit();
                        kortitSekoittuu();
                        piilotaKaikkiKortitJoitaEiOleLoydetty();
                        kaannettyja = 0;

                    } else {
                        kaannettyja++;
                        korttiNappulat[i].setText(arvo);
                        korttiNappulat[i].setBackground(Color.orange);
                    }

                }
            }

        } else {

            for (int i = 0; i < korttiNappulat.length; i++) {
                Kortti k = jarj.kortit().get(i);

                if (korttiNappulat[i] == e.getSource() && !k.nakyykoKuva()) {

                    if (k.arvo() == 0) {
                        k.loydettiin();
                        jarj.sekoitaKortit();
                        kortitSekoittuu();
                        piilotaKaikki();

                    } else if (jarj.onkoSeuraava(k)) {
                        String arvo = "" + k.arvo();
                        k.kuvaNakyviin();
                        korttiNappulat[i].setText(arvo);
                        korttiNappulat[i].setBackground(Color.orange);
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

        parit.kaannaKortit();

        for (int i = 0; i < korttiNappulat.length; i++) {

            if (!parit.kortit().get(i).nakyykoKuva()) {
                korttiNappulat[i].setText("");
                korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
            }

        }

    }

    private void piilotaKaikki() {
        for (int i = 0; i < korttiNappulat.length; i++) {
            Kortti k = jarj.kortit().get(i);

            if (k.arvo() != 0) {
                jarj.kortit().get(i).kuvaPiiloon();
                korttiNappulat[i].setText("");
                korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
            }
        }
    }

    /**
     * Metodi asettaa voittotekstin, kun kaikki kortit on löydetty.
     */
    private void kaikkiLoytyivat() {

        Kysymysalusta kysymysalusta = new Kysymysalusta(true);
        kysymysalusta.aloita();

        ikkuna.dispose();

    }

    private void kortitSekoittuu() {
        for (int i = 0; i < korttiNappulat.length; i++) {

            if (pelaaPariMuistipeli) {
                Kortti k = parit.kortit().get(i);

                kortinKuva(k, i);

            } else {

                Kortti k = jarj.kortit().get(i);

                kortinKuva(k, i);
            }

        }
    }

    private void kortinKuva(Kortti k, int i) {
        if (k.nakyykoKuva() && k.arvo() == 0) {
            korttiNappulat[i].setText("Sekoitus");
            korttiNappulat[i].setBackground(Color.GREEN);
        } else if (k.nakyykoKuva()) {
            String arvo = "" + k.arvo();
            korttiNappulat[i].setText(arvo);
            korttiNappulat[i].setBackground(Color.orange);

        } else {
            korttiNappulat[i].setText("");
            korttiNappulat[i].setBackground(Color.LIGHT_GRAY);
        }
    }

}
