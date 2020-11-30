package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.dao.UnidadeDAO;
import com.dragsters.model.Cargo;
import com.dragsters.model.Unidade;
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
public class BuscarCargos extends HttpServlet {

    private CargoDAO cargoDAO = new CargoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Cargo> listaCargos = cargoDAO.listar();
        
        request.setAttribute("listaCargos", listaCargos);
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/employees/create-employee.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
