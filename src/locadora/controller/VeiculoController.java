/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.Calendar;
import java.util.List;
import locadora.model.Automovel;
import locadora.model.Cliente;
import locadora.model.Motocicleta;
import locadora.model.Veiculo;
import locadora.model.dao.VeiculoDAO;
import locadora.view.TelaAlugar.TelaAlugarVeiculoView;
import locadora.view.TelaComprar.TelaComprarVeiculoView;
import locadora.view.TelaDevolver.TelaDevolverVeiculoView;
import locadora.view.TelaVender.TelaVenderVeiculoView;

/**
 *
 * @author goldb
 */
public class VeiculoController {
    private TelaComprarVeiculoView viewComprar;
    private TelaAlugarVeiculoView viewAlugar;
    private TelaDevolverVeiculoView viewDevolver;
    private TelaVenderVeiculoView viewVender;
    private VeiculoDAO modelDao;

    public VeiculoController(TelaComprarVeiculoView view, VeiculoDAO modelDao) {
        this.viewComprar = view;
        this.modelDao = modelDao;
        initComprarController();
    }
    
    public VeiculoController(TelaAlugarVeiculoView view, VeiculoDAO modelDao) {
        this.viewAlugar = view;
        this.modelDao = modelDao;
        initAlugarController();
    }
    
    public VeiculoController(TelaDevolverVeiculoView view, VeiculoDAO modelDao) {
        this.viewDevolver = view;
        this.modelDao = modelDao;
        initDevolverController();
    }

    public VeiculoController(TelaVenderVeiculoView view, VeiculoDAO modelDao) {
        this.viewVender = view;
        this.modelDao = modelDao;
        initVenderController();
    }
    
    private void initComprarController(){
        this.viewComprar.setController(this);
        this.viewComprar.initView();
    }
    
    private void initAlugarController(){
        this.viewAlugar.setController(this);
        this.viewAlugar.initView();
    }
    
    private void initDevolverController(){
        this.viewDevolver.setController(this);
        this.viewDevolver.initView();
    }
    
    private void initVenderController(){
        this.viewVender.setController(this);
        this.viewVender.initView();
    }

    public void incluirVeiculo() {
        try {
            
            Veiculo v = viewComprar.getVeiculoFormulario();
            
            if (v.getPlaca().equals("   -    ") || v.getPlaca().startsWith(" ") || v.getPlaca().endsWith(" ")) {
                throw new Exception("Preencha todos os campos para inserir!");
            }
            if (v.getAno() < 1960 || v.getAno() > 2023) {
                throw new Exception("Ano Invalido!");
            }
            
            String veiculo = "";
            if (v instanceof Automovel) {
                veiculo = "Automovel";
            } else if (v instanceof Motocicleta) {
                veiculo = "Motocicleta";
            } else {
                veiculo = "Van";
            }
            
            modelDao.inserirVeiculo(v,veiculo);
            viewComprar.apresentaInfo("Veiculo incluido com sucesso.");
            viewComprar.limparCampos();
        }
        catch (Exception e) {
            if (e.getMessage().contains("No enum constant")) {
                viewComprar.apresentaErro("Preencha todos os campos para inserir!");
            } else {
               viewComprar.apresentaErro(e.getMessage());
            }
        }

        
    }

    public void filtrarVeiculo() {
        try {
            String[] veiculoDados = viewAlugar.getVeiculoFiltro();
            if (veiculoDados[0].equals("- Marca -") || veiculoDados[1].equals("- Categoria -") || veiculoDados[2].equals("- Tipo -")) {
                throw new Exception("Selecione as opções para efetuar o filtro");
            }
           
            List<Veiculo> veiculos = modelDao.filtrarVeiculos(veiculoDados);
            if (veiculos.isEmpty()) {
                throw new Exception("Nenhum veiculo disponível para locação com os filtros selecionados!");
            }
            viewAlugar.setListaVeiculosTabela(veiculos);
        }
        catch(Exception e) {
            viewAlugar.apresentaErro(e.getMessage());
        }
    }
    
    public void filtrarVenderVeiculo() {
        try {
            String[] veiculoDados = viewVender.getVeiculoFiltro();
            if (veiculoDados[0].equals("- Marca -") || veiculoDados[1].equals("- Categoria -") || veiculoDados[2].equals("- Tipo -")) {
                throw new Exception("Selecione as opções para efetuar o filtro");
            }
           
            List<Veiculo> veiculos = modelDao.filtrarVeiculos(veiculoDados);
            if (veiculos.isEmpty()) {
                throw new Exception("Nenhum veiculo disponível para locação com os filtros selecionados!");
            }
            viewVender.setListaVeiculosTabela(veiculos);
        }
        catch(Exception e) {
            viewVender.apresentaErro(e.getMessage());
        }
    }

