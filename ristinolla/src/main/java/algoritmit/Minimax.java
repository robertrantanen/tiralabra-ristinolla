package algoritmit;

/**
 * Luokka minimax-algoritmin toteutukseen
 */
public class Minimax {

    private int voittorivi;
    private int edellinenRivi;
    private int edellinenSarake;
    private String edellinenMerkki;

    public Minimax() {
        this.voittorivi = 3;
        this.edellinenRivi = -1;
        this.edellinenSarake = -1;
        this.edellinenMerkki = "_";
    }

    public void setVoittorivi(int voittorivi) {
        this.voittorivi = voittorivi;
    }

    /**
     * Metodi käy läpi edellisen siirron läheisyyden ja tarkistaa, onko peli
     * päätynyt voittoon.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @param merkki "X" tai "O"
     * @param i rivi
     * @param j sarake
     * @return 100 jos "X" voittaa, -100 jos "O" voittaa, muuten 0
     *
     */
    public int laudanTulos(String[][] lauta, String merkki, int i, int j) {
        if (i == -1) {
            return 0;
        }

        int rivi = i;
        int sarake = j;
        int merkkeja = 1;

        for (; sarake < lauta.length - 1; sarake++) {
            if (lauta[rivi][sarake].equals(lauta[rivi][sarake + 1])) {
                merkkeja++;
            } else {
                break;
            }
        }

        sarake = j;

        for (; sarake > 0; sarake--) {
            if (lauta[rivi][sarake].equals(lauta[rivi][sarake - 1])) {
                merkkeja++;
            } else {
                break;
            }
        }

        if (merkkeja >= this.voittorivi) {
            if (merkki.equals("X")) {
                return 100;
            } else if (merkki.equals("O")) {
                return -100;
            }
        }

        rivi = i;
        sarake = j;
        merkkeja = 1;

        for (; rivi < lauta.length - 1; rivi++) {
            if (lauta[rivi][sarake].equals(lauta[rivi + 1][sarake])) {
                merkkeja++;
            } else {
                break;
            }
        }

        rivi = i;

        for (; rivi > 0; rivi--) {
            if (lauta[rivi][sarake].equals(lauta[rivi - 1][sarake])) {
                merkkeja++;
            } else {
                break;
            }
        }

        if (merkkeja >= this.voittorivi) {
            if (merkki.equals("X")) {
                return 100;
            } else if (merkki.equals("O")) {
                return -100;
            }
        }

        merkkeja = 1;
        rivi = i;
        sarake = j;

        for (; rivi < lauta.length - 1; rivi++) {
            if (sarake == lauta.length - 1) {
                break;
            }
            if (lauta[rivi][sarake].equals(lauta[rivi + 1][sarake + 1])) {
                merkkeja++;
            } else {
                break;
            }
            sarake++;
        }

        rivi = i;
        sarake = j;

        for (; rivi > 0; rivi--) {
            if (sarake == 0) {
                break;
            }
            if (lauta[rivi][sarake].equals(lauta[rivi - 1][sarake - 1])) {
                merkkeja++;
            } else {
                break;
            }
            sarake--;
        }

        if (merkkeja >= this.voittorivi) {
            if (merkki.equals("X")) {
                return 100;
            } else if (merkki.equals("O")) {
                return -100;
            }
        }

        merkkeja = 1;
        rivi = i;
        sarake = j;

        for (; rivi > 0; rivi--) {
            if (sarake == lauta.length - 1) {
                break;
            }
            if (lauta[rivi][sarake].equals(lauta[rivi - 1][sarake + 1])) {
                merkkeja++;
            } else {
                break;
            }
            sarake++;
        }

        rivi = i;
        sarake = j;

        for (; rivi < lauta.length - 1; rivi++) {
            if (sarake == 0) {
                break;
            }
            if (lauta[rivi][sarake].equals(lauta[rivi + 1][sarake - 1])) {
                merkkeja++;
            } else {
                break;
            }
            sarake--;
        }

        if (merkkeja >= this.voittorivi) {
            if (merkki.equals("X")) {
                return 100;
            } else if (merkki.equals("O")) {
                return -100;
            }
        }

        return 0;
    }

