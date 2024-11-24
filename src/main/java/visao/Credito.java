package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 * Tela de exibição dos créditos do projeto.
 * Exibe os créditos dos desenvolvedores e um botão de fechamento.
 * 
 * @author joaov
 */
public class Credito extends JFrame {

    public Credito() {
        // Configurações do JFrame
        setTitle("Créditos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas a janela

        // Criação do JTextPane para exibição dos créditos
        JTextPane textPane = new JTextPane();
        textPane.setText("""
                         Créditos

                         Este projeto foi desenvolvido por:

                         João Vitor Ferraz de Camargo
                         Cauan da Silva dos Santos
                         Victor Oliveira Morais de Vasconcelos
                         
                         Agradecemos a todos os envolvidos e aos que contribuíram para a realização deste trabalho.""");

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

    // Esse método pode ser removido se não for necessário
    public static JTextPane criarCreditos() {
        JTextPane textPane = new JTextPane();
        return textPane;
    }

    public static void main(String[] args) {
        // Criação da janela de créditos ao iniciar o programa
        new Credito();
    }
}
