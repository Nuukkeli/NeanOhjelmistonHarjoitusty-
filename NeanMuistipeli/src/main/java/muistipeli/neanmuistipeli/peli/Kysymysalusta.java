/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Luokka käynnistää pelin. Myöhemmin tekee varmasti muutakin.
 */
public class Kysymysalusta extends JFrame implements ActionListener {

    private Pelialusta pelialusta;
    int pareja;
    boolean pelaaPariMuistipeli;
    boolean sekoituskortti;
    JFrame alusta;
    private JRadioButton helppo;
    private JRadioButton keskitaso;
    private JRadioButton vaikea;
    private JRadioButton haaste;
    private JRadioButton pari;
    private JRadioButton jarjestys;
    private JRadioButton sekoitusJoo;
    private JRadioButton sekoitusEi;
    private JButton aloita;
    boolean pelattu;
    
    /**
     * Luokan konstruktori.
     *
     */
    public Kysymysalusta(boolean onkoJoPelattu) {
        pareja = 2;
        pelattu = onkoJoPelattu;
        pelaaPariMuistipeli = true;
        sekoituskortti = false;
    }    

    /**
     * Metodi aloittaa pelin.
     */
    public void aloita() {
        this.kysymysAlusta();
    }
    
    public void kysymysAlusta() {

        if (pelattu) {
            alusta = new JFrame("Uusi peli?");
            alusta.setLayout(new GridLayout(5, 1));
        } else {
            alusta = new JFrame("Valitse peli ja vaikeustaso");
            alusta.setLayout(new GridLayout(4,1));
        }

        alusta.setPreferredSize(new Dimension(400, 600));
        
        
        if(pelattu){
            JLabel laabeli = new JLabel("VOITIT! :D");
            Font fontti = new Font("Comic Sans", Font.BOLD, 20);
            laabeli.setFont(fontti);
            laabeli.setForeground(Color.pink);
            alusta.add(laabeli);
        }
        
        JPanel pelimuotopaneeli = pelimuotopaneeli();
        JPanel vaikeustasopaneeli = vaikeustasopaneeli();
        
        JPanel sekoituskortti = new JPanel(new GridLayout(3,1));
        sekoituskortti.add(new JLabel("Sekoituskortti peliin?"));
        sekoitusJoo = new JRadioButton("Joo!");
        sekoitusJoo.addActionListener(this);
        sekoituskortti.add(sekoitusJoo);
        sekoitusEi = new JRadioButton("Ei!");
        sekoitusEi.addActionListener(this);
        sekoituskortti.add(sekoitusEi);
        
        alusta.add(pelimuotopaneeli);
        alusta.add(vaikeustasopaneeli);
        alusta.add(sekoituskortti);
        
        aloita = new JButton("Aloita");
        aloita.addActionListener(this);
        alusta.add(aloita);
        
        alusta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        alusta.pack();
        alusta.setVisible(true);
    }
    
    private JPanel pelimuotopaneeli(){
        JPanel pelimuotopaneeli = new JPanel(new GridLayout(4, 4));
        
        ButtonGroup peli = new ButtonGroup();
        
        jarjestys = new JRadioButton("Järjestys muistipeli");
        jarjestys.addActionListener(this);
        peli.add(jarjestys);
        pari = new JRadioButton("Pari muistipeli");
        pari.addActionListener(this);
        peli.add(pari);
        
        pelimuotopaneeli.add(new JLabel("Valitse pelimuoto:"));
        pelimuotopaneeli.add(pari);
        pelimuotopaneeli.add(jarjestys);
        
        return pelimuotopaneeli;
    }
    
    private JPanel vaikeustasopaneeli(){
        JPanel vaikeustasopaneeli = new JPanel(new GridLayout(5,1));
        
        ButtonGroup vaikeus = new ButtonGroup();
        
        helppo = new JRadioButton("Helppo");
        helppo.addActionListener(this);
        vaikeus.add(helppo);
        keskitaso = new JRadioButton("Keskitaso");
        keskitaso.addActionListener(this);
        vaikeus.add(keskitaso);
        vaikea = new JRadioButton("Vaikea");
        vaikea.addActionListener(this);
        vaikeus.add(vaikea);
        haaste = new JRadioButton("HAASTE");
        haaste.addActionListener(this);
        vaikeus.add(haaste);
        
        vaikeustasopaneeli.add(new JLabel("Valitse vaikeustaso: "));
        vaikeustasopaneeli.add(helppo);
        vaikeustasopaneeli.add(keskitaso);
        vaikeustasopaneeli.add(vaikea);
        vaikeustasopaneeli.add(haaste);
        
        return vaikeustasopaneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click!");
        
        if(e.getSource() == pari){
            pelaaPariMuistipeli = true;
        } 
        
        if(e.getSource() == jarjestys){
            pelaaPariMuistipeli = false;
        }
        
        if(e.getSource() == helppo){
            pareja = 2;
        }
        
        if(e.getSource() == keskitaso){
            pareja = 4;
        }
        
        if(e.getSource() == vaikea){
            pareja = 6;
        }
        
        if(e.getSource() == haaste){
            pareja = 10;
        }
        
        if (e.getSource() == sekoitusJoo) {
           sekoituskortti = true;
        }
        
        if(e.getSource() == sekoitusEi){
            sekoituskortti = false;
        }
        
        if(e.getSource() == aloita){
            pelialusta = new Pelialusta(pareja, pelaaPariMuistipeli, sekoituskortti);
            pelialusta.pelaa();
            alusta.dispose();
            
        }
    }
}
