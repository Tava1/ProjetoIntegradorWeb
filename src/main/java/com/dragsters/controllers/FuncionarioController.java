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
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/employees/list-employee.jsp");
        requestDispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        int funcionarioID = Integer.parseInt(request.getParameter("funcionarioID"));
        
        try {
            if(funcionarioDAO.deletar(funcionarioID))
            {
                ArrayList<Funcionario> listaFuncionarios = funcionarioDAO.listar();
                request.setAttribute("listaFuncionarios", listaFuncionarios);
                response.setContentType("text/html;charset=UTF-8");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/protected/admin/employees/list-employee.jsp");
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


}
