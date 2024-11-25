package principal;

import visao.FrmMenuPrincipal;
import java.sql.SQLException;

/**
 * Classe principal da aplicação, responsável por inicializar a interface
 * gráfica e outras operações principais, como a criação de conexões e o
 * lançamento da tela principal.
 *
 */
public class Principal {

    public static void main(String[] args) {

        try {
            // Cria a instância do menu principal
            FrmMenuPrincipal objeto = new FrmMenuPrincipal();

            // Posiciona a janela no centro da tela
            objeto.setLocationRelativeTo(null);

            // Torna a janela visível
            objeto.setVisible(true);
        } catch (Exception ex) {
            // Captura outras exceções que podem ocorrer
            System.err.println("Erro inesperado: " + ex.getMessage());
        }

    }
}
