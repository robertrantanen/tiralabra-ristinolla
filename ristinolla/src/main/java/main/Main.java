package main;

import algoritmit.Minimax;
import pelilauta.Pelilauta;

public class Main {

    public static void main(String[] args) {

        Minimax minimax = new Minimax();
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
            {"_", "_", "X", "X","_"},
            {"_", "_", "_", "_","_"},
            {"_", "_", "_", "_","_"}};
        
        //System.out.println(minimax.parasLiike(lauta, "X"));       
        //System.out.println(minimax.laudanTulos(lauta2, "X", 0, 0));
        //System.out.println(minimax.parasLiike(lauta4, "O"));
        
        ka.aloita();
    }

}
