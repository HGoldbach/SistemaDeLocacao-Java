/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package locadora.view.TelaAlugar;

import java.util.List;
import javax.swing.JOptionPane;
import locadora.controller.VeiculoController;
import locadora.model.Cliente;
import locadora.model.Veiculo;

/**
 *
 * @author goldb
 */
public class TelaAlugarVeiculoView extends javax.swing.JFrame {

    /**
     * Creates new form NewTelaAlugarVeiculoView
     */
    public TelaAlugarVeiculoView() {
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

        botoesTelaAlugarVeiculoView = new locadora.view.TelaAlugar.BotoesTelaAlugarVeiculoView();
        tabelaTelaAlugarVeiculoView = new locadora.view.TelaAlugar.TabelaTelaAlugarVeiculoView();
        formularioTelaAlugarVeiculoView = new locadora.view.TelaAlugar.FormularioTelaAlugarVeiculoView();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alugar Veiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabelaTelaAlugarVeiculoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(formularioTelaAlugarVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botoesTelaAlugarVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formularioTelaAlugarVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botoesTelaAlugarVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaTelaAlugarVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initView() {
        formularioTelaAlugarVeiculoView.setTelaView(this);
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }

    public void setController(VeiculoController controller) {
        this.botoesTelaAlugarVeiculoView.setController(controller);
    }
    
    public String getClienteCPF() {
        return this.formularioTelaAlugarVeiculoView.getClienteCPF();
    }
    
    public void apresentaCliente(Cliente c) {
        this.formularioTelaAlugarVeiculoView.apresentaCliente(c);
    }
    
    public String[] getVeiculoFiltro() {
        return this.formularioTelaAlugarVeiculoView.getVeiculoFiltro();
    }
    
    public String getDataLocacao() {
        return this.formularioTelaAlugarVeiculoView.getDataLocacao();
    }

    public String getDiasLocacao() {
        return this.formularioTelaAlugarVeiculoView.getDiasLocacao();
    }

    public void formataData() {
        this.formularioTelaAlugarVeiculoView.formataData();
    }

    public void limpaCampos() {
        this.formularioTelaAlugarVeiculoView.limpaCampos();
    }

    public void setListaVeiculosTabela(List<Veiculo> veiculos) {
        this.tabelaTelaAlugarVeiculoView.setListaVeiculosTabela(veiculos);
    }

    public Veiculo getVeiculoTabela() {
        return this.tabelaTelaAlugarVeiculoView.getVeiculoTabela();
    }
    
    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public TabelaTelaAlugarVeiculoView getTabelaView() {
        return tabelaTelaAlugarVeiculoView;
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private locadora.view.TelaAlugar.BotoesTelaAlugarVeiculoView botoesTelaAlugarVeiculoView;
    private locadora.view.TelaAlugar.FormularioTelaAlugarVeiculoView formularioTelaAlugarVeiculoView;
    private javax.swing.JLabel jLabel1;
    private locadora.view.TelaAlugar.TabelaTelaAlugarVeiculoView tabelaTelaAlugarVeiculoView;
    // End of variables declaration//GEN-END:variables
}
