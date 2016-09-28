/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;

import java.util.Scanner;



public class Peli  {
    
    private Scanner lukija;
    Pelialusta alusta;
    
    public Peli(){
        lukija = new Scanner(System.in);
    }
    
    public void aloita(){
        
        System.out.println("Montako paria? Kaksi, neljä, kuusi vai kahdeksan? Syötä tekstimuodossa.");
        
        boolean onnistuiko = false;

        while (!onnistuiko) {
            String pareja = lukija.nextLine();

            if (pareja.equals("Kaksi") || pareja.equals("kaksi")) {
                alusta = new Pelialusta(2);
                onnistuiko = true;
            } else if (pareja.equals("Neljä") || pareja.equals("neljä")) {
                alusta = new Pelialusta(4);
                onnistuiko = true;
            } else if (pareja.equals("Kuusi") || pareja.equals("kuusi")) {
                alusta = new Pelialusta(6);
                onnistuiko = true;
            } else if (pareja.equals("Kahdeksan") || pareja.equals("kahdeksan")) {
                alusta = new Pelialusta(8);
                onnistuiko = true;
            } else {
                System.out.println("Väärä parien määrä: Kaksi, neljä, kuusi vai kahdeksan paria?");
            }
        }
        
        alusta.pelaa();
        
    }
}
