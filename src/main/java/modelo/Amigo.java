package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Amigo {
    private int id;
    private String nome;
    private String telefone;

    public Amigo(int id, String nome, String telefone) {
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
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
        }
    }
}

