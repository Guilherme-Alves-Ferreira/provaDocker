package configBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TesteConfig {

    // Conexão com o banco
    // Mude o server name, username, e password com as suas credenciais
     String connectionUrl
            = "jdbc:sqlserver://supervisor-servidor.database.windows.net;"
            + "database=BD-SuperVisor;"
            + "user=supervisor;"
            + "password=Grupo5super;"
            + "encrypt=true;"
            + "trustServerCertificate=false;"
            + "loginTimeout=30;";

//     ResultSet resultSet;
    
//     Scanner leitorTexto = new Scanner(System.in);

    
//    public static void main(String[] args) {
//
//        Scanner leitor = new Scanner(System.in);
//
//        System.out.println("Quer fazer uma busca ou insercao no banco?");
//        String resposta = leitor.nextLine();
//
////        if (resposta.equalsIgnoreCase("busca")) {
////            fazerSelect();
////        } else if (resposta.equalsIgnoreCase("insercao")) {
////            fazerInsert();
////        }
//
//    }

//    public  void fazerSelect() {
//
//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//                Statement statement = connection.createStatement();) {
//
//            // Cria e depois executa uma query feita por colunas, 
//            // mas * funciona da mesma forma e poupa tempo.
//            String selectSql = "SELECT * FROM Faculdade";
//            resultSet = statement.executeQuery(selectSql);
//
//            // Exibe o resultado do select
//            while (resultSet.next()) {
//                System.out.println(String.format("Nome: %s\nNome do representante: %s\nCNPJ: %s\nTelefone: %s\n",
//                        resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5)));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public  void fazerInsert(String nomeTabela) {
//        
//        System.out.println("Digite o nome da faculdade: ");
//        String nomeFaculdade = leitorTexto.nextLine();
//        
//        System.out.println("Digite o nome do representante: ");
//        String nomeRepresentante = leitorTexto.nextLine();
//        
//        System.out.println("Digite o CNPJ: ");
//        String cnpj = leitorTexto.nextLine();
//        
//        System.out.println("Digite o telefone: ");
//        String telefone = leitorTexto.nextLine();
//        
//        System.out.println("Digite o endereço: ");
//        String endereco = leitorTexto.nextLine();
//        
//        // Coloca o insert em uma String
//        String insertSql = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s')", 
//                nomeTabela, nomeFaculdade, nomeRepresentante, cnpj, telefone, endereco);
//        
//        System.out.println(insertSql);
//        
//
//        // Conecta no banco e passa o insert como query SQL
//        try (Connection connection = DriverManager.getConnection(connectionUrl);
//                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql);) {
//
//            // Executa o insert
//            prepsInsertProduct.execute();
//
//            // Confirma a execução
//            System.out.println("Inserção feita com sucesso!");
//            
//        } // Handle any errors that may have occurred.
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        fazerSelect();
//    }
}
