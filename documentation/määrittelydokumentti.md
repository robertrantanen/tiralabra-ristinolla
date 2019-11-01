## Määrittelydokumentti

Tarkoitus on luoda tekoäly ristinolla-pelille. Ohjelmointikielenä Java. Tekoäly toteutetaan minimax-algoritmilla, joka on peruuttavan etsinnän tapainen. Ongelma voidaan kuvitella puuna, jonka solmuja ovat pelilaudan mahdolliset tilanteet. Algoritmi saa syötteenä pelilaudan tilanteen ja käy puun laskentahaaroja läpi rekursiivisesti, ja valitsee optimaalisen siirron. Algoritmia voidaan mahdollisesti nopeuttaa alpha-beta pruning-menetelmällä, joka karsii turhia laskentahaaroja pois. Tavalliset taulukot ja kaksiulotteiset taulukot ovat luultavasti toteuttamiseen riittäviä tietorakenteita. 3x3-pelilauta on ilmeisesti hyvin helppoa toteuttaa nopeasti, algoritmin pitäisi pystyä toimimaan myös suuremmilla pelilaudoilla. Algoritmin aikavaativuus on luonnollisesti pelilaudan kokoon nähden eksponentiaalinen, mutta optimointi voi tehdä siitä tarpeeksi nopean käsittelemään suurempia syötteitä kuin 3x3-pelilauta.

### lähteitä:
[https://en.wikipedia.org/wiki/Minimax](https://en.wikipedia.org/wiki/Minimax)

[https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-3-tic-tac-toe-ai-finding-optimal-move/](https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-3-tic-tac-toe-ai-finding-optimal-move/)
