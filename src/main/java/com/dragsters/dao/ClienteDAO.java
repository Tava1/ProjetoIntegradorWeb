package com.dragsters.dao;

import com.dragsters.model.Cliente;
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
public class ClienteDAO {
    public static boolean criar(Cliente cliente) {
        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("INSERT INTO Cliente(Nome, CPF, Genero, EstadoCivil, Email, DataNascimento, NumeroContato, Endereco, EnderecoNumero, Complemento, Cidade, Estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getGenero());
            ps.setString(4, cliente.getEstadoCivil());
            ps.setString(5, cliente.getEmail());
            ps.setDate(6, cliente.getDataNascimento());
            ps.setString(7, cliente.getNumeroContato());
            ps.setString(8, cliente.getEndereco());
            ps.setString(9, cliente.getEnderecoNumero());
            ps.setString(10, cliente.getComplemento());
            ps.setString(11, cliente.getCidade());
            ps.setString(12, cliente.getEstado());
            
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
    
    // Listar todos os clientes
    public static List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Cliente;");
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setClienteID(resultSet.getInt("ClienteID"));
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setCPF(resultSet.getString("CPF"));
                cliente.setGenero(resultSet.getString("Genero"));
                cliente.setEstadoCivil(resultSet.getString("EstadoCivil"));
                cliente.setEmail(resultSet.getString("Email"));
                cliente.setDataNascimento(resultSet.getDate("DataNascimento"));
                cliente.setNumeroContato(resultSet.getString("NumeroContato"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                cliente.setEnderecoNumero(resultSet.getString("EnderecoNumero"));
                cliente.setComplemento(resultSet.getString("Complemento"));
                cliente.setCidade(resultSet.getString("Cidade"));
                cliente.setEstado(resultSet.getString("Estado"));
                
                clientes.add(cliente);
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
        
        return clientes;
    }
    
    // Listar clientes por CPF
    public static List<Cliente> listarClientesCPF(String CPF) {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Cliente WHERE CPF LIKE '%?%';");
            ps.setString(1, CPF);
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setClienteID(resultSet.getInt("ClienteID"));
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setCPF(resultSet.getString("CPF"));
                cliente.setGenero(resultSet.getString("Genero"));
                cliente.setEstadoCivil(resultSet.getString("EstadoCivil"));
                cliente.setEmail(resultSet.getString("Email"));
                cliente.setDataNascimento(resultSet.getDate("DataNascimento"));
                cliente.setNumeroContato(resultSet.getString("NumeroContato"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                cliente.setEnderecoNumero(resultSet.getString("EnderecoNumero"));
                cliente.setComplemento(resultSet.getString("Complemento"));
                cliente.setCidade(resultSet.getString("Cidade"));
                cliente.setEstado(resultSet.getString("Estado"));
                
                clientes.add(cliente);
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
        return clientes;
    }
    
    // Listar clientes pelo Nome 
    public static List<Cliente> listarClientesNome(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("SELECT * FROM Cliente WHERE Nome LIKE '%?%';");
            ps.setString(1, nome);
            
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setClienteID(resultSet.getInt("ClienteID"));
                cliente.setNome(resultSet.getString("Nome"));
                cliente.setCPF(resultSet.getString("CPF"));
                cliente.setGenero(resultSet.getString("Genero"));
                cliente.setEstadoCivil(resultSet.getString("EstadoCivil"));
                cliente.setEmail(resultSet.getString("Email"));
                cliente.setDataNascimento(resultSet.getDate("DataNascimento"));
                cliente.setNumeroContato(resultSet.getString("NumeroContato"));
                cliente.setEndereco(resultSet.getString("Endereco"));
                cliente.setEnderecoNumero(resultSet.getString("EnderecoNumero"));
                cliente.setComplemento(resultSet.getString("Complemento"));
                cliente.setCidade(resultSet.getString("Cidade"));
                cliente.setEstado(resultSet.getString("Estado"));
                
                clientes.add(cliente);
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
        
        
        return clientes;
    }

    public static boolean atualizar(Cliente cliente) {
        PreparedStatement ps = null;

        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("UPDATE Cliente SET Nome = ?, CPF = ?, Genero = ?, EstadoCivil = ?, Email = ?, DataNascimento = ?, NumeroContato = ?, Endereco = ?, EnderecoNumero = ?, Complemento = ?, Cidade = ?, Estado = ? WHERE ClienteID = ?;");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getGenero());
            ps.setString(4, cliente.getEstadoCivil());
            ps.setString(5, cliente.getEmail());
            ps.setDate(6, cliente.getDataNascimento());
            ps.setString(7, cliente.getNumeroContato());
            ps.setString(8, cliente.getEndereco());
            ps.setString(9, cliente.getEnderecoNumero());
            ps.setString(10, cliente.getComplemento());
            ps.setString(11, cliente.getCidade());
            ps.setString(12, cliente.getEstado());
            // WHERE
            ps.setInt(13, cliente.getClienteID());
            
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
    
    public static boolean deletar(int clienteID) {

        PreparedStatement ps = null;
        
        try {
            Connection conn = ConexaoDataBase.abrirConexao();
            ps = conn.prepareStatement("DELETE FROM Cliente WHERE ClienteID = ?;");
            
            ps.setInt(1, clienteID);
            
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
