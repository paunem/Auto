/**
 * Klase objektu skaitymui is failo
 */
package saugojimas;

import automobilis.Automobilis;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;

public class ObjektuSaugojimas implements Runnable {
    List<Automobilis> perskaityta = new LinkedList<Automobilis>();

    /**
     * override'intas gijos run() metodas
     */
    public void run() {
        try {
            FileInputStream fis = new FileInputStream("duomenys.bin");
            ObjectInputStream objIvedimas = new ObjectInputStream(fis);
            Object obj = null;
            while ((obj = objIvedimas.readObject()) != null) {
                if (obj instanceof Automobilis) {
                    perskaityta.add((Automobilis) obj);
                }
            }
            objIvedimas.close();
        }catch(Exception e){}
    }

    public List<Automobilis> getPerskaityta() {
        return perskaityta;
    }
}

