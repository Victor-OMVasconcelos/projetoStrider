package visao;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author joaov
 */
public class Credito extends JFrame {

    public Credito() {
        // Configurações do JFrame
        setTitle("Créditos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setText("""
                         Cr\u00e9ditos

                         Este projeto foi desenvolvido por:

                         Jo\u00e3o Vitor Ferraz de Camargo
                         Cauan da Silva dos Santos
                         Victor Oliveira Morais de Vasconcelos
                         Agradecemos a todos os envolvidos e aos que contribu\u00edram para a realiza\u00e7\u00e3o deste trabalho.""");

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

    public static JTextPane criarCreditos() {
        JTextPane textPane = new JTextPane();
        return textPane;
    }

}
