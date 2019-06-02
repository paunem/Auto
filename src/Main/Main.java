
package Main;

import autoServisas.Servisas;
import automobilis.*;
import customMap.*;
import isimtys.*;
import saugojimas.*;
import vairuotojas.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.logging.*;

/**
 * Testine klase
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Automobilis naujas1 = new NaujasAutomobilis("BMW", "530d", 155, true);
        //Automobilis senas1 = new SenasAutomobilis("Skoda", "Fabia", 1999, 66, 450, false, false);
        Kodas kodas = new Kodas(12345);
        Vairuotojas arnas = new Vairuotojas(kodas, 18, 1);
        Vairuotojas mantas = new Vairuotojas(kodas, 19, 2);
        Draudimas draudimas = new Draudimas();

        AutomobiliuGamykla autoGamykla = new AutomobiliuGamykla();
        //Automobilis naujas1 = autoGamykla.pagamintiAuto(AutoRusys.NaujasAutomobilis);
        SenasAutomobilis senas1 = (SenasAutomobilis) autoGamykla.pagamintiAuto(AutoRusys.SenasAutomobilis);
        autoGamykla.apibudintiSenaAuto(senas1,"Skoda", "Fabia", 1999, 66, 450, false, false);

        System.out.println(draudimas.draudimoKaina(arnas, senas1));
        System.out.println(draudimas.draudimoKainosSimuliacija(arnas, senas1, 1, 0));

        try {
            FileOutputStream fos = new FileOutputStream("duomenys.bin");
            ObjectOutputStream objIsvedimas = new ObjectOutputStream(fos);
            objIsvedimas.writeObject(naujas1);
            objIsvedimas.writeObject(senas1);
            objIsvedimas.writeObject(naujas1);
            objIsvedimas.close();
        }catch(Exception e){}

        ObjektuSaugojimas objSaug = new ObjektuSaugojimas();
        Thread gija1 = new Thread(objSaug);
        gija1.start();
        gija1.join();

        //--------------------------------------LINKEDLIST-----------------------------------------
        List<Automobilis> perskaityta = objSaug.getPerskaityta();
        System.out.println(perskaityta);

        //--------------------------------------HASHMAP---------------------------------------------
        draudimas.drausti(arnas, naujas1);
        draudimas.drausti(mantas, senas1);
        Map<Vairuotojas, Automobilis> draudimoDuomBaze = draudimas.getDraudimoDuomBaze();
        System.out.println(draudimoDuomBaze.get(arnas));
        System.out.println(draudimoDuomBaze.get(mantas));

        //--------------------------------------HASHSET---------------------------------------------
        Set<Detale> sudauzytosDetales = new HashSet<Detale>();
        sudauzytosDetales.add(new Detale("Variklis", 10));
        sudauzytosDetales.add(new Detale("Kapotas", 3));
        sudauzytosDetales.add(new Detale("Lempa", 2));
        naujas1.avarija(arnas, sudauzytosDetales);

        for (Detale d : naujas1.getBlogosDetales()) {
            System.out.println(d);
        }

        //------------------------------SERVISAS-----------------------------------------------------------
        Servisas servisas = new Servisas(8);
        Set<String> keiciaDetales = new HashSet<String>();
        //keiciaDetales.add("Kapotas");
        //keiciaDetales.add("Lempa");
        keiciaDetales.add("Variklis");
        servisas.setKeiciaDetales(keiciaDetales);

        System.out.println(servisas.remontoTrukme(naujas1));
        Set<String> trukstamosDetales = servisas.apziuretiAuto(naujas1);
        if(trukstamosDetales.isEmpty()) {
            System.out.println("Pilnai suremontuosime automobili");
        }else{
            System.out.print("Neremontuojame ");
            for (String s : trukstamosDetales) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        /*
        try {
            Log log = new Log("log.txt");
            System.out.println(naujas1.toString());
            System.out.println(senas1.toString());
            System.out.println(arnas.toString());

            System.out.println(draudimas.draudimoKaina(arnas, senas1, -5));
        }
        catch(DraudimoTrukmesIsimtis isimtis){
            Log.logger.log(Level.SEVERE, "Ivedete: " + isimtis.getIvestasKiekis(), isimtis);
        }
        catch(Exception e){}
        */
    }
}