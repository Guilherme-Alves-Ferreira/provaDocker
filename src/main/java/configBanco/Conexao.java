  
package configBanco;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {

    BasicDataSource dataSource = new BasicDataSource();
    
    public Conexao() {
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.17.0.2:3306/bancoSupervisor");
        dataSource.setUsername("supervisor");
        dataSource.setPassword("1234");
    }
    
    public Connection getConnection() throws SQLException {
    
        return dataSource.getConnection();
    }

}