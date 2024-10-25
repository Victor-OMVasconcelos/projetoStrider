package modelo;

/**
 *
 * @author joaov
 */
import java.util.Date;
import java.util.List;

public class Emprestimo {

    private int id;
    private Amigo amigo;
    private List<Ferramenta> ferramentas;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(int id, Amigo amigo, List<Ferramenta> ferramentas, Date dataEmprestimo) {
        this.id = id;
        this.amigo = amigo;
        this.ferramentas = ferramentas;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = null; // Data de devolução começa como null
    }

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

    public void devolverFerramentas(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return "Emprestimo [ID=" + id + ", Amigo=" + amigo.getNome() + ", Ferramentas=" + ferramentas.size()
                + ", Data Emprestimo=" + dataEmprestimo + ", Data Devolucao=" + dataDevolucao + "]";
    }
}
