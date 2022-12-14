/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalhofinal;

import trabalhofinal.Veiculo.Veiculo;
import trabalhofinal.Tabelas.VeiculoDevolverTableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author goldb
 */
public class TelaDevolverVeiculo extends javax.swing.JFrame {
    private TelaInicial locadora;
    VeiculoDevolverTableModel dvModeloTabela = new VeiculoDevolverTableModel();
    /**
     * Creates new form TelaDevolverVeiculo
     */
    public TelaDevolverVeiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabela = new javax.swing.JTable();
        bDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Devolver Veiculo");

        bListar.setText("Listar Veiculos Alugados");
        bListar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bListarMouseClicked(evt);
            }
        });

        tTabela.setModel(dvModeloTabela);
        jScrollPane1.setViewportView(tTabela);

        bDevolver.setText("Devolver Veiculo");
        bDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bDevolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bListar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(bListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bListarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bListarMouseClicked
        List<Veiculo> list = locadora.getVeiculos();
        List<Veiculo> listTabela = new ArrayList<Veiculo>();
        boolean locExiste = false;
        
        for (Veiculo v : list) {
            if (v.getLocacao() != null) {
                locExiste = true;
                listTabela.add(v);
            }
        }
        
        if (locExiste) {
            dvModeloTabela.setListaVeiculos(listTabela);
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum ve??culo est?? locado no momento!");
        }
        
    }//GEN-LAST:event_bListarMouseClicked

    private void bDevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bDevolverMouseClicked
        List<Veiculo> listaVeiculos = this.locadora.getVeiculos();
        int row;
        String placa = "";
        
        try {
            row = tTabela.getSelectedRow();
            placa = (tTabela.getModel().getValueAt(row, 1)).toString();
        }
        catch (Exception err) {
            JOptionPane.showMessageDialog(this, "Nenhum ve??culo foi selecionado");
        }
       
       
        Veiculo veiculo = null;
        for (Veiculo v : listaVeiculos) {
            if (v.getPlaca().equals(placa)) {
                veiculo = v;
            }
        }
        
        if (veiculo != null) {
            veiculo.devolver();
            JOptionPane.showMessageDialog(this, "Veiculo devolvido com Sucesso!");
            dvModeloTabela.limpaTabela();
        }
    }//GEN-LAST:event_bDevolverMouseClicked

    /**
     * @param args the command line arguments
     */
    public void init(TelaInicial locadora) {
        this.locadora = locadora;
        TelaDevolverVeiculo inicial = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicial.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDevolver;
    private javax.swing.JButton bListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTabela;
    // End of variables declaration//GEN-END:variables
}
