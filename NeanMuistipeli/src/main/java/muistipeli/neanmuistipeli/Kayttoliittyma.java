
package muistipeli.neanmuistipeli;

import java.awt.*;
import javax.swing.*;
import muistipeli.neanmuistipeli.kortti.*;

public class Kayttoliittyma implements Runnable {
    
    private JFrame ikkuna; 
    Panel pelilauta;
    Korttipakka pakka;
    
    public Kayttoliittyma(){
        pakka = new Korttipakka(3);
    }

    @Override
    public void run() {
        ikkuna = new JFrame("Muistipeli");
        ikkuna.setPreferredSize(new Dimension(500, 500));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoPelilauta();
        
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    
    private void luoPelilauta(){
        pelilauta = new Panel();
        
        pelilauta.setLayout(new GridLayout(2, 3));
        
        for(Kortti k : pakka.kortit()){
            String arvo = " " + k.arvo();
            pelilauta.add(new JButton(arvo));
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
    
    public JFrame palautaIkkuna(){
        return ikkuna;
    }

}
