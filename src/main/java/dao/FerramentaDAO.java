package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

/**
 * Classe responsável pela interação com o banco de dados para as ferramentas.
 * Contém métodos para inserir, atualizar, deletar e consultar ferramentas.
 */
public class FerramentaDAO {

    private final ArrayList<Ferramenta> minhaLista = new ArrayList<>();

    /**
     * Recupera todas as ferramentas da base de dados e as adiciona à lista.
     *
     * @return Lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear();

        String query = "SELECT * FROM ferramenta";
        try (Connection conexao = ConexaoBd.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet res = stmt.executeQuery(query)) {

            while (res.next()) {
                Ferramenta ferramenta = new Ferramenta(
                    res.getInt("id"),
                    res.getString("nome"),
                    res.getString("marca"),
                    res.getDouble("preco")
                );
                minhaLista.add(ferramenta);
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao recuperar ferramentas: " + ex.getMessage());
        }
        return minhaLista;
    }

    /**
     * Retorna o maior ID de uma ferramenta na tabela.
     *
     * @return Maior ID.
     */
    public int maiorID() {
        int maiorID = 0;
        String query = "SELECT MAX(id) AS id FROM ferramenta";

        try (Connection conexao = ConexaoBd.getConnection();
             Statement stmt = conexao.createStatement();
             ResultSet res = stmt.executeQuery(query)) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar maior ID: " + ex.getMessage());
        }
        return maiorID;
    }

    /**
     * Insere uma ferramenta no banco de dados.
     *
     * @param ferramenta Objeto ferramenta a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean insereFerramentaBD(Ferramenta ferramenta) {
        String query = "INSERT INTO ferramenta(id, nome, marca, preco) VALUES(?, ?, ?, ?)";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setInt(1, ferramenta.getId());
            stmt.setString(2, ferramenta.getNome());
            stmt.setString(3, ferramenta.getMarca());
            stmt.setDouble(4, ferramenta.getPreco());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao inserir ferramenta: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Deleta uma ferramenta do banco de dados.
     *
     * @param id ID da ferramenta a ser deletada.
     * @return true se a deleção for bem-sucedida, false caso contrário.
     */
    public boolean deletaFerramentaBD(int id) {
        String query = "DELETE FROM ferramenta WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar ferramenta: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Atualiza os dados de uma ferramenta no banco de dados.
     *
     * @param ferramenta Objeto ferramenta com os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizaFerramentaBD(Ferramenta ferramenta) {
        String query = "UPDATE ferramenta SET nome = ?, marca = ?, preco = ? WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getPreco());
            stmt.setInt(4, ferramenta.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar ferramenta: " + ex.getMessage());
            return false;
        }
    }

    /**
     * Carrega uma ferramenta específica pelo ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Objeto Ferramenta ou null se não encontrado.
     */
    public Ferramenta carregaFerramenta(int id) {
        String query = "SELECT * FROM ferramenta WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    return new Ferramenta(
                        id,
                        res.getString("nome"),
                        res.getString("marca"),
                        res.getDouble("preco")
                    );
                } else {
                    // Se não encontrar a ferramenta, você pode retornar null ou lançar uma exceção
                    System.out.println("Ferramenta com ID " + id + " não encontrada.");
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erro ao carregar ferramenta: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Gera um relatório de todas as ferramentas disponíveis e o custo total.
     *
     * @return Relatório formatado como String.
     */
    public String geraRelatorioFerramentas() {
        StringBuilder relatorio = new StringBuilder();
        double custoTotal = 0.0;

        relatorio.append("Relatório de Ferramentas Disponíveis:\n")
                 .append("--------------------------------------\n");

        for (Ferramenta ferramenta : getMinhaLista()) {
            relatorio.append("ID: ").append(ferramenta.getId())
                     .append(", Nome: ").append(ferramenta.getNome())
                     .append(", Marca: ").append(ferramenta.getMarca())
                     .append(", Preço: R$ ").append(String.format("%.2f", ferramenta.getPreco()))
                     .append("\n");

            // Adicionar o preço da ferramenta ao custo total
            custoTotal += ferramenta.getPreco();
        }

        relatorio.append("--------------------------------------\n")
                 .append("Custo Total: R$ ").append(String.format("%.2f", custoTotal)).append("\n");

        // Retornar o relatório formatado
        return relatorio.toString();
    }

}
