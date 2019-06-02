/**
 * Klase skirta registruoti programos isimtims
 */
package isimtys;
import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class Log {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Log(String failas) throws SecurityException, IOException {
        File f = new File(failas);
        if(!f.exists()){
            f.createNewFile();
        }

        FileHandler fh = new FileHandler(failas, true);
        fh.setLevel(Level.ALL);
        logger.addHandler(fh);
        SimpleFormatter form = new SimpleFormatter();
        fh.setFormatter(form);


        logger.setLevel(Level.ALL);
    }
}