package modelo;

import java.util.Date;
import java.util.List;

/**
 * Representa um empréstimo de ferramentas a um amigo com data de empréstimo e devolução.
 * Permite registrar o amigo, as ferramentas emprestadas e as datas de empréstimo e devolução.
 * 
 * @author joaov
 */
public class Emprestimo {

    private int id;
    private Amigo amigo;
    private List<Ferramenta> ferramentas;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    /**
     * Construtor para inicializar o empréstimo com id, amigo, ferramentas e data de empréstimo.
     * A data de devolução é inicialmente nula.
     */
    public Emprestimo(int id, Amigo amigo, List<Ferramenta> ferramentas, Date dataEmprestimo) {
        this.id = id;
        this.amigo = amigo;
        this.ferramentas = ferramentas;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null; // Devolução não ocorre no momento do empréstimo
    }

    // Métodos getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public List<Ferramenta> getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(List<Ferramenta> ferramentas) {
        this.ferramentas = ferramentas;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Método para registrar a devolução das ferramentas. 
     * Valida se a data de devolução não é anterior à data de empréstimo.
     * 
     * @param dataDevolucao A data em que as ferramentas são devolvidas.
     * @return true se a devolução for válida, caso contrário false.
     */
    public boolean devolverFerramentas(Date dataDevolucao) {
        if (dataDevolucao.before(this.dataEmprestimo)) {
            System.out.println("Erro: Data de devolução não pode ser anterior à data de empréstimo.");
            return false;
        }
        this.dataDevolucao = dataDevolucao;
        return true; // Devolução válida
    }

    
    /**
    * Gera uma representação textual do objeto Emprestimo.
    * 
    * O método `toString()` cria uma descrição detalhada do objeto,
    * incluindo informações como o ID do empréstimo, nome do amigo associado,
    * quantidade de ferramentas emprestadas, data de empréstimo e data de devolução.
    * Caso a data de devolução não tenha sido definida, é exibida como "Não devolvido".
    * 
    * @return String representando o objeto Emprestimo.
    */
    @Override
    public String toString() {
        String devolucao = (dataDevolucao != null) ? dataDevolucao.toString() : "Não devolvido";
        return "Emprestimo [ID=" + id + ", Amigo=" + amigo.getNome() + ", Ferramentas=" + ferramentas.size()
                + ", Data Emprestimo=" + dataEmprestimo + ", Data Devolucao=" + devolucao + "]";
    }

    public void setDataDevolucao(Date dataDevolucao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
