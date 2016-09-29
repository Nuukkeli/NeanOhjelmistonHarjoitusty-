/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli.neanmuistipeli.peli;


//MUUTTUU JA PALJON! TARKOITUS, ETTÄ SAA VALITA PARIEN MÄÄRÄN (NAPPULAT) JA PELIMUODON (AINAKIN AIKAA JA YRITYKSIÄ VASTAAN, EHKÄ MYÖS KAKSINPELI)

public class Peli  {
    
    Pelialusta alusta;
    int pareja;
    
    public Peli(int parienMaara){
        pareja = parienMaara;
    }
    
    public void aloita(){
        alusta = new Pelialusta(pareja);
        alusta.pelaa();
        
    }
}
