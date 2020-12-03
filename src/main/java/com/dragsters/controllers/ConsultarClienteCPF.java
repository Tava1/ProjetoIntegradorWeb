package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
@WebServlet(name = "ConsultarClienteCPF", urlPatterns = "/ConsultarClienteCPF")
public class ConsultarClienteCPF extends HttpServlet {

    private Gson gson = new Gson();
    private ClienteDAO clienteDAO = new ClienteDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String CPF = request.getParameter("cpf");
        
        Cliente cliente = clienteDAO.listarClientesCPF(CPF);
        
        String employeeJsonString = this.gson.toJson(cliente);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(employeeJsonString);
    }
}
