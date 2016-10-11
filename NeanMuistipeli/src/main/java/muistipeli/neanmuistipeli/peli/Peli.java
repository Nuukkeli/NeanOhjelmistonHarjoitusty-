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
public class Peli extends JFrame implements ActionListener {

    private Pelialusta pelialusta;
    int pareja;
    boolean pelaaPariMuistipeli;
    JFrame alusta;
    private JRadioButton helppo;
    private JRadioButton keskitaso;
    private JRadioButton vaikea;
    private JRadioButton haaste;
    private JRadioButton pari;
    private JRadioButton jarjestys;
    private JButton aloita;
    
    /**
     * Luokan konstruktori.
     *
     */
    public Peli() {
        pareja = 2;
        pelaaPariMuistipeli = true;
    }    

    /**
     * Metodi aloittaa pelin.
     */
    public void aloita() {
        this.kysymysAlusta();
    }
    
    public void kysymysAlusta(){
        alusta = new JFrame("Valitse peli ja vaikeustaso");
        alusta.setPreferredSize(new Dimension(500, 500));
        alusta.setLayout(new GridLayout(3, 1));
        
        JPanel pelimuotopaneeli = new JPanel(new GridLayout(4, 4));
        
        ButtonGroup peli = new ButtonGroup();
        ButtonGroup vaikeus = new ButtonGroup();
        
        jarjestys = new JRadioButton("Järjestys muistipeli");
        jarjestys.addActionListener(this);
        pari = new JRadioButton("Pari muistipeli");
        pari.addActionListener(this);
        
        pelimuotopaneeli.add(new JLabel("Valitse pelimuoto:"));
        
        peli.add(pari);
        pelimuotopaneeli.add(pari);
        peli.add(jarjestys);
        pelimuotopaneeli.add(jarjestys);
        
        helppo = new JRadioButton("Helppo");
        helppo.addActionListener(this);
        keskitaso = new JRadioButton("Keskitaso");
        keskitaso.addActionListener(this);
        vaikea = new JRadioButton("Vaikea");
        vaikea.addActionListener(this);
        haaste = new JRadioButton("HAASTE");
        haaste.addActionListener(this);
        
        JPanel vaikeustasopaneeli = new JPanel(new GridLayout(4,4));
                
        pelimuotopaneeli.add(new JLabel("Valitse vaikeustaso: "));
        
        vaikeus.add(helppo);
        vaikeustasopaneeli.add(helppo);
        vaikeus.add(keskitaso);
        vaikeustasopaneeli.add(keskitaso);
        vaikeus.add(vaikea);
        vaikeustasopaneeli.add(vaikea);
        vaikeus.add(haaste);
        vaikeustasopaneeli.add(haaste);
        
        alusta.add(pelimuotopaneeli);
        alusta.add(vaikeustasopaneeli);
        
        aloita = new JButton("Aloita");
        aloita.addActionListener(this);
        alusta.add(aloita);
        
        alusta.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        alusta.pack();
        alusta.setVisible(true);
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
        
        if(e.getSource() == aloita){
            pelialusta = new Pelialusta(pareja, pelaaPariMuistipeli);
            pelialusta.pelaa();
            
        }
    }
}
