
package muistipeli.neanmuistipeli;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {
    
    private JFrame ikkuna; 
    
    public Kayttoliittyma(){

    }

    @Override
    public void run() {
        ikkuna = new JFrame("Muistipeli");
        ikkuna.setPreferredSize(new Dimension(100, 200));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ikkuna.getContentPane());
        
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        BoxLayout asettelu = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(asettelu);
        
        container.add(new JLabel("Montako paria?"));
        container.add(new JButton("2 paria"));
        container.add(new JButton("4 paria"));
        container.add(new JButton("6 paria"));
        container.add(new JButton("8 paria"));
    }
    
    public JFrame palautaIkkuna(){
        return ikkuna;
    }

}
