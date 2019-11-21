## Testausdokumentti

JUnit-testeillä on testattu algoritmin yleistä toimivuutta, että se esim. valitsee nopeimman tien voittoon. Olen testannut algoritmin toiminnallisuutta myös empiirisesti. Teoriassa ihmisen on mahdotonta voittaa minimax-algoritmia, ja pelin pitäisi päätyä aina tasapeliin kun algoritmi pelaa itseään vastaan 3x3-laudalla. Olen pelannut tekoälyä vastaan monesti enkä ole pystynyt voittamaan sitä, ja peli päätyy aina tasapaliin kun algoritmi pelaa itseään vastaan säännöillä, missä "voittorivin" koko on yhtä kuin laudan sivun pituus. Laajennettu ristinolla pienellä voittorivillä on luonteeltaan sellainen, että joissakin tilanteissa on mahdotonta estää vastustajaa voittamasta. Esim 5x5-lauta ja kolmen merkin voittorivi: jos X laittaa ensimmäisen siirtonsa laudan keskelle, niin O ei voi mitenkään estää X:ää voittamasta. Siis algoritmissa ei pitäisi olla virhettä, kun peli ei päädy tasapeliin pienellä voittorivillä.

Olen myös testannut algoritmin nopeutta, kun se pelaa itseään vastaan. Ensimmäinen siirto valitaan satunnaisesti, loput algoritmilla. Aika mitataan pelin alusta loppuun asti. Voittorivin pituus on aina yhtä kuin laudan sivun pituus. Pelin aikana tapahtuu pelilaudalle kirjoittamista ja konsoliin tulostamista, mutta tämän ei pitäisi vaikutaa nopeuteen merkittävästi.

* 3x3-lauta: 10-20 millisekuntia
* 4x4: noin 700 millisekuntia
* 5x5: noin 1.3 sekuntia
* 6x6: noin 1.7 sekuntia
* 8x8: noin 2 sekuntia
* 10x10: noin 2.5 sekuntia
* 15x15: noin 4 sekuntia
* 20x20: noin 8 sekuntia
* 25x25: noin 15 sekuntia
* 30x30: yli 30 sekuntia
