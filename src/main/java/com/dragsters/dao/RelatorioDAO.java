package com.dragsters.dao;

import com.dragsters.model.PedidoDetalheRelatorio;
import com.dragsters.model.PedidoRelatorio;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Santos
 */
public class RelatorioDAO {

    public static ArrayList<PedidoRelatorio> listar() {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<PedidoRelatorio> pedidosRelatorio = new ArrayList<>();
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT Pedido.PedidoID, Pedido.Total, Pedido.DataPedido, Cliente.Nome as NomeCliente, Cliente.CPF, Funcionario.Nome as NomeFuncionario, Unidade.Endereco, Unidade.EnderecoNumero FROM Pedido INNER JOIN Cliente ON Pedido.ClienteID = Cliente.ClienteID INNER JOIN Funcionario ON Pedido.FuncionarioID = Funcionario.FuncionarioID INNER JOIN Unidade ON Pedido.UnidadeID = Unidade.UnidadeID");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                PedidoRelatorio pedidoRelatorio = new PedidoRelatorio();
                
                pedidoRelatorio.setPedidoID(resultSet.getInt("PedidoID"));
                pedidoRelatorio.setTotal(resultSet.getDouble("Total"));
                pedidoRelatorio.setDataPedido(resultSet.getDate("DataPedido"));
                pedidoRelatorio.setNomeCliente(resultSet.getString("NomeCliente"));
                pedidoRelatorio.setCpfCliente(resultSet.getString("CPF"));
                pedidoRelatorio.setNomeFuncionario(resultSet.getString("NomeFuncionario"));
                pedidoRelatorio.setEnderecoUnidade(resultSet.getString("Endereco"));
                pedidoRelatorio.setEnderecoNumeroUnidade(resultSet.getString("EnderecoNumero"));

                pedidosRelatorio.add(pedidoRelatorio);
            }
        } 
        catch (Exception e) {
        }
        finally {
            try {
                if (ps != null) {
                    ConexaoDataBase.fecharConexao();
                }
            } 
            catch (Exception e) {
            }
        }
        
        return pedidosRelatorio;
    }
    
    
    public static ArrayList<PedidoDetalheRelatorio> listarDetalheVenda(int pedidoID) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        ArrayList<PedidoDetalheRelatorio> detalhePedidoRelatorio = new ArrayList<>();
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT Pedido.PedidoID, Produto.Modelo, ItemPedido.Quantidade, Produto.PrecoUnitario, Pedido.Total, Cliente.Nome as NomeCliente, Cliente.CPF as CPFCliente, Funcionario.Nome as FuncionarioNome, Unidade.Endereco, Unidade.EnderecoNumero, Pedido.DataPedido FROM ItemPedido INNER JOIN Pedido ON ItemPedido.PedidoID = Pedido.PedidoID INNER JOIN Cliente ON Pedido.ClienteID = Cliente.ClienteID INNER JOIN Produto ON Produto.ProdutoID = ItemPedido.ProdutoID INNER JOIN Funcionario ON Pedido.FuncionarioID = Funcionario.FuncionarioID INNER JOIN Unidade ON Unidade.UnidadeID = Funcionario.UnidadeID WHERE Pedido.PedidoID = ?;");
            ps.setInt(1, pedidoID);
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                PedidoDetalheRelatorio pedidoDetalheRelatorio = new PedidoDetalheRelatorio();
                
                pedidoDetalheRelatorio.setPedidoID(resultSet.getInt("PedidoID"));
                pedidoDetalheRelatorio.setModelo(resultSet.getString("Modelo"));
                pedidoDetalheRelatorio.setQuantidade(resultSet.getInt("Quantidade"));
                pedidoDetalheRelatorio.setPrecoUnitario(resultSet.getDouble("PrecoUnitario"));
                pedidoDetalheRelatorio.setTotal(resultSet.getDouble("Total"));
                pedidoDetalheRelatorio.setNomeCliente(resultSet.getString("NomeCliente"));
                pedidoDetalheRelatorio.setCpfCliente(resultSet.getString("CPFCliente"));
                pedidoDetalheRelatorio.setNomeFuncionario(resultSet.getString("FuncionarioNome"));
                pedidoDetalheRelatorio.setEnderecoUnidade(resultSet.getString("Endereco"));
                pedidoDetalheRelatorio.setEnderecoNumeroUnidade(resultSet.getString("EnderecoNumero"));
                pedidoDetalheRelatorio.setDataPedido(resultSet.getDate("DataPedido"));

                detalhePedidoRelatorio.add(pedidoDetalheRelatorio);
            }
        } 
        catch (Exception e) {
        }
        finally {
            try {
                if (ps != null) {
                    ConexaoDataBase.fecharConexao();
                }
            } 
            catch (Exception e) {
            }
        }
        
        return detalhePedidoRelatorio;
    }
}
