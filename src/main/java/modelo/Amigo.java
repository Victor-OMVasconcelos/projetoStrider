package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Amigo {
    private int id;
    private String nome;
    private String telefone;

    public Amigo(int id, String nome, String telefone) {
        if (nome == null || nome.isEmpty() || telefone == null || telefone.isEmpty()){
            throw new IllegalArgumentException("Nome e telefone não podem ser vazios.");
        }
        if (telefone == null || !telefone.matches("\\d{4,5}-\\d{4}")) {
            throw new IllegalArgumentException("Telefone em formato inválido. Use 'XXXX-XXXX'.");
        }
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException ("Nome não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(telefone == null || !telefone.matches("\\d{4,5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone em formato inválido. Use 'XXXX-XXXX'.");
         }
        this.telefone = telefone;
    }

    public void save() throws SQLException {
        String query = "INSERT INTO amigos (id, nome_amigo, telefone) VALUES (?, ?, ?)";

        try (Connection con = ConexaoBd.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, this.id);
            stmt.setString(2, this.nome);
            stmt.setString(3, this.telefone);
            stmt.executeUpdate();
            System.out.println("Amigo salvo com sucesso!");
        } catch (SQLException e) {
             System.err.println("Erro ao salvar amigo: " + e.getMessage());
            throw e;
        }
    }
    
@Override
    public String toString() {
        return "Amigo{" + "id=" + id + ", nome='" + nome + '\'' + ", telefone='" + telefone + '\'' + '}';
    }
}