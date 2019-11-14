## Testausdokumentti

JUnit-testeillä on testattu algoritmin yleistä toimivuutta, että se esim. valitsee nopeimman tien voittoon. Pelasin tekoälyä vastaan enkä voinut voitaa sitä, eli sen pitäisi toimia niin kuin pitää ainakin 3x3-laudalla. Tekoälyn voi myös laittaa pelaamaan itseään vastaan ja peli päättyy aina tasapeliin, niin kuin pitäisi aina käydä toimivalla minimax-algoritmilla. Tekoäly voi pelata itseään vastaan mielivaltaisen suurella pelilaudalla, mutta pelin "voittorivi" on nyt aina yhtä pitkä kuin laudan pituus. Ensimmäinen siiro valitaan satunnaisesti, loput algoritmilla. Olen testannut algoritmin nopeutta kun se pelaa itseään vastaan, aika mitataan pelin alusta loppuun asti. Pelin aikana tapahtuu pelilaudalle kirjoittamista ja konsoliin tulostamista, mutta tämän ei pitäisi vaikutaa nopeuteen merkittävästi.

* 3x3-lauta: 10-20 millisekuntia
* 4x4: noin 250 millisekuntia
* 5x5: noin 500 millisekuntia
* 6x6: noin 700 millisekuntia
* 10x10: noin 1.7 sekuntia
* 15x15: noin 8 sekuntia
* 20x20: yli 30 sekuntia
