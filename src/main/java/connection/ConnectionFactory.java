package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_suporte", "root", "senha");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar no banco de dados: " + e.getMessage());
        }
    }
}