package modelo;

import dao.FerramentaDAO;
import java.util.ArrayList;

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
    public Ferramenta() {
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

    public ArrayList<Ferramenta> getMinhaLista() {
        return dao.getMinhaLista();
    }

    //Insere uma nova ferramenta
    public boolean insereFerramentaBD(String nome, String marca, double preco) {
        int id = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id, nome, marca, preco);
        dao.insereFerramentaBD(objeto);
        return true;
    }

    //Deleta uma ferramenta especÍfica pelo ID.
    public boolean deletaFerramentaBD(int id) {
        dao.deletaFerramentaBD(id);
        return true;
    }

    //Edita uma ferramenta especÍfica pelo ID.
    public boolean atualizaFerramentaBD(int id, String nome, String marca, double preco) {
        Ferramenta objeto = new Ferramenta(id, nome, marca, preco);
        dao.atualizaFerramentaBD(objeto);
        return true;
    }

    //Carrega dados de um aluno especÍfico pelo seu ID.
    public Ferramenta carregaFerramenta(int id) {
        return dao.carregaFerramenta(id);
    }

    //Retorna o maior ID da nossa base de dados.
    public int maiorID() {
        return dao.maiorID();
    }
}
