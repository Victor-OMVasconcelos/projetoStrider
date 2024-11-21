package dao;

import java.sql.*;
import java.util.ArrayList;
import modelo.Amigo;

/**
 *
 * @author Victor Omv
 */
public class AmigoDAO {
    
     //Utilizado para criar a lista de amigos.
    public ArrayList<Amigo> minhaLista = new ArrayList<>();

    public ArrayList<Amigo> getMinhaLista() {
        minhaLista.clear(); //Limpa a ArrayList

        try (Connection conexao = ConexaoBd.getConnection();
            Statement stmt = conexao.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM amigos")) {
            
            while (res.next()) {
                int id = res.getInt("id");
                String nome = res.getString("nome_amigo");
                String telefone = res.getString("telefone");
                

                Amigo amigo = new Amigo(id, nome, telefone);
                minhaLista.add(amigo);
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
    
    
    //Insere amigo na db
    public boolean insereAmigoBD(Amigo amigo) {
        String sql = "INSERT INTO amigos(id,nome_amigo,telefone) VALUES(?,?,?)";
        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, amigo.getId());
            stmt.setString(2, amigo.getNome());
            stmt.setString(3, amigo.getTelefone());

            stmt.execute();

            return true;
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
    }
    
    
    //Deleta um amigo da bd
    public boolean deletaAmigoBD(int id) {
        String sql = " DELETE FROM amigos WHERE ID = ?";
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
    
    
   //Atualiza amigo na bd
    public boolean atualizaAmigoBD(Amigo amigo) {

        String sql = "UPDATE amigos SET nome_amigo = ? ,telefone = ? WHERE id = ?";

        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, amigo.getId());

            stmt.executeUpdate();
            

            return true;

        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
            return false;
        }
    }
    
    
    //Carrega amigo pelo ID
    public Amigo carregaAmigo(int id) {
        Amigo amigo = null;
        String sql = "SELECT * FROM amigos WHERE id = ?";
        try (Connection conexao = ConexaoBd.getConnection();
            PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1,id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    String nome = res.getString("nome_amigo");
                    String telefone = res.getString("telefone");
                    amigo = new Amigo(id, nome,telefone);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro:" + erro);
        }
        return amigo;
    }
}
