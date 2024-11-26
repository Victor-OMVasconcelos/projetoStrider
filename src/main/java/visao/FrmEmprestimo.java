package visao;

import dao.ConexaoBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
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
        this.configurarData(JTFDataDevolucao);
        this.configurarData(JTFDataEmprestimo);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableEmprestimo = new javax.swing.JTable();
        JBCancelar = new javax.swing.JButton();
        JBAlterar = new javax.swing.JButton();
        JBEmprestar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableRelatorio = new javax.swing.JTable();
        JBDeletar = new javax.swing.JButton();
        JBFechar = new javax.swing.JButton();
        JTFDataEmprestimo = new javax.swing.JFormattedTextField();
        JTFDataDevolucao = new javax.swing.JFormattedTextField();

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Empréstimos");

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

        JBEmprestar.setText("Emprestar");
        JBEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBEmprestarActionPerformed(evt);
            }
        });

        jLabel1.setText("Data de Empréstimo");

        jLabel2.setText("Data de Devolução");

        JTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Itens", "Data Emprestimo", "Data Devolução"
            }
        ));
        JTableRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableRelatorioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableRelatorio);
        if (JTableRelatorio.getColumnModel().getColumnCount() > 0) {
            JTableRelatorio.getColumnModel().getColumn(0).setMinWidth(100);
            JTableRelatorio.getColumnModel().getColumn(0).setMaxWidth(200);
        }

        JBDeletar.setText("Deletar");
        JBDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBDeletarActionPerformed(evt);
            }
        });

        JBFechar.setText("Fechar");
        JBFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBFecharActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(JTFDataEmprestimo)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JTFDataDevolucao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(441, Short.MAX_VALUE)
                        .addComponent(JBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(JBEmprestar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBAlterar)
                    .addComponent(JBEmprestar)
                    .addComponent(JBDeletar)
                    .addComponent(JBFechar))
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

        }
    }

    private String getCellValue(int row, int column) {
        Object value = this.JTableEmprestimo.getValueAt(row, column);
        return value != null ? value.toString() : "";
    }//GEN-LAST:event_JTableEmprestimoMouseClicked

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        // Limpar os campos de texto
        JTFDataEmprestimo.setText("");
        JTFDataDevolucao.setText("");

        // Limpar as seleções das tabelas
        JTableEmprestimo.clearSelection();
        JTableRelatorio.clearSelection();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        try {
            // Obter a linha selecionada na tabela JTableRelatorio
            int linhaSelecionada = JTableRelatorio.getSelectedRow();

            // Verificar se uma linha foi selecionada
            if (linhaSelecionada == -1) {
                throw new Exception("Selecione um item para alterar.");
            }

            // Obter os dados da linha selecionada na JTableRelatorio
            DefaultTableModel modeloRelatorio = (DefaultTableModel) JTableRelatorio.getModel();
            String idAmigo = modeloRelatorio.getValueAt(linhaSelecionada, 0) != null ? modeloRelatorio.getValueAt(linhaSelecionada, 0).toString() : "";
            String nomeAmigo = modeloRelatorio.getValueAt(linhaSelecionada, 1) != null ? modeloRelatorio.getValueAt(linhaSelecionada, 1).toString() : "";
            String quantidadeItens = modeloRelatorio.getValueAt(linhaSelecionada, 2) != null ? modeloRelatorio.getValueAt(linhaSelecionada, 2).toString() : "";

            // Pegar os valores das novas datas de empréstimo e devolução
            String novaDataEmprestimo = JTFDataEmprestimo.getText().trim();
            String novaDataDevolucao = JTFDataDevolucao.getText().trim();

            // Verificar se os campos obrigatórios não estão vazios
            if (idAmigo.isEmpty() || nomeAmigo.isEmpty() || quantidadeItens.isEmpty() || novaDataEmprestimo.isEmpty() || novaDataDevolucao.isEmpty()) {
                throw new Exception("Todos os campos obrigatórios devem ser preenchidos.");
            }

            // Validar as novas datas
            String novaDataEmprestimoFormatada = converterData(novaDataEmprestimo);
            String novaDataDevolucaoFormatada = converterData(novaDataDevolucao);

            if (novaDataEmprestimoFormatada == null) {
                throw new Exception("Data de empréstimo inválida.");
            }

            if (novaDataDevolucaoFormatada == null) {
                throw new Exception("Data de devolução inválida.");
            }

            // Remover os listeners temporariamente para evitar loops recursivos
            DefaultTableModel modelo = (DefaultTableModel) JTableRelatorio.getModel();
            List<TableModelListener> listeners = new ArrayList<>(Arrays.asList(modelo.getTableModelListeners()));
            for (TableModelListener listener : listeners) {
                modelo.removeTableModelListener(listener);
            }

            // Atualizar os valores da JTableRelatorio (segundo modelo)
            modeloRelatorio.setValueAt(nomeAmigo, linhaSelecionada, 1);  // Atualiza o nome_amigo na tabela
            modeloRelatorio.setValueAt(quantidadeItens, linhaSelecionada, 2);  // Atualiza a quantidade_itens
            modeloRelatorio.setValueAt(novaDataEmprestimoFormatada, linhaSelecionada, 3);  // Atualiza a data_emprestimo
            modeloRelatorio.setValueAt(novaDataDevolucaoFormatada, linhaSelecionada, 4);  // Atualiza a data_devolucao

            // Re-adicionar os listeners após a alteração
            for (TableModelListener listener : listeners) {
                modelo.addTableModelListener(listener);
            }

            // Conectar ao banco de dados para atualizar os dados
            Connection connection = ConexaoBd.getConnection();
            String sql = "UPDATE relatorio SET nome_amigo = ?, quantidade_itens = ?, data_emprestimo = ?, data_devolucao = ? WHERE id_amigo = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Definir os parâmetros para o SQL
            stmt.setString(1, nomeAmigo);
            stmt.setString(2, quantidadeItens);
            stmt.setString(3, novaDataEmprestimoFormatada);
            stmt.setString(4, novaDataDevolucaoFormatada);
            stmt.setString(5, idAmigo);

            // Executar a atualização no banco de dados
            stmt.executeUpdate();

            // Fechar a conexão
            stmt.close();
            connection.close();

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Empréstimo alterado com sucesso na tabela e no banco de dados!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            // Exibir erro se algo falhar
            JOptionPane.showMessageDialog(this, "Erro ao alterar os dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBEmprestarActionPerformed
        try {
            // Obter os dados da linha selecionada na tabela de empréstimos
            int linhaSelecionada = JTableEmprestimo.getSelectedRow();

            // Verificar se uma linha foi selecionada
            if (linhaSelecionada == -1) {
                throw new Exception("Selecione um item para emprestar.");
            }

            // Obter os dados da linha selecionada
            DefaultTableModel modeloEmprestimo = (DefaultTableModel) JTableEmprestimo.getModel();
            String idAmigo = modeloEmprestimo.getValueAt(linhaSelecionada, 0) != null ? modeloEmprestimo.getValueAt(linhaSelecionada, 0).toString() : "";
            String nomeAmigo = modeloEmprestimo.getValueAt(linhaSelecionada, 1) != null ? modeloEmprestimo.getValueAt(linhaSelecionada, 1).toString() : "";
            String quantidadeItens = modeloEmprestimo.getValueAt(linhaSelecionada, 2) != null ? modeloEmprestimo.getValueAt(linhaSelecionada, 2).toString() : "";
            String dataEmprestimo = JTFDataEmprestimo.getText().trim();  // Pega a data de empréstimo
            String dataDevolucao = JTFDataDevolucao.getText().trim();    // Pega a data de devolução

            // Verificar se os campos essenciais não estão vazios
            if (idAmigo.isEmpty() || nomeAmigo.isEmpty() || quantidadeItens.isEmpty() || dataEmprestimo.isEmpty() || dataDevolucao.isEmpty()) {
                throw new Exception("Todos os campos obrigatórios devem ser preenchidos.");
            }

            // Validar a data de empréstimo e de devolução
            String dataEmprestimoFormatada = converterData(dataEmprestimo);
            String dataDevolucaoFormatada = converterData(dataDevolucao);

            if (dataEmprestimoFormatada == null) {
                throw new Exception("Data de empréstimo inválida.");
            }

            if (dataDevolucaoFormatada == null) {
                throw new Exception("Data de devolução inválida.");
            }

            // Atualizar o banco de dados com as informações do empréstimo
            Connection connection = ConexaoBd.getConnection();
            String sql = "INSERT INTO relatorio (id_amigo, nome_amigo, quantidade_itens, data_emprestimo, data_devolucao) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, idAmigo);
            stmt.setString(2, nomeAmigo);
            stmt.setString(3, quantidadeItens);
            stmt.setString(4, dataEmprestimoFormatada);
            stmt.setString(5, dataDevolucaoFormatada);

            // Executar a atualização no banco de dados
            stmt.executeUpdate();

            // Fechar a conexão
            stmt.close();
            connection.close();

            // Adicionar os dados na JTableRelatorio
            DefaultTableModel modeloRelatorio = (DefaultTableModel) JTableRelatorio.getModel();
            modeloRelatorio.addRow(new Object[]{idAmigo, nomeAmigo, quantidadeItens, dataEmprestimoFormatada, dataDevolucaoFormatada});

            // Remover o item da tabela de empréstimos
            DefaultTableModel modeloTabelaEmprestimo = (DefaultTableModel) JTableEmprestimo.getModel();
            modeloTabelaEmprestimo.removeRow(linhaSelecionada);

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Empréstimo registrado e item movido para o relatório com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            // Exibir erro se algo falhar
            JOptionPane.showMessageDialog(this, "Erro ao salvar no banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBEmprestarActionPerformed

    private void JTableRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableRelatorioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JTableRelatorioMouseClicked

    private void JBDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBDeletarActionPerformed
        // Deletar: Remover o empréstimo da JTableRelatorio
        int selectedRow = JTableRelatorio.getSelectedRow();

        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir o empréstimo?", "Confirmar Deletação", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Remover da JTableRelatorio
                DefaultTableModel modeloTabelaRelatorio = (DefaultTableModel) JTableRelatorio.getModel();
                modeloTabelaRelatorio.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Empréstimo excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um empréstimo para excluir.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_JBDeletarActionPerformed

    private void JBFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_JBFecharActionPerformed

    private void carregaTabela() {
        // Limpar a tabela JTableEmprestimo
        DefaultTableModel modeloTabela1 = (DefaultTableModel) JTableEmprestimo.getModel();
        modeloTabela1.setRowCount(0); // Limpa a tabela antes de carregar

        // Obtenha a lista de amigos e carregue na tabela JTableEmprestimo
        List<Amigo> minhaLista = objetoAmigo.getMinhaLista();

        // Verifique se a lista não é nula
        if (minhaLista != null) {
            for (Amigo amigo : minhaLista) {
                modeloTabela1.addRow(new Object[]{amigo.getId(), amigo.getNome(), amigo.getItem()});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum amigo encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }

        // Agora, vamos carregar os dados na tabela JTableRelatorio
        DefaultTableModel modeloTabela2 = (DefaultTableModel) JTableRelatorio.getModel();
        modeloTabela2.setRowCount(0); // Limpa a tabela antes de carregar

        try {
            // Conectar ao banco de dados e carregar os dados para JTableRelatorio
            Connection connection = ConexaoBd.getConnection();

            String sql = "SELECT id_amigo, nome_amigo, quantidade_itens, data_emprestimo, data_devolucao FROM relatorio";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Preencher a JTableRelatorio com os dados do banco
            while (rs.next()) {
                String idAmigo = rs.getString("id_amigo");
                String nomeAmigo = rs.getString("nome_amigo");
                String quantidadeItens = rs.getString("quantidade_itens");
                String dataEmprestimo = rs.getString("data_emprestimo");
                String dataDevolucao = rs.getString("data_devolucao");

                // Adicionar uma nova linha com os dados
                modeloTabela2.addRow(new Object[]{idAmigo, nomeAmigo, quantidadeItens, dataEmprestimo, dataDevolucao});
            }

            // Fechar a conexão
            rs.close();
            stmt.close();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar os dados da tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        // Impede a edição de células na Tabela 2 (caso deseje desabilitar a edição completamente)
        JTableRelatorio.setDefaultEditor(Object.class, null);  // Desabilita a edição para todas as células

        // Se você deseja permitir a edição e refletir as alterações na interface e no banco de dados, 
        // remova ou ajuste o código abaixo que impede a edição
        modeloTabela2.addTableModelListener(e -> {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                // Caso ocorra uma tentativa de atualização, você pode aqui atualizar os dados no banco de dados
                int row = e.getFirstRow();
                int column = e.getColumn();

                // Atualizar o banco de dados conforme a célula modificada
                String idAmigo = modeloTabela2.getValueAt(row, 0).toString();
                String novoValor = modeloTabela2.getValueAt(row, column).toString();

                // Exemplo: Atualizando dados no banco conforme a célula modificada
                try {
                    Connection connection = ConexaoBd.getConnection();
                    String updateSQL = "UPDATE relatorio SET ";

                    if (column == 1) { // Nome do amigo
                        updateSQL += "nome_amigo = ?";
                    } else if (column == 2) { // Quantidade de itens
                        updateSQL += "quantidade_itens = ?";
                    } else if (column == 3) { // Data de empréstimo
                        updateSQL += "data_emprestimo = ?";
                    } else if (column == 4) { // Data de devolução
                        updateSQL += "data_devolucao = ?";
                    }

                    updateSQL += " WHERE id_amigo = ?";

                    PreparedStatement stmt = connection.prepareStatement(updateSQL);
                    stmt.setString(1, novoValor);
                    stmt.setString(2, idAmigo);

                    // Executar o update no banco
                    stmt.executeUpdate();

                    // Fechar a conexão
                    stmt.close();
                    connection.close();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao atualizar o banco de dados: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
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
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JButton JBDeletar;
    private javax.swing.JButton JBEmprestar;
    private javax.swing.JButton JBFechar;
    private javax.swing.JFormattedTextField JTFDataDevolucao;
    private javax.swing.JFormattedTextField JTFDataEmprestimo;
    private javax.swing.JTable JTableEmprestimo;
    private javax.swing.JTable JTableRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private void configurarData(JFormattedTextField campoData) {
        try {
            // Cria a máscara para o formato DD/MM/AAAA
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');  // Define um caractere de placeholder

            // Aplica a máscara ao campo de data fornecido
            campoData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascaraData));
        } catch (java.text.ParseException ex) {
            // Em caso de erro, exibe uma mensagem
            JOptionPane.showMessageDialog(this, "Erro ao configurar a máscara de data.", "Erro", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();  // Exibe o stack trace para diagnóstico
        }
    }

    private String converterData(String data) {
        try {
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy"); // Formato que o usuário vai inserir
            Date dataFormatada = formatoEntrada.parse(data);  // Converte a string para o tipo Date
            SimpleDateFormat formatoBanco = new SimpleDateFormat("yyyy-MM-dd"); // Formato esperado pelo banco de dados
            return formatoBanco.format(dataFormatada); // Retorna a data no formato correto para o banco de dados
        } catch (Exception e) {
            System.out.println("Erro na conversão de data: " + e.getMessage());
            return null; // Se houver erro, retorna null
        }
    }

}
