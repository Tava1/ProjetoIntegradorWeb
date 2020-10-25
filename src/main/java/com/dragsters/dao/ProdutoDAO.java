package com.dragsters.dao;

import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.dragsters.model.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gustavo Santos
 */
public class ProdutoDAO {
    public static boolean criar(Produto produto) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Produto (Marca, Modelo, Descricao, PrecoUnitario, Ativo, CategoriaID, EstoqueID, FilialID) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            
            ps.setString(1, produto.getMarca());
            ps.setString(2, produto.getModelo());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getPrecoUnitario());
            ps.setInt(5, produto.getAtivo());
            ps.setInt(6, produto.getCategoriaID());
            ps.setInt(7, produto.getEstoqueID());
            ps.setInt(8, produto.getFilialID());
            
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
    
    // Listar todos os funcionarios ativos no sistema
    public static List<Produto> listarAtivos() {
        List<Produto> produtos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Produto WHERE Ativo = 1;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Produto produto = new Produto();
                
                produto.setProdutoID(resultSet.getInt("ProdutoID"));
                produto.setMarca(resultSet.getString("Marca"));
                produto.setModelo(resultSet.getString("Modelo"));
                produto.setDescricao(resultSet.getString("Descricao"));
                produto.setPrecoUnitario(resultSet.getDouble("PrecoUnitario"));
                produto.setAtivo(resultSet.getInt("Ativo"));
                produto.setCategoriaID(resultSet.getInt("CategoriaID"));
                produto.setEstoqueID(resultSet.getInt("EstoqueID"));
                produto.setFilialID(resultSet.getInt("FilialID"));

                produtos.add(produto);
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
        
        return produtos;
    }
    
    // Listar todos os produtos inativos no sistema
    public static List<Produto> listarInativos() {
        List<Produto> produtos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Produto WHERE Ativo = 0;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Produto produto = new Produto();
                
                produto.setProdutoID(resultSet.getInt("ProdutoID"));
                produto.setMarca(resultSet.getString("Marca"));
                produto.setModelo(resultSet.getString("Modelo"));
                produto.setDescricao(resultSet.getString("Descricao"));
                produto.setPrecoUnitario(resultSet.getDouble("PrecoUnitario"));
                produto.setAtivo(resultSet.getInt("Ativo"));
                produto.setCategoriaID(resultSet.getInt("CategoriaID"));
                produto.setEstoqueID(resultSet.getInt("EstoqueID"));
                produto.setFilialID(resultSet.getInt("FilialID"));

                produtos.add(produto);
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
        
        return produtos;
    }
   
    // Listar todos os produtos
    public static List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Produto");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Produto produto = new Produto();
                
                produto.setProdutoID(resultSet.getInt("ProdutoID"));
                produto.setMarca(resultSet.getString("Marca"));
                produto.setModelo(resultSet.getString("Modelo"));
                produto.setDescricao(resultSet.getString("Descricao"));
                produto.setPrecoUnitario(resultSet.getDouble("PrecoUnitario"));
                produto.setAtivo(resultSet.getInt("Ativo"));
                produto.setCategoriaID(resultSet.getInt("CategoriaID"));
                produto.setEstoqueID(resultSet.getInt("EstoqueID"));
                produto.setFilialID(resultSet.getInt("FilialID"));

                produtos.add(produto);
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
        
        return produtos;
    }
    
    // Buscar produto pelo ID
    public static Produto buscarProduto(int produtoID) {
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Produto produto = new Produto();

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Produto WHERE ProdutoID = ?;");
            ps.setInt(1, produtoID);
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                produto.setProdutoID(resultSet.getInt("ProdutoID"));
                produto.setMarca(resultSet.getString("Marca"));
                produto.setModelo(resultSet.getString("Modelo"));
                produto.setDescricao(resultSet.getString("Descricao"));
                produto.setPrecoUnitario(resultSet.getDouble("PrecoUnitario"));
                produto.setAtivo(resultSet.getInt("Ativo"));
                produto.setCategoriaID(resultSet.getInt("CategoriaID"));
                produto.setEstoqueID(resultSet.getInt("EstoqueID"));
                produto.setFilialID(resultSet.getInt("FilialID"));
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
        
        return produto;
    }
    
    public static boolean atualizar(Produto produto) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Produto SET Marca = ?, Modelo = ?, Descricao = ?, PrecoUnitario = ?, Ativo = ?, CategoriaID = ?, EstoqueID = ?, FilialID = ? WHERE ProdutoID = ?;");
            
            ps.setString(1, produto.getMarca());
            ps.setString(2, produto.getModelo());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getPrecoUnitario());
            ps.setInt(5, produto.getAtivo());
            ps.setInt(6, produto.getCategoriaID());
            ps.setInt(7, produto.getEstoqueID());
            ps.setInt(8, produto.getFilialID());

            // WHERE
            ps.setInt(9, produto.getProdutoID());
            
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
    
    public static boolean deletar(int produtoID) {

        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("DELETE FROM Produto WHERE ProdutoID = ?;");
            
            ps.setInt(1, produtoID);
            
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
