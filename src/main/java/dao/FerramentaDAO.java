package dao;

import java.sql.*;
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

   
    //Retorna o maior ID de um amigo
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

    
    //Insere Amigo na db
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
        String sql = " DELETE FROM ferramentas WHERE ID = ?";
        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
    }

    //Atualiza ferramenta na bd
    public boolean atualizaFerramentaBD(Ferramenta ferramenta) {

        String sql = "UPDATE ferramentas SET nome = ? ,marca = ? ,preco = ? WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getPreco());
            stmt.setInt(4, ferramenta.getId());

            stmt.executeUpdate();
            

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
    }
    //Carrega ferramenta pelo ID
    public Ferramenta carregaFerramenta(int id) {
        Ferramenta ferramenta = null;
        String sql = "SELECT * FROM ferramentas WHERE id = ?";
        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1,id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    String nome = res.getString("nome");
                    String marca = res.getString("marca");
                    double preco = res.getDouble("preco");
                    ferramenta = new Ferramenta(id, nome, marca, preco);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return ferramenta;
    }
}
