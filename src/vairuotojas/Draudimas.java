/**
 * Klase automobilio draudimui
 */
package vairuotojas;

import automobilis.Automobilis;
import isimtys.*;
import customMap.*;

public class Draudimas {
    //HashMap<Vairuotojas, Automobilis> draudimoDuomBaze = new HashMap<Vairuotojas, Automobilis>();
    MyMap<Vairuotojas, Automobilis> draudimoDuomBaze = new MyMap<Vairuotojas, Automobilis>();

    /**
     * Metodas metines draudimo kainos apskaiciavimui
     * @param vair vairuotojo objektas
     * @param auto automobilio objektas
     * @return grazina draudimo kaina metams
     */
    public int draudimoKaina(Vairuotojas vair, Automobilis auto){
        int a = vair.skaiciuotiRizika();
        return (auto.getGalia() * 5 - vair.getStazas() * 10) / 100 * a;
    }

    /**
     * Metodas menesines draudimo kainos apskaiciavimui
     * @param vair vairuotojo objektas
     * @param auto automobilio objektas
     * @param menesiai norimas laikotarpis draustis
     * @return grazina draudimo kaina (menesiai) menesiems
     * @throws DraudimoTrukmesIsimtis meta isimti, kai blogai ivestas menesiu skaicius
     */
    public int draudimoKaina(Vairuotojas vair, Automobilis auto, int menesiai) throws DraudimoTrukmesIsimtis {
        if(menesiai <= 0){
            throw new DraudimoTrukmesIsimtis("Reikia pasirinkti menesiu skaiciu didesni uz 0", menesiai);
        }
        int a = vair.skaiciuotiRizika();
        return ((auto.getGalia() * 5 - vair.getStazas() * 10) / 100 * a) / 12 * menesiai;
    }

    /**
     * Metodas skirtas apskaiciuoti draudimo kainai po kazkiek metu ir vairuotojo nusizengimu
     * @param vair vairuotojo objektas
     * @param auto automobilio objektas
     * @param poKiekMetu po kiek metu vykdyti simuliacija
     * @param kiekAvariju kiek avariju padare vairuotojas per ta laikotarpi
     * @return grazina draudimo kaina metams
     */
    public int draudimoKainosSimuliacija(Vairuotojas vair, Automobilis auto, int poKiekMetu, int kiekAvariju) {
        Vairuotojas vairuotojas = new Vairuotojas(vair);

        vairuotojas.setAmzius(vairuotojas.getAmzius() + poKiekMetu);
        vairuotojas.setStazas(vairuotojas.getStazas() + poKiekMetu);
        vairuotojas.setAvarijos(vairuotojas.getAvarijos() + kiekAvariju);

        int a = vairuotojas.skaiciuotiRizika();
        return (auto.getGalia() * 5 - vairuotojas.getStazas() * 10) / 100 * a;
    }

    public void drausti(Vairuotojas vair, Automobilis auto){
        draudimoDuomBaze.put(vair, auto);
    }

    public MyMap<Vairuotojas, Automobilis> getDraudimoDuomBaze() {
        return draudimoDuomBaze;
    }
}