
package ArquivosLog;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

class Log {
    public Logger logger;
    FileHandler criar;
    
    public Log(String nomeArq) throws SecurityException, IOException {
        File arquivo = new File(nomeArq);
        if(!arquivo.exists()){
            arquivo.createNewFile();
        }
        criar = new FileHandler(nomeArq, true);
        logger = logger.getLogger("supervisor");
        logger.addHandler(criar);
        SimpleFormatter formatter = new SimpleFormatter();
        criar.setFormatter(formatter);
  
    }
    
}
