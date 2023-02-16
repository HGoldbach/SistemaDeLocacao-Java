/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package locadora.view.TelaVender;

import java.util.List;
import javax.swing.JOptionPane;
import locadora.controller.VeiculoController;
import locadora.model.Veiculo;

/**
 *
 * @author goldb
 */
public class TelaVenderVeiculoView extends javax.swing.JFrame {

    /**
     * Creates new form NewTelaVenderVeiculoView
     */
    public TelaVenderVeiculoView() {
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

        formularioTelaVenderVeiculoView = new locadora.view.TelaVender.FormularioTelaVenderVeiculoView();
        botoesTelaVenderVeiculoView = new locadora.view.TelaVender.BotoesTelaVenderVeiculoView();
        tabelaTelaVenderVeiculoView = new locadora.view.TelaVender.TabelaTelaVenderVeiculoView();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(200, 100, 150));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vender Veiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formularioTelaVenderVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botoesTelaVenderVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabelaTelaVenderVeiculoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoesTelaVenderVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formularioTelaVenderVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaTelaVenderVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initView() {
        formularioTelaVenderVeiculoView.setTelaView(this);
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }
    
    public void setController(VeiculoController controller) {
        this.botoesTelaVenderVeiculoView.setController(controller);
    }
    
    public String[] getVeiculoFiltro() {
        return this.formularioTelaVenderVeiculoView.getVeiculoFiltro();
    }
    
    public void limpaCampos() {
        this.formularioTelaVenderVeiculoView.limpaCampos();
    }
    
    public void setListaVeiculosTabela(List<Veiculo> veiculos) {
        this.tabelaTelaVenderVeiculoView.setListaVeiculosTabela(veiculos);
    }
    
    public Veiculo getVeiculoTabela() {
        return this.tabelaTelaVenderVeiculoView.getVeiculoTabela();
    }
    
    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public TabelaTelaVenderVeiculoView getTabelaView() {
        return tabelaTelaVenderVeiculoView;
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private locadora.view.TelaVender.BotoesTelaVenderVeiculoView botoesTelaVenderVeiculoView;
    private locadora.view.TelaVender.FormularioTelaVenderVeiculoView formularioTelaVenderVeiculoView;
    private javax.swing.JLabel jLabel1;
    private locadora.view.TelaVender.TabelaTelaVenderVeiculoView tabelaTelaVenderVeiculoView;
    // End of variables declaration//GEN-END:variables
}
