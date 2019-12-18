package main;

import algoritmit.Minimax;

public class Main {

    public static void main(String[] args) {
        String[][] lauta = new String[][]{
            {"_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_"},
            {"_", "_", "X", "_", "_"},
            {"_", "_", "_", "_", "_"},
            {"_", "_", "_", "_", "_"}};
        Minimax minimax = new Minimax();
        minimax.setVoittorivi(3);
        Kayttoliittyma ka = new Kayttoliittyma();
        //System.out.println(minimax.parasLiike(lauta, "X"));
        ka.aloita();
    }

}
