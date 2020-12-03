package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */

@WebServlet(name = "ClienteController", urlPatterns = "/ClienteController")
public class ClienteController extends HttpServlet {

    private ClienteDAO clienteDAO = new ClienteDAO();
    
    // Lista todos os cliente cadastrados
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Cliente> listaClientes = clienteDAO.listar();
        
        request.setAttribute("listaClientes", listaClientes);
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/customers/list-customer.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int clienteID = Integer.parseInt(request.getParameter("clienteID"));
        
        try {
            if(clienteDAO.deletar(clienteID))
            {
                ArrayList<Cliente> listaClientes = clienteDAO.listar();
                request.setAttribute("listaClientes", listaClientes);
                request.setCharacterEncoding("UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/pages/customers/list-customer.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                request.setAttribute("erro", "Ocorreu algum erro ao tentar deletar.");
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
                requestDispatcher.forward(request, response);
            }
        } 
        catch (Exception e) {
            request.setAttribute("erro", e.getMessage());
            response.setContentType("text/html;charset=UTF-8");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            requestDispatcher.forward(request, response);
        }
    }
    
    

//    // Cria um novo cliente
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        Cliente cliente = new Cliente();
//        
//        cliente.setNome(request.getParameter("nome"));
//        cliente.setCPF(request.getParameter("cpf"));
//        cliente.setGenero(request.getParameter("genero"));
//        cliente.setEstadoCivil(request.getParameter("estadoCivil"));
//        cliente.setEmail(request.getParameter("email"));
//        cliente.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
//        cliente.setNumeroContato(request.getParameter("numeroContato"));
//        cliente.setEndereco(request.getParameter("endereco"));
//        cliente.setEnderecoNumero(request.getParameter("enderecoNumero"));
//        cliente.setComplemento(request.getParameter("complemento"));
//        cliente.setCidade(request.getParameter("cidade"));
//        cliente.setEstado(request.getParameter("estado"));
//        
//        try {
//            clienteDAO.criar(cliente);
//        } 
//        catch (Exception e) {
//        }
//    }
    
//    // Atualiza um cliente especifico
//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        Cliente cliente = new Cliente();
//        
//        cliente.setClienteID(Integer.parseInt(request.getParameter("clienteID")));
//        cliente.setNome(request.getParameter("nome"));
//        cliente.setCPF(request.getParameter("cpf"));
//        cliente.setGenero(request.getParameter("genero"));
//        cliente.setEstadoCivil(request.getParameter("estadoCivil"));
//        cliente.setEmail(request.getParameter("email"));
//        cliente.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
//        cliente.setNumeroContato(request.getParameter("numeroContato"));
//        cliente.setEndereco(request.getParameter("endereco"));
//        cliente.setEnderecoNumero(request.getParameter("enderecoNumero"));
//        cliente.setComplemento(request.getParameter("complemento"));
//        cliente.setCidade(request.getParameter("cidade"));
//        cliente.setEstado(request.getParameter("estado"));
//        
//        try {
//            clienteDAO.atualizar(cliente);
//        } 
//        catch (Exception e) {
//        }
//    }
    
}
