package algoritmit;

public class minimax {

    public int evaluoiTulos(String[][] lauta) {

        for (int rivi = 0; rivi < 3; rivi++) {
            if (lauta[rivi][0].equals(lauta[rivi][1]) && lauta[rivi][1].equals(lauta[rivi][2])) {
                if (lauta[rivi][0].equals("X")) {
                    return 1;
                } else if (lauta[rivi][0].equals("O")) {
                    return -1;
                }
            }
        }

        for (int sarake = 0; sarake < 3; sarake++) {
            if (lauta[0][sarake].equals(lauta[1][sarake]) && lauta[1][sarake].equals(lauta[2][sarake])) {
                if (lauta[0][sarake].equals("X")) {
                    return 1;
                } else if (lauta[0][sarake].equals("O")) {
                    return -1;
                }
            }
        }

        if (lauta[0][0].equals(lauta[1][1]) && lauta[1][1].equals(lauta[2][2])) {
            if (lauta[0][0].equals("X")) {
                return 1;
            } else if (lauta[0][0].equals("O")) {
                return -1;
            }
        }

        if (lauta[0][2].equals(lauta[1][1]) && lauta[1][1].equals(lauta[2][0])) {
            if (lauta[0][2].equals("X")) {
                return 1;
            } else if (lauta[0][2].equals("O")) {
                return -1;
            }
        }

        return 0;
    }

    public boolean siirtojaJaljella(String[][] lauta) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (lauta[i][j].equals("_")) {
                    return true;
                }
            }
        }
        return false;
    }

    public int minimax(String[][] lauta, int syvyys, boolean maksimoija) {

        int arvo = evaluoiTulos(lauta);

        if (arvo == 1 || arvo == -1) {
            return arvo;
        }

        if (!siirtojaJaljella(lauta)) {
            return 0;
        }

        if (maksimoija) {
            int paras = -999;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "X";

                        paras = Math.max(paras, minimax(lauta, syvyys + 1, !maksimoija));

                        lauta[i][j] = "_";
                    }
                }
            }
            return paras;
        } else {
            int paras = 999;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "O";

                        paras = Math.min(paras, minimax(lauta, syvyys + 1, !maksimoija));

                        lauta[i][j] = "_";
                    }
                }
            }
            return paras;
        }

    }

    public String parasLiike(String[][] lauta, String merkki) {

        int maksimi = -999;
        int minimi = 999;
        int rivi = -1;
        int sarake = -1;

        if (merkki.equals("X")) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "X";

                        int arvo = minimax(lauta, 0, false);

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

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (lauta[i][j].equals("_")) {

                        lauta[i][j] = "O";

                        int arvo = minimax(lauta, 0, true);

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
}
