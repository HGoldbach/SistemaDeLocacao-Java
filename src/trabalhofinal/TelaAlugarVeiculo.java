/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalhofinal;

import trabalhofinal.Veiculo.Veiculo;
import trabalhofinal.Tabelas.VeiculoAlugarTableModel;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import trabalhofinal.Cliente.Cliente;

/**
 *
 * @author goldb
 */
public class TelaAlugarVeiculo extends javax.swing.JFrame {
    private TelaInicial locadora;
    private VeiculoAlugarTableModel vModeloTabela = new VeiculoAlugarTableModel();
    
    /**
     * Creates new form TelaAlugarVeiculo
     */
    public TelaAlugarVeiculo() {
        initComponents();
        this.setLocationRelativeTo(null);
        formataData();
        
        tipoCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "- Tipo -", "Automóvel", "Motocicleta", "Van"
        }));
        
        categoriaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
            "- Categoria -", "POPULAR", "INTERMEDIARIO", "LUXO"
        }));
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
        jLabel2 = new javax.swing.JLabel();
        tBusca = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tSNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabela = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tipoCombo = new javax.swing.JComboBox<>();
        marcaCombo = new javax.swing.JComboBox<>();
        categoriaCombo = new javax.swing.JComboBox<>();
        bFiltrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tDiasLocacao = new javax.swing.JTextField();
        bLocar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tDataLocacao = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Alugar Veiculo");

        jLabel2.setText("Cliente CPF:");

        tBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBuscaActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bBuscarMouseClicked(evt);
            }
        });

        jLabel3.setText("Nome");

        tNome.setEditable(false);

        jLabel4.setText("Sobrenome");

        tSNome.setEditable(false);

        tTabela.setModel(vModeloTabela);
        jScrollPane1.setViewportView(tTabela);

        jLabel7.setText("Buscar Veiculo");

        tipoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Tipo -" }));
        tipoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoComboActionPerformed(evt);
            }
        });

        marcaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Marca -" }));
        marcaCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                marcaComboMousePressed(evt);
            }
        });

        categoriaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Categoria -" }));

        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });

        jLabel5.setText("Dias de Locação");

        bLocar.setText("Locar");
        bLocar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bLocarMouseClicked(evt);
            }
        });

        jLabel6.setText("Data da Locação");

        tDataLocacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDataLocacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tBusca)
                        .addGap(18, 18, 18)
                        .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tSNome, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(marcaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tDiasLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bLocar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tSNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marcaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoriaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bFiltrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tDiasLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLocar)
                    .addComponent(jLabel6)
                    .addComponent(tDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tBuscaActionPerformed

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed
        vModeloTabela.limpaTabela();
        List<Veiculo> list = locadora.getVeiculos();
        String tipo = tipoCombo.getSelectedItem().toString();
        String marca = marcaCombo.getSelectedItem().toString();
        String categoria = categoriaCombo.getSelectedItem().toString();
        if (tipo.equals("- Tipo -") || marca.equals("- Marca -") || categoria.equals("- Categoria -")) {
            JOptionPane.showMessageDialog(this, "Selecione as opções para realizar a filtragem dos veiculos!");
        } else {
            vModeloTabela.setListaVeiculos(list, tipo, marca, categoria);
        }
    }//GEN-LAST:event_bFiltrarActionPerformed

    private void bBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bBuscarMouseClicked
        tNome.setText("");
        tSNome.setText("");
        List<Cliente> lista = locadora.getClientes();
        String textoBusca = tBusca.getText();
        for (Cliente l: lista) {
            if (l.getCPF().equals(textoBusca) || l.getNome().equals(textoBusca)) {
                tNome.setText(l.getNome());
                tSNome.setText(l.getSobreNome());
                
            }
        }
        if (tNome.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado!");
            tBusca.setText("");
        }
        
    }//GEN-LAST:event_bBuscarMouseClicked

    private void tipoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoComboActionPerformed

    private void marcaComboMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcaComboMousePressed
        switch(tipoCombo.getSelectedItem().toString()) {
            case "Automóvel":
                marcaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                    "- Marca -", "VW", "GM", "Fiat", "Mercedes",
                }));
                break;
            case "Motocicleta":
                marcaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                    "- Marca -", "Honda", "Yamaha"
                }));
                break;
            case "Van":
                marcaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                    "- Marca -", "VW", "Mercedes"
                }));
                break;    
        }
    }//GEN-LAST:event_marcaComboMousePressed

    private void tDataLocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDataLocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tDataLocacaoActionPerformed

    private void bLocarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLocarMouseClicked
        List<Cliente> listaCliente = this.locadora.getClientes();
        List<Veiculo> listaVeiculos = this.locadora.getVeiculos();
        int row;
        String placa = "";
        try {
            row = tTabela.getSelectedRow();
            placa = (tTabela.getModel().getValueAt(row, 0)).toString();
        }
        catch (Exception err) {
            
        }
        

        Cliente cliente = null;
        Veiculo veiculo = null;
        for (Cliente c : listaCliente) {
            if (c.getCPF().equals(tBusca.getText())) {
                cliente = c;
            }
        }
        for (Veiculo v : listaVeiculos) {
            if (v.getPlaca().equals(placa)) {
                veiculo = v;
            }
        }
        
       
        if (cliente != null && veiculo != null && !tDiasLocacao.getText().equals("") && !tDataLocacao.getText().equals("  /  /    ")) {
            int dias = Integer.parseInt(tDiasLocacao.getText());
            String dataLocacao = tDataLocacao.getText();
            String[] dLocacao = dataLocacao.split("/");
            Calendar calendar = Calendar.getInstance();
            if (Integer.parseInt(dLocacao[0]) < 1 || Integer.parseInt(dLocacao[0]) > 31) {
                JOptionPane.showMessageDialog(this, "Dia inserido não existe!");
            } else if ( Integer.parseInt(dLocacao[1]) < 1 || Integer.parseInt(dLocacao[1]) > 12 ) {
                JOptionPane.showMessageDialog(this, "Mês inserido não existe!");
            } else if ( Integer.parseInt(dLocacao[2]) < 1930 || Integer.parseInt(dLocacao[2]) > 2022 ) {
                JOptionPane.showMessageDialog(this, "O ano inserido está incorreto!");
            } else {
                calendar.set(Integer.parseInt(dLocacao[2]), Integer.parseInt(dLocacao[1]), Integer.parseInt(dLocacao[0]));
                veiculo.locar(dias, calendar, cliente);
                JOptionPane.showMessageDialog(this, "Veiculo Locado com Sucesso!");

                vModeloTabela.limpaTabela();
                tBusca.setText("");
                tNome.setText("");
                tSNome.setText("");
                tDiasLocacao.setText("");
                tDataLocacao.setText("");

                tipoCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                    "- Tipo -", "Automóvel", "Motocicleta", "Van"
                }));
                marcaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                     "- Marca -"
                }));
                categoriaCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                    "- Categoria -", "POPULAR", "INTERMEDIARIO", "LUXO"
                }));
            }
        } else if (cliente == null ){
            JOptionPane.showMessageDialog(this, "Não foi possível locar o veículo devido a nenhum cliente ter sido selecionado!");
        } else if (veiculo == null) {
            JOptionPane.showMessageDialog(this, "Não foi possível locar o veículo devido a nenhum veiculo ter sido selecionado!");
        } else {
            JOptionPane.showMessageDialog(this, "Não foi possível locar o veículo porque não foi informado a data ou dias de locação!");
        }
        
        
    }//GEN-LAST:event_bLocarMouseClicked

    /**
     * @param args the command line arguments
     */
    
    public void init(TelaInicial locadora) {
        this.locadora = locadora;
        TelaAlugarVeiculo inicial = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                inicial.setVisible(true);
            }
        });
    }
    
    public List<Veiculo> getVeiculos() {
         return this.locadora.getVeiculos();
    }
    
    public void formataData() {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.install(tDataLocacao);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this,"Data inserida está incorreta");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bLocar;
    private javax.swing.JComboBox<String> categoriaCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> marcaCombo;
    private javax.swing.JTextField tBusca;
    private javax.swing.JFormattedTextField tDataLocacao;
    private javax.swing.JTextField tDiasLocacao;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextField tSNome;
    private javax.swing.JTable tTabela;
    private javax.swing.JComboBox<String> tipoCombo;
    // End of variables declaration//GEN-END:variables
}
