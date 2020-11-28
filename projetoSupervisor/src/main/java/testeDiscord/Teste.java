package testeDiscord;

import configBanco.Conexao;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Teste {

    static Conexao config = new Conexao();

    public static void main(final String[] args) {
        final String token = "NzgxNjQ3OTg1Mzc2NjI0NjUx.X8Asag.dD1coud_dVuOlBFYkofJSVLRePY";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();
        final List<String> relatorio = new ArrayList<>();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("Relatorio".equalsIgnoreCase(message.getContent())) {

                for (Integer i = 1; i <= 3; i++) {

                   relatorio.add(verificarLogin(i.toString()));
                }
                
                System.out.println(relatorio.toString());
                
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage("**INFORMAÇÕES DOS COMPONENTES: **\n" 
                        + relatorio.toString()).block();
            }
        });

        gateway.onDisconnect().block();
    }

    public static String verificarLogin(String idComponente) {
        String descricao = null;
        String valor = null;

        try (Connection connection = DriverManager.getConnection(config.connectionUrl);
                Statement statement = connection.createStatement();) {

            // Cria e depois executa uma query feita por colunas, 
            // mas * funciona da mesma forma e poupa tempo.
            String selectSql = String.format("SELECT TOP 1 VALOR, DESCRICAO FROM Registro"
                    + " WHERE fkComponentes = '%s'", idComponente);

            ResultSet resultSet = statement.executeQuery(selectSql);

            while (resultSet.next()) {
                valor = resultSet.getString("VALOR");
                descricao = resultSet.getString("DESCRICAO");
                System.out.println(descricao + " - " + valor + "%\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "\n" + descricao + " - " + valor + "%\n";
    }
    
    
}
