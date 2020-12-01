
package com.dragsters.dao;

import com.dragsters.interfaces.IDAO;
import com.dragsters.model.Categoria;
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
public class CategoriaDAO implements IDAO<Categoria>{
    
    @Override
    public boolean criar(Categoria categoria) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Categoria(Titulo) VALUES (?)");
            ps.setString(1, categoria.getTitulo());

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
    
    @Override
    public ArrayList<Categoria> listar() {
        ArrayList<Categoria> categorias = new ArrayList<Categoria>();
        PreparedStatement ps = null; 
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Categoria");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setCategoriaID(resultSet.getInt("CategoriaID"));
                categoria.setTitulo(resultSet.getString("Titulo"));
                
                categorias.add(categoria);
            }

        } 
        catch (Exception e) {
        }
        
        return categorias;
    }
    
    @Override
    public boolean atualizar(Categoria categoria) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Categoria SET Titulo = ? WHERE CategoriaID = ?;");
            
            ps.setString(1, categoria.getTitulo());
            
            // WHERE
            ps.setInt(2, categoria.getCategoriaID());
            
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
    
    @Override
    public boolean deletar(int categoriaID) {

        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("DELETE FROM Categoria WHERE CategoriaID = ?;");
            
            ps.setInt(1, categoriaID);
            
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
