package com.dragsters.dao;

import com.dragsters.model.Cargo;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Santos
 */
public class CargoDAO {
    public static boolean criar(Cargo cargo) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Cargo(Titulo) VALUES (?)");
            ps.setString(1, cargo.getTitulo());

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                return true;
            }
            else {
                return false;
            }
        } 
        catch (SQLException | ClassNotFoundException ex) {
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
    }
    
    public static ArrayList<Cargo> listar() {
        ArrayList<Cargo> cargos = new ArrayList<Cargo>();
        PreparedStatement ps = null; 
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Cargo");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Cargo cargo = new Cargo();
                cargo.setCargoID(resultSet.getInt("CargoID"));
                cargo.setTitulo(resultSet.getString("Titulo"));
                
                cargos.add(cargo);
            }

        } 
        catch (Exception e) {
        }
        
        return cargos;
    }
    
    public static void atualizar() {
    
    }
}
