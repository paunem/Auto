/**
 * Isvestine klase skirta seniems automobiliams
 */
package automobilis;

public class SenasAutomobilis extends Automobilis implements SveikasAuto {
    private boolean variklioProblema;
    private boolean kitosProblemos;

    public SenasAutomobilis(String marke, String modelis, int metai, int galia, int ridaT, boolean variklioProblema, boolean kitosProblemos) {
        super(marke, modelis, metai, galia, ridaT, Bukle.Sugedes);
        this.variklioProblema = variklioProblema;
        this.kitosProblemos = kitosProblemos;
        padidintiNebenaudojamuAuto();
    }

    public boolean getVariklioProblema() {
        return variklioProblema;
    }

    public boolean getKitosProblemos() {
        return kitosProblemos;
    }

    public void setVariklioProblema(boolean variklioProblema) {
        this.variklioProblema = variklioProblema;
    }

    public void setKitosProblemos(boolean kitosProblemos) {
        this.kitosProblemos = kitosProblemos;
    }

    public String toString() {
        return super.toString() + ". Variklio problemos: " + variklioProblema + ", kitos problemos: " + kitosProblemos;
    }

    public void taisytiAuto() {
        if (getVariklioProblema() != true || getKitosProblemos() != true) {
            if (getVariklioProblema() == true && getKitosProblemos() == false) {
                setBukle(Bukle.Pataisytas);
                setVariklioProblema(false);
                setRida(0);
            }
            if (getVariklioProblema() == false && getKitosProblemos() == true) {
                setBukle(Bukle.Pataisytas);
                setKitosProblemos(false);
            }
            if (getVariklioProblema() == false && getKitosProblemos() == false) {
                setBukle(Bukle.Pataisytas);
            }
        }
    }

    public void nuvaziavo(int atstumas) {
        int a = getRida() + atstumas;
        if (atstumas >= 50 || a >= 500) {
            setBukle(Bukle.Sugedes);
            setVariklioProblema(true);
            setRida(a);
        }
    }
}