/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
public class DetalheCliente extends HttpServlet {
    
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int clienteID = Integer.parseInt(request.getParameter("clienteID"));
        
        Cliente cliente = clienteDAO.listarClienteID(clienteID);
        
        request.setAttribute("cliente", cliente);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/customers/update-customer.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Gson gson = new Gson();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Cliente cliente = new Cliente();
       
        try {
            cliente.setClienteID(Integer.parseInt(request.getParameter("clienteID")));
            cliente.setNome(request.getParameter("nome"));
            cliente.setCPF(request.getParameter("cpf"));
            cliente.setGenero(request.getParameter("genero"));
            cliente.setEstadoCivil(request.getParameter("estadoCivil"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
            cliente.setNumeroContato(request.getParameter("numeroContato"));
            cliente.setEndereco(request.getParameter("endereco"));
            cliente.setEnderecoNumero(request.getParameter("enderecoNumero"));
            cliente.setComplemento(request.getParameter("complemento"));
            cliente.setCidade(request.getParameter("cidade"));
            cliente.setEstado(request.getParameter("estado"));
        
            
            if(clienteDAO.atualizar(cliente)) {
                response.getWriter().write(gson.toJson("Atualização efetuada com sucesso."));
            }
            else {
                response.getWriter().write(gson.toJson("Ocorreu algum erro."));
            }
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
