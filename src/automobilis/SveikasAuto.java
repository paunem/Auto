/**
 * Interfeisas pasakantis ka gali daryti tik sveikas automobilis
 */
package automobilis;

import vairuotojas.Vairuotojas;

import java.util.HashSet;
import java.util.Set;

public interface SveikasAuto extends Auto {
    /**
     * Padidinti automobilio rida
     * @param atstumas kiek tukst km nuvaziavo automobilis
     */
    void nuvaziavo (int atstumas);

    /**
     * Vairuotojas padaro avarija su automobiliu
     * @param obj Vairuotojo objektas
     * @param detales Setas detaliu objektu, kurios buvo pazeistos ir bus keiciamos
     */
    void avarija(Vairuotojas obj, Set<Detale> detales);
}