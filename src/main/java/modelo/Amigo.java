package modelo;

import dao.AmigoDAO;
import dao.ConexaoBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Amigo {

    private int id;
    private String nome;
    private String telefone;
    private int item;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }
    private AmigoDAO dao;

    /**
     * Construtor para inicializar o amigo com id, nome e telefone. Valida o
     * telefone e o nome.
     *
     * @param id ID do amigo.
     * @param nome Nome do amigo.
     * @param telefone Telefone do amigo no formato 'XXXX-XXXX'.
     * @param item Quantidade de itens do amigo.
     */
    public Amigo(int id, String nome, String telefone, int item) {
        // Validação como está
        if (nome == null || nome.isEmpty() || telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser vazio.");
        }
        
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.item = item;
        this.dao = new AmigoDAO(); // Inicia com uma instância nova
    }

    // Construtor sem parâmetros, inicializa com valores padrão.
    public Amigo() {
        this.id = 0;
        this.nome = "";
        this.telefone = "";
        this.item = 0;
        this.dao = new AmigoDAO();
    }

    public AmigoDAO getDao() {
        return dao;
    }

    public void setDao(AmigoDAO dao) {
        this.dao = dao;
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
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone em formato inválido. Use 'XXXX-XXXX'.");
        }
        this.telefone = telefone;
    }

    // Retorna os dados do amigo em String
    @Override
    public String toString() {
        return "Amigo{" + "id=" + id + ", nome='" + nome + '\'' + ", telefone='" + telefone + '\'' + '}';
    }

    // Retorna a lista de amigos
    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhaLista();
    }

    /**
     * Insere um novo amigo no banco de dados.
     *
     * @param amigo Objeto Amigo a ser inserido.
     * @return true se a inserção for bem-sucedida, false caso contrário.
     */
    public boolean insereAmigoBD(String nome, String telefone, int item) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: Nome do amigo não pode ser vazio.");
            return false;
        }
        if (telefone == null) {
            System.out.println("Erro: Telefone inválido.");
            return false;
        }

        int id = maiorID() + 1;
        Amigo objeto = new Amigo(id, nome, telefone, item);
        return dao.insereAmigoBD(objeto); // Sucesso ou falha da inserção no banco
    }

    /**
     * Deleta um amigo do banco de dados pelo ID.
     *
     * @param id ID do amigo a ser deletado.
     * @return true se a exclusão for bem-sucedida, false caso contrário.
     */
    public boolean deletaAmigoBD(int id) {
        // Definindo a consulta SQL para exclusão
        String query = "DELETE FROM amigo WHERE id = ?";

        try (Connection con = ConexaoBd.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando o parâmetro da consulta
            stmt.setInt(1, id);

            // Executando a consulta
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar amigo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Atualiza os dados de um amigo no banco de dados.
     *
     * @param amigo Objeto Amigo contendo as novas informações.
     * @return true se a atualização for bem-sucedida, false caso contrário.
     */
    public boolean atualizaAmigoBD(int id, String nome, String telefone, int item) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("Erro: Nome do amigo não pode ser vazio.");
            return false;
        }
        if (telefone == null || telefone.isEmpty()) {
            System.out.println("Erro: Telefone do amigo não pode ser vazio.");
            return false;
        }

        Amigo objeto = new Amigo(id, nome, telefone, item);
        return dao.atualizaAmigoBD(objeto); // Sucesso ou falha da atualização no banco
    }

    /**
     * Carrega um amigo do banco de dados pelo ID.
     *
     * @param id ID do amigo a ser carregado.
     * @return Objeto Amigo carregado ou null caso não seja encontrado.
     */
    public Amigo carregaAmigo(int id) {
        // Definindo a consulta SQL para carregar um amigo
        String query = "SELECT id, nome, telefone, item FROM amigo WHERE id = ?";
        Amigo amigo = null;

        try (Connection con = ConexaoBd.getConnection(); PreparedStatement stmt = con.prepareStatement(query)) {
            // Setando o parâmetro da consulta
            stmt.setInt(1, id);

            // Executando a consulta
            try (ResultSet rs = stmt.executeQuery()) {
                // Verificando se o amigo foi encontrado
                if (rs.next()) {
                    amigo = new Amigo(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getInt("item")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar amigo: " + e.getMessage());
        }
        return amigo;
    }

    public int maiorID() {
        return dao.maiorID();
    }

}
