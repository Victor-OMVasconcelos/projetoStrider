package modelo;

import dao.ConexaoBd;
import dao.FerramentaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Representa uma ferramenta com informações como nome, marca, preço, e
 * operações no banco de dados.
 *
 */
public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private double preco;
    private FerramentaDAO dao;

    // Construtor com parâmetros
    public Ferramenta(int id, String nome, String marca, double preco, FerramentaDAO dao) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.dao = dao != null ? dao : new FerramentaDAO(); // Permite injeção do DAO
    }

    // Construtor vazio (com DAO padrão)
    public Ferramenta() {
        this(0, "", "", 0.0, new FerramentaDAO());
    }

    public Ferramenta(int id, String nome, String marca, double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco < 0) {
            throw new IllegalArgumentException("Preço não pode ser negativo.");
        }
        this.preco = preco;
    }

    public FerramentaDAO getDao() {
        return dao;
    }

    public void setDao(FerramentaDAO dao) {
        this.dao = dao;
    }

    // Retorna os dados da ferramenta em String
    @Override
    public String toString() {
        return "Ferramenta [Nome=" + nome + ", Marca=" + marca + ", Preço=" + preco + "]";
    }

    // Retorna a lista de ferramentas
    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere uma nova ferramenta no banco de dados. O ID é atribuído com base
     * no maior ID atual.
     */
    public boolean insereFerramentaBD(String nome, String marca, double preco) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Erro: Nome da ferramenta não pode ser vazio.");
            return false;
        }
        if (marca == null || marca.isEmpty()) {
            System.out.println("Erro: Marca não pode ser vazia, coloque 'sem marca' em vez disso.");
            return false;
        }
        if (preco <= 0) {
            System.out.println("Erro: O preço da ferramenta deve ser maior que zero.");
            return false;
        }

        int id = maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, preco, this.dao);
        return dao.insereFerramentaBD(objeto); // Sucesso ou falha da inserção no banco
    }

    /**
     * Deleta uma ferramenta específica pelo ID.
     */
    public boolean deletaFerramentaBD(int id) {
        try {
            Connection conn = ConexaoBd.getConnection();
            String sql = "DELETE FROM ferramenta WHERE id = ?"; // Usando o nome correto da tabela
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultado = stmt.executeUpdate();
            conn.close();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Atualiza os dados de uma ferramenta específica.
     */
    public boolean atualizaFerramentaBD(int id, String nome, String marca, double preco) {
        try {
            Connection conn = ConexaoBd.getConnection();
            String sql = "UPDATE ferramenta SET nome_ferramenta = ?, marca = ?, preco = ? WHERE id = ?"; // Usando o nome correto da coluna 'nome_ferramenta'
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, marca);
            stmt.setDouble(3, preco);
            stmt.setInt(4, id);
            int resultado = stmt.executeUpdate();
            conn.close();
            return resultado > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Carrega os dados de uma ferramenta pelo ID.
     */
    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    /**
     * Retorna o maior ID da base de dados.
     */
    public int maiorID() {
        return dao.maiorID();
    }
}
