/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import locadora.model.Cliente;

/**
 *
 * @author goldb
 */
public class ClienteTableModel extends AbstractTableModel {

    private final String[] colunas = new String[]{ "Nome","Sobrenome","RG","CPF"};
    private List<Cliente> lista = new ArrayList();
    
    public ClienteTableModel() {};
    
    
    
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
            case 0: return "Nome";
            case 1: return "Sobrenome";
            case 2: return "RG";
            case 3: return "CPF";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getRG();
            case 3: return cliente.getCPF();
            default : return null;
        }
    }
    
    @Override
    public void setValueAt (Object value, int row, int col) {
        Cliente cliente = lista.get(row);
        switch(col) {
            case 0:
                cliente.setNome((String) value);
                break;
            case 1:
                cliente.setSobrenome((String) value);
                break;
            case 2:
                cliente.setRG((String) value);
                break;
            case 3:
                cliente.setCPF((String) value);
                break;
            default:
        }
        this.fireTableCellUpdated(row, col);
    }
    
    public void removeClientes(List<Cliente> listaParaExcluir) {
        listaParaExcluir.forEach((cliente) -> {
            removeCliente(cliente);
        });
    }
    
    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableCellUpdated(linha, linha);
        return result;
    }
    
    public void adicionaCliente(Cliente cliente) {
        this.lista.add(cliente);
        this.fireTableCellUpdated(lista.size()-1, lista.size()-1);
    }
    
    public void setListaClientes(List<Cliente> clientes) {
        this.lista = clientes;
        
        this.fireTableDataChanged();
    }
    
    public void limpaTabela() {
        int indice = lista.size()-1;
        if (indice < 0) {
            indice = 0;
        }
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);
    }
    
    public Cliente getCliente(int linha) {
        return lista.get(linha);
    }
    
    
}
