package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
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
public class CriarCliente extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/customers/create-customer.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente cliente = new Cliente();
        
        try {

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
        
            clienteDAO.criar(cliente);
        } 
        catch (Exception ex) {
            Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
