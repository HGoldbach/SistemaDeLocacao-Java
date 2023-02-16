/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model;

/**
 *
 * @author goldb
 */
public class Motocicleta extends Veiculo {
    private ModeloMotocicleta modelo;
    
    public Motocicleta(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valor, String placa, int ano, ModeloMotocicleta modelo){
        super(marca, estado, locacao, categoria, valor, placa, ano);
        this.modelo = modelo;
    }
    
    
    public ModeloMotocicleta getModelo() {
        return this.modelo;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        if (this.getCategoria().toString().equals("POPULAR")) {
            return 70.00;
        } else if (this.getCategoria().toString().equals("INTERMEDIARIO")) {
            return 200.00;
        } else {
            return 350.00;
        }
    }

    @Override
    public String getStringModelo() {
        return "" + this.modelo;
    }
    
}
