/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model.dao;

import locadora.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author goldb
 */
public class ClienteDAO {
    private ConnectionFactory connection;
    private final String insert = "INSERT INTO Cliente (cliente_nome, cliente_sobrenome, cliente_cpf, cliente_rg, cliente_endereco) VALUES (?,?,?,?,?)";
    private final String update = "UPDATE Cliente SET cliente_endereco=? WHERE cliente_cpf=?";
    private final String delete = "DELETE FROM Cliente WHERE cliente_cpf=?";
    private final String select = "SELECT * FROM Cliente";
    
    
    public ClienteDAO(ConnectionFactory conn) {
        this.connection = conn;
    }
    
    public void inserirCliente(Cliente c) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(insert)) {
            pst.setString(1, c.getNome());
            pst.setString(2, c.getSobrenome());
            pst.setString(3, c.getCPF());
            pst.setString(4, c.getRG());
            pst.setString(5, c.getEndereco());
            pst.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException("RG ou CPF já inseridos no sistema!");
        }
    }
    
    public void alterarCliente(Cliente c) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(update)) {
            pst.setString(1, c.getEndereco());
            pst.setString(2, c.getCPF());
            pst.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void excluirLista(List<Cliente> clientes) throws SQLException {
        for(Cliente cliente:clientes){
            excluirCliente(cliente);
        }
    }

    public void excluirCliente(Cliente c) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(delete)) {
            pst.setString(1, c.getCPF().trim());
            pst.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException("Nao foi possível excluir o cliente, o mesmo possuí um veiculo locado em seu nome!");
        }
    }  
    
    public List<Cliente> getListaCliente() {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(select)) {
            List<Cliente> list = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                list.add(new Cliente(rs.getString("cliente_nome"), rs.getString("cliente_sobrenome"), rs.getString("cliente_rg"), rs.getString("cliente_cpf"), rs.getString("cliente_endereco")));
            }
            return list;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    
}
