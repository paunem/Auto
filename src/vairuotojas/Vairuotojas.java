/**
 * Pagrindine vairuotojo klase
 */
package vairuotojas;

public class Vairuotojas{
    private Kodas kodas;
    private int amzius;
    private int stazas;
    private int avarijos = 0;

    /**
     * Vairuotojo objekto konstruktorius
     * @param kodas vairuotojo kodas
     * @param amzius vairuotojo amzius
     * @param stazas vairuotojo stazas
     */
    public Vairuotojas(Kodas kodas, int amzius, int stazas){
        this.kodas = kodas;
        this.amzius = amzius;
        this.stazas = stazas;
    }

    /**
     * Vairuotojo objekto konstruktorius skirtas gilias klonavimui
     * @param vair norimas nuklonuoti vairuotojo objektas
     */
    public Vairuotojas(Vairuotojas vair){
        this.kodas = new Kodas(vair.kodas);
        this.amzius = vair.amzius;
        this.stazas = vair.stazas;
    }


    public Kodas getKodas() {
        return kodas;
    }
    public int getAmzius() {
        return amzius;
    }
    public int getStazas() {
        return stazas;
    }
    public int getAvarijos() {
        return avarijos;
    }
    public void setKodas(Kodas kodas) {
        this.kodas = kodas;
    }
    public void setAmzius(int amzius) {
        this.amzius = amzius;
    }
    public void setStazas(int stazas) {
        this.stazas = stazas;
    }
    public void setAvarijos(int avarijos) {
        this.avarijos = avarijos;
    }

    public String toString(){
        return kodas.toString() + amzius + " metu amziaus. Per " + stazas + " metu staza padare " + avarijos + " avariju";
    }

    public void padareAvarija(){
        avarijos++;
    }

    /**
     * Metodas apskaiciuoti vairuotojo rizikos lygi (%)
     * @return grazina vairuotojo rizikos lygi (%)
     */
    public int skaiciuotiRizika(){
        int x = 0;
        if(getStazas() >= 2 && getAmzius() <= 60) {
            x = getAmzius() - getStazas() + getAvarijos() * 5;
        }
        else if(getStazas() >= 2 && getAmzius() > 60) {
            x = getAmzius() - getStazas() / 2 + getAvarijos() * 5;
        }
        else if(getStazas() < 2 && getAmzius() <= 60){
            x = 20 + getAmzius() - getStazas() + getAvarijos() * 10;
        }
        else{
            x = 50 + getAmzius() - getStazas() + getAvarijos() * 10;
        }

        if(x > 100) {
            return 100;
        }
        else {
            return x;
        }
    }
}