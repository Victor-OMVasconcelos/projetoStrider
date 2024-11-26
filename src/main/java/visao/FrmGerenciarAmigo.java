package visao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amigo;

/**
 * Classe responsável por gerenciar a interface gráfica para operações com amigos.
 * Inclui funcionalidades de cadastro, alteração, exclusão e exibição de amigos.
 *
 */
public class FrmGerenciarAmigo extends javax.swing.JFrame {

    private Amigo objetoAmigo; // Controlador para operações relacionadas ao amigo.

    /**
     * Construtor da classe. Inicializa os componentes e carrega a tabela de amigos.
     */
    public FrmGerenciarAmigo() {
        initComponents();
        this.objetoAmigo = new Amigo(); // carrega objeto de Amigo
        this.carregaTabela();
    }

    /**
     * Método gerado automaticamente para inicialização dos componentes da interface gráfica.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JTFTelefone = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JBAlterar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JBApagar = new javax.swing.JButton();
        JBCancelar = new javax.swing.JButton();
        JTFNomeAmigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableAmigos = new javax.swing.JTable();
        JTFQuantidadeItens = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciar Amigos");

        JTFTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTFTelefoneActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do Amigo:");

        JBAlterar.setText("Alterar");
        JBAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBAlterarActionPerformed(evt);
            }
        });

        jLabel2.setText("Telefone:");

        jLabel3.setText("Quantidade de Itens:");

        JBApagar.setText("Apagar");
        JBApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBApagarActionPerformed(evt);
            }
        });

        JBCancelar.setText("Cancelar");
        JBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCancelarActionPerformed(evt);
            }
        });

        JTableAmigos.setModel(new javax.swing.table.DefaultTableModel(
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
                "ID", "Nome", "Telefone", "Itens"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableAmigos);
        if (JTableAmigos.getColumnModel().getColumnCount() > 0) {
            JTableAmigos.getColumnModel().getColumn(3).setHeaderValue("Itens");
        }

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JTFQuantidadeItens, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                .addGap(189, 189, 189))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFNomeAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addComponent(JTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTFQuantidadeItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBCancelar)
                    .addComponent(JBAlterar)
                    .addComponent(JBApagar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBAlterarActionPerformed
        try {
            // Recebendo e validando dados da interface gráfica.
            int id = 0;
            String nome = "";
            String telefone = "";
            int item = 0;

            if (this.JTFNomeAmigo.getText().length() < 2) {
                throw new Exception("Nome do amigo deve conter ao menos 2 caracteres!");
            } else {
                nome = this.JTFNomeAmigo.getText();
            }

            if (this.JTFTelefone.getText().length() < 1) {
                throw new Exception("Telefone deve ter ao menos 1 caractere!");
            } else {
                telefone = this.JTFTelefone.getText();
            }

            if (this.JTFQuantidadeItens.getText().length() <= 0) {
                throw new Exception("Quantidade de itens deve ser numérica e maior que 0!");
            } else {
                item = Integer.parseInt(this.JTFQuantidadeItens.getText());
            }

            if (this.JTableAmigos.getSelectedRow() == -1) {
                throw new Exception("Selecione um amigo para alterar!");
            } else {
                id = Integer.parseInt(this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 0).toString());
            }

            // Envia os dados para a atualização do amigo
            if (this.objetoAmigo.atualizaAmigoBD(id, nome, telefone, item)) {
                // Limpa os campos
                this.JTFNomeAmigo.setText("");
                this.JTFTelefone.setText("");
                this.JTFQuantidadeItens.setText("");
                JOptionPane.showMessageDialog(null, "Amigo alterado com sucesso!");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // Atualiza a tabela.
            carregaTabela();
        }
    }//GEN-LAST:event_JBAlterarActionPerformed

    private void JBApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBApagarActionPerformed
        try {
            // validando dados da interface gráfica.
            int id = 0;
            if (this.JTableAmigos.getSelectedRow() == -1) {
                throw new Mensagem("Selecione uma ferramenta para APAGAR!!!");
            } else {
                id = Integer.parseInt(this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 0).toString());
            }

            // retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int respostaUsuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar esta ferramenta ?");

            if (respostaUsuario == 0) {// clicou em SIM
                // envia os dados para o Amigo processar, Amigo não possui métodos da BD ainda
                if (this.objetoAmigo.deletaAmigoBD(id)) {
                    // limpa os campos
                    this.JTFNomeAmigo.setText("");
                    this.JTFTelefone.setText("");
                    this.JTFQuantidadeItens.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Amigo apagado com sucesso!");
                }
            }
            // atualiza a tabela.
            System.out.println(this.objetoAmigo.getMinhaLista().toString());
        } catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        } finally {
            // atualiza a tabela.
            carregaTabela();
        }

    }//GEN-LAST:event_JBApagarActionPerformed

    private void JBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCancelarActionPerformed
        //Libera todos os recurso da interface gráfica
        this.dispose();
    }//GEN-LAST:event_JBCancelarActionPerformed

    private void JTableAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableAmigosMouseClicked
        if (this.JTableAmigos.getSelectedRow() != -1) {
            String nome = this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 1).toString();
            String telefone = this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 2).toString();
            String item = this.JTableAmigos.getValueAt(this.JTableAmigos.getSelectedRow(), 3).toString();

            this.JTFNomeAmigo.setText(nome);
            this.JTFTelefone.setText(telefone);
            this.JTFQuantidadeItens.setText(item);
        }
    }//GEN-LAST:event_JTableAmigosMouseClicked

    private void JTFTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTFTelefoneActionPerformed
        this.dispose();
    }//GEN-LAST:event_JTFTelefoneActionPerformed

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) JTableAmigos.getModel();
        modelo.setRowCount(0); // Limpa a tabela antes de carregar

        // Obtenha a lista de amigos
        List<Amigo> minhaLista = objetoAmigo.getMinhaLista();

        // Verifique se a lista não é nula
        if (minhaLista != null) {
            for (Amigo amigo : minhaLista) {
                modelo.addRow(new Object[]{amigo.getId(), amigo.getNome(), amigo.getTelefone(), amigo.getItem()});
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum amigo encontrado.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FrmGerenciarAmigo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBAlterar;
    private javax.swing.JButton JBApagar;
    private javax.swing.JButton JBCancelar;
    private javax.swing.JTextField JTFNomeAmigo;
    private javax.swing.JTextField JTFQuantidadeItens;
    private javax.swing.JTextField JTFTelefone;
    private javax.swing.JTable JTableAmigos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
