
package muistipeli.neanmuistipeli;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;
import muistipeli.neanmuistipeli.kortti.*;
import muistipeli.neanmuistipeli.KortinKaantaja;

public class Kayttoliittyma extends JFrame implements ActionListener {
    
    private JFrame ikkuna; 
    Panel pelilauta;
    Korttipakka pakka;
    int kaannettyja;
    JButton[] korttiNappulat;
    
    public Kayttoliittyma(){
        pakka = new Korttipakka(4);
        kaannettyja = 0;
        korttiNappulat = new JButton[8];
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
            
            //KortinKaantaja kaanto = new KortinKaantaja(korttiNappulat[i], pakka.kortit().get(i));
            korttiNappulat[i].addActionListener(this);
            pelilauta.add(korttiNappulat[i]);
        }
        
        ikkuna.add(pelilauta);
    }

    
    /*private void montakoKorttiparia(){
        BoxLayout asettelu = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(asettelu);
        
        container.add(new JLabel("Montako paria?"));
        container.add(new JButton("2 paria"));
        container.add(new JButton("4 paria"));
        container.add(new JButton("6 paria"));
        container.add(new JButton("8 paria"));
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(kaannettyja == 2){
            
            
        } else {
            
            for(int i = 0; i < korttiNappulat.length; i++){
                
                if(korttiNappulat[i] == e.getSource()){
                    String arvo = "" + pakka.kortit().get(i).arvo();
                    korttiNappulat[i].setText(arvo);
                    kaannettyja++;
                }
            }
        }
    }

}
