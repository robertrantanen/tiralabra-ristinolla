package algoritmit;

/**
 * Luokka minimax-algoritmin toteutukseen
 */
public class Minimax {

    /**
     * Metodi käy läpi pelilaudan ja tarkistaa, onko peli päätynyt jommankumman
     * voittoon.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @return 100 jos "X" voittaa, -100 jos "O" voittaa, muuten 0
     *
     */
    public int laudanTulos(String[][] lauta) {

        boolean tarkistaja;

        for (int rivi = 0; rivi < lauta.length; rivi++) {
            tarkistaja = true;
            for (int sarake = 0; sarake < lauta.length - 1; sarake++) {
                if (!(lauta[rivi][sarake].equals(lauta[rivi][sarake + 1]))) {
                    tarkistaja = false;
                }
            }
            if (tarkistaja) {
                if (lauta[rivi][0].equals("X")) {
                    return 100;
                } else if (lauta[rivi][0].equals("O")) {
                    return -100;
                }
            }
        }

        for (int sarake = 0; sarake < lauta.length; sarake++) {
            tarkistaja = true;
            for (int rivi = 0; rivi < lauta.length - 1; rivi++) {
                if (!(lauta[rivi][sarake].equals(lauta[rivi + 1][sarake]))) {
                    tarkistaja = false;
                }
            }
            if (tarkistaja) {
                if (lauta[0][sarake].equals("X")) {
                    return 100;
                } else if (lauta[0][sarake].equals("O")) {
                    return -100;
                }
            }
        }

        tarkistaja = true;
        for (int i = 0; i < lauta.length - 1; i++) {
            if (!(lauta[i][i].equals(lauta[i + 1][i + 1]))) {
                tarkistaja = false;
            }
        }
        if (tarkistaja) {
            if (lauta[0][0].equals("X")) {
                return 100;
            } else if (lauta[0][0].equals("O")) {
                return -100;
            }
        }

        tarkistaja = true;
        int sarake = 0;
        for (int rivi = lauta.length - 1; rivi > 0; rivi--) {
            if (!(lauta[rivi][sarake].equals(lauta[rivi - 1][sarake + 1]))) {
                tarkistaja = false;
            }
            sarake++;
        }

        if (tarkistaja) {
            if (lauta[lauta.length - 1][0].equals("X")) {
                return 100;
            } else if (lauta[lauta.length - 1][0].equals("O")) {
                return -100;
            }
        }

        return 0;
    }

    /**
     * Metodi käy pelilaudan läpi ja tarkistaa, onko siirtoja jäljellä.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @return true tai false
     */
    public boolean siirtojaJaljella(String[][] lauta) {
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j].equals("_")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Algoritmin ydin. Metodi kutsuu itseään rekursiivisesti ja selvittää
     * laudan kaikki mahdolliset tulevat tilanteet. Laudan tilanteille annetaan
     * arvo, pienemmällä rekursion syvyydellä on parempi arvo.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @param syvyys rekursion syvyys
     * @param maksimoija totuusarvo siitä, onko pelaaja maksimoija vai minimoija
     * @return positiivinen arvo jos maksimoijan vuoro, negatiivinen arvo jos
     * minimoijan.
     */
    public int minimax(String[][] lauta, int syvyys, boolean maksimoija, int alpha, int beta) {

        int tulos = laudanTulos(lauta);

        if (tulos == 100 || tulos == -100 || syvyys == 0) {
            return tulos;
        }

        if (!siirtojaJaljella(lauta)) {
            return 0;
        }

        if (maksimoija) {
            int paras = -100;

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "X";

                        int arvo = minimax(lauta, syvyys - 1, !maksimoija, alpha, beta);

                        lauta[i][j] = "_";

                        paras = Math.max(paras, arvo);

                        alpha = Math.max(alpha, paras);

                        if (beta <= alpha) {
                            return paras + syvyys;
                        }
                    }
                }
            }
            return paras + syvyys;
        } else {
            int paras = 100;

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "O";

                        int arvo = minimax(lauta, syvyys - 1, !maksimoija, alpha, beta);

                        lauta[i][j] = "_";

                        paras = Math.min(paras, arvo);

                        beta = Math.min(beta, paras);

                        if (beta <= alpha) {
                            return paras - syvyys;
                        }
                    }
                }
            }
            return paras - syvyys;
        }

    }

    /**
     * Metodi palauttaa parhaimman mahdollisen liikkeen. Jokainen tyhjä kohta
     * käydään läpi ja kutsutaan minimax-algoritmia. "X" haluaa suurimman
     * mahdollisen arvon, "O" pienimmän mahdollisen.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @param merkki "X" tai "O" merkki
     * @return parhaimman siirron koordinaatit
     */
    public String parasLiike(String[][] lauta, String merkki) {

        int maksimi = -1000;
        int minimi = 1000;
        int rivi = -1;
        int sarake = -1;

        int syvyys = aloitusSyvyys(lauta);

        if (merkki.equals("X")) {

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "X";

                        int arvo = minimax(lauta, syvyys, false, Integer.MIN_VALUE, Integer.MAX_VALUE);

                        lauta[i][j] = "_";

                        if (arvo > maksimi) {
                            rivi = i;
                            sarake = j;
                            maksimi = arvo;
                        }
                    }
                }
            }
        } else if (merkki.equals("O")) {

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "O";

                        int arvo = minimax(lauta, syvyys, true, Integer.MIN_VALUE, Integer.MAX_VALUE);

                        lauta[i][j] = "_";

                        if (arvo < minimi) {
                            rivi = i;
                            sarake = j;
                            minimi = arvo;
                        }
                    }
                }
            }
        }
        return rivi + " " + sarake;
    }

    private int tyhjiaJaljella(String[][] lauta) {
        int tyhjia = 0;
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j].equals("_")) {
                    tyhjia++;
                }
            }
        }
        return tyhjia;
    }

    private int aloitusSyvyys(String[][] lauta) {
        int koko = lauta.length * lauta.length;

        if (koko <= 9) {
            return 10;
        }

        int tyhjia = tyhjiaJaljella(lauta);

        if (tyhjia > 30) {
            return 0;
        }

        if (tyhjia > 25) {
            return 1;
        }

        if (tyhjia > 20) {
            return 2;
        }

        if (tyhjia > 15) {
            return 3;
        }

        if (tyhjia > 10) {
            return 4;
        }

        return 5;
    }

}
