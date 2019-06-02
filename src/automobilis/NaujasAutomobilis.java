/**
 * Isvestine klase skirta naujiems automobiliams
 */
package automobilis;

public class NaujasAutomobilis extends Automobilis implements SveikasAuto {
    private boolean turiGarantija;

    public NaujasAutomobilis(String marke, String modelis, int galia, boolean turiGarantija) {
        super(marke, modelis, 2019, galia, 0, Bukle.Naujas);
        this.turiGarantija = turiGarantija;
    }

    public String toString() {
        return super.toString() + ". Turi garantija: " + turiGarantija;
    }

    public void setTuriGarantija(boolean turiGarantija) {
        this.turiGarantija = turiGarantija;
    }

    public void nuvaziavo(int atstumas) {
        int a = getRida() + atstumas;
        if(a >= 20){
            setTuriGarantija(false);
        }
        setRida(a);
    }

    public void taisytiAuto() {
        setBukle(Bukle.Pataisytas);
    }
}