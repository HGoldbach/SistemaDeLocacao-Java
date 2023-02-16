/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package locadora.view.TelaCliente;

import locadora.controller.ClienteController;

/**
 *
 * @author goldb
 */
public class BotoesTelaClienteView extends javax.swing.JPanel {

    /**
     * Creates new form BotoesTelaClienteView
     */
    public BotoesTelaClienteView() {
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

        bIncluir = new javax.swing.JButton();
        bExcluir = new javax.swing.JButton();
        bAtualizar = new javax.swing.JButton();
        bListar = new javax.swing.JButton();

        bIncluir.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        bIncluir.setText("Incluir");
        bIncluir.setPreferredSize(new java.awt.Dimension(50, 22));

        bExcluir.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        bExcluir.setText("Excluir");
        bExcluir.setPreferredSize(new java.awt.Dimension(50, 22));

        bAtualizar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        bAtualizar.setText("Atualizar");
        bAtualizar.setPreferredSize(new java.awt.Dimension(50, 22));

        bListar.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        bListar.setText("Listar");
        bListar.setMaximumSize(new java.awt.Dimension(50, 22));
        bListar.setMinimumSize(new java.awt.Dimension(50, 22));
        bListar.setPreferredSize(new java.awt.Dimension(50, 22));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(bListar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(bListar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAtualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public void setController(ClienteController controller) {
      
        this.bIncluir.addActionListener(e -> controller.incluirCliente());
        this.bAtualizar.addActionListener(e -> controller.atualizarCliente());
        this.bExcluir.addActionListener(e -> controller.excluirCliente());
        this.bListar.addActionListener(e -> controller.listarCliente());

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtualizar;
    private javax.swing.JButton bExcluir;
    private javax.swing.JButton bIncluir;
    private javax.swing.JButton bListar;
    // End of variables declaration//GEN-END:variables
}
