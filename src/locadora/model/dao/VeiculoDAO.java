/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.model.dao;

import locadora.model.Veiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import locadora.model.Automovel;
import locadora.model.Categoria;
import locadora.model.Cliente;
import locadora.model.Estado;
import locadora.model.Locacao;
import locadora.model.Marca;
import locadora.model.ModeloAutomovel;
import locadora.model.ModeloMotocicleta;
import locadora.model.ModeloVan;
import locadora.model.Motocicleta;
import locadora.model.Van;

/**
 *
 * @author goldb
 */
public class VeiculoDAO {
    private ConnectionFactory connection;
    private final String insert = "INSERT INTO Veiculo (veiculo_marca, veiculo_estado, veiculo_categoria, veiculo_valor, veiculo_placa, veiculo_ano, veiculo_tipo, veiculo_modelo) VALUES (?,?,?,?,?,?,?,?)";
    private final String selectFiltro = "SELECT * FROM Veiculo WHERE veiculo_marca=? AND veiculo_categoria=? AND veiculo_tipo=?";
    private final String selectCliente = "SELECT * FROM Cliente WHERE cliente_cpf=?";
    private final String selectVeiculo = "SELECT * FROM Veiculo WHERE veiculo_placa=?";
    private final String updateVeiculoEstado = "UPDATE Veiculo SET veiculo_estado=? WHERE veiculo_placa=?";
    private final String locarVeiculo = "INSERT INTO Locacao (locacao_cliente_id, locacao_veiculo_id, locacao_dias, locacao_valor, locacao_data) VALUES (?,?,?,?,?)";
    private final String selectLocados = "SELECT * FROM Locacao,Veiculo,Cliente WHERE locacao_cliente_id=cliente_id AND locacao_veiculo_id=veiculo_id";
    private final String deleteLocacao = "DELETE FROM Locacao WHERE locacao_veiculo_id=?";
    
    
    public VeiculoDAO(ConnectionFactory conn) {
        this.connection = conn;
    }
    
