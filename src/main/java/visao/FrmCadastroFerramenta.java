package visao;

import javax.swing.JOptionPane;
import modelo.Ferramenta;

/**
 * Classe responsável pela interface de cadastro de ferramentas. A classe exibe
 * um formulário para o usuário cadastrar novas ferramentas no sistema.
 */
public class FrmCadastroFerramenta extends javax.swing.JFrame {

    // Atributo para armazenar a ferramenta
    private Ferramenta objetoferramenta;

    /**
     * Construtor da classe que inicializa a interface gráfica e cria um objeto
     * Ferramenta.
     */
    public FrmCadastroFerramenta() {
        initComponents();
        this.objetoferramenta = new Ferramenta();
    }

    /**
     * Método gerado automaticamente pelo Form Editor para inicializar os
     * componentes da interface gráfica. Não deve ser alterado manualmente.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTFNomeFerramenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTFMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFPreco = new javax.swing.JTextField();
        JBFechar = new javax.swing.JButton();
        JBLimpar = new javax.swing.JButton();
        JBCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastar Ferramenta");

        jLabel1.setText("Nome da ferramenta:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Preço:");

        JTFPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFPrecoActionPerformed(evt);
            }
        });

        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
            }
        });

        JBLimpar.setText("Limpar");
        JBLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimparActionPerformed(evt);
            }
        });

        JBCadastrar.setText("Cadastrar");
        JBCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTFMarca)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JBFechar)
                                        .addGap(62, 62, 62)
                                        .addComponent(JBLimpar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(JBCadastrar)))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBFechar)
                    .addComponent(JBLimpar)
                    .addComponent(JBCadastrar))
                .addGap(25, 25, 25))
        );

        getAccessibleContext().setAccessibleDescription("Faz o cadastro de um ferramenta nova.");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Método acionado quando o usuário clica no campo de preço.
     */
    private void JTFPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFPrecoActionPerformed
        // Método não utilizado.
    }//GEN-LAST:event_JTFPrecoActionPerformed
    
    /**
     * Método para fechar a janela do formulário.
     */
    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBFecharActionPerformed
    
    /**
     * Método para limpar os campos do formulário.
     */
    private void JBLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimparActionPerformed
        JTFNomeFerramenta.setText("");
        JTFMarca.setText("");
        JTFPreco.setText("");
    }//GEN-LAST:event_JBLimparActionPerformed

    /**
     * Método para cadastrar a ferramenta no banco de dados.
     */
    private void JBCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCadastrarActionPerformed
        try {
            // Recebe e valida os dados da interface gráfica
            String nome = "";
            String marca = "";
            double preco = 0.0;

            if (this.JTFNomeFerramenta.getText().length() < 2) {
                throw new Mensagem("Nome da ferramenta deve conter ao menos 2 caracteres.");
            } else {
                nome = this.JTFNomeFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() < 1) {
                throw new Mensagem("Marca deve ao menos conter 1 caractere.");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFPreco.getText().length() <= 0) {
                throw new Mensagem("O custo da ferramenta deve conter somente numerais e ser maior do que 0.");
            } else {
                preco = Double.parseDouble(this.JTFPreco.getText());
            }

            // Envia os dados para o controlador para o cadastro
            if (this.objetoferramenta.insereFerramentaBD(nome, marca, preco)) {
                JOptionPane.showMessageDialog(null, "Ferramenta cadastrada com sucesso!");
                // Limpa os campos após o cadastro
                this.JTFNomeFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFPreco.setText("");
            }
            // Exibe no console a lista de ferramentas cadastradas
            System.out.println(this.objetoferramenta.getMinhaLista().toString());

        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        }
    }//GEN-LAST:event_JBCadastrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmCadastroFerramenta().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCadastrar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JButton JBLimpar;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNomeFerramenta;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
