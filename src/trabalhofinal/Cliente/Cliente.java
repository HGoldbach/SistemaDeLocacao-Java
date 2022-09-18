/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhofinal.Cliente;

/**
 *
 * @author goldb
 */
public class Cliente {
    
    private String nome, sobreNome, cpf, endereco;
    private String rg;


    public Cliente(String nome, String sobreNome, String rg, String cpf, String endereco) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return this.sobreNome;
    }
    
    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCPF() {
        return this.cpf;
    }
    
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRG() {
        return this.rg;
    }
    
    public void setRG(String rg) {
        this.rg = rg;
    }

    
}
