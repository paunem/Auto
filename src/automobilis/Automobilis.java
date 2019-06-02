/**
 * Pagrindine automobilio klase
 */
package automobilis;
import vairuotojas.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Automobilis implements Auto, Serializable {
    private String marke;
    private String modelis;
    private int metai;
    private int galia;
    private int ridaT;
    private Bukle bukle;
    private Set<Detale> blogosDetales;
    private static int nebenaudojamuAuto = 0;

    /**
     * Automobilio objekto tuscias konstruktorius
     */
    public Automobilis(){}

    /**
     * Automobilio objekto konstruktorius
     * @param marke automobilio marke
     * @param modelis automobilio modelis
     * @param metai automobilio metai
     * @param galia automobilio galia
     * @param ridaT automobilio rida
     */
    public Automobilis(String marke, String modelis, int metai, int galia, int ridaT){
        this(marke, modelis, metai, galia, ridaT, Bukle.Naudojamas);
    }

    /**
     * Automobilio objekto konstruktorius
     * @param marke automobilio marke
     * @param modelis automobilio modelis
     * @param metai automobilio metai
     * @param galia automobilio galia
     * @param ridaT automobilio rida (tukst. km)
     * @param bukle automobilio bukle
     */
    public Automobilis(String marke, String modelis, int metai, int galia, int ridaT, Bukle bukle){
        this.marke = marke;
        this.modelis = modelis;
        this.metai = metai;
        this.galia = galia;
        this.ridaT = ridaT;
        this.bukle = bukle;
    }

    public static int kiekNebenaudojamuAuto(){
        return nebenaudojamuAuto;
    }
    public void padidintiNebenaudojamuAuto(){
        nebenaudojamuAuto++;
    }
    public void sumazintiNebenaudojamuAuto(){
        nebenaudojamuAuto--;
    }

    public String getMarke(){
        return marke;
    }
    public String getModelis(){
        return modelis;
    }
    public int getMetai(){
        return metai;
    }
    public int getGalia(){
        return galia;
    }
    public int getRida(){
        return ridaT;
    }
    public Bukle getBukle() {
        return bukle;
    }
    public Set<Detale> getBlogosDetales(){
        return blogosDetales;
    }
    public void setMarke(String marke){
        this.marke = marke;
    }
    public void setModelis(String modelis){
        this.modelis = modelis;
    }
    public void setMetai(int metai){
        this.metai = metai;
    }
    public void setGalia(int galia){
        this.galia = galia;
    }
    public void setRida(int ridaT){
        this.ridaT = ridaT;
    }
    public void setBukle(Bukle bukle){
        this.bukle = bukle;
    }
    public void setBlogosDetales(Set<Detale> blogosDetales){
        this.blogosDetales = blogosDetales;
    }

    /**
     * toString() metodas automobilio objektui
     * @return grazina automobilio objekto informacija
     */
    public String toString(){
        return marke + " " + modelis + " " + metai + " metu " + galia + "kW " + ridaT + "000km " + bukle;
    }

    /**
     * Vairuotojas padaro avarija su automobiliu
     * @param obj Vairuotojo objektas
     * @param detales Setas detaliu objektu, kurios buvo pazeistos ir bus keiciamos
     */
    public final void avarija(Vairuotojas obj, Set<Detale> detales){
        obj.padareAvarija();
        setBukle(Bukle.Sudauzytas);
        nebenaudojamuAuto++;
        setBlogosDetales(detales);
    }

    /**
     * Sutaisyti automobili
     * @param remontas remonto kaina
     * @param verte automobilio verte
     */
    public void taisytiAuto(int remontas, int verte){
        if(remontas < verte / 2) {
            setBukle(Bukle.Pataisytas);
        }
    }

    /**
     * Padidinti automobilio rida
     * @param atstumas kiek tukst km nuvaziavo automobilis
     */
    public abstract void nuvaziavo (int atstumas);
}