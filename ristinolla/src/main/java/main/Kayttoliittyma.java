package main;

import algoritmit.Minimax;
import java.util.Scanner;
import pelilauta.Pelilauta;

public class Kayttoliittyma {

    private Pelilauta pelilauta;
    private Minimax minimax;
    private Scanner lukija;

    public Kayttoliittyma(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
        this.minimax = new Minimax();
        this.lukija = new Scanner(System.in);
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    
    public void ihminenVsAi() {
        System.out.println("Ristinolla");
        System.out.println("Syötteet muotoa 'rivi sarake' esim '0 0'");
        pelilauta.tulostaLauta();
        System.out.println("");

        while (true) {

            if (minimax.laudanTulos(pelilauta.getLauta()) == 100) {
                System.out.println("Sinä voitit");
                break;
            }
            if (minimax.laudanTulos(pelilauta.getLauta()) == -100) {
                System.out.println("Tietokone voitti");
                break;
            }

            System.out.print("Syöte: ");
            String siirto = lukija.nextLine();
            String[] palat = siirto.split(" ");
            int rivi = Integer.valueOf(palat[0]);
            int sarake = Integer.valueOf(palat[1]);
            if (!this.pelilauta.getLauta()[rivi][sarake].equals("_")) {
                System.out.println("Yritit huijata!");
            } else {
                this.pelilauta.lisaaMerkki("X", rivi, sarake);
            }
            System.out.println("");
            pelilauta.tulostaLauta();
            System.out.println("");

            if (!minimax.siirtojaJaljella(this.pelilauta.getLauta())) {
                System.out.println("Tasapeli");
                break;
            }

            siirto = minimax.parasLiike(this.pelilauta.getLauta(), "O");
            palat = siirto.split(" ");
            rivi = Integer.valueOf(palat[0]);
            sarake = Integer.valueOf(palat[1]);

            this.pelilauta.lisaaMerkki("O", rivi, sarake);
            pelilauta.tulostaLauta();
            System.out.println("");
        }

    }

}