    public void locarVeiculo() {
        try {
            Cliente cliente = null;
            Veiculo veiculo = null;
            
            try {
                cliente = modelDao.buscaCliente(viewAlugar.getClienteCPF());
                veiculo = viewAlugar.getVeiculoTabela();
            }
            catch(Exception e) {
                throw new Exception("Cliente ou Veiculo não selecionados!");
                
            }
            
            if (viewAlugar.getDiasLocacao().equals("") || viewAlugar.getDataLocacao().equals("  /  /    ") || viewAlugar.getDataLocacao().startsWith(" ") || viewAlugar.getDataLocacao().endsWith(" ")) {
                throw new Exception("Preencha todos os campos!");
            }
            
            int diasLocacao = Integer.parseInt(viewAlugar.getDiasLocacao());
            String dataLocacao = viewAlugar.getDataLocacao();
            String[] dLocacao = dataLocacao.split("/");
            Calendar calendar = Calendar.getInstance();
            
            if (Integer.parseInt(dLocacao[0]) < 1 || Integer.parseInt(dLocacao[0]) > 31) {
                throw new Exception("Dia inserido não existe!");
            } else if ( Integer.parseInt(dLocacao[1]) < 1 || Integer.parseInt(dLocacao[1]) > 12 ) {
                throw new Exception("Mês inserido não existe!");
            } else if ( Integer.parseInt(dLocacao[2]) < 1930 || Integer.parseInt(dLocacao[2]) > 2022 ) {
                throw new Exception("O ano inserido está incorreto!");
            } else {
                calendar.set(Integer.parseInt(dLocacao[2]), Integer.parseInt(dLocacao[1]), Integer.parseInt(dLocacao[0]));
                veiculo.locar(diasLocacao, calendar, cliente);
            }
            modelDao.mudarEstadoVeiculo(veiculo);
            modelDao.locarVeiculo(veiculo);
            viewAlugar.apresentaInfo("Veiculo alocado com sucesso.");
            viewAlugar.limpaCampos();
            
        }
        catch(Exception e) {
            viewAlugar.apresentaErro(e.getMessage());
        }
        
    }
    
    public void buscarCliente() {
        try {
            String clienteCPF = viewAlugar.getClienteCPF();
            if (clienteCPF.equals("")) {
                throw new Exception("Informe um CPF para a busca!");
            }
            Cliente c = modelDao.buscaCliente(clienteCPF);
            viewAlugar.apresentaCliente(c);
        } catch(Exception e) {
            viewAlugar.apresentaErro(e.getMessage());
        }
        
        
    }

    public void listarVeiculos() {
        try {
            List<Veiculo> veiculosAlugados = modelDao.getLocadosVeiculos();
            if (veiculosAlugados.isEmpty()) {
                throw new Exception("Nenhum veiculo está locado no momento!");
            }
         
            viewDevolver.setListaVeiculosTabela(veiculosAlugados);
        }
        catch (Exception e) {
            viewDevolver.apresentaErro(e.getMessage());
        }
    }
    
    public void devolverVeiculo() {
        try {
            Veiculo veiculo = viewDevolver.getVeiculoTabela();
            if (veiculo == null) {
                throw new Exception("Selecione um veiculo!");
            }
            modelDao.devolverVeiculo(veiculo);
            veiculo.devolver();
            viewDevolver.apresentaInfo("Veiculo devolvido!");
            viewDevolver.limpaLista();
            listarVeiculos();
        }
        catch(Exception e) {
            viewDevolver.apresentaErro(e.getMessage());
        }
    }

    public void venderVeiculo() {
       try {
            Veiculo veiculo = viewVender.getVeiculoTabela();
            if (veiculo == null) {
                throw new Exception("Selecione um veiculo!");
            }
            veiculo.vender();
            modelDao.venderVeiculo(veiculo);
            viewVender.apresentaInfo("Veiculo vendido!");
            viewVender.limpaCampos();
        }
        catch(Exception e) {
            viewVender.apresentaErro(e.getMessage());
        }
    }
    
    
}
