
package muistipeli.neanmuistipeli;

//TÄMÄ LUOKKA MUUTTUU PALJON SIIRRYTTÄESSÄ POIS PELKÄSTÄ TEKSTISTÄ. Hieman ajatusta tähän vain hain.
public class Pelialusta {

    private Korttipakka pakka;
    private int kortteja;

    public Pelialusta(Korttipakka korttipakka) {
        this.pakka = korttipakka;
        this.kortteja = 2 * pakka.parienMaara();
    }

    public void tulostaAlusta() {

        if (kortteja <= 6) {
            kortitAlustaan(kortteja / 2);

        } else if (kortteja > 6 && kortteja <= 16) {
            kortitAlustaan(4);

        } else {
            System.out.println("Kortteja määrä väärä!");
        }

        System.out.println("");
    }

    //Koska kortin arvot ovat tällä hetkellä numeroita, piilossa olevaa arvoa kuvaa 0.
    public int kortinArvo(Kortti kortti) {
        if (kortti.nakyykoKuva() || kortti.onkoLoydetty()) {
            return kortti.arvo();
        } else {
            return 0;
        }
    }

    private void kortitAlustaan(int rivinPituus) {
        int i = 1;

        for (Kortti k : pakka.kortit()) {
            System.out.print(" " + kortinArvo(k));

            if (i == rivinPituus) {
                System.out.println("");
                i = 0;
            }

            i++;
        }
    }
}