    public void inserirVeiculo(Veiculo v, String tipo) {
        try(Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(insert)) {
            pst.setString(1, v.getMarca().toString());
            pst.setString(2, v.getEstado().toString());
            pst.setString(3, v.getCategoria().toString());
            pst.setDouble(4, v.getValorParaVenda());
            pst.setString(5, v.getPlaca());
            pst.setInt(6, v.getAno());
            pst.setString(7, tipo);
            pst.setString(8, v.getStringModelo());
            pst.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Veiculo> filtrarVeiculos(String[] veiculoDados) {
        try(Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(selectFiltro)) {
            pst.setString(1, veiculoDados[0]);
            pst.setString(2, veiculoDados[1]);
            pst.setString(3, veiculoDados[2]);
            
            ResultSet rs = pst.executeQuery();
            List<Veiculo> veiculos = new ArrayList();
            while(rs.next()) {
                Marca marca = Marca.valueOf(rs.getString("veiculo_marca"));
                Estado estado = Estado.valueOf(rs.getString("veiculo_estado"));
                if (estado.toString().equals("LOCADO") || estado.toString().equals("VENDIDO")) {
                    continue;
                }
                Categoria cat = Categoria.valueOf(rs.getString("veiculo_categoria"));
                Double valor = Double.parseDouble(rs.getString("veiculo_valor"));
                String placa = rs.getString("veiculo_placa");
                int ano = Integer.parseInt(rs.getString("veiculo_ano"));
                String tipo = rs.getString("veiculo_tipo");

                if (tipo.equals("Motocicleta")) {
                    ModeloMotocicleta modMot = ModeloMotocicleta.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Motocicleta(marca,estado,null,cat,valor,placa,ano,modMot));
                } else if (tipo.equals("Automovel")) {
                    ModeloAutomovel modAut = ModeloAutomovel.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Automovel(marca,estado,null,cat,valor,placa,ano,modAut));
                } else if (tipo.equals("Van")) {
                    ModeloVan modVan = ModeloVan.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Van(marca,estado,null,cat,valor,placa,ano,modVan));
                } else {
                    throw new SQLException();
                }
            }
            return veiculos;

        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
      
    public Cliente buscaCliente(String clienteCPF) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(selectCliente)) {
            Cliente cliente = null;
            pst.setString(1, clienteCPF);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                cliente = new Cliente(rs.getString("cliente_nome"), rs.getString("cliente_sobrenome"), rs.getString("cliente_rg"), rs.getString("cliente_cpf"), rs.getString("cliente_endereco"));
            }
            if (cliente == null) {
                throw new SQLException("CPF não localizado!");
            }
            return cliente;
        }
        catch(SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void locarVeiculo(Veiculo veiculo) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(locarVeiculo); PreparedStatement pstc = conn.prepareStatement(selectCliente); PreparedStatement pstv = conn.prepareStatement(selectVeiculo)) {
            pstc.setString(1, veiculo.getLocacao().getCliente().getCPF());
            ResultSet rsc = pstc.executeQuery();
            while(rsc.next()) {
                pst.setInt(1, rsc.getInt("cliente_id"));
            }
            
            pstv.setString(1,veiculo.getPlaca());
            ResultSet rsv = pstv.executeQuery();
            while(rsv.next()) {
                pst.setInt(2,rsv.getInt("veiculo_id"));
            }
            
            pst.setInt(3, veiculo.getLocacao().getDias());
            pst.setDouble(4,veiculo.getLocacao().getValor());
            Calendar date = veiculo.getLocacao().getData();
            pst.setDate(5, new java.sql.Date(date.getTimeInMillis()));
            pst.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void mudarEstadoVeiculo(Veiculo veiculo) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(updateVeiculoEstado)) {
            pst.setString(1, veiculo.getEstado().toString());
            pst.setString(2, veiculo.getPlaca());
            pst.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Veiculo> getLocadosVeiculos() {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(selectLocados)) {
            List<Veiculo> veiculos = new ArrayList();
            ResultSet rs = pst.executeQuery();
            
            
            
            while(rs.next()) {
                Marca marca = Marca.valueOf(rs.getString("veiculo_marca"));
                Estado estado = Estado.valueOf(rs.getString("veiculo_estado"));
                Categoria cat = Categoria.valueOf(rs.getString("veiculo_categoria"));
                Double valor = Double.parseDouble(rs.getString("veiculo_valor"));
                String placa = rs.getString("veiculo_placa");
                int ano = Integer.parseInt(rs.getString("veiculo_ano"));
                String tipo = rs.getString("veiculo_tipo");
                Cliente cliente = new Cliente(rs.getString("cliente_nome"), rs.getString("cliente_sobrenome"), rs.getString("cliente_rg"), rs.getString("cliente_cpf"), rs.getString("cliente_endereco"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(rs.getDate("locacao_data"));
                Locacao locacao = new Locacao(rs.getInt("locacao_dias"), rs.getDouble("locacao_valor"), cal, cliente);
                if (tipo.equals("Motocicleta")) {
                    ModeloMotocicleta modMot = ModeloMotocicleta.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Motocicleta(marca,estado,locacao,cat,valor,placa,ano,modMot));
                } else if (tipo.equals("Automovel")) {
                    ModeloAutomovel modAut = ModeloAutomovel.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Automovel(marca,estado,locacao,cat,valor,placa,ano,modAut));
                } else if (tipo.equals("Van")) {
                    ModeloVan modVan = ModeloVan.valueOf(rs.getString("veiculo_modelo"));
                    veiculos.add(new Van(marca,estado,locacao,cat,valor,placa,ano,modVan));
                } else {
                    throw new SQLException();
                }
            }
            return veiculos;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void devolverVeiculo(Veiculo veiculo) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(updateVeiculoEstado); PreparedStatement pstv = conn.prepareStatement(selectVeiculo); PreparedStatement pstd = conn.prepareStatement(deleteLocacao)) {
            pst.setString(1, "DISPONIVEL");
            pst.setString(2, veiculo.getPlaca());
            
            pstv.setString(1, veiculo.getPlaca());
            ResultSet rs = pstv.executeQuery();
            while(rs.next()) {
                pstd.setInt(1, rs.getInt("veiculo_id"));
                pstd.executeUpdate();
            }
            pst.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void venderVeiculo(Veiculo veiculo) {
        try (Connection conn = connection.getConnection(); PreparedStatement pst = conn.prepareStatement(updateVeiculoEstado)) {
            pst.setString(1, veiculo.getEstado().toString());
            pst.setString(2, veiculo.getPlaca());
            pst.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
