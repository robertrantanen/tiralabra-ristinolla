package pelilauta;

/**
 * Luokka vastaa pelilaudan logiikasta
 */
public class Pelilauta {

    private String[][] lauta;

    public Pelilauta(int pituus) {

        this.lauta = new String[pituus][pituus];

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

    /**
     * Metodi tulostaa pelilaudan tilanteen
     */
    public void tulostaLauta() {
        int l = this.lauta.length;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(this.lauta[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Metodi lisää merkin pelilaudan tietylle riville ja sarakkeelle
     * 
     * @param merkki "X" tai "O"
     * @param rivi kaksiulotteisen taulukon eli pelilaudan rivi
     * @param sarake kaksiulotteisen taulukon eli pelilaudan sarake
     */
    public void lisaaMerkki(String merkki, int rivi, int sarake) {
        this.lauta[rivi][sarake] = merkki;
    }


}
