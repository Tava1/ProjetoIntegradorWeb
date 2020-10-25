package com.dragsters.dao;

import com.dragsters.model.Pedido;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gustavo Santos
 */
public class PedidoDAO {
    public static boolean criar(Pedido pedido) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Pedido(Total, DataPedido, VendaConcluida, ClienteID, FuncionarioID) VALUES (?, ?, ?, ?, ?);");
            
            ps.setDouble(1, pedido.getTotal());
            ps.setDate(2, pedido.getDataPedido());
            ps.setInt(3, pedido.getVendaConcluida());
            ps.setInt(4, pedido.getClienteID());
            ps.setInt(5, pedido.getFuncionarioID());
            
            int linhasAfetadas = ps.executeUpdate();
            
            if (linhasAfetadas <= 0) {
                return false;
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
