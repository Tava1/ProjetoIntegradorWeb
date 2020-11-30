package com.dragsters.controllers;

import com.dragsters.dao.FuncionarioDAO;
import com.dragsters.model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gustavo Santos
 */
public class FuncionarioController extends HttpServlet {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ArrayList<Funcionario> listaFuncionarios = funcionarioDAO.listar();
        
        request.setAttribute("listaFuncionarios", listaFuncionarios);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/employees/list-employee.jsp");
        requestDispatcher.forward(request, response);
    }

}
