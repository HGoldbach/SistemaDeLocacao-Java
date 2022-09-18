/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalhofinal;

import trabalhofinal.Veiculo.Veiculo;
import trabalhofinal.Cliente.Cliente;
import java.util.List;

/**
 *
 * @author goldb
 */
public class TelaInicial extends javax.swing.JFrame {
    private Locadora locadora;
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cliente = new javax.swing.JMenu();
        mNovoVeiculo = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mDevolver = new javax.swing.JMenu();
        mVender = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("LOCADORA LPOO");

        cliente.setText("Clientes");
        cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteMouseClicked(evt);
            }
        });
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        jMenuBar1.add(cliente);

        mNovoVeiculo.setText("Novo Veiculo");
        mNovoVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mNovoVeiculoMouseClicked(evt);
            }
        });
        mNovoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNovoVeiculoActionPerformed(evt);
            }
        });
        jMenuBar1.add(mNovoVeiculo);

        jMenu3.setText("Alugar Veiculo");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        mDevolver.setText("Devolver Veiculo");
        mDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mDevolverMouseClicked(evt);
            }
        });
        jMenuBar1.add(mDevolver);

        mVender.setText("Vender Veiculo");
        mVender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mVenderMouseClicked(evt);
            }
        });
        jMenuBar1.add(mVender);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel1)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        
    }//GEN-LAST:event_clienteActionPerformed

    private void clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteMouseClicked
        TelaCliente tc = new TelaCliente();
        tc.init(this);
    }//GEN-LAST:event_clienteMouseClicked

    private void mNovoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNovoVeiculoActionPerformed

    }//GEN-LAST:event_mNovoVeiculoActionPerformed

    private void mNovoVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mNovoVeiculoMouseClicked
        TelaComprarVeiculo tcv = new TelaComprarVeiculo();
        tcv.init(this);
    }//GEN-LAST:event_mNovoVeiculoMouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        TelaAlugarVeiculo tav = new TelaAlugarVeiculo();
        tav.init(this);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void mDevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDevolverMouseClicked
        TelaDevolverVeiculo tdv = new TelaDevolverVeiculo();
        tdv.init(this);
    }//GEN-LAST:event_mDevolverMouseClicked

    private void mVenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mVenderMouseClicked
        TelaVenderVeiculo tvv = new TelaVenderVeiculo();
        tvv.init(this);
    }//GEN-LAST:event_mVenderMouseClicked

 
    public void initView(Locadora locadora) {
        this.locadora = locadora;
        TelaInicial inicial = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicial.setVisible(true);
            }
        });
    }
    
    void adicionaCliente(Cliente f) {
        this.locadora.adicionaCliente(f);
    }

    public List<Cliente> getClientes() {
        return this.locadora.getClientes();
    }

    void removeCliente(Cliente f) {
        this.locadora.removeCliente(f);
    }

    void adicionaVeiculo(Veiculo f) {
        this.locadora.adicionaVeiculo(f);
    }
    
    List<Veiculo> getVeiculos() {
        return this.locadora.getVeiculos();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu mDevolver;
    private javax.swing.JMenu mNovoVeiculo;
    private javax.swing.JMenu mVender;
    // End of variables declaration//GEN-END:variables

    
}
