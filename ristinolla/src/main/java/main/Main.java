package main;

import algoritmit.Minimax;
import pelilauta.Pelilauta;

public class Main {

    public static void main(String[] args) {

        Minimax minimax = new Minimax();
        Pelilauta pelilauta = new Pelilauta(3);

        

        String[][] lauta = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "_", "_"}};

        String[][] lauta2 = new String[][]{
            {"_", "_", "X"},
            {"_", "O", "X"},
            {"O", "_", "_"}};
        
        String[][] lauta3 = new String[][]{
            {"X", "O", "X", "O"},
            {"X", "_", "_", "O"},
            {"_", "X", "_", "X"},
            {"O", "_", "_", "O"}};
        
        
        System.out.println(minimax.parasLiike(lauta, "X"));
        System.out.println(minimax.parasLiike(lauta, "O"));
        System.out.println(minimax.parasLiike(lauta2, "X"));

        
        //pelilauta.ihminenVsAi();
    }

}
