package com.dragsters.dao;

import com.dragsters.interfaces.IDAO;
import com.dragsters.model.Funcionario;
import com.dragsters.utils.ConexaoDataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Santos
 */
public class FuncionarioDAO implements IDAO<Funcionario>{
    @Override
    public boolean criar(Funcionario funcionario) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Funcionario(Nome, CPF, Genero, Email, DataNascimento, Senha, Ativo, CargoID, UnidadeID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCPF());
            ps.setString(3, funcionario.getGenero());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, funcionario.getDataNascimento());
            ps.setString(6, funcionario.getSenha());
            ps.setInt(7, funcionario.getAtivo());
            ps.setInt(8, funcionario.getCargoID());
            ps.setInt(9, funcionario.getUnidadeID());
            
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
    public ArrayList<Funcionario> listarAtivos() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
                funcionario.setUnidadeID(resultSet.getInt("UnidadeID"));

                
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
    public ArrayList<Funcionario> listarInativos() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
                funcionario.setUnidadeID(resultSet.getInt("UnidadeID"));
                
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
    @Override
    public ArrayList<Funcionario> listar() {
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
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
                funcionario.setUnidadeID(resultSet.getInt("UnidadeID"));
                
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

    @Override
    public boolean atualizar(Funcionario funcionario) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Funcionario SET Nome = ?, CPF = ?, Genero = ?, Email = ?, DataNascimento = ?, Senha = ?, Ativo = ?, CargoID = ?, UnidadeID = ? WHERE FuncionarioID = ?;");
            
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCPF());
            ps.setString(3, funcionario.getGenero());
            ps.setString(4, funcionario.getEmail());
            ps.setDate(5, funcionario.getDataNascimento());
            ps.setString(6, funcionario.getSenha());
            ps.setInt(7, funcionario.getAtivo());
            ps.setInt(8, funcionario.getCargoID());
            ps.setInt(9, funcionario.getUnidadeID());

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
    
    @Override
    public boolean deletar(int funcionarioID) {

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
    
            
    public Funcionario listarFuncionarioID(int funcionarioID) {
        PreparedStatement ps = null; 
        ResultSet resultSet = null;
        
        Funcionario funcionario = new Funcionario();
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Funcionario WHERE FuncionarioID = ?;");
            ps.setInt(1, funcionarioID);
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setNome(resultSet.getString("Nome"));
                funcionario.setCPF(resultSet.getString("CPF"));
                funcionario.setGenero(resultSet.getString("Genero"));
                funcionario.setEmail(resultSet.getString("Email"));
                funcionario.setDataNascimento(resultSet.getDate("DataNascimento"));
                funcionario.setAtivo(resultSet.getInt("Ativo"));
                funcionario.setCargoID(resultSet.getInt("CargoID"));
                funcionario.setUnidadeID(resultSet.getInt("UnidadeID"));
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
        
        return funcionario;
    }
    
    
    public Funcionario verificarAcesso(int usuario, String senha) {
        PreparedStatement ps = null; 
        ResultSet resultSet = null;
        Funcionario funcionario = new Funcionario();

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Funcionario WHERE FuncionarioID = ? AND Senha = ?;");
            ps.setInt(1, usuario);
            ps.setString(2, senha);
            
            resultSet = ps.executeQuery();
            
            if (resultSet.next()) {
                funcionario.setNome(resultSet.getString("Nome"));
                funcionario.setFuncionarioID(resultSet.getInt("FuncionarioID"));
                funcionario.setCargoID(resultSet.getInt("CargoID"));
            }
            else {
                return null;
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
        
        return funcionario;
    }
}
