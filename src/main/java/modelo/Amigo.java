package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo {

    private int id;
    private String nome;
    private String telefone;
    private AmigoDAO dao;

    /**
     * Construtor para inicializar o amigo com id, nome e telefone.
     * Valida o telefone e o nome.
     * 
     * @param id ID do amigo.
     * @param nome Nome do amigo.
     * @param telefone Telefone do amigo no formato 'XXXX-XXXX'.
     */
    public Amigo(int id, String nome, String telefone) {
        if (nome == null || nome.isEmpty() || telefone == null || telefone.isEmpty()) {
            throw new IllegalArgumentException("Nome e telefone não podem ser vazios.");
        }
        if (!telefone.matches("\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone em formato inválido. Use 'XXXX-XXXX'.");
        }
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dao = dao != null ? dao : new AmigoDAO(); // Permite injeção do DAO
    }

    // Construtor sem parâmetros, inicializa com valores padrão.
    public Amigo() {
        this.id = 0;
        this.nome = "";
        this.telefone = "";
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
}
