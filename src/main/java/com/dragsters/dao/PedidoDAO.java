package com.dragsters.dao;

import com.dragsters.model.ItemPedido;
import com.dragsters.model.Pedido;
import com.dragsters.utils.ConexaoDataBase;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Santos
 */
public class PedidoDAO {
    public static boolean criar(Pedido pedido, ArrayList<ItemPedido> itensPedido) {
        PreparedStatement ps = null;
        Date date = new Date();
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Pedido(Total, DataPedido, VendaConcluida, ClienteID, FuncionarioID, UnidadeID) VALUES (?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            
            ps.setDouble(1, pedido.getTotal());
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ps.setInt(3, 1);
            ps.setInt(4, pedido.getClienteID());
            ps.setInt(5, pedido.getFuncionarioID());
            ps.setInt(6, pedido.getUnidadeID());
            
            int linhasAfetadasPedido = ps.executeUpdate();
            
            if (linhasAfetadasPedido <= 0) {
                return false;
            }
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int idPedido = 0;
            
            if (rs.next()) {
                idPedido = rs.getInt(1);
            }
            
            for (ItemPedido item : itensPedido) {
                ps = conn.prepareStatement("INSERT INTO ItemPedido(Quantidade, PedidoID, ProdutoID) VALUES (?, ?, ?)");
                
                ps.setInt(1, item.getQuantidade());
                ps.setInt(2, idPedido);
                ps.setInt(3, item.getProdutoID());
                
                int linhasAfetadasItemPedido = ps.executeUpdate();
                
                if (linhasAfetadasItemPedido <= 0) {
                    return false;
                }
                
                // TODO: Estoque
                
//                ps = conn.prepareStatement("UPDATE Estoque SET Quantidade = ? WHERE = ?;");
//                ps.setInt(1, - item.getQuantidade());
//                // WHERE
//                ps.setInt(2, item.getProdutoID());
//                
//                int linhasAfetadasEstoque = ps.executeUpdate();
//                
//                if (linhasAfetadasEstoque <= 0) {
//                    return false;
//                }
            }
        } 
        catch (Exception e) {
            return false;
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
        
        return true;
    }
}
