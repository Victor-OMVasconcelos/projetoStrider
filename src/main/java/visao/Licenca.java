package visao;

/**
 *
 * @author joaov
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Licenca extends JFrame {

    public Licenca() {
        // Configurações do JFrame
        setTitle("Licenciamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação do JTextPane
        JTextPane textPane = new JTextPane();
        textPane.setText("""
                         MIT License
                         
                         Copyright (c) 2024 Strider
                         
                         Permiss\u00e3o \u00e9 concedida, gratuitamente, a qualquer pessoa que obtenha uma c\u00f3pia deste software e arquivos de documenta\u00e7\u00e3o associados (o "Software"), para lidar no Software sem restri\u00e7\u00f5es, incluindo sem limita\u00e7\u00e3o os direitos de usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender c\u00f3pias do Software, e para permitir que as pessoas a quem o Software \u00e9 fornecido o fa\u00e7am, sujeito \u00e0s seguintes condi\u00e7\u00f5es:
                         
                         A seguir, as condi\u00e7\u00f5es e as permiss\u00f5es acima dever\u00e3o ser inclu\u00eddas em todas as c\u00f3pias ou partes substanciais do Software.
                         
                         O Software \u00e9 fornecido "no estado em que se encontra", sem garantia de qualquer tipo, expressa ou impl\u00edcita, incluindo mas n\u00e3o se limitando \u00e0s garantias de comercializa\u00e7\u00e3o, adequa\u00e7\u00e3o a um prop\u00f3sito espec\u00edfico e n\u00e3o viola\u00e7\u00e3o. Em nenhum caso o autor ou detentor dos direitos autorais ser\u00e1 respons\u00e1vel por qualquer reclama\u00e7\u00e3o, dano ou outra responsabilidade, seja em uma a\u00e7\u00e3o de contrato, ato il\u00edcito ou de outro tipo, decorrente de, ou em conex\u00e3o com o Software ou o uso ou outros neg\u00f3cios no Software.""");

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

    public static JTextPane criarLicenca() {
        JTextPane textPane = new JTextPane();
        return textPane;
    }

}
