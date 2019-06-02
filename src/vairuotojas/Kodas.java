/**
 * Klase vairuotojo kodui sukurti
 */
package vairuotojas;

public class Kodas {
    public int kodas;

    public Kodas(int kodas) {
        this.kodas = kodas;
    }

    public Kodas(Kodas kod) {
        this.kodas = kod.kodas;
    }

    public String toString(){
        return kodas + " ";
    }
}
