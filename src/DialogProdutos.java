
import java.io.File;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class DialogProdutos extends javax.swing.JDialog {
    
    static Connection conexao;
    
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtNomeProduto.setText("");
        cbCategoria.setSelectedIndex(0);
        txtEstoque.setText("");
        txtPreco.setText("");
        txtNomeProduto.grabFocus();
    }
    
    private void mostrarDados() {
        int total = 0, totalEstoque = 0;
        double totalPreco = 0;
        
        try {
            PreparedStatement ps = conexao.prepareStatement("SELECT * FROM produtos");
            ResultSet rs = ps.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
            model.setRowCount(0); // Limpo o model
            while (rs.next()) {
                Object linha[] = {rs.getString("id"), rs.getString("descricao"),
                        rs.getString("categoria"), rs.getString("estoque"),
                        rs.getString("preco")};
                model.addRow(linha);
                total++; // Soma 1 nos itens
                totalEstoque += rs.getInt("estoque");
                totalPreco += rs.getDouble("preco");                
            }
            
            tblProdutos.setModel(model);
            
            lblTotalItens.setText("Itens: " + total);
            lblTotalEstoque.setText("Total Itens: " + totalEstoque);
            lblTotalEstoquePreco.setText("Total Estoque: " + totalPreco);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados");
        }
    }
    
    private boolean validarCampos() {
        if ( (txtNomeProduto.getText().length() > 0) &&
                (txtEstoque.getText().length() > 0) &&
                (txtPreco.getText().length() > 0) ) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Creates new form DialogProdutos
     */
    public DialogProdutos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCadastroProdutos = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        lblEstoque = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblTotalItens = new javax.swing.JLabel();
        lblTotalEstoque = new javax.swing.JLabel();
        lblTotalEstoquePreco = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCadastroProdutos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCadastroProdutos.setText("Cadastro de Produtos");
        getContentPane().add(lblCadastroProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblCodigo.setText("Código:");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, -1));

        lblNome.setText("Nome do Produto:");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));
        getContentPane().add(txtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 280, -1));

        lblCategoria.setText("Categoria:");
        getContentPane().add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alimentos", "Limpeza", "Higiene", "Padaria", "Açougue", "Bebidas" }));
        getContentPane().add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 180, -1));

        lblEstoque.setText("Estoque:");
        getContentPane().add(lblEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(txtEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, -1));

        lblPreco.setText("Preço:");
        getContentPane().add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, -1));
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 180, -1));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Categoria", "Estoque", "Preço"
            }
        ));
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        tblProdutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProdutosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 470, 120));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-new-window-22.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 120, -1));

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-save-22.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 120, -1));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-trash-can-22.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 120, -1));

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-print-22.png"))); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 120, -1));

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-close-window-22.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 120, -1));

        lblTotalItens.setText("0");
        getContentPane().add(lblTotalItens, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        lblTotalEstoque.setText("0");
        getContentPane().add(lblTotalEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        lblTotalEstoquePreco.setText("0");
        getContentPane().add(lblTotalEstoquePreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, -1, -1));

        setSize(new java.awt.Dimension(650, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        txtNomeProduto.grabFocus();
        
        File dados = new File("dados.db"); // Banco de Dados Sqlite
        if (dados.exists()) {
            try {
                conexao = DriverManager.getConnection("jdbc:sqlite:dados.db");   
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Arquivo de Dados não encontrado");
            dispose();
        }        
        
        mostrarDados();
    }//GEN-LAST:event_formWindowOpened

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        try {
            // TODO add your handling code here:
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        
        if (validarCampos())  { // ValidarCampos() == true
            PreparedStatement ps;
            try {
                if (txtCodigo.getText().length() == 0) {
                    // Inserindo
                    ps = conexao.prepareStatement(
                            "INSERT INTO produtos (descricao, categoria, estoque, preco) VALUES (?, ?, ?, ?)");
                    ps.setString(1, txtNomeProduto.getText());
                    ps.setInt(2, cbCategoria.getSelectedIndex());
                    ps.setString(3, txtEstoque.getText());
                    ps.setDouble(4, Double.parseDouble(txtPreco.getText()));
                    ps.execute();
                    ps.close();  
                } else {
                    // Alterando
                    ps = conexao.prepareStatement(
                            "UPDATE produtos SET descricao=?, categoria=?, estoque=?, preco=? WHERE id=?");
                    ps.setString(1, txtNomeProduto.getText());
                    ps.setInt(2, cbCategoria.getSelectedIndex());
                    ps.setInt(3, Integer.parseInt(txtEstoque.getText()));
                    ps.setDouble(4, Double.parseDouble(txtPreco.getText()));
                    ps.setString(5, txtCodigo.getText());
                    ps.execute();
                    ps.close();                
                }

                limparCampos();
                mostrarDados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o produto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro na validação dos campos.");
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
        try {
            tblProdutos.print();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao imprimir.");
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        // TODO add your handling code here:
        int linha = tblProdutos.getSelectedRow();
        if (linha >= 0) {
            txtCodigo.setText(tblProdutos.getValueAt(linha, 0).toString());
            txtNomeProduto.setText(tblProdutos.getValueAt(linha, 1).toString());
            cbCategoria.setSelectedIndex(Integer.parseInt(tblProdutos.getValueAt(linha, 2).toString()));
            txtEstoque.setText(tblProdutos.getValueAt(linha, 3).toString());
            txtPreco.setText(tblProdutos.getValueAt(linha, 4).toString());
            //txtNomeProduto.grabFocus();
        };
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void tblProdutosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProdutosKeyReleased
        // TODO add your handling code here:
        tblProdutosMouseClicked(null);
    }//GEN-LAST:event_tblProdutosKeyReleased

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().length() > 0) {
            try {
                PreparedStatement ps = conexao.prepareStatement("DELETE FROM produtos WHERE id=?");
                ps.setString(1, txtCodigo.getText());
                ps.execute();
                ps.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir.");
            }
            limparCampos();
            mostrarDados();
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um item para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCadastroProdutos;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTotalEstoque;
    private javax.swing.JLabel lblTotalEstoquePreco;
    private javax.swing.JLabel lblTotalItens;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}