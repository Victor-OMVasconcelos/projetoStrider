package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por estabelecer a conexão com o banco de dados do mySQL.
 */
public class ConexaoBd {

    // URL de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/strider_db";

    // Usuário para autenticação no banco de dados
    private static final String USER = "root"; // Corrigido a sintaxe do usuário

    // Senha para autenticação no banco de dados
    private static final String PASSWORD = "root";

    /**
     * Estabelece a conexão com o banco de dados.
     * @return Uma instância de Connection com a conexão aberta
     * @throws SQLException Se ocorrer um erro ao estabelecer a conexão
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

