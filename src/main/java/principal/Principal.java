package principal;

/**
 *
 * @author joaov
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Amigo;
import modelo.Emprestimo;
import modelo.Ferramenta;

public class Principal {

    public static void main(String[] args) {
        // Criando lista para armazenar ferramentas e amigos
        List<Ferramenta> listaFerramentas = new ArrayList<>();
        List<Amigo> listaAmigos = new ArrayList<>();

        // Cadastro de ferramentas usando JOptionPane
        int numFerramentas = Integer.parseInt(JOptionPane.showInputDialog("Quantas ferramentas deseja cadastrar?"));

        for (int i = 0; i < numFerramentas; i++) {
            String nomeFerramenta = JOptionPane.showInputDialog("Digite o nome da ferramenta:");
            String marcaFerramenta = JOptionPane.showInputDialog("Digite a marca da ferramenta:");
            double custoFerramenta = Double.parseDouble(JOptionPane.showInputDialog("Digite o custo da ferramenta:"));
            Ferramenta ferramenta = new Ferramenta(i + 1, nomeFerramenta, marcaFerramenta, custoFerramenta);
            listaFerramentas.add(ferramenta);
        }

        // Cadastro de amigos usando JOptionPane
        int numAmigos = Integer.parseInt(JOptionPane.showInputDialog("Quantos amigos deseja cadastrar?"));

        for (int i = 0; i < numAmigos; i++) {
            String nomeAmigo = JOptionPane.showInputDialog("Digite o nome do amigo:");
            String telefoneAmigo = JOptionPane.showInputDialog("Digite o telefone do amigo:");
            Amigo amigo = new Amigo(i + 1, nomeAmigo, telefoneAmigo);
            listaAmigos.add(amigo);
        }

        // Escolha do amigo para o empréstimo
        StringBuilder listaAmigosStr = new StringBuilder();
        for (Amigo amigo : listaAmigos) {
            listaAmigosStr.append(amigo.getId()).append(" - ").append(amigo.getNome()).append("\n");
        }
        int idAmigo = Integer.parseInt(JOptionPane.showInputDialog("Escolha o amigo para o empréstimo:\n" + listaAmigosStr));

        Amigo amigoSelecionado = null;
        for (Amigo amigo : listaAmigos) {
            if (amigo.getId() == idAmigo) {
                amigoSelecionado = amigo;
                break;
            }
        }

        // Escolha das ferramentas para o empréstimo
        StringBuilder listaFerramentasStr = new StringBuilder();
        for (Ferramenta ferramenta : listaFerramentas) {
            listaFerramentasStr.append(ferramenta.getId()).append(" - ").append(ferramenta.getNome()).append("\n");
        }
        String idsFerramentas = JOptionPane.showInputDialog("Escolha as ferramentas para o empréstimo (separadas por vírgula):\n" + listaFerramentasStr);
        String[] idsFerramentasArray = idsFerramentas.split(",");

        List<Ferramenta> ferramentasEmprestimo = new ArrayList<>();
        for (String idFerramentaStr : idsFerramentasArray) {
            int idFerramenta = Integer.parseInt(idFerramentaStr.trim());
            for (Ferramenta ferramenta : listaFerramentas) {
                if (ferramenta.getId() == idFerramenta) {
                    ferramentasEmprestimo.add(ferramenta);
                    break;
                }
            }
        }

        // Registro do empréstimo
        Emprestimo emprestimo = new Emprestimo(1, amigoSelecionado, ferramentasEmprestimo, new Date());

        // Exibindo detalhes do empréstimo
        JOptionPane.showMessageDialog(null, emprestimo.toString());

        // Devolução das ferramentas
        int opcaoDevolucao = JOptionPane.showConfirmDialog(null, "Deseja devolver as ferramentas?");
        if (opcaoDevolucao == JOptionPane.YES_OPTION) {
            emprestimo.devolverFerramentas(new Date());
            JOptionPane.showMessageDialog(null, "Após a devolução: " + emprestimo.toString());
        }
    }
}
