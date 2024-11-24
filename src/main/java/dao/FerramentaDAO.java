package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.Ferramenta;

/**
 * Classe responsável pela interação com o banco de dados para as ferramentas.
 * Ela contém métodos para inserir, atualizar, deletar e consultar ferramentas.
 *
 * @author joaov
 */
public class FerramentaDAO {

    // Lista de ferramentas, utilizada para armazenar temporariamente os objetos.
    public ArrayList<Ferramenta> minhaLista = new ArrayList<>();

    /**
     * Recupera todas as ferramentas da base de dados e as adiciona à lista.
     *
     * @return Lista de ferramentas.
     */
    public ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear(); // Limpa a lista antes de atualizar com dados novos.

        try (Connection conexao = ConexaoBd.getConnection(); Statement stmt = conexao.createStatement(); ResultSet res = stmt.executeQuery("SELECT * FROM ferramenta")) {

            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                double preco = res.getDouble("preco");

                Ferramenta ferramenta = new Ferramenta(id, nome, marca, preco);
                minhaLista.add(ferramenta);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    /**
     * Retorna o maior ID de uma ferramenta na tabela de ferramentas.
     *
     * @return Maior ID.
     */
    public int maiorID() {
        int maiorID = 0;
        try (Connection conexao = ConexaoBd.getConnection(); Statement stmt = conexao.createStatement(); ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM ferramenta")) {

            if (res.next()) {
                maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
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
        String sql = "INSERT INTO ferramenta(id, nome, marca, preco) VALUES(?,?,?,?)";
        try (Connection conexao = ConexaoBd.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, ferramenta.getId());
            stmt.setString(2, ferramenta.getNome());
            stmt.setString(3, ferramenta.getMarca());
            stmt.setDouble(4, ferramenta.getPreco());

            // Uso de executeUpdate(), que é mais adequado para INSERT/UPDATE/DELETE
            stmt.executeUpdate();  // Foi alterado de execute() para executeUpdate()
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
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
        String sql = "DELETE FROM ferramenta WHERE ID = ?";
        try (Connection conexao = ConexaoBd.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
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
        String sql = "UPDATE ferramenta SET nome = ?, marca = ?, preco = ? WHERE id = ?";
        try (Connection conexao = ConexaoBd.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getPreco());
            stmt.setInt(4, ferramenta.getId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Carrega uma ferramenta específica a partir do seu ID.
     *
     * @param id ID da ferramenta a ser carregada.
     * @return Objeto Ferramenta com os dados carregados ou null se não
     * encontrado.
     */
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta ferramenta = null;
        String sql = "SELECT * FROM ferramenta WHERE id = ?";
        try (Connection conexao = ConexaoBd.getConnection(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    String nome = res.getString("nome");
                    String marca = res.getString("marca");
                    double preco = res.getDouble("preco");
                    ferramenta = new Ferramenta(id, nome, marca, preco);
                } else {
                    // Se não encontrar a ferramenta, você pode retornar null ou lançar uma exceção
                    System.out.println("Ferramenta com ID " + id + " não encontrada.");
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
        }
        return ferramenta;  // Pode retornar null se não encontrar a ferramenta
    }
        /**
    * Gera um relatório de todas as ferramentas disponíveis e o custo total gasto.
    * 
    * @return Relatório formatado como String.
    */
    public String geraRelatorioFerramentas() {
        // Recuperar a lista de ferramentas
        ArrayList<Ferramenta> lista = getMinhaLista(); // Buscar ferramentas do DAO

        // Inicializar o custo total
        double custoTotal = 0.0;

        // Criar um StringBuilder para formatar o relatório
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("Relatório de Ferramentas Disponíveis:\n");
        relatorio.append("--------------------------------------\n");

        // Iterar sobre as ferramentas e construir o relatório
        for (Ferramenta ferramenta : lista) {
           relatorio.append("ID: ").append(ferramenta.getId())
                 .append(", Nome: ").append(ferramenta.getNome())
                 .append(", Marca: ").append(ferramenta.getMarca())
                 .append(", Preço: R$ ").append(String.format("%.2f", ferramenta.getPreco()))
                 .append("\n");

            // Adicionar o preço da ferramenta ao custo total
            custoTotal += ferramenta.getPreco();
        }

        // Adicionar o custo total ao relatório
        relatorio.append("--------------------------------------\n");
        relatorio.append("Custo Total: R$ ").append(String.format("%.2f", custoTotal)).append("\n");

        // Retornar o relatório formatado
        return relatorio.toString();
    }

}
