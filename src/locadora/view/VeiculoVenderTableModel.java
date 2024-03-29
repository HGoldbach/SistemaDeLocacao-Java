/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.view;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import locadora.model.Veiculo;


/**
 *
 * @author goldb
 */
public class VeiculoVenderTableModel extends AbstractTableModel {

    private final String[] colunas = new String[]{ "Placa","Marca","Modelo","Ano","Preço para Venda"};
    private List<Veiculo> lista = new ArrayList();
    
    public VeiculoVenderTableModel() {};
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }
    
    @Override
    public String getColumnName(int coluna) {
        switch(coluna) {
            case 0: return "Placa";
            case 1: return "Marca";
            case 2: return "Modelo";
            case 3: return "Ano";
            case 4: return "Preço para Venda";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = lista.get(rowIndex);
        String valorVenda = String.format("R$%.2f", veiculo.getValorParaVenda());
        switch(columnIndex) {
            case 0: return veiculo.getPlaca();
            case 1: return veiculo.getMarca();
            case 2: return veiculo.getStringModelo();
            case 3: return veiculo.getAno();
            case 4: return valorVenda;
            default : return null;
        }
    }
    
    public void setListaVeiculos(List<Veiculo> veiculos) {
        this.lista = veiculos;
        this.fireTableDataChanged();
    }
    
    public boolean removeVeiculo(Veiculo veiculo) {
        int linha = this.lista.indexOf(veiculo);
        boolean result = this.lista.remove(veiculo);
        this.fireTableCellUpdated(linha, linha);
        return result;
    }
    
    public void limpaTabela() {
        int indice = lista.size()-1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);
    }
    
    public Veiculo getVeiculo(int linha) {
        return lista.get(linha);
    }
    
}
