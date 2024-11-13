package modelo;

/**
 *
 * @author victor omv
 */
public class Ferramenta {

    private String nome;
    private String marca;
    private double custo;

    public Ferramenta(String nome, String marca, double custo) {
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
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

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        return "Ferramenta [Nome=" + nome + ", Marca=" + marca + ", Custo=" + custo + "]";
    }
}
