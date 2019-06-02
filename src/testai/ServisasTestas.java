package testai;

import autoServisas.Servisas;
import automobilis.Automobilis;
import automobilis.Detale;
import automobilis.NaujasAutomobilis;
import org.junit.Assert;
import org.junit.Test;
import vairuotojas.Kodas;
import vairuotojas.Vairuotojas;

import java.util.HashSet;
import java.util.Set;

public class ServisasTestas {

    private void idetiISeta(Set<Detale> det){
        det.add(new Detale("Lempa", 2));
        det.add(new Detale("Kapotas", 3));
        det.add(new Detale("Variklis", 10));
    }

    @Test
    public void remontoTrukme() {
        Automobilis naujas1 = new NaujasAutomobilis("BMW", "530d", 155, true);
        Kodas kodas = new Kodas(12345);
        Vairuotojas arnas = new Vairuotojas(kodas, 18, 1);
        Set<Detale> det = new HashSet<Detale>();
        idetiISeta(det);
        naujas1.avarija(arnas, det);

        Servisas servisas = new Servisas(8);
        Assert.assertEquals("Remontas uztruks 15h . Yra darbu, kurie uztrunka ne viena diena", servisas.remontoTrukme(naujas1));
    }

    @Test
    public void apziuretiAuto() {
        Automobilis naujas1 = new NaujasAutomobilis("BMW", "530d", 155, true);
        Kodas kodas = new Kodas(12345);
        Vairuotojas arnas = new Vairuotojas(kodas, 18, 1);
        Set<Detale> det2 = new HashSet<Detale>();
        idetiISeta(det2);
        naujas1.avarija(arnas, det2);

        Servisas servisas = new Servisas(8);
        HashSet<String> keiciaDetales = new HashSet<String>();
        keiciaDetales.add("Variklis");
        servisas.setKeiciaDetales(keiciaDetales);

        Set<String> trukstamosDetales = new HashSet<String>();
        trukstamosDetales.add("Kapotas");
        trukstamosDetales.add("Lempa");

        Assert.assertEquals(trukstamosDetales, servisas.apziuretiAuto(naujas1));
    }
}