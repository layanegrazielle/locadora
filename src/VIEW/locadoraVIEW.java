/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import DAO.LocadoraDAO;
import DTO.VeiculoDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class locadoraVIEW extends javax.swing.JFrame {
    int id_locadora;
    /**
     * Creates new form locadoraVIEW
     */
    public locadoraVIEW(int idLocadora) {
        initComponents();
        id_locadora = idLocadora;
        listarVeiculos();
    }
    public locadoraVIEW() {
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

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVeiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cbxFiltro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Marca", "Modelo", "Acessórios", "Categoria", "Ano", "Preço"
            }
        ));
        jScrollPane1.setViewportView(tabelaVeiculos);

        jLabel1.setText("Carros cadastrados");

        btnEditar.setText("Editar veículo");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir veículo");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar veículo");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Marca", "Modelo", "Acessórios", "Categorias", "Ano", "Preço" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });

        jLabel2.setText("Buscar de:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 103, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnEditar)
                .addGap(150, 150, 150)
                .addComponent(btnExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(288, 288, 288))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnAdicionar))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        cadastroVeiculoVIEW cadVeiculo = new cadastroVeiculoVIEW(id_locadora);
        cadVeiculo.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int setar = tabelaVeiculos.getSelectedRow();
        if(setar == - 1){
            JOptionPane.showMessageDialog(null, "Nenhum veículo selecionado");
        }else{
            editarVeiculoVIEW editar = new editarVeiculoVIEW(id_locadora);
            editar.carregarVeiculo((int) tabelaVeiculos.getModel().getValueAt(setar,0));
            editar.setVisible(true);
        
            dispose();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int setar = tabelaVeiculos.getSelectedRow();
        
        if(setar == - 1) {
            JOptionPane.showMessageDialog(null, "Nenhum veículo selecionado");
        }else{
            LocadoraDAO locadora = new LocadoraDAO();
            locadora.deletarVeiculo((int) tabelaVeiculos.getModel().getValueAt(setar, 0));
            
            listarVeiculos();
            JOptionPane.showMessageDialog(null, "Veìculo deletado!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtrarBusca();
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(locadoraVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(locadoraVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(locadoraVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(locadoraVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new locadoraVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaVeiculos;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

    public void listarVeiculos() {
         try {
           LocadoraDAO locadora = new LocadoraDAO();
           
           DefaultTableModel model = (DefaultTableModel) tabelaVeiculos.getModel();
           model.setNumRows(0);
           
           ArrayList<VeiculoDTO> lista = locadora.PesquisarVeiculo(id_locadora);
           
           for(int num = 0; num < lista.size(); num++) {
               model.addRow(new Object[] {
                   lista.get(num).getId(),
                   lista.get(num).getMarca(),
                   lista.get(num).getModelo(),
                   lista.get(num).getAcessorios(),
                   lista.get(num).getCategoria(),
                   lista.get(num).getAno(),
                   lista.get(num).getPreco()
               });
           }
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"listar veiculos" + e);
       }
   } 
    
   private void carregarCampo(){
       int setar = tabelaVeiculos.getSelectedRow();
       
       
   }
   
   private void filtrarBusca(){
       
       String filtroSelecionado[] = new String[7];
       String pesquisa = txtPesquisa.getText();

       filtroSelecionado[0] = "selecione";
       filtroSelecionado[1] = "marca";
       filtroSelecionado[2] = "modelo";
       filtroSelecionado[3] = "acessorios";
       filtroSelecionado[4] = "categoria";
       filtroSelecionado[5] = "ano";
       filtroSelecionado[6] = "preco";
       
       String coluna = filtroSelecionado[cbxFiltro.getSelectedIndex()];
       
       if(cbxFiltro.getSelectedIndex() == 0){
           listarVeiculos();
       }else{
           LocadoraDAO locadora = new LocadoraDAO();
           DefaultTableModel model = (DefaultTableModel)tabelaVeiculos.getModel();
           model.setNumRows(0);
           
           ArrayList<VeiculoDTO> lista = locadora.fitrarBuscaVeiculo(id_locadora,coluna,pesquisa);
          
           for(int num = 0; num < lista.size(); num++) {
               model.addRow(new Object[] {
                   lista.get(num).getId(),
                   lista.get(num).getMarca(),
                   lista.get(num).getModelo(),
                   lista.get(num).getAcessorios(),
                   lista.get(num).getCategoria(),
                   lista.get(num).getAno(),
                   lista.get(num).getPreco()
               });
       }
           JOptionPane.showMessageDialog(null, coluna);
    }

   }
}
