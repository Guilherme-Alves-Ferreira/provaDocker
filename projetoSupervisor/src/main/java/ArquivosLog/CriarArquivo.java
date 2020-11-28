package ArquivosLog;

import java.io.IOException;
import java.util.logging.Level;

public class CriarArquivo {

    public void logBtnAtualizar() {
        try {
            Log supervisorErros = new Log("superVisorErros.txt");

            supervisorErros.logger.setLevel(Level.INFO);

            supervisorErros.logger.info("Botão atualizar sem funcionamento esperado, procurar administrador.");

        } catch (IOException e) {

        }
    }

    public void logInserir() {

        try {
            Log supervisorErrosMemoria = new Log("superVisorErros.txt");

            supervisorErrosMemoria.logger.setLevel(Level.SEVERE);

            supervisorErrosMemoria.logger.severe("Não foi possivel inserir os dados.");

        } catch (IOException e) {

        }
    }

}
