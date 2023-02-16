/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package locadora.model;

/**
 *
 * @author goldb
 */
public class Automovel extends Veiculo {
    private ModeloAutomovel modelo;
        
    public Automovel (Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valor, String placa, int ano, ModeloAutomovel modelo) {
        super(marca, estado, locacao, categoria, valor, placa, ano);
        this.modelo = modelo;
       
    }
    
    public ModeloAutomovel getModelo() {
        return this.modelo;
        
    }

    @Override
    public double getValorDiariaLocacao() {
        if (this.getCategoria().toString().equals("POPULAR")) {
            return 100.00;
        } else if (this.getCategoria().toString().equals("INTERMEDIARIO")) {
            return 300.00;
        } else {
            return 450.00;
        }
    }

    @Override
    public String getStringModelo() {
        return "" + this.modelo;
    }
    
    

    
}
