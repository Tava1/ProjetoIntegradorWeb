package com.dragsters.controllers;

import com.dragsters.dao.CargoDAO;
import com.dragsters.model.Cargo;
import com.dragsters.model.Produto;
import com.google.gson.Gson;
import java.io.IOException;
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
    private Gson gson = new Gson();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        ArrayList<Cargo> listaCargos = cargoDAO.listar();
//        
//        request.setAttribute("listaCargos", listaCargos);
//        response.setContentType("text/html;charset=UTF-8");
//        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/pages/employees/create-employee.jsp");
//        requestDispatcher.forward(request, response);
//    }
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ArrayList<Cargo> cargos = cargoDAO.listar();
        
        String jsonString = this.gson.toJson(cargos);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonString);
    }

}
