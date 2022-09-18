/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal.Veiculo;

/**
 *
 * @author goldb
 */
public class Van extends Veiculo {
    private ModeloVan modelo;
    
    public Van (Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valor, String placa, int ano, ModeloVan modelo) {
        super(marca, estado, locacao, categoria, valor, placa, ano);
        this.modelo = modelo;
    }
    
    public ModeloVan getModelo() {
        return this.modelo;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        if (this.getCategoria().toString().equals("POPULAR")) {
            return 200.00;
        } else if (this.getCategoria().toString().equals("INTERMEDIARIO")) {
            return 400.00;
        } else {
            return 600.00;
        }
    }

    @Override
    public String getStringModelo() {
        return "" + this.modelo;
    }
    
}
