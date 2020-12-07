package ArquivosLog;

import configBanco.Conexao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ArquivoLog {

    private Boolean cpu, memoria, disco;
    
    static Conexao config = new Conexao();

    public ArquivoLog() {
        this.cpu = false;
        this.memoria = false;
        this.disco = false;
    }

    public void setCpu(Boolean cpu) {
        this.cpu = cpu;
    }

    public void setMemoria(Boolean memoria) {
        this.memoria = memoria;
    }

    public void setDisco(Boolean disco) {
        this.disco = disco;
    }

    public void criar() {
        try {

            String razao = null;
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy | HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            File arquivo = new File("LogSupervisor.txt");

            String dataFormatada = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter escrita = new FileWriter(arquivo, true);
            BufferedWriter write = new BufferedWriter(escrita);

            if (cpu) {
                write.write(String.format("[%s] ERRO: Não foi possivel "
                        + "inserir os dados de CPU. \r\n", dataFormatada));
                razao = "Não foi possivel inserir os dados de CPU.";
            } else if (memoria) {
                write.write(String.format("[%s] ERRO: Não foi possivel "
                        + "inserir os dados de Memória. \r\n", dataFormatada));
                razao = "Não foi possivel inserir os dados de CPU.";
            } else if (disco) {
                write.write(String.format("[%s] ERRO: Não foi possivel "
                        + "inserir os dados de Disco. \r\n", dataFormatada));
                razao = "Não foi possivel inserir os dados de CPU.";
            }

            write.close();

            FileReader ler = new FileReader(arquivo.getName());
            BufferedReader reader = new BufferedReader(ler);
            
            inserirLog(razao, dtf.format(now));

//            String leitura;
//            while((leitura = reader.readLine()) != null){
//                System.out.println(leitura);
//            }
        } catch (Exception e) {
        }
    }

    public static void inserirLog(String motivo, String data) {
        
        // Coloca o insert em uma String
        String insertSql = String.format("INSERT INTO Logs VALUES "
                + "('%s', '%s', 1)", data, motivo);

        // Conecta no banco e passa o insert como query SQL
        try (Connection connection = DriverManager.getConnection(config.getConnection().toString());
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {

            // Executa o insert
            prepsInsertProduct.execute();

            // Confirma a execução
//            System.out.println("Inserção feita DISCO!\n");
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
