
package muistipeli.neanmuistipeli;

public class Kortti {
    
    private int arvo; //Alustavasti int, mahdollisesti muuttuu myöhemmin.
    private boolean kuvaNakyvissa;
    private boolean loydetty;
    
    public Kortti(int arvo){
        this.arvo = arvo;
        this.kuvaNakyvissa = false;
        this.loydetty = false;
    }
    
    public int arvo(){
        return this.arvo;
    } //Jos muutetaan arvo(esim stringiksi), pitää tätäkin muuttaa.
    
    public boolean nakyykoKuva(){
        return this.kuvaNakyvissa;
    }
    
    public boolean onkoLoydetty(){
        return this.loydetty;
    }
    
    public void kuvaNakyviin(){
        this.kuvaNakyvissa = true;
    }
    
    public void kuvaPiiloon(){
        this.kuvaNakyvissa = false;
    }
    
    public void loydettiin(){
        this.loydetty = true;
    }
}
