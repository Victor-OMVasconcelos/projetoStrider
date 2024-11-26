package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Amigo;

public class AmigoDAO {
    
    // Lista de amigos, utilizada para armazenar temporariamente os objetos.
    public ArrayList<Amigo> minhaLista = new ArrayList<>();
    
    /**
     * Recupera todas os amigos da base de dados e os adiciona à lista.
     *
     * @return Lista de amigos.
     */
    public ArrayList<Amigo> getMinhaLista() {
        minhaLista.clear(); // Limpa a lista antes de atualizar com dados novos.
    try (Connection conexao = ConexaoBd.getConnection(); Statement stmt = conexao.createStatement(); ResultSet res = stmt.executeQuery("SELECT * FROM amigo")) {

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String telefone = res.getString("telefone");
                int item = res.getInt("item");

                Amigo amigo = new Amigo(id, nome, telefone, item);
                minhaLista.add(amigo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }
    
    /**
     * Insere um novo amigo no banco de dados.
     * 
     * @param amigo Objeto Amigo a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean insereAmigoBD(Amigo amigo) {
        // Definindo a consulta SQL para inserção
        String query = "INSERT INTO amigo (id, nome, telefone, item) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexaoBd.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando os parâmetros da consulta
            stmt.setInt(1, amigo.getId());
            stmt.setString(2, amigo.getNome());
            stmt.setString(3, amigo.getTelefone());
            stmt.setInt(4, amigo.getItem());

            // Executando a consulta
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao salvar amigo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Deleta um amigo do banco de dados pelo ID.
     * 
     * @param id ID do amigo a ser deletado.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean deletaAmigoBD(int id) {
        // Definindo a consulta SQL para exclusão
        String query = "DELETE FROM amigo WHERE id = ?";

        try (Connection con = ConexaoBd.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando o parâmetro da consulta
            stmt.setInt(1, id);

            // Executando a consulta
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar amigo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     * 
     * @param amigo Objeto Amigo contendo as novas informações.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizaAmigoBD(Amigo amigo) {
        // Definindo a consulta SQL para atualização
        String query = "UPDATE amigo SET nome = ?, telefone = ?, item = ? WHERE id = ?";

        try (Connection con = ConexaoBd.getConnection(); 
            PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando os parâmetros da consulta
            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, amigo.getItem());
            stmt.setInt(4, amigo.getId());

            // Executando a consulta
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar amigo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Carrega um amigo do banco de dados pelo ID.
     * 
     * @param id ID do amigo a ser carregado.
     * @return Objeto Amigo carregado ou null caso não seja encontrado.
     */
    public Amigo carregaAmigo(int id) {
        // Definindo a consulta SQL para carregar um amigo
        String query = "SELECT id, nome, telefone, item FROM amigo WHERE id = ?";
        Amigo amigo = null;

        try (Connection con = ConexaoBd.getConnection(); 
             PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando o parâmetro da consulta
            stmt.setInt(1, id);

            // Executando a consulta
            try (ResultSet rs = stmt.executeQuery()) {
                // Verificando se o amigo foi encontrado
                if (rs.next()) {
                    amigo = new Amigo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getInt("item")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar amigo: " + e.getMessage());
        }
        return amigo;
    }
    
    /**
     * Retorna o maior ID de um amigo na tabela de ferramentas.
     *
     * @return Maior ID.
     */
    public int maiorID() {
        int maiorID = 0;
        try (Connection conexao = ConexaoBd.getConnection(); Statement stmt = conexao.createStatement(); ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM amigo")) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }
}
