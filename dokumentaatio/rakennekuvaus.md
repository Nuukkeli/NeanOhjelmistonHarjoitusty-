# Rakennekuvaus

Peli sisältää kortteja (luokka Kortti), joita kääntämällä etsitään pareja tai kortteja oikeassa järjestyksessä. 
Luokka Korttipakka sisältää kortteja 4-21 kappaletta riippuen pelin vaikeustasosta ja siitä halutaanko peliin mukaan 
ylimääräinen kortti, jonka löytyessä löytämättömät kortit sekoittuvat. Luokat PariPakka ja JarjestysPakka perivät luokan 
Korttipakka ominaisuudet. PariPakka on korttipakka, jota käytetään perinteisessä muistipelissä, jossa etsitään korteille 
pareja. JarjestysPakka on korttipakka, jota käytetään muistipelissä, jossa kortteja yritetään löytää oikeassa järjestyksessä.

Pelin käyttöliittymällä (luokka PeliAlusta) on käytössään joko JarjestysPakka tai PariPakka, riippuen pelimuodosta. 
Pelimuoto valitaan luokassa KysymysAlusta, jossa voi valita pelimuodon lisäksi myös vaikeustason ja sekoituskortin. 
KysymysAlusta antaa tiedot luokalle PeliAlusta, joka käynnistää pelin.
