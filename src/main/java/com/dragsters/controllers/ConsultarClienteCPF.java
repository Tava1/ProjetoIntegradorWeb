package com.dragsters.controllers;

import com.dragsters.dao.ClienteDAO;
import com.dragsters.model.Cliente;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String CPF = request.getParameter("cpf");
        
        Cliente cliente = ClienteDAO.listarClientesCPF(CPF);
        
        request.setAttribute("cliente", cliente);

        response.setContentType("text/plain");
        response.getWriter().write(cliente.getNome());
    }
}
