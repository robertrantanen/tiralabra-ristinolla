## viikkoraportti 2

Tällä viikolla tein ensimmäisen version minimax-algoritmista. Kysessä on täysin optimoimaton versio, se toimii hyvin 3x3-laudalla, mutta 4x4 on jo liian hidas. Ohjelmoin myös pelilaudan logiikka ja tekstikäyttöliittymää. Ohjelmalla voi nyt pelata tekoälyä vastaan 3x3-laudalla. Toteutin myös pari JUnit-testiä ja konfiguraatiot jacocoon, checkstyleen ja jarin generointiin. En oikein oppinut mitään uutta, sovelsin vain jo oppimaani.

Vaikeuksia tuotti pelilaudan tilanteen evaluointi mielivaltaisella laudan koolla. Eli siis onko laudalla X:n voitto vai O:n voitto, vai ei kumpaakaan. Nykyinen versio käy läpi jokaisen rivin, jokaisen sarakkeen ja molemmat diagonaalit, ja tarkistaa boolean-muuttujalla, että toistuuko aina sama merkki. Epäselvää on, että miten saan evaluoinnin toimimaan mielivaltaisella "voittorivin" koolla. Esim. 5x5-laudalla voitaisiin voittaa kolmen merkin sekvenssillä, mutta tämän toteuttaminen tuntuu hankalalta diagonaalien suhteen.

Seuraavaksi alan optimoimaan algoritmia ja toteutan tietokone vastaan tietokone-toiminnallisuuden. Samalla voidaan testata myös algoritmin nopeutta. Yritän myös pohtia ylläolevaa ongelmaa, nykyinen toteutus on mahdollisesti huono myös aikavaativuuden kannalta. En katsonut kelloa koodatessani, mutta arvioin aikaa kuluneen noin 10 tuntia tällä viikolla.
