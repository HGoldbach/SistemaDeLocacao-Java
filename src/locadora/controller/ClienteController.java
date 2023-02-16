/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locadora.controller;

import java.util.List;
import locadora.model.Cliente;
import locadora.model.dao.ClienteDAO;
import locadora.view.TelaCliente.TelaClienteView;


/**
 *
 * @author goldb
 */
public class ClienteController {
    // private TelaClienteView telaClienteView;
    private TelaClienteView telaClienteView;
    private ClienteDAO modelDao;
    
    /*
    public ClienteController(TelaClienteView view, ClienteDAO modelDao) {
        this.telaClienteView = view;
        this.modelDao = modelDao;
        initTelaController();
    }
    */
    
    public ClienteController(TelaClienteView view, ClienteDAO modelDao) {
        this.telaClienteView = view;
        this.modelDao = modelDao;
        initTelaController();
    }
    
    private void initTelaController(){
        this.telaClienteView.setController(this);
        this.telaClienteView.initView();
    }
    
    public void atualizarCliente() {
        try {
            Cliente cliente = telaClienteView.getClienteParaAtualizar();
            if(cliente == null){
                throw new Exception("Selecione um cliente para atualizar!");
            }
            String[] endereco = cliente.getEndereco().split(",");
            if(endereco[0].equals("") || endereco[1].equals("") || endereco[2].equals("") || endereco[3].equals("  ") || endereco[4].equals("     -   ")) {
                throw new Exception("Preencha todos os campos para inserir!");
            }
            modelDao.alterarCliente(cliente);
            telaClienteView.atualizarClienteNaTabela(cliente);
            telaClienteView.apresentaInfo("Cliente alterado com sucesso.");
            telaClienteView.limparCampos();
        }
        catch(Exception e){
            telaClienteView.apresentaErro(e.getMessage());
        }
    }
    
    public void excluirCliente() {
        try {
            List<Cliente> listaParaExcluir = telaClienteView.getClientesParaExcluir();
            if(listaParaExcluir.isEmpty()) {
                throw new Exception("Selecione um cliente para excluir!");
            }
            modelDao.excluirLista(listaParaExcluir);
            telaClienteView.apresentaInfo("Cliente removido com sucesso.");
            telaClienteView.excluirContatosDaTabela(listaParaExcluir);
            listarCliente();
        }
        catch(Exception e){
            telaClienteView.apresentaErro(e.getMessage());
        }
    }
    
    public void incluirCliente() {
        try{
            Cliente cliente = telaClienteView.getClienteFormulario();
            String[] endereco = cliente.getEndereco().split(",");
            if(cliente.getNome().equals("") || cliente.getSobrenome().equals("") || endereco[0].equals("") || endereco[1].equals("") || endereco[2].equals("") || endereco[3].equals("  ") || endereco[4].equals("     -   ")) {
                throw new Exception("Preencha todos os campos para inserir!");
            }
            modelDao.inserirCliente(cliente);
            telaClienteView.inserirContatoTabela(cliente);
            telaClienteView.limparCampos();
            telaClienteView.apresentaInfo("Cliente adicionado com sucesso!!!");
        }catch(Exception e){
            telaClienteView.apresentaErro(e.getMessage());
        }
    }
    
    public void listarCliente() {
        try{
            telaClienteView.limparCampos();
            List<Cliente> lista = this.modelDao.getListaCliente();
            telaClienteView.setListaClientesTabela(lista);
        }catch(Exception e){
            telaClienteView.apresentaErro("Erro ao listar contatos.");
        }
    }
   
}
