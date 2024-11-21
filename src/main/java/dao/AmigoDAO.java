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
    
    
    
}
