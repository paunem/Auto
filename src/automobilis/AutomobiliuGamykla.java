/**
 * Klase skirta kurti automobiliu objektus pagal sablona
 */
package automobilis;

public class AutomobiliuGamykla {

    /**
     * Metodas-fabrikas automobilio objektui sukurti pagal sablona
     * @param rusis automobilio rusis
     * @return grazina sukurta automobilio objekta
     */
    public Automobilis pagamintiAuto(AutoRusys rusis) {

        if(rusis == AutoRusys.SenasAutomobilis){
            return new SenasAutomobilis(null, "-", 0, 0, 0, false, false);
        }
        else if(rusis == AutoRusys.NaujasAutomobilis){
            return new NaujasAutomobilis("-", "-", 0, false);
        }
        else return null;
    }

    /**
     * Setter'iu metodas patogiau apibudinti naujai sukurta seno automobilio objekta
     * @param auto automobilio objektas
     * @param marke automobilio marke
     * @param modelis automobilio modelis
     * @param metai automobilio metai
     * @param galia automobilio galia
     * @param ridaT automobilio rida
     * @param variklioProblema boolean'as pasakantis ar automobilis turi variklio problemu
     * @param kitosProblemos boolean'as pasakantis ar automobilis turi kitu problemu
     */
    public void apibudintiSenaAuto(SenasAutomobilis auto, String marke, String modelis, int metai, int galia, int ridaT, boolean variklioProblema, boolean kitosProblemos){
        auto.setMarke(marke);
        auto.setModelis(modelis);
        auto.setMetai(metai);
        auto.setGalia(galia);
        auto.setRida(ridaT);
        auto.setVariklioProblema(variklioProblema);
        auto.setKitosProblemos(kitosProblemos);
        auto.setBukle(Bukle.Sugedes);
    }

    /**
     * Setter'iu metodas patogiau apibudinti naujai sukurta naujo automobilio objekta
     * @param auto automobilio objektas
     * @param marke automobilio marke
     * @param modelis automobilio modelis
     * @param galia automobilio galia
     * @param turiGarantija boolean'as pasakantis ar automobilis turi garantijau
     */
    public void apibudintiNaujaAuto(NaujasAutomobilis auto, String marke, String modelis, int galia, boolean turiGarantija){
        auto.setMarke(marke);
        auto.setModelis(modelis);
        auto.setMetai(2019);
        auto.setGalia(galia);
        auto.setRida(0);
        auto.setTuriGarantija(turiGarantija);
        auto.setBukle(Bukle.Naujas);
    }
}