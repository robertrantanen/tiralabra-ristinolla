package main;

import algoritmit.Minimax;
import java.util.Scanner;
import pelilauta.Pelilauta;

public class Kayttoliittyma {

    private Pelilauta pelilauta;
    private Minimax minimax;
    private Scanner lukija;
    private int rivi;
    private int sarake;

    public Kayttoliittyma() {
        this.pelilauta = new Pelilauta(3);
        this.minimax = new Minimax();
        this.lukija = new Scanner(System.in);
        this.rivi = 0;
        this.sarake = 0;
    }

    public void setPelilauta(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    public void aloita() {
        System.out.println("Syötä numero:");
        System.out.println("1 - ihminen vs tekoäly");
        System.out.println("2 - tekoäly vs tekoäly");
        System.out.println("3 - lopeta");
        System.out.println("");
        while (true) {
            System.out.print("Syöte: ");
            String syote = lukija.nextLine();
            if (syote.equals("1")) {
                setPelilauta(new Pelilauta(3));
                ihminenVsAi();
                break;
            } else if (syote.equals("2")) {
                System.out.print("Minkä kokoinen lauta? ");
                String pituus = lukija.nextLine();
                setPelilauta(new Pelilauta(Integer.valueOf(pituus)));
                aiVsAi();
                break;
            } else if (syote.equals("3")) {
                break;
            } else {
                System.out.println("virheellinen syöte");
            }
        }
    }

    public void ihminenVsAi() {
        System.out.println("Ristinolla");
        System.out.println("");
        System.out.println("Syötä numero 1-9");
        System.out.println("");
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        System.out.println("");

        while (true) {

            System.out.print("Syöte: ");
            String siirto = lukija.nextLine();
            if (siirto.equals("1")) {
                rivi = 0;
                sarake = 0;
            } else if (siirto.equals("2")) {
                rivi = 0;
                sarake = 1;
            } else if (siirto.equals("3")) {
                rivi = 0;
                sarake = 2;
            } else if (siirto.equals("4")) {
                rivi = 1;
                sarake = 0;
            } else if (siirto.equals("5")) {
                rivi = 1;
                sarake = 1;
            } else if (siirto.equals("6")) {
                rivi = 1;
                sarake = 2;
            } else if (siirto.equals("7")) {
                rivi = 2;
                sarake = 0;
            } else if (siirto.equals("8")) {
                rivi = 2;
                sarake = 1;
            } else if (siirto.equals("9")) {
                rivi = 2;
                sarake = 2;
            } else {
                System.out.println("virheellinen syöte");
            }

            if (this.pelilauta.getLauta()[rivi][sarake].equals("O")) {
                System.out.println("Yritit huijata!");
            } else {
                this.pelilauta.lisaaMerkki("X", rivi, sarake);
            }
            System.out.println("");
            pelilauta.tulostaLauta();
            System.out.println("");

            if (minimax.laudanTulos(pelilauta.getLauta(), "X", rivi, sarake) == 100) {
                System.out.println("Sinä voitit");
                break;
            }

            if (minimax.tyhjiaJaljella(this.pelilauta.getLauta()) == 0) {
                System.out.println("Tasapeli");
                break;
            }

            siirto = minimax.parasLiike(this.pelilauta.getLauta(), "O");
            String[] palat = siirto.split(" ");
            rivi = Integer.valueOf(palat[0]);
            sarake = Integer.valueOf(palat[1]);

            this.pelilauta.lisaaMerkki("O", rivi, sarake);
            pelilauta.tulostaLauta();
            System.out.println("");

            if (minimax.laudanTulos(pelilauta.getLauta(), "O", rivi, sarake) == -100) {
                System.out.println("Tietokone voitti");
                break;
            }
        }
        
        aloita();

    }

    public void aiVsAi() {
        rivi = (int) (Math.random() * this.pelilauta.getLauta().length);
        sarake = (int) (Math.random() * this.pelilauta.getLauta().length);
        pelilauta.lisaaMerkki("X", rivi, sarake);
        pelilauta.tulostaLauta();
        System.out.println("");
        long aika1 = System.currentTimeMillis();
        while (true) {
            String siirto = minimax.parasLiike(this.pelilauta.getLauta(), "O");
            String[] palat = siirto.split(" ");
            rivi = Integer.valueOf(palat[0]);
            sarake = Integer.valueOf(palat[1]);
            this.pelilauta.lisaaMerkki("O", rivi, sarake);

            pelilauta.tulostaLauta();
            System.out.println("");

            if (minimax.tyhjiaJaljella(this.pelilauta.getLauta()) == 0) {
                System.out.println("Tasapeli");
                break;
            }

            if (minimax.laudanTulos(pelilauta.getLauta(), "O", rivi, sarake) == -100) {
                System.out.println("O voitti");
                break;
            }

            siirto = minimax.parasLiike(this.pelilauta.getLauta(), "X");
            palat = siirto.split(" ");
            rivi = Integer.valueOf(palat[0]);
            sarake = Integer.valueOf(palat[1]);
            this.pelilauta.lisaaMerkki("X", rivi, sarake);

            pelilauta.tulostaLauta();
            System.out.println("");

            if (minimax.laudanTulos(pelilauta.getLauta(), "X", rivi, sarake) == 100) {
                System.out.println("X voitti");
                break;
            }

            if (minimax.tyhjiaJaljella(this.pelilauta.getLauta()) == 0) {
                System.out.println("Tasapeli");
                break;
            }
        }
        long aika2 = System.currentTimeMillis();

        System.out.println("");

        System.out.println("aikaa kului " + (aika2 - aika1) + " millisekuntia");
        System.out.println("");
        
        aloita();
    }

}
