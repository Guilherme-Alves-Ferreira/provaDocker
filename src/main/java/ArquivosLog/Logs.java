package ArquivosLog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class Logs {
    
   public ArrayList <String> registro = new ArrayList(); 
   
   public void gravarLog(String error, String sistema){
        
        //Data atual do computador
        DateFormat dataAtual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DateFormat nomearArquivo = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        
        try {
        //Criando o arquivo de log
        String home = System.getProperty("user.home");
        File acesso = new File(home + File.separator + "Desktop" + File.separator + "Logs" + File.separator).getCanonicalFile();
        String caminho = acesso + File.separator + nomearArquivo.format(date)+"Logs_Supervisor.txt";
        acesso.mkdir();
        
        FileWriter arquivo = new FileWriter(caminho);
        
        acesso.setReadable(true);
        acesso.setWritable(true);
        
        registro.add(String.format("%s  ||  %s  ||  %s \n", dataAtual.format(date), sistema, error));
        
        for(String contador : registro){
            //System.out.println(contador);
            arquivo.append(contador);
        }
        
        arquivo.flush();
        arquivo.close();
        
        } catch (IOException e) {
            System.out.println("Erro desconhecido, entre em contato com a central de atendimento. \nCodigo do erro: "+ e);
        }
        
    }
}
    

