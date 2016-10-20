**Testausdokumentaatio**

Pelin logiikkapuoli eli korttipakkaan ja kortteihin liittyvät luokat on yritetty testata mahdollisimman kattavasti automaattisilla 
testeillä. Ennen testien tekoa luokkien toimintaa testattiin myös käsin, jolloin tuli myös ilmi virheitä ja uusia asioita, joita on 
hyvä lisätä luokkiin ja testeihin. 

Muistipelin käyttöliittymä on testattu vain käsin. Kaikki pelimuodot on pelattu läpi muutamaan kertaan, jotta mahdolliset bugit 
löytyisivät. Peliä on testannut (pelaamalla sen läpi) useat ihmiset, sillä eri ihmiset kiinnittävät huomioita eri asioihin ja pelaavat 
eri taktiikoilla. Tällä tavalla käyttöliittymästä saatiin korjattua ainakin muutama bugi esimerkiksi korttien kääntymiseen liittyen. 

Ainakin yksi bugi peliin on jäänyt. Joissain tilanteissa järjestyspeliä pelatessa sekoituskortin jälkeen joutuu seuraavaa korttia 
klikkaamaan kahdesti, jotta se kääntyy. Eli, jos heti sekoituskortin jälkeen sattumalta onnistuu klikkaamaan ensimmäistä korttia, se ei 
silti aina käänny ellei sitä klikkaa toista kertaa. Tämä ei tapahdu aina, eikä tämän syytä ole onnistuttu löytämään. Muita bugeja pelistä 
ei ole ainakaan vielä löytynyt.  


 
