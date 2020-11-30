package com.dragsters.dao;

import com.dragsters.interfaces.IDAO;
import com.dragsters.model.Unidade;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Santos
 */
public class UnidadeDAO implements IDAO<Unidade>{
    
    @Override
    public boolean criar(Unidade unidade) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Unidade (Endereco, EnderecoNumero, Cidade, Estado, Titulo) VALUES (?, ?, ?, ?, ?);");
            
            ps.setString(1, unidade.getEndereco());
            ps.setString(2, unidade.getEnderecoNumero());
            ps.setString(3, unidade.getCidade());
            ps.setString(4, unidade.getEstado());
            ps.setString(5, unidade.getTitulo());
            
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
    public ArrayList<Unidade> listar() {
        ArrayList<Unidade> unidades = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Unidade");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Unidade unidade = new Unidade();
                
                unidade.setUnidadeID(resultSet.getInt("UnidadeID"));
                unidade.setEndereco(resultSet.getString("Endereco"));
                unidade.setEnderecoNumero(resultSet.getString("EnderecoNumero"));
                unidade.setCidade(resultSet.getString("Cidade"));
                unidade.setEstado(resultSet.getString("Estado"));
                unidade.setTitulo(resultSet.getString("Titulo"));

                unidades.add(unidade);
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
        
        return unidades;
    }
    
    @Override
    public boolean atualizar(Unidade unidade) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Unidade SET Endereco = ?, EnderecoNumero = ?, Cidade = ?, Estado = ?, Titulo = ?, WHERE UnidadeID = ?;");
            
            ps.setString(1, unidade.getEndereco());
            ps.setString(2, unidade.getEnderecoNumero());
            ps.setString(3, unidade.getCidade());
            ps.setString(4, unidade.getEstado());
            ps.setString(5, unidade.getTitulo());

            // WHERE
            ps.setInt(6, unidade.getUnidadeID());
            
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
    public boolean deletar(int unidadeID) {

        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("DELETE FROM Unidade WHERE UnidadeID = ?;");
            
            ps.setInt(1, unidadeID);
            
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
