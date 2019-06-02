/**
 * Klase draudimo isimciai aprasyti
 */
package isimtys;

public class DraudimoIsimtis extends Exception {
    /**
     * Tuscias draudimo isimties konstruktorius
     */
    public DraudimoIsimtis(){}

    /**
     * Draudimo isimties konstruktorius
     * @param klaidosPranesimas pranesimas, kuri isves pagavus isimti
     */
    public DraudimoIsimtis(String klaidosPranesimas){
        super(klaidosPranesimas);
    }
}