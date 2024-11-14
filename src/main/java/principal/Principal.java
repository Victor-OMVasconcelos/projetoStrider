package principal;
import modelo.Amigo;
import visao.FrmMenuPrincipal;
import java.sql.SQLException;

/**
 *
 * @author joaov
 */
public class Principal {

    public static void main(String[] args) {
        try {
            Amigo amigo = new Amigo(3, "cauan", "8856-789");
            amigo.save();
            System.out.println("Dados salvos");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        /*
        FrmMenuPrincipal objeto = new FrmMenuPrincipal();
        objeto.setLocationRelativeTo(null);
        objeto.setVisible(true);
        */
    }
}
