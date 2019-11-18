package main;

import algoritmit.Minimax;
import pelilauta.Pelilauta;

public class Main {

    public static void main(String[] args) {

        Minimax minimax = new Minimax();
        Pelilauta pelilauta = new Pelilauta(3);
        Kayttoliittyma ka = new Kayttoliittyma();

        String[][] lauta = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "_", "_"}};

        String[][] lauta2 = new String[][]{
            {"X", "_", "O"},
            {"_", "X", "_"},
            {"O", "_", "O"}};

        String[][] lauta4 = new String[][]{
            {"_", "_", "_", "_","_"},
            {"_", "_", "_", "_","_"},
            {"_", "_", "X", "_","_"},
            {"_", "_", "_", "_","_"},
            {"_", "_", "_", "_","_"}};
        
        //System.out.println(minimax.parasLiike(lauta, "X"));
        

//        long aika1 = System.currentTimeMillis();
//        System.out.println(minimax.parasLiike(lauta4, "X"));
//        long aika2 = System.currentTimeMillis();
//        System.out.println("kului " + (aika2 - aika1) + " millisekuntia");

        //ka.ihminenVsAi();
        ka.aloita();

        //System.out.println(minimax.laudanTulos(lauta2, "X", 0, 0));
        //System.out.println(minimax.parasLiike(lauta4, "O"));
    }

}
