/**
 * Automobilio detales klase
 */
package automobilis;

public class Detale {
    private String pavadinimas;
    private int pakeitimoLaikas;

    /**
     * Detales objekto konstruktorius
     * @param pavadinimas detales pavadinimas
     * @param pakeitimoLaikas laikas reikalingas detalei pakeisti
     */
    public Detale(String pavadinimas, int pakeitimoLaikas){
        this.pavadinimas = pavadinimas;
        this.pakeitimoLaikas = pakeitimoLaikas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }
    public int getPakeitimoLaikas() {
        return pakeitimoLaikas;
    }

    public String toString(){
        return pavadinimas + " keiciama " +  pakeitimoLaikas + " h";
    }
}
