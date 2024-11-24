package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Tela de exibição das informações sobre o software.
 * Exibe uma descrição detalhada do sistema e um botão de fechamento.
 * 
 * @author joaov
 */
public class Descricao extends JFrame {

    private static final String DESCRICAO_TEXTO = """
                         Este é um software simples e local para gerenciar o empréstimo de ferramentas para amigos. Ele permite que o usuário cadastre ferramentas e amigos, registre os empréstimos e acompanhe as devoluções. As funcionalidades principais incluem:
                         
                         Cadastro de Ferramentas: O usuário pode cadastrar ferramentas, inserindo informações como o nome, marca e custo de aquisição.
                         
                         Cadastro de Amigos: Permite o cadastro de amigos, incluindo nome e telefone, que serão os destinatários dos empréstimos.
                         
                         Registro de Empréstimos: O sistema permite registrar um empréstimo para um amigo específico, escolhendo uma ou mais ferramentas e definindo a data de empréstimo e uma data de devolução.
                         
                         Relatórios e Acompanhamento: O software oferece um relatório de todas as ferramentas cadastradas, incluindo o total gasto em aquisições, além de relatórios de empréstimos ativos e de todos os empréstimos realizados. Também exibe um alerta caso algum amigo já possua ferramentas em aberto, ajudando no controle dos empréstimos.
                         
                         Este sistema simples é ideal para uso pessoal e local, facilitando o acompanhamento de empréstimos de ferramentas para evitar perdas e monitorar as devoluções.""";

    public Descricao() {
        // Configurações do JFrame
        setTitle("Informações sobre o software");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas a janela

        // Criação do JTextPane para exibição da descrição
        JTextPane textPane = new JTextPane();
        textPane.setText(DESCRICAO_TEXTO);
        textPane.setEditable(false); // Desabilita a edição do texto

        // Coloca o JTextPane dentro de um JScrollPane para permitir rolagem
        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        // Criação do botão "Fechar"
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });

        // Adiciona o botão ao rodapé do JFrame
        add(btnFechar, BorderLayout.SOUTH);
        
        // Define a localização da janela
        setLocation(200, 100);
        
        // Exibe a janela
        setVisible(true);
    }

    public static void main(String[] args) {
        // Criação da janela de descrição ao iniciar o programa
        new Descricao();
    }
}
