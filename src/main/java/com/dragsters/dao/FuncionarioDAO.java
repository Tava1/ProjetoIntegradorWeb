/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragsters.dao;

import com.dragsters.model.Funcionario;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gustavo Santos
 */
public class FuncionarioDAO {
    public static boolean criar(Funcionario funcionario) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Funcionario(Nome, CPF, Genero, Email, DataNascimento, Senha, Ativo, CargoID) VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCPF());
            ps.setString(3, funcionario.getGenero());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, funcionario.getDataNascimento());
            ps.setString(6, funcionario.getSenha());
            ps.setInt(7, funcionario.getAtivo());
            ps.setInt(8, funcionario.getCargoID());
            
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
    public static List<Funcionario> listarAtivos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Funcionario WHERE Ativo = 1;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setNome(resultSet.getString("Nome"));
                funcionario.setCPF(resultSet.getString("CPF"));
                funcionario.setGenero(resultSet.getString("Genero"));
                funcionario.setEmail(resultSet.getString("Email"));
                funcionario.setDataNascimento(resultSet.getDate("DataNascimento"));
                funcionario.setAtivo(resultSet.getInt("Ativo"));
                funcionario.setCargoID(resultSet.getInt("CargoID"));
                
                funcionarios.add(funcionario);
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
        
        return funcionarios;
    }
    
    // Lista funcionario inativos no sistema
    public static List<Funcionario> listarInativos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Funcionario WHERE Ativo <> 1;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setNome(resultSet.getString("Nome"));
                funcionario.setCPF(resultSet.getString("CPF"));
                funcionario.setGenero(resultSet.getString("Genero"));
                funcionario.setEmail(resultSet.getString("Email"));
                funcionario.setDataNascimento(resultSet.getDate("DataNascimento"));
                funcionario.setAtivo(resultSet.getInt("Ativo"));
                funcionario.setCargoID(resultSet.getInt("CargoID"));
                
                funcionarios.add(funcionario);
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
        
        return funcionarios;
    }
   
    // Lista todos os funcionarios
    public static List<Funcionario> listar() {
        List<Funcionario> funcionarios = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Funcionario;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                
                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setNome(resultSet.getString("Nome"));
                funcionario.setCPF(resultSet.getString("CPF"));
                funcionario.setGenero(resultSet.getString("Genero"));
                funcionario.setEmail(resultSet.getString("Email"));
                funcionario.setDataNascimento(resultSet.getDate("DataNascimento"));
                funcionario.setAtivo(resultSet.getInt("Ativo"));
                funcionario.setCargoID(resultSet.getInt("CargoID"));
                
                funcionarios.add(funcionario);
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
        
        return funcionarios;
    }

    public static boolean atualizar(Funcionario funcionario) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Funcionario SET Nome = ?, CPF = ?, Genero = ?, Email = ?, DataNascimento = ?, Senha = ?, Ativo = ?, CargoID = ? WHERE FuncionarioID = ?;");
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCPF());
            ps.setString(3, funcionario.getGenero());
            ps.setString(5, funcionario.getEmail());
            ps.setDate(6, funcionario.getDataNascimento());
            ps.setString(7, funcionario.getSenha());
            ps.setInt(8, funcionario.getAtivo());
            ps.setInt(9, funcionario.getCargoID());

            // WHERE
            ps.setInt(10, funcionario.getFuncionarioID());
            
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
    
    public static boolean deletar(int funcionarioID) {

        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("DELETE FROM Funcionario WHERE FuncionarioID = ?;");
            
            ps.setInt(1, funcionarioID);
            
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
