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

    List<Integer> valoresRecuperados = new ArrayList<>();

    public void recuperarDados(JLabel lblestavel, JLabel lblalerta, JLabel lblRisco) {

        for (Integer i = 1; i <= contagemMaquinas(); i++) {
            
            definirStatus();

            if (valoresRecuperados.get(0) > 70 || valoresRecuperados.get(1) > 70 || valoresRecuperados.get(2) > 80) 
                lblRisco.setText(String.valueOf(Integer.valueOf(lblRisco.getText()) + 1));
            
            else if (valoresRecuperados.get(0) > 40 || valoresRecuperados.get(1) > 50 || valoresRecuperados.get(2) > 60) 
                lblalerta.setText(String.valueOf(Integer.valueOf(lblalerta.getText()) + 1));
            
            else
                lblestavel.setText(String.valueOf(Integer.valueOf(lblestavel.getText()) + 1));

        }
    }

    public void definirStatus() {

        try (Connection connection = DriverManager.getConnection(config.getConnection().toString());
                Statement statement = connection.createStatement();) {

            if (!valoresRecuperados.isEmpty()) {
                valoresRecuperados.clear();
            }

            for (Integer i = 1; i <= 3; i++) {

                // Cria e depois executa uma query feita por colunas, 
                // mas * funciona da mesma forma e poupa tempo.
                String selectSql = String.format("SELECT valor FROM Registro"
                        + " WHERE fkComponente = '%d'", i);

                ResultSet resultSet = statement.executeQuery(selectSql);

                while (resultSet.next()) {
                    valoresRecuperados.add(Integer.parseInt(resultSet.getString(i)));
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
