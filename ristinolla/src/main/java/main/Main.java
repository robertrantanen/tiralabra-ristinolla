package main;

import algoritmit.minimax;

public class Main {

    public static void main(String[] args) {

        minimax minimax = new minimax();

        String[][] lauta = new String[][]{
            {"X", "O", "X"},
            {"O", "O", "X"},
            {"_", "_", "_"}};

        String[][] lauta2 = new String[][]{
            {"_", "_", "X"},
            {"_", "_", "O"},
            {"X", "_", "O"}};
        
        String[][] lauta3 = new String[][]{
            {"X", "O", "X", "O"},
            {"X", "_", "_", "O"},
            {"_", "X", "_", "X"},
            {"O", "_", "_", "O"}};

        System.out.println(minimax.parasLiike(lauta, "X"));
        System.out.println(minimax.parasLiike(lauta, "O"));
        System.out.println(minimax.parasLiike(lauta2, "X"));
    }

}
