/**
 * Klase draudimo isimciai patikslinti
 */
package isimtys;

public class DraudimoTrukmesIsimtis extends DraudimoIsimtis {
    private int ivestasKiekis;

    /**
     * Draudimo trukmes isimties konstruktorius
     * @param klaidosPranesimas pranesimas, kuri isves pagavus isimti
     * @param ivestasKiekis (netinkamas) ivestas kiekis
     */
    public DraudimoTrukmesIsimtis(String klaidosPranesimas, int ivestasKiekis){
        super(klaidosPranesimas);
        this.ivestasKiekis = ivestasKiekis;
    }

    public int getIvestasKiekis(){
        return ivestasKiekis;
    }
}
