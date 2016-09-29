
package muistipeli.neanmuistipeli.peli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import muistipeli.neanmuistipeli.kortti.*;

public class Pelialusta extends JFrame implements ActionListener {
    
    private JFrame ikkuna; 
    Panel pelilauta;
    Korttipakka pakka;
    int kaannettyja;
    int pareja;
    JButton[] korttiNappulat;
    
    public Pelialusta(int parienMaara){
        pakka = new Korttipakka(parienMaara);
        kaannettyja = 0;
        korttiNappulat = new JButton[parienMaara*2];
    }

    public void pelaa() {
        ikkuna = new JFrame("Muistipeli");
        ikkuna.setPreferredSize(new Dimension(500, 500));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoPelilauta();
        
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    
    
    private void luoPelilauta(){
        pelilauta = new Panel();
        pelilauta.setLayout(new GridLayout(2,3));
        
        for(int i = 0; i < korttiNappulat.length; i++){
            String arvo = "?";
            
            korttiNappulat[i] = new JButton(arvo);
            
            korttiNappulat[i].addActionListener(this);
            pelilauta.add(korttiNappulat[i]);
        }
        
        ikkuna.add(pelilauta);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < korttiNappulat.length; i++) {

            if (korttiNappulat[i] == e.getSource() && !pakka.kortit().get(i).nakyykoKuva()) {
                kaannettyja++;
                String arvo = "" + pakka.kortit().get(i).arvo();
                pakka.kortit().get(i).kuvaNakyviin();
                korttiNappulat[i].setText(arvo);

            }
        }

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
        
    }
    
    public void piilotaKaikkiKortitJoitaEiOleLoydetty(){
        pakka.kaannaKortit();
        
        for(int i = 0; i < korttiNappulat.length ; i++){
            
            if(!pakka.kortit().get(i).nakyykoKuva()){
                korttiNappulat[i].setText("?");
            }
            
        }
    }
    
    public void kaikkiLoytyivat(){
        for(int i = 0; i < korttiNappulat.length ; i++){
            korttiNappulat[i].setText("Voitit!!!!! :D:D:D");
        }
    }

}
