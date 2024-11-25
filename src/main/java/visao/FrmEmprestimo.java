/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;

/**
 *
 * @author LoLvSk
 */
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

        jButton3.setText("Emprestar");

        jLabel1.setText("Data de Empréstimo");

        jLabel2.setText("Data de Devolução");

        jLabel3.setText("Quantidade de Itens");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(JTFDataEmprestimo)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JTFQuantidadeItens, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JTFDataDevolucao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1)
                        .addGap(117, 117, 117)
                        .addComponent(jButton2)
                        .addGap(104, 104, 104)
                        .addComponent(jButton3)))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFDataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addComponent(JTFQuantidadeItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTableEmprestimoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableEmprestimoMouseClicked
        if (this.JTableEmprestimo.getSelectedRow() != -1) {
            String nome = this.JTableEmprestimo.getValueAt(this.JTableEmprestimo.getSelectedRow(), 1).toString();
            String item = this.JTableEmprestimo.getValueAt(this.JTableEmprestimo.getSelectedRow(), 2).toString();
            String dataemprestimo = this.JTableEmprestimo.getValueAt(this.JTableEmprestimo.getSelectedRow(), 3).toString();
            String datadevolucao = this.JTableEmprestimo.getValueAt(this.JTableEmprestimo.getSelectedRow(), 4).toString();

            this.JTFDataEmprestimo.setText(dataemprestimo);
            this.JTFDataDevolucao.setText(datadevolucao);
            this.JTFQuantidadeItens.setText(item);
        }
    }//GEN-LAST:event_JTableEmprestimoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTFDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFDataDevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTFDataDevolucaoActionPerformed

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) JTableEmprestimo.getModel();
        modelo.setRowCount(0); // Limpa a tabela antes de carregar

        // Obtenha a lista de amigos
        List<Amigo> minhaLista = objetoAmigo.getMinhaLista();

        // Verifique se a lista não é nula
        if (minhaLista != null) {
            for (Amigo amigo : minhaLista) {
                modelo.addRow(new Object[]{amigo.getId(), amigo.getNome(), amigo.getItem()});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum amigo encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
