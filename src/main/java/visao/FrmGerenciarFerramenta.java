
package visao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Ferramenta;


public class FrmGerenciarFerramenta extends javax.swing.JFrame {

    private Ferramenta objetoferramenta; //cria vinculo com Ferramenta

    /**
     * Creates new form FrmGerenciarFerramenta
     */
    public FrmGerenciarFerramenta() {
        initComponents();
        this.objetoferramenta = new Ferramenta(); //carrega objeto de Ferramenta
        this.carregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTFMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JTFPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableFerramentas = new javax.swing.JTable();
        JBCancelar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBApagar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JTFNomeFerramenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Ferramentas");

        jLabel3.setText("Preço:");

        JTableFerramentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Marca", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableFerramentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableFerramentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableFerramentas);

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome da Ferramenta:");

        jLabel2.setText("Marca:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JBCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(JBAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(JBApagar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JTFMarca, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNomeFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(JTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(JTFPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBAlterar)
                    .addComponent(JBApagar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableFerramentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableFerramentasMouseClicked

        if (this.JTableFerramentas.getSelectedRow() != -1) {
            String nome = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 1).toString();
            String marca = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 2).toString();
            String preco = this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 3).toString();

            this.JTFNomeFerramenta.setText(nome);
            this.JTFMarca.setText(marca);
            this.JTFPreco.setText(preco);
        }
    }//GEN-LAST:event_JTableFerramentasMouseClicked

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        //Libera todos os recurso da interface gráfica
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        try {
            // recebendo e validando dados da interface gráfica.
            int id = 0;
            String nome = "";
            String marca = "";
            double preco = 0.0;

            if (this.JTFNomeFerramenta.getText().length() < 2) {
                throw new Mensagem("Nome da ferramenta deve conter ao menos 2 caracteres!! ");
            } else {
                nome = this.JTFNomeFerramenta.getText();
            }

            if (this.JTFMarca.getText().length() < 1) {
                throw new Mensagem("Marca deve ter ao menos 1 caractere!! ");
            } else {
                marca = this.JTFMarca.getText();
            }

            if (this.JTFPreco.getText().length() <= 0) {
                throw new Mensagem("O valor da ferramenta de ser numérico e ser maior do que 0!! ");
            } else {
                preco = Double.parseDouble(this.JTFPreco.getText());
            }

            if (this.JTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Selecione alguma ferramenta para alterar!! ");
            } else {
                id = Integer.parseInt(this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 0).toString());
            }

            // envia os dados para a Ferramenta processar
            if (this.objetoferramenta.atualizaFerramentaBD(id, nome, marca, preco)) {
                // limpa os campos
                this.JTFNomeFerramenta.setText("");
                this.JTFMarca.setText("");
                this.JTFPreco.setText("");
                JOptionPane.showMessageDialog(null, "Ferramenta Alterada com Sucesso!");

            }
            // Exibe no console a Ferramenta cadastrada.
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número válido.");
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.JTableFerramentas.getSelectedRow() == -1) {
                throw new Mensagem("Selecione uma ferramenta para APAGAR!!!");
            } else {
                id = Integer.parseInt(this.JTableFerramentas.getValueAt(this.JTableFerramentas.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta ferramenta ?");

            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para o Aluno processar
                if (this.objetoferramenta.deletaFerramentaBD(id)) {
                    // limpa os campos
                    this.JTFNomeFerramenta.setText("");
                    this.JTFMarca.setText("");
                    this.JTFPreco.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Ferramenta apagada com sucesso!");
                }
            }
            // atualiza a tabela.
            System.out.println(this.objetoferramenta.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }


    }//GEN-LAST:event_JBApagarActionPerformed
    public void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) this.JTableFerramentas.getModel();
        modelo.setNumRows(0); // Limpa a tabela
        ArrayList<Ferramenta> minhaLista = objetoferramenta.getMinhaLista();  // Obtém a lista de ferramentas
        for (Ferramenta a : minhaLista) {
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(), // Usando o método correto para pegar o nome da ferramenta
                a.getMarca(),
                a.getPreco(),});
        }
    }

    
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
        java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FrmGerenciarFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FrmGerenciarFerramenta().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFMarca;
    private javax.swing.JTextField JTFNomeFerramenta;
    private javax.swing.JTextField JTFPreco;
    private javax.swing.JTable JTableFerramentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
