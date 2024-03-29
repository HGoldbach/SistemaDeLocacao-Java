/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package locadora.view.TelaDevolver;

import java.util.List;
import javax.swing.JOptionPane;
import locadora.controller.VeiculoController;
import locadora.model.Veiculo;

/**
 *
 * @author goldb
 */
public class TelaDevolverVeiculoView extends javax.swing.JFrame {

    /**
     * Creates new form NewTelaDevolverVeiculoView
     */
    public TelaDevolverVeiculoView() {
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

        botoesTelaDevolverVeiculoView = new locadora.view.TelaDevolver.BotoesTelaDevolverVeiculoView();
        tabelaTelaDevolverVeiculoView = new locadora.view.TelaDevolver.TabelaTelaDevolverVeiculoView();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Devolver Veiculo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botoesTelaDevolverVeiculoView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabelaTelaDevolverVeiculoView, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(botoesTelaDevolverVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabelaTelaDevolverVeiculoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void initView() {
        java.awt.EventQueue.invokeLater(() -> this.setVisible(true));
    }
    
    public void setController(VeiculoController controller) {
        this.botoesTelaDevolverVeiculoView.setController(controller);
    }
    
    public void setListaVeiculosTabela(List<Veiculo> lista) {
        this.tabelaTelaDevolverVeiculoView.setListaVeiculosTabela(lista);
    }
    
    public Veiculo getVeiculoTabela() {
        return this.tabelaTelaDevolverVeiculoView.getVeiculoTabela();
    }
    
    public void limpaLista() {
        this.tabelaTelaDevolverVeiculoView.limpaLista();
    }
    
    public void apresentaInfo(String info) {
        JOptionPane.showMessageDialog(null, info + "\n", "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    public void apresentaErro(String erro) {
        JOptionPane.showMessageDialog(null, erro + "\n", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private locadora.view.TelaDevolver.BotoesTelaDevolverVeiculoView botoesTelaDevolverVeiculoView;
    private javax.swing.JLabel jLabel1;
    private locadora.view.TelaDevolver.TabelaTelaDevolverVeiculoView tabelaTelaDevolverVeiculoView;
    // End of variables declaration//GEN-END:variables
}
