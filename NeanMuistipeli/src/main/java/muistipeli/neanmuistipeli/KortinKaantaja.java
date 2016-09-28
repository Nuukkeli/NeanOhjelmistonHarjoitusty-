/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import muistipeli.neanmuistipeli.kortti.*;

/**
 *
 * @author euro
 */
public class KortinKaantaja implements ActionListener {

    private Kortti kortti;
    private JButton button;
    int kaannettyja;
    Korttipakka pakka;
    
    public KortinKaantaja(JButton nappi, Kortti k) {
        button = nappi;
        kaannettyja = 0;
        kortti = k;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String arvo = "" + kortti.arvo();
        button.setText(arvo);

    }

}
