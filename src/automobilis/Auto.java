/**
 * Interfeisas pasakantis ka gali daryti automobilis
 */
package automobilis;

public interface Auto {
    /**
     * Metodas automobilio taisymui
     */
    void taisytiAuto();

    /**
     * Metodas automobiliui eiti technine apziura
     * @param auto automobilio objektas
     */
    default void eitiTechnikine(Automobilis auto) {
        if (auto.getBukle() == Bukle.Pataisytas) {
            auto.setBukle(Bukle.Naudojamas);
            auto.sumazintiNebenaudojamuAuto();
        }
    }
}
