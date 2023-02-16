/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package locadora.model;

import java.util.Calendar;

/**
 *
 * @author goldb
 */
public abstract class Veiculo implements VeiculoI {
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private Locacao locacao;
    private double valorDeCompra;
    private String placa;
    private int ano;
    
    
    public Veiculo(Marca marca, Estado estado, Locacao locacao, Categoria categoria, double valor, String placa, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.locacao = locacao;
        this.categoria = categoria;
        this.valorDeCompra = valor;
        this.placa = placa;
        this.ano = ano;
    }
    
    
    public void locar(int dias, Calendar data, Cliente cliente) {
        double valor = this.getValorDiariaLocacao()*dias;
        this.locacao = new Locacao(dias, valor, data, cliente);
        this.estado = Estado.LOCADO;
    };
    
    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
    };
    
    @Override
    public void devolver() {
        this.locacao = null;
        this.estado = Estado.DISPONIVEL;
    };
    
    @Override
    public Estado getEstado() {
        return this.estado;
    };
    
    @Override
    public Marca getMarca() {
        return this.marca;
    };
    
    @Override
    public Categoria getCategoria() {
        return this.categoria;
    };
    
    @Override
    public Locacao getLocacao() {
        return this.locacao;
    };
    
    @Override
    public String getPlaca() {
        return this.placa;
    };
    
    @Override
    public int getAno() {
        return this.ano;
    };
    
    @Override
    public double getValorParaVenda() {
        double valorVenda = this.valorDeCompra - ((2022-this.ano) * 0.15 * this.valorDeCompra);
        if (valorVenda < (this.valorDeCompra*0.1)) {
            valorVenda = this.valorDeCompra*0.1;
        }
        return valorVenda;
    };
    
    public abstract String getStringModelo();
    
    
    @Override
    public abstract double getValorDiariaLocacao();
    
    
}
