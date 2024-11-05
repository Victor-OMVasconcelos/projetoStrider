package modelo;

/**
 *
 * @author joaov
 */
public class Amigo {
    private String nome;
    private String telefone;

    public Amigo(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "Amigo [Nome=" + nome + ", Telefone=" + telefone + "]";
    }
}

