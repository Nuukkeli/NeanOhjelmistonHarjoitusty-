package muistipeli.neanmuistipeli.kortti;

/**
 * Luokka tarjoaa ominaisuuksia ja metodeja yksittäiselle muistipelin kortille.
 */
public class Kortti {

    private int arvo; //Alustavasti int, mahdollisesti muuttuu myöhemmin.
    private boolean kuvaNakyvissa;
    private boolean loydetty;

    /**
     * Luokan konstruktori.
     *
     * @param arvo Kortin arvo.
     */
    public Kortti(int arvo) {
        this.arvo = arvo;
        this.kuvaNakyvissa = false;
        this.loydetty = false;
    }

    /**
     * Metodi palauttaa kortin arvon.
     *
     * @return Kortin arvo.
     */
    public int arvo() {
        return this.arvo;
    }

    /**
     * Metodi kertoo onko kortin kuva näkyvissä.
     *
     * @return Totuusarvo, joka kertoo onko kortin kuva näkyvissä.
     */
    public boolean nakyykoKuva() {
        return this.kuvaNakyvissa;
    }

    /**
     * Metodi kertoo onko kortti löydetty, eli onko sen pari löydetty.
     *
     * @return Totuusarvo, joka kertoo onko kortti löydetty.
     */
    public boolean onkoLoydetty() {
        return this.loydetty;
    }

    /**
     * Metodi asettaa kortin arvon näkyviin.
     */
    public void kuvaNakyviin() {
        this.kuvaNakyvissa = true;
    }

    /**
     * Metodi asettaa kortin arvon piiloon.
     */
    public void kuvaPiiloon() {
        this.kuvaNakyvissa = false;
    }

    /**
     * Metodi asettaa kortin löydetyksi.
     */
    public void loydettiin() {
        this.loydetty = true;
        this.kuvaNakyvissa = true;
    }
}
