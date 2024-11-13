package visao;

/**
 *
 * @author joaov
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Descricao extends JFrame {

    public Descricao() {
        // Configurações do JFrame
        setTitle("Informações sobre o software");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setText("""
                         Este \u00e9 um software simples e local para gerenciar o empr\u00e9stimo de ferramentas para amigos. Ele permite que o usu\u00e1rio cadastre ferramentas e amigos, registre os empr\u00e9stimos e acompanhe as devolu\u00e7\u00f5es. As funcionalidades principais incluem:
                         
                         Cadastro de Ferramentas: O usu\u00e1rio pode cadastrar ferramentas, inserindo informa\u00e7\u00f5es como o nome, marca e custo de aquisi\u00e7\u00e3o.
                         
                         Cadastro de Amigos: Permite o cadastro de amigos, incluindo nome e telefone, que ser\u00e3o os destinat\u00e1rios dos empr\u00e9stimos.
                         
                         Registro de Empr\u00e9stimos: O sistema permite registrar um empr\u00e9stimo para um amigo espec\u00edfico, escolhendo uma ou mais ferramentas e definindo a data de empr\u00e9stimo e uma data de devolu\u00e7\u00e3o.
                         
                         Relat\u00f3rios e Acompanhamento: O software oferece um relat\u00f3rio de todas as ferramentas cadastradas, incluindo o total gasto em aquisi\u00e7\u00f5es, al\u00e9m de relat\u00f3rios de empr\u00e9stimos ativos e de todos os empr\u00e9stimos realizados. Tamb\u00e9m exibe um alerta caso algum amigo j\u00e1 possua ferramentas em aberto, ajudando no controle dos empr\u00e9stimos.
                         
                         Este sistema simples \u00e9 ideal para uso pessoal e local, facilitando o acompanhamento de empr\u00e9stimos de ferramentas para evitar perdas e monitorar as devolu\u00e7\u00f5es.""");
        
        textPane.setEditable(false);
        
        JScrollPane scrollPane = new JScrollPane(textPane);
        
        add(scrollPane, BorderLayout.CENTER);
        
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        // Adicionando o botão na parte inferior do JFrame
        add(btnFechar, BorderLayout.SOUTH);
        setLocation(200, 100);
        setVisible(true);
    }

    public static JTextPane criarDescricao() {
        JTextPane textPane = new JTextPane();
        return textPane;
    }

}
