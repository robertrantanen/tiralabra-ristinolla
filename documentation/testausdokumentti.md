## Testausdokumentti

JUnit-testeillä on testattu algoritmin yleistä toimivuutta, että se esim. valitsee nopeimman tien voittoon. Olen testannut algoritmin toiminnallisuutta myös empiirisesti. Teoriassa ihmisen on mahdotonta voittaa minimax-algoritmia, ja pelin pitäisi päätyä aina tasapeliin kun algoritmi pelaa itseään vastaan 3x3-laudalla. Olen pelannut tekoälyä vastaan monesti enkä ole pystynyt voittamaan sitä, ja peli päätyy aina tasapaliin kun algoritmi pelaa itseään vastaan säännöillä, missä "voittorivin" koko on yhtä kuin laudan sivun pituus. Laajennettu ristinolla pienellä voittorivillä on luonteeltaan sellainen, että joissakin tilanteissa on mahdotonta estää vastustajaa voittamasta. Esim 5x5-lauta ja kolmen merkin voittorivi: jos X laittaa ensimmäisen siirtonsa laudan keskelle, niin O ei voi mitenkään estää X:ää voittamasta. Siis algoritmissa ei pitäisi olla virhettä, kun peli ei päädy tasapeliin pienellä voittorivillä.

Olen myös testannut algoritmin nopeutta, kun se pelaa itseään vastaan. Ensimmäinen siirto valitaan satunnaisesti, loput algoritmilla. Aika mitataan pelin alusta loppuun asti. Voittorivin pituus on aina yhtä kuin laudan sivun pituus. Pelin aikana tapahtuu pelilaudalle kirjoittamista ja konsoliin tulostamista, mutta tämän ei pitäisi vaikutaa nopeuteen merkittävästi.

* 3x3-lauta: 10-20 millisekuntia
* 4x4: noin 400 millisekuntia
* 5x5: noin 700 millisekuntia
* 6x6: noin 900 millisekuntia
* 8x8: noin 1.2 sekuntia
* 10x10: noin 1.5 sekuntia
* 15x15: noin 2 sekuntia
* 20x20: noin 2.8 sekuntia
* 25x25: noin 7 sekuntia
* 30x30: noin 20 sekuntia
* 35x35: yli 40 sekuntia
