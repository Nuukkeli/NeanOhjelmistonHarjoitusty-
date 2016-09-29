package muistipeli.neanmuistipeli.kortti;

public class Kortti {

    private int arvo; //Alustavasti int, mahdollisesti muuttuu myöhemmin.
    private boolean kuvaNakyvissa;
    private boolean loydetty;

    //Konstruktori
    public Kortti(int arvo) {
        this.arvo = arvo;
        this.kuvaNakyvissa = false;
        this.loydetty = false;
    }

    //Palauttaa kortin arvon.
    public int arvo() {
        return this.arvo;
    } //Jos muutetaan arvo(esim stringiksi), pitää tätäkin muuttaa.

    //Kertoo onko kortin kuva näkyvissä.
    public boolean nakyykoKuva() {
        return this.kuvaNakyvissa;
    }

    //Kertoo onko kortti loydetty.
    public boolean onkoLoydetty() {
        return this.loydetty;
    }

    //Asettaa kortin kuvan näkyväksi.
    public void kuvaNakyviin() {
        this.kuvaNakyvissa = true;
    }

    //Asettaa kortin kuvan piiloon.
    public void kuvaPiiloon() {
        this.kuvaNakyvissa = false;
    }

    //Asettaa kortin löydetyksi ja kuvan näkyväksi.
    public void loydettiin() {
        this.loydetty = true;
        this.kuvaNakyvissa = true;
    }
}
