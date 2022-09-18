/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal;

import trabalhofinal.Veiculo.Veiculo;
import trabalhofinal.Cliente.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author goldb
 */
public class Locadora {
    private List<Cliente>clientes = new ArrayList<Cliente>();  
    private List<Veiculo>veiculos = new ArrayList<Veiculo>();
    
    TelaInicial inicial = new TelaInicial();
    
    public static void main(String[] args) {
        Locadora locadora = new Locadora(); 
        locadora.init();
        
    }
    
    public void init() {
        inicial.initView(this);
    }

    public void adicionaCliente(Cliente f) {
        clientes.add(f);
    }
    
    public void removeCliente(Cliente f) {
        clientes.remove(f);
    }
    
    public List<Cliente> getClientes() {
        return this.clientes;
    }
    
    public void adicionaVeiculo(Veiculo f) {
        veiculos.add(f);
    }
    
    public void removeVeiculo(Veiculo f) {
        veiculos.remove(f);
    }
    
    public List<Veiculo> getVeiculos() {
        return this.veiculos;
    }
    
}