    /**
     * Algoritmin ydin. Metodi kutsuu itseään rekursiivisesti ja selvittää
     * laudan mahdolliset tulevat tilanteet. Laudan tilanteille annetaan arvo,
     * pienemmällä rekursion syvyydellä on parempi arvo.
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @param syvyys rekursion syvyys
     * @param maksimoija totuusarvo siitä, onko pelaaja maksimoija vai minimoija
     * @param alpha optimointimenetelmä
     * @param beta optimointimenetelmä
     * @return mahdollisimman suuri arvo jos maksimoijan vuoro, mahdollisiimman
     * pieni jos minimoijan.
     */
    public int minimax(String[][] lauta, int syvyys, boolean maksimoija, int alpha, int beta) {

        int tulos = laudanTulos(lauta, edellinenMerkki, edellinenRivi, edellinenSarake);

        if (tulos == 100 || tulos == -100 || syvyys == 0) {
            return tulos;
        }

        if (!siirtojaJaljella(lauta)) {
            return 0;
        }

        if (maksimoija) {
            int paras = -1000;

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "X";

                        this.edellinenRivi = i;
                        this.edellinenSarake = j;
                        this.edellinenMerkki = "X";

                        int arvo = minimax(lauta, syvyys - 1, !maksimoija, alpha, beta);

                        lauta[i][j] = "_";

                        if (arvo > paras) {
                            paras = arvo;
                        }

                        if (paras > alpha) {
                            alpha = paras;
                        }

                        if (beta <= alpha) {
                            return paras + syvyys;
                        }
                    }
                }
            }
            return paras + syvyys;
        } else {
            int paras = 1000;

            for (int i = 0; i < lauta.length; i++) {
                for (int j = 0; j < lauta.length; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "O";

                        this.edellinenRivi = i;
                        this.edellinenSarake = j;
                        this.edellinenMerkki = "O";

                        int arvo = minimax(lauta, syvyys - 1, !maksimoija, alpha, beta);

                        lauta[i][j] = "_";

                        if (arvo < paras) {
                            paras = arvo;
                        }

                        if (paras < beta) {
                            beta = paras;
                        }

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

                        this.edellinenRivi = i;
                        this.edellinenSarake = j;
                        this.edellinenMerkki = "X";

                        int arvo = minimax(lauta, syvyys, false, -1000, 1000);

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

                        this.edellinenRivi = i;
                        this.edellinenSarake = j;
                        this.edellinenMerkki = "O";

                        int arvo = minimax(lauta, syvyys, true, -1000, 1000);

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

    /**
     * Metodi käy läpi pelilaudan ja selvittää tyhjien ruutujen määrän
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @return tyhjien ruutujen määrä
     */
    public int tyhjiaJaljella(String[][] lauta) {
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

    /**
     * Marginaalisesti nopeampi tapa selvittää, onko siirtoja jäljellä
     * 
     * @param lauta pelilauta
     * @return true jos siitoja jäljellä, muuten false
     */
    private boolean siirtojaJaljella(String[][] lauta) {
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
     * Metodi selvittää tarpeeksi tehokkaan aloitussyvyyden minimax-algoritmille
     *
     * @param lauta kaksiulotteinen taulukko eli pelilauta
     * @return 3x3-laudalla kaikki tilanteet kattava syvyys, isommilla laudoilla
     * pienempi syvyys
     */
    public int aloitusSyvyys(String[][] lauta) {

        if (lauta.length == 3) {
            return 10;
        }

        int tyhjia = tyhjiaJaljella(lauta);
        
        if (tyhjia < this.voittorivi) {
            return 1;
        }

        if (tyhjia > 50) {
            return 1;
        }

        if (tyhjia > 30) {
            return 2;
        }

        if (tyhjia > 20) {
            return 3;
        }

        if (tyhjia > 15) {
            return 4;
        }

        if (tyhjia > 10) {
            return 5;
        }

        if (tyhjia > 5) {
            return 6;
        }

        return 7;
    }

}
