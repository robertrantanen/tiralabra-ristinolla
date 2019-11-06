package pelilauta;

import algoritmit.Minimax;
import java.util.Scanner;

public class Pelilauta {

    private String[][] lauta;
    private Minimax minimax;
    private Scanner lukija;

    public Pelilauta(int pituus) {

        this.lauta = new String[pituus][pituus];
        this.minimax = new Minimax();
        this.lukija = new Scanner(System.in);

        for (int i = 0; i < pituus; i++) {
            for (int j = 0; j < pituus; j++) {
                this.lauta[i][j] = "_";
            }

        }

    }

    public String[][] getLauta() {
        return this.lauta;
    }

    public void setLauta(String[][] lauta) {
        this.lauta = lauta;
    }

    public void tulostaLauta() {
        int l = this.lauta.length;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(this.lauta[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void lisaaMerkki(String merkki, int rivi, int sarake) {
        this.lauta[rivi][sarake] = merkki;
    }

    public void ihminenVsAi() {
        System.out.println("Ristinolla");
        tulostaLauta();
        System.out.println("");

        while (true) {

            if (minimax.laudanTulos(this.lauta) == 1) {
                System.out.println("Sinä voitit");
                break;
            }
            if (minimax.laudanTulos(this.lauta) == -1) {
                System.out.println("Tietokone voitti");
                break;
            }

            System.out.print("Syöte: ");
            String siirto = lukija.nextLine();
            String[] palat = siirto.split(" ");
            int rivi = Integer.valueOf(palat[0]);
            int sarake = Integer.valueOf(palat[1]);
            if (!this.lauta[rivi][sarake].equals("_")) {
                System.out.println("Yritit huijata!");
            } else {
                this.lauta[rivi][sarake] = "X";
            }
            System.out.println("");
            tulostaLauta();
            System.out.println("");

            if (!minimax.siirtojaJaljella(this.lauta)) {
                System.out.println("Tasapeli");
                break;
            }

            siirto = minimax.parasLiike(this.lauta, "O");
            palat = siirto.split(" ");
            rivi = Integer.valueOf(palat[0]);
            sarake = Integer.valueOf(palat[1]);

            this.lauta[rivi][sarake] = "O";
            tulostaLauta();
            System.out.println("");
        }

    }

}
