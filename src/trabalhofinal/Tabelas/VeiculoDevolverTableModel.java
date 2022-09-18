/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal.Tabelas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import trabalhofinal.Veiculo.Veiculo;


/**
 *
 * @author goldb
 */
public class VeiculoDevolverTableModel extends AbstractTableModel {

    private final String[] colunas = new String[]{ "Nome do Cliente","Placa","Marca","Modelo","Ano","Data Locação","Preço Diária","Quantidade de Dias Locado","Valor Locação"};
    private List<Veiculo> lista = new ArrayList();
    
    
    public VeiculoDevolverTableModel() {};
    
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
            case 0: return "Nome do Cliente";
            case 1: return "Placa";
            case 2: return "Marca";
            case 3: return "Modelo";
            case 4: return "Ano";
            case 5: return "Data Locação";
            case 6: return "Preço Diária";
            case 7: return "Quantidade de Dias Locado";
            case 8: return "Valor Locação";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo veiculo = lista.get(rowIndex);
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        String diaria = String.format("R$%.2f", veiculo.getValorDiariaLocacao());
        String total = String.format("R$%.2f", veiculo.getLocacao().getValor());
        switch(columnIndex) {
            case 0: return veiculo.getLocacao().getCliente().getNome();
            case 1: return veiculo.getPlaca();
            case 2: return veiculo.getMarca();
            case 3: return veiculo.getStringModelo();
            case 4: return veiculo.getAno();
            case 5: return d.format(veiculo.getLocacao().getData().getTime());
            case 6: return diaria;
            case 7: return veiculo.getLocacao().getDias();
            case 8: return total;
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
    
}
