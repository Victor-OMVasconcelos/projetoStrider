package modelo;

import dao.FerramentaDAO;

/**
 *
 * @author victor omv
 */
public class Ferramenta {

    private int id;
    private String nome;
    private String marca;
    private double preco;
    private FerramentaDAO dao;

    //Construtor com parâmetros
    public Ferramenta(Integer id, String nome, String marca, double preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.dao = new FerramentaDAO();
    }

    //Construtor vazio
    public Ferramenta (){
        this(0, "", "", 0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.preco = preco;
    }

    public FerramentaDAO getDao() {
        return dao;
    }

    public void setDao(FerramentaDAO dao) {
        this.dao = dao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    


    //Retorna os dados da ferramenta em String
    @Override
    public String toString() {
        return "Ferramenta [Nome= " + nome + ", Marca= " + marca + ", Custo= " + preco + "]";
    }
}
