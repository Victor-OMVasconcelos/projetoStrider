package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;

/**
 * Classe responsável pela interação com o banco de dados para os empréstimos.
 * Gerencia operações de CRUD (Create, Read, Update, Delete).
 * 
 */
public class EmprestimoDAO {

    // Lista de empréstimos para armazenar temporariamente os objetos.
    public ArrayList<Emprestimo> minhaLista = new ArrayList<>();

    /**
     * Recupera todos os empréstimos da base de dados e os adiciona à lista.
     *
     * @return Lista de empréstimos.
     */
    public ArrayList<Emprestimo> getMinhaLista() {
        minhaLista.clear(); // Limpa a lista antes de atualizar com dados novos.

        String sqlEmprestimos = "SELECT * FROM emprestimo";
        String sqlFerramentas = "SELECT * FROM ferramenta_emprestimo WHERE emprestimo_id = ?";

        try (Connection conexao = ConexaoBd.getConnection(); 
             Statement stmt = conexao.createStatement(); 
             ResultSet resEmprestimos = stmt.executeQuery(sqlEmprestimos)) {

            while (resEmprestimos.next()) {
                int id = resEmprestimos.getInt("id");
                int amigoId = resEmprestimos.getInt("amigo_id");
                Date dataEmprestimo = resEmprestimos.getDate("data_emprestimo");
                Date dataDevolucao = resEmprestimos.getDate("data_devolucao");

                // Recupera o amigo pelo ID
                Amigo amigo = new AmigoDAO().carregaAmigo(amigoId);

                // Recupera as ferramentas associadas ao empréstimo
                List<Ferramenta> ferramentas = new ArrayList<>();
                try (PreparedStatement stmtFerramentas = conexao.prepareStatement(sqlFerramentas)) {
                    stmtFerramentas.setInt(1, id);
                    try (ResultSet resFerramentas = stmtFerramentas.executeQuery()) {
                        while (resFerramentas.next()) {
                            int ferramentaId = resFerramentas.getInt("ferramenta_id");
                            Ferramenta ferramenta = new FerramentaDAO().carregaFerramenta(ferramentaId);
                            ferramentas.add(ferramenta);
                        }
                    }
                }

                Emprestimo emprestimo = new Emprestimo(id, amigo, ferramentas, dataEmprestimo);
                emprestimo.setDataDevolucao(dataDevolucao);
                minhaLista.add(emprestimo);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return minhaLista;
    }

    /**
     * Insere um empréstimo no banco de dados.
     *
     * @param emprestimo Objeto empréstimo a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean insereEmprestimoBD(Emprestimo emprestimo) {
        String sqlEmprestimo = "INSERT INTO emprestimo(id, amigo_id, data_emprestimo, data_devolucao) VALUES(?,?,?,?)";
        String sqlFerramentaEmprestimo = "INSERT INTO ferramenta_emprestimo(emprestimo_id, ferramenta_id) VALUES(?,?)";

        try (Connection conexao = ConexaoBd.getConnection(); 
             PreparedStatement stmtEmprestimo = conexao.prepareStatement(sqlEmprestimo);
             PreparedStatement stmtFerramentaEmprestimo = conexao.prepareStatement(sqlFerramentaEmprestimo)) {

            // Inserir dados do empréstimo
            stmtEmprestimo.setInt(1, emprestimo.getId());
            stmtEmprestimo.setInt(2, emprestimo.getAmigo().getId());
            stmtEmprestimo.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            if (emprestimo.getDataDevolucao() != null) {
                stmtEmprestimo.setDate(4, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            } else {
                stmtEmprestimo.setNull(4, Types.DATE);
            }
            stmtEmprestimo.executeUpdate();

            // Inserir ferramentas associadas
            for (Ferramenta ferramenta : emprestimo.getFerramentas()) {
                stmtFerramentaEmprestimo.setInt(1, emprestimo.getId());
                stmtFerramentaEmprestimo.setInt(2, ferramenta.getId());
                stmtFerramentaEmprestimo.executeUpdate();
            }

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Atualiza os dados de um empréstimo no banco de dados.
     *
     * @param emprestimo Objeto empréstimo com os novos dados.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizaEmprestimoBD(Emprestimo emprestimo) {
        String sqlEmprestimo = "UPDATE emprestimo SET amigo_id = ?, data_emprestimo = ?, data_devolucao = ? WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection(); 
             PreparedStatement stmtEmprestimo = conexao.prepareStatement(sqlEmprestimo)) {

            stmtEmprestimo.setInt(1, emprestimo.getAmigo().getId());
            stmtEmprestimo.setDate(2, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            if (emprestimo.getDataDevolucao() != null) {
                stmtEmprestimo.setDate(3, new java.sql.Date(emprestimo.getDataDevolucao().getTime()));
            } else {
                stmtEmprestimo.setNull(3, Types.DATE);
            }
            stmtEmprestimo.setInt(4, emprestimo.getId());
            stmtEmprestimo.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }

    /**
     * Deleta um empréstimo do banco de dados.
     *
     * @param id ID do empréstimo a ser deletado.
     * @return true se a deleção for bem-sucedida, false caso contrário.
     */
    public boolean deletaEmprestimoBD(int id) {
        String sqlEmprestimo = "DELETE FROM emprestimo WHERE id = ?";
        String sqlFerramentaEmprestimo = "DELETE FROM ferramenta_emprestimo WHERE emprestimo_id = ?";

        try (Connection conexao = ConexaoBd.getConnection(); 
             PreparedStatement stmtFerramentaEmprestimo = conexao.prepareStatement(sqlFerramentaEmprestimo);
             PreparedStatement stmtEmprestimo = conexao.prepareStatement(sqlEmprestimo)) {

            // Excluir associações de ferramentas
            stmtFerramentaEmprestimo.setInt(1, id);
            stmtFerramentaEmprestimo.executeUpdate();

            // Excluir empréstimo
            stmtEmprestimo.setInt(1, id);
            stmtEmprestimo.executeUpdate();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro);
            return false;
        }
    }
}
