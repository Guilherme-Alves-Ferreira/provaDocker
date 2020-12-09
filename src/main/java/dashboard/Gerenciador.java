package dashboard;

import configBanco.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

public class Gerenciador {

    private Boolean conectado = true;
    Conexao config = new Conexao();

    List<Double> valoresRecuperados = new ArrayList<>();

    public void recuperarDados(JLabel lblestavel, JLabel lblalerta, JLabel lblRisco) {

        Integer quantidadeEstavel = 0, quantidadeAlerta = 0, quantidadeRisco = 0;

        definirStatus();
        for (Integer i = 1; i <= contagemMaquinas(); i++) {

            if (valoresRecuperados.get(0) > 70.0 || valoresRecuperados.get(1) > 70.0 || valoresRecuperados.get(2) > 80.0) {
                quantidadeRisco++;
            } else if (valoresRecuperados.get(0) > 40.0 || valoresRecuperados.get(1) > 50.0 || valoresRecuperados.get(2) > 60.0) {
                quantidadeAlerta++;
            } else {
                quantidadeEstavel++;
            }

        }

        lblestavel.setText(quantidadeEstavel.toString());
        lblalerta.setText(quantidadeAlerta.toString());
        lblRisco.setText(quantidadeRisco.toString());
    }

    public void definirStatus() {
        
        String valor = "";

        try (Connection connection = DriverManager.getConnection(config.getConnection().toString());
                Statement statement = connection.createStatement();) {

            if (!valoresRecuperados.isEmpty()) {
                valoresRecuperados.clear();
            }

            for (Integer i = 1; i <= 3; i++) {

                // Cria e depois executa uma query feita por colunas, 
                // mas * funciona da mesma forma e poupa tempo.
                String selectSql = String.format("SELECT TOP 1 VALOR FROM Registro"
                        + " WHERE fkComponentes = '%d' ORDER BY idRegistro DESC", i);

                ResultSet resultSet = statement.executeQuery(selectSql);

                while (resultSet.next()) {
                    valor = resultSet.getString("VALOR");
                    valoresRecuperados.add(Double.valueOf(valor));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            conectado = false;
        }

    }

    public Integer contagemMaquinas() {

        Integer qtdMaquina = 0;

        try (Connection connection = DriverManager.getConnection(config.getConnection().toString());
                Statement statement = connection.createStatement();) {

            // Cria e depois executa uma query feita por colunas, 
            // mas * funciona da mesma forma e poupa tempo.
            String selectSql = "SELECT COUNT(idMaquina) FROM Maquina";

            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                qtdMaquina++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            conectado = false;
        }

        return qtdMaquina;
    }

    public Boolean getConectado() {
        return conectado;
    }

    public void setConectado(Boolean conectado) {
        this.conectado = conectado;
    }

}