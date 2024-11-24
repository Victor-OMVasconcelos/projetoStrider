package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.Amigo;

/**
 * Classe responsável por gerenciar as operações de banco de dados relacionadas à entidade Amigo.
 * @author Victor Omv
 */
public class AmigoDAO {

    // Lista de amigos
    private final ArrayList<Amigo> minhaLista = new ArrayList<>();

    /**
     * Retorna a lista de amigos cadastrados no banco de dados.
     * @return ArrayList de objetos Amigo
     */
    public ArrayList<Amigo> getMinhaLista() {
        minhaLista.clear(); // Limpa a lista antes de carregar

        String sql = "SELECT * FROM amigos";
        try (Connection conexao = ConexaoBd.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome_amigo");
                String telefone = res.getString("telefone");

                minhaLista.add(new Amigo(id, nome, telefone));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar lista de amigos: " + ex.getMessage());
        }

        return minhaLista;
    }

    /**
     * Obtém o maior ID registrado no banco de dados.
     * @return int maior ID
     */
    public int maiorID() {
        int maiorID = 0;
        String sql = "SELECT MAX(id) AS id FROM amigos";

        try (Connection conexao = ConexaoBd.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao obter maior ID: " + ex.getMessage());
        }

        return maiorID;
    }

    /**
     * Insere um novo amigo no banco de dados.
     * @param amigo Objeto Amigo a ser inserido
     * @return true se inserido com sucesso, false caso contrário
     */
    public boolean insereAmigoBD(Amigo amigo) {
        String sql = "INSERT INTO amigos (id, nome_amigo, telefone) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, amigo.getId());
            stmt.setString(2, amigo.getNome());
            stmt.setString(3, amigo.getTelefone());
            stmt.execute();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir amigo: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Exclui um amigo do banco de dados com base no ID fornecido.
     * @param id ID do amigo a ser excluído
     * @return true se excluído com sucesso, false caso contrário
     */
    public boolean deletaAmigoBD(int id) {
        String sql = "DELETE FROM amigos WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir amigo: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     * @param amigo Objeto Amigo com os novos dados
     * @return true se atualizado com sucesso, false caso contrário
     */
    public boolean atualizaAmigoBD(Amigo amigo) {
        String sql = "UPDATE amigos SET nome_amigo = ?, telefone = ? WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, amigo.getId());
            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar amigo: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Carrega um amigo específico pelo ID.
     * @param id ID do amigo a ser carregado
     * @return Objeto Amigo ou null se não encontrado
     */
    public Amigo carregaAmigo(int id) {
        Amigo amigo = null;
        String sql = "SELECT * FROM amigos WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    String nome = res.getString("nome_amigo");
                    String telefone = res.getString("telefone");
                    amigo = new Amigo(id, nome, telefone);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao carregar amigo: " + ex.getMessage());
        }

        return amigo;
    }
}
