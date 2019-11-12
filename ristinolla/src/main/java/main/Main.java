package main;

import algoritmit.Minimax;
import pelilauta.Pelilauta;

public class Main {

    public static void main(String[] args) {

        Minimax minimax = new Minimax();
        Pelilauta pelilauta = new Pelilauta(10);
        Kayttoliittyma ka = new Kayttoliittyma();

        String[][] lauta = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "_", "_"}};

        String[][] lauta2 = new String[][]{
            {"_", "_", "X"},
            {"_", "O", "X"},
            {"O", "_", "_"}};

        String[][] lauta3 = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "X", "O"}};

        String[][] lauta4 = new String[][]{
            {"X", "_", "_", "_"},
            {"O", "_", "_", "_"},
            {"X", "_", "_", "_"},
            {"O", "_", "_", "_"}};
        
        //System.out.println(minimax.parasLiike(lauta, "X"));
        

//        long aika1 = System.currentTimeMillis();
//        System.out.println(minimax.parasLiike(lauta4, "X"));
//        long aika2 = System.currentTimeMillis();
//        System.out.println("kului " + (aika2 - aika1) + " millisekuntia");

        //ka.ihminenVsAi();
        ka.setPelilauta(pelilauta);
        ka.aiVsAi();
    }

}
