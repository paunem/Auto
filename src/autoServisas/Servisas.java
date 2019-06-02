/**
 * Klase automobilio remontui
 */
package autoServisas;

import automobilis.Automobilis;
import automobilis.Detale;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Servisas {
    private int darboTrukme;
    private Set<String> keiciaDetales = new HashSet<String>();

    public Servisas(int darboTrukme){
        this.darboTrukme = darboTrukme;
    }

    public void setKeiciaDetales(Set<String> keiciaDetales){
        this.keiciaDetales = keiciaDetales;
    }

    /**
     *Automobilio remonto trukmes metodas
     * @param auto Automobilio objektas
     * @return grazina pranesima su informacija apie automobilio remonto trukme
     */
    public String remontoTrukme(Automobilis auto) {
        Set<Detale> blogosDetales = auto.getBlogosDetales();
        int visasLaikas = blogosDetales.stream().map(Detale::getPakeitimoLaikas).reduce(0, Integer::sum);
        boolean keliuDienuDarbas = blogosDetales.stream().map(Detale::getPakeitimoLaikas).anyMatch(x -> x > darboTrukme);

        if(keliuDienuDarbas == true)
            return "Remontas uztruks " + String.valueOf(visasLaikas) + "h . Yra darbu, kurie uztrunka ne viena diena";

        return "Remontas uztruktu " + String.valueOf(visasLaikas) + "h";
    }

    /**
     * Automobilio (pries remontuojant) apziuros metodas
     * @param auto Automobilio objektas
     * @return grazina Stringu hashSeta su detaliu vardais, kuriu servisas negali pakeisti automobilije
     */
    public Set<String> apziuretiAuto(Automobilis auto) {
        Set<Detale> blogosDetales = auto.getBlogosDetales();

        Set<String> nekeiciamosDetales = blogosDetales.stream().map(Detale::getPavadinimas).filter(x -> !(keiciaDetales.contains(x))).collect(Collectors.toSet());
        return nekeiciamosDetales;
    }
}
