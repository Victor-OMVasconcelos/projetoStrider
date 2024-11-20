package dao;

import dao.ConexaoBd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Ferramenta;

/**
 *
 * @author joaov
 */
public class FerramentaDAO {

    //Utilizado para criar a lista de ferramentas.
    public ArrayList<Ferramenta> minhaLista = new ArrayList<>();

    public ArrayList<Ferramenta> getMinhaLista() {
        minhaLista.clear(); //Limpa a ArrayList

        try (Connection conexao = ConexaoBd.getConnection();
            Statement stmt = conexao.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM ferramentas")) {
            
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome_ferramenta");
                String marca = res.getString("marca");
                double preco = res.getDouble("preco");

                Ferramenta ferramenta = new Ferramenta(id, nome, marca, preco);
                minhaLista.add(ferramenta);
            }   
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        return minhaLista;
    }

   
    //Retorna o maior ID de um aluno
    public int maiorID() {
        int maiorID = 0;
        try (Connection conexao = ConexaoBd.getConnection();
            Statement stmt = conexao.createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) AS id FROM ferramentas")) {
            
            if (res.next()) {
            maiorID = res.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return maiorID;
    }

    
    //Insere Ferramenta na db
    public boolean insereFerramentaBD(Ferramenta ferramenta) {
        String sql = "INSERT INTO ferramentas(id,nome_ferramentas,marca,preco) VALUES(?,?,?,?)";
        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, ferramenta.getId());
            stmt.setString(2, ferramenta.getNome());
            stmt.setString(3, ferramenta.getMarca());
            stmt.setDouble(4, ferramenta.getPreco());

            stmt.execute();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
    }

    //Deleta uma ferramenta da bd
    public boolean deletaFerramentaBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_ferramentas WHERE id = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return true;
    }

    //Atualiza ferramenta na bd
    public boolean atualizaFerramentaBD(Ferramenta objeto) {

        String sql = "UPDATE tb_ferramentas set nome = ? ,marca = ? ,preco = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getPreco());
            stmt.setInt(5, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            throw new RuntimeException(erro);
        }
    }
    //Carrega ferramenta pelo ID
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta objeto = new Ferramenta();
        objeto.setId(id);
        try {
            Statement stmt = this.getConexao().createStatement();

            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            res.next();

            objeto.setNome(res.getString("nome"));
            objeto.setMarca(res.getString("marca"));
            objeto.setPreco(res.getDouble("preco"));
            
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return objeto;
    }
}
