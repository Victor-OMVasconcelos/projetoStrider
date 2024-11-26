package visao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;


public class FrmEmprestimo extends javax.swing.JFrame {

    private Amigo objetoAmigo; // Controlador para operações relacionadas ao amigo

    /**
     * Contrutor da classe. Inicializa os componentes e carrega a tabela de
     * amigos.
     */
    public FrmEmprestimo() {
        initComponents();
        this.objetoAmigo = new Amigo(); // carrega objeto de Amigo
        this.carregaTabela();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        JTFDataEmprestimo = new javax.swing.JTextField();
        JTFDataDevolucao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableEmprestimo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        JTFQuantidadeItens = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTFDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFDataDevolucaoActionPerformed(evt);
            }
        });

        JTableEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Itens", "Data Emprestimo", "Data Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableEmprestimo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableEmprestimoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableEmprestimo);
        if (JTableEmprestimo.getColumnModel().getColumnCount() > 0) {
            JTableEmprestimo.getColumnModel().getColumn(0).setMinWidth(100);
            JTableEmprestimo.getColumnModel().getColumn(0).setPreferredWidth(1);
            JTableEmprestimo.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Alterar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Emprestar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Data de Empréstimo");

        jLabel2.setText("Data de Devolução");

        jLabel3.setText("Quantidade de Itens");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Itens", "Data Emprestimo", "Data Devolução"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(100);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        jButton4.setText("Deletar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Fechar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JTFQuantidadeItens)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                            .addComponent(JTFDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(441, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFQuantidadeItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableEmprestimoMouseClicked
        if (this.JTableEmprestimo.getSelectedRow() != -1) {
            int selectedRow = this.JTableEmprestimo.getSelectedRow();

            String item = getCellValue(selectedRow, 2);
            String dataEmprestimo = getCellValue(selectedRow, 3);
            String dataDevolucao = getCellValue(selectedRow, 4);

            this.JTFDataEmprestimo.setText(dataEmprestimo);
            this.JTFDataDevolucao.setText(dataDevolucao);
            this.JTFQuantidadeItens.setText(item);
        }
    }

    private String getCellValue(int row, int column) {
        Object value = this.JTableEmprestimo.getValueAt(row, column);
        return value != null ? value.toString() : "";
    }//GEN-LAST:event_JTableEmprestimoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Cancelar: Limpar os campos de texto e desfazer a seleção da tabela
        JTFDataEmprestimo.setText("");
        JTFDataDevolucao.setText("");
        JTFQuantidadeItens.setText("");
        JTableEmprestimo.clearSelection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTFDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataDevolucaoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Alterar: Atualizar os dados do amigo selecionado
        int selectedRow = JTableEmprestimo.getSelectedRow();

        if (selectedRow != -1) {
            // Obter novos valores dos campos
            String dataEmprestimo = JTFDataEmprestimo.getText();
            String dataDevolucao = JTFDataDevolucao.getText();
            String quantidadeItens = JTFQuantidadeItens.getText();

            // Atualizar a tabela e o objeto correspondente
            DefaultTableModel modelo = (DefaultTableModel) JTableEmprestimo.getModel();
            modelo.setValueAt(quantidadeItens, selectedRow, 2);
            modelo.setValueAt(dataEmprestimo, selectedRow, 3);
            modelo.setValueAt(dataDevolucao, selectedRow, 4);

            JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!", "Alteração", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um registro para alterar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Emprestar: Transferir os dados do usuário da tabela 1 para a tabela 2
        int selectedRow = JTableEmprestimo.getSelectedRow();

        if (selectedRow != -1) {
            // Obter os dados da linha selecionada na tabela 1
            String id = getCellValue(selectedRow, 0);
            String nome = getCellValue(selectedRow, 1);
            String quantidadeItens = getCellValue(selectedRow, 2);
            String dataEmprestimo = JTFDataEmprestimo.getText();
            String dataDevolucao = JTFDataDevolucao.getText();

            // Verificar se todos os campos estão preenchidos corretamente
            if (!dataEmprestimo.isEmpty() && !dataDevolucao.isEmpty() && !quantidadeItens.isEmpty()) {
                // Transferir para a tabela 2 (jTable1)
                DefaultTableModel modeloTabela2 = (DefaultTableModel) jTable1.getModel();
                modeloTabela2.addRow(new Object[]{id, nome, quantidadeItens, dataEmprestimo, dataDevolucao});

                // Remover o registro da tabela 1
                DefaultTableModel modeloTabela1 = (DefaultTableModel) JTableEmprestimo.getModel();
                modeloTabela1.removeRow(selectedRow);

                JOptionPane.showMessageDialog(this, "Empréstimo registrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Limpar campos após transferência
                jButton1ActionPerformed(evt);
            } else {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos antes de emprestar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um amigo para emprestar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Deletar: Remover o amigo selecionado
        int selectedRow = JTableEmprestimo.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o empréstimo?", "Confirmar Deletação", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Remover da tabela
                DefaultTableModel modeloTabela1 = (DefaultTableModel) JTableEmprestimo.getModel();
                modeloTabela1.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Empréstimo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void carregaTabela() {
    DefaultTableModel modeloTabela1 = (DefaultTableModel) JTableEmprestimo.getModel();
    modeloTabela1.setRowCount(0); // Limpa a tabela antes de carregar

    // Obtenha a lista de amigos
    List<Amigo> minhaLista = objetoAmigo.getMinhaLista();

    // Verifique se a lista não é nula
    if (minhaLista != null) {
        for (Amigo amigo : minhaLista) {
            modeloTabela1.addRow(new Object[]{amigo.getId(), amigo.getNome(), amigo.getItem()});
        }
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum amigo encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    // Impede a edição de células na Tabela 2
    DefaultTableModel modeloTabela2 = (DefaultTableModel) jTable1.getModel();
    jTable1.setDefaultEditor(Object.class, null);  // Desabilita a edição para todas as células

    // Adicionando o TableModelListener
    modeloTabela2.addTableModelListener(e -> {
        if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
            // Caso ocorra uma tentativa de atualização
            int row = e.getFirstRow();
            int column = e.getColumn();

            // Restaura o valor original da célula após a tentativa de edição
            Object originalValue = modeloTabela2.getValueAt(row, column);
            modeloTabela2.setValueAt(originalValue, row, column);
        }
    });
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
        java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FrmEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new FrmEmprestimo().setVisible(true);
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTFDataDevolucao;
    private javax.swing.JTextField JTFDataEmprestimo;
    private javax.swing.JTextField JTFQuantidadeItens;
    private javax.swing.JTable JTableEmprestimo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
