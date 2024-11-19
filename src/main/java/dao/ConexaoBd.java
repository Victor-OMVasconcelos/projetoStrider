package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {
    private static final String URL = "jdbc:mysql://localhost:3306/strider_db";
    private static final String USER = "user_remoto";
    private static final String PASSWORD = "acesso_remoto_jocavi";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
