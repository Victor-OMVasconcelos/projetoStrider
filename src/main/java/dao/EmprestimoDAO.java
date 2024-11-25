package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        minhaLista.clear();
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

    // Restante do código permanece igual, com os imports ajustados
}
